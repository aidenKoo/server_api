package server_api;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import server_api.DBConnecter.dao.SchMasterInfo;
import server_api.DBConnecter.dao.SchMasterInfoDAOImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Created by aiden on 2017-06-29.
 * 참조 http://blog.naver.com/PostView.nhn?blogId=ddraemon1&logNo=220444202520
 */
@Controller
public class MainContoller {

    protected Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("/")
    public String Index(Model model) throws Exception {

        logger.info("index.....");

        System.out.println("index");

        return "index";

    }

    @RequestMapping(value = "/master_info/getwith/seq.do",method= RequestMethod.GET)
    /*
    http://localhost:8080/master_info/getwith/seq.do?schMasterInfo=[{"sch_seq":"456"}]
    */
    public @ResponseBody
    List<SchMasterInfo> getWithSeq (@RequestParam("schMasterInfo") String schMasterInfo, HttpServletRequest req) throws Exception {

        List<SchMasterInfo> schList = null;
        try {
            //SchoolParaTest[] emp = new ObjectMapper().readValue(empJson, SchoolParaTest[].class); // 배열로 받기
            List<SchMasterInfo> requestedSchMasterInfos = new ObjectMapper().readValue(schMasterInfo, new TypeReference<java.util.List<SchMasterInfo>>() {
            });//list로받기
            if (requestedSchMasterInfos != null) {
                for (SchMasterInfo requestedSchMasterInfo : requestedSchMasterInfos) {

                    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config/DBContext/*-context.xml");

                    SchMasterInfoDAOImpl d = (SchMasterInfoDAOImpl)ctx.getBean("schMasterInfoDAO");

                    schList = (java.util.List<SchMasterInfo>) d.list("server_api.SchMasterInfo.getSchMasterInfos",requestedSchMasterInfo);//db커넥션 정의, requestedSchMasterInfo 질문. 질문항목


                }
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return schList;
    }

    @RequestMapping(value = "/master_info/string/synthesis.do",method= RequestMethod.GET)
    /*
    http://localhost:8080/master_info/string/synthesis.do?schMasterInfo=[{"sch_name":"456"}]
    */
    public @ResponseBody
    List<SchMasterInfo> stringSynthesis (@RequestParam("schMasterInfo") String schMasterInfo, HttpServletRequest req) throws Exception {

        List<SchMasterInfo> schList = null;
        try {
            //SchoolParaTest[] emp = new ObjectMapper().readValue(empJson, SchoolParaTest[].class); // 배열로 받기
            List<SchMasterInfo> requestedSchMasterInfos = new ObjectMapper().readValue(schMasterInfo, new TypeReference<java.util.List<SchMasterInfo>>() {
            });//list로받기
            if (requestedSchMasterInfos != null) {
                for (SchMasterInfo requestedSchMasterInfo : requestedSchMasterInfos) {

                    requestedSchMasterInfo.setSch_name("%"+requestedSchMasterInfo.getSch_name()+"%");

                    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config/DBContext/*-context.xml");

                    SchMasterInfoDAOImpl d = (SchMasterInfoDAOImpl)ctx.getBean("schMasterInfoDAO");

                    schList = (java.util.List<SchMasterInfo>) d.list("server_api.SchMasterInfo.getSynthesistSchMasterInfos",requestedSchMasterInfo);

                    System.out.println("결과값: " + schList);

                    System.out.println("select 종료");



                }
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return schList;
    }


    @RequestMapping(value = "/master_info/string/sch_name.do",method= RequestMethod.GET)
    /*
    http://localhost:8080/master_info/string/sch_name.do?schMasterInfo=[{"sch_name":"456"}]
    */

    public @ResponseBody
    List<SchMasterInfo> stringSchName (@RequestParam("schMasterInfo") String schMasterInfo, HttpServletRequest req) throws Exception {

        List<SchMasterInfo> schList = null;
        try {
            //SchoolParaTest[] emp = new ObjectMapper().readValue(empJson, SchoolParaTest[].class); // 배열로 받기
            List<SchMasterInfo> requestedSchMasterInfos = new ObjectMapper().readValue(schMasterInfo, new TypeReference<java.util.List<SchMasterInfo>>() {
            });//list로받기
            if (requestedSchMasterInfos != null) {
                for (SchMasterInfo requestedSchMasterInfo : requestedSchMasterInfos) {

                    requestedSchMasterInfo.setSch_name("%"+requestedSchMasterInfo.getSch_name()+"%");

                    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config/DBContext-context.xml");

                    SchMasterInfoDAOImpl d = (SchMasterInfoDAOImpl)ctx.getBean("schMasterInfoDAO");

                    schList = (java.util.List<SchMasterInfo>) d.list("server_api.SchMasterInfo.getSchnameSchMasterInfos",requestedSchMasterInfo);

                    System.out.println("결과값: " + schList);

                    System.out.println("select 종료");



                }
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return schList;
    }


    @RequestMapping(value = "/master_info/location.do",method= RequestMethod.GET)
    /*
    http://localhost:8080/master_info/location.do?schMasterInfo=[{"sch_locX":"456","sch_locY":"456"}]&limitedDistanceKM=30.0
    */
    List<SchMasterInfo> location (@RequestParam("schMasterInfo") String schMasterInfo, HttpServletRequest req) throws Exception {

        List<SchMasterInfo> schList = null;
        double limitedDistanceKM = 10; // 해당 좌표값에서 10KM 이내를 검색한다;

        try {
            //SchoolParaTest[] emp = new ObjectMapper().readValue(empJson, SchoolParaTest[].class); // 배열로 받기
            List<SchMasterInfo> requestedSchMasterInfos = new ObjectMapper().readValue(schMasterInfo, new TypeReference<java.util.List<SchMasterInfo>>() {
            });//list로받기
            double getDistance = Double.parseDouble(req.getParameter("limitedDistanceKM")); // json 외 별도의 parameter
            System.out.println("getDistance : " + getDistance);
            if(getDistance != 0){
                limitedDistanceKM = getDistance;
            }

            if (requestedSchMasterInfos != null) {
                for (SchMasterInfo requestedSchMasterInfo : requestedSchMasterInfos) {

                    requestedSchMasterInfo.setSch_tchPerStu(limitedDistanceKM);

                    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config/DBContext/*-context.xml");

                    SchMasterInfoDAOImpl d = (SchMasterInfoDAOImpl)ctx.getBean("schMasterInfoDAO");

                    schList = (java.util.List<SchMasterInfo>) d.list("server_api.SchMasterInfo.getLocationSchMasterInfos",requestedSchMasterInfo);

                    System.out.println("결과값: " + schList);

                    System.out.println("select 종료");



                }
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return schList;
    }
/*-----------------------TEST-----------------------------------*/

    @RequestMapping("/hi.do")
    public String hi(Model model) throws Exception {

        logger.info("hi.....");

        System.out.println("hi");

        return "index";

    }

    /*
    http://localhost:8080/paraTest.do?schMasterInfo=[{"sch_name":"123","":"","":"","":""},{"sch_name":"123","":"","":"","":""}]
    */
    /*----------------------------------- TEST-----------------------------------------------*/

    @RequestMapping(value = "/master_info/string/test.do",method= RequestMethod.GET)
    public @ResponseBody
    Object stringTest (@RequestParam HttpServletRequest req) throws Exception {
    /*
    http://localhost:8080/master_info/string/test?sch_name=HI
    */
        List<SchMasterInfo> schList = null;

        new ObjectMapper();
        String requestedSearchWord = req.getParameter("sch_name"); // json 외 별도의 parameter
        System.out.println("requestedSearchWord : " + requestedSearchWord);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config/DBContext/*-context.xml");

        SchMasterInfoDAOImpl d = (SchMasterInfoDAOImpl)ctx.getBean("schMasterInfoDAO");
        SchMasterInfo requestedSchMasterInfo = new SchMasterInfo();
        requestedSchMasterInfo.setSch_name(requestedSearchWord);
        schList = (java.util.List<SchMasterInfo>) d.list("server_api.SchMasterInfo.getSynthesistSchMasterInfos",requestedSchMasterInfo);

        System.out.println("결과값: " + schList);

        System.out.println("select 종료");



        return schList;
    }

}

