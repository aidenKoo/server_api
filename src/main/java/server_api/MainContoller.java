package server_api;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import server_api.DBConnecter.dao.SchMasterInfo;
import server_api.DBConnecter.dao.SchMasterInfoDAOImpl;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.List;
import java.io.IOException;
import java.util.*;

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

                    schList = (java.util.List<SchMasterInfo>) d.list("server_api.SchMasterInfo.getSchMasterInfos",requestedSchMasterInfo);



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
    /*-----------------------------------PARA TEST-----------------------------------------------*/
    @RequestMapping(value = "/paraTest.do",method= RequestMethod.GET)
    public @ResponseBody
    SchoolParaTest paraTest (@RequestParam("empJson") String empJson, HttpServletRequest req) throws Exception {

        try {
            //SchoolParaTest[] emp = new ObjectMapper().readValue(empJson, SchoolParaTest[].class); // 배열로 받기
            java.util.List<SchoolParaTest> emp = new ObjectMapper().readValue(empJson, new TypeReference<java.util.List<SchoolParaTest>>() {
            });//list로받기
            String normalParam = req.getParameter("normalParam"); // json 외 별도의 parameter
            System.out.println("normalParam : " + normalParam);
            if (emp != null) {
                for (SchoolParaTest e : emp) {
                    System.out.println("name : " + e.getName());
                    System.out.println("empNo : " + e.getEmpNo());
                    System.out.println("deptName : " + e.getDeptName());
                    System.out.println("cellphone : " + e.getCellphone());
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("hi.....");

        System.out.println("hi");

        return new SchoolParaTest();
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

    @RequestMapping(value = "/jsonTest1.do",method= RequestMethod.GET)
    public @ResponseBody
    Object jsonTest1() { //가상의 배열및 리스트에 데이터 add
        SchoolBasicInfo1 schInfo = new SchoolBasicInfo1();
        schInfo.getBasicInfoBySeq(1);

        logger.info("jsonTest1.....");

        System.out.println("jsonTest1");
        return schInfo;
    }
    @RequestMapping(value = "/jsonTest2.do")
    public @ResponseBody
    Object jsonTest2() { //가상의 배열및 리스트에 데이터 add
        Board board = new Board();
        board.setSeq(1);
        board.setTitle("제목");
        board.setContent("내요내용내용");
        board.setRegdate(new Date());
        ArrayList<BoardFile> filelist = new ArrayList<BoardFile>();
        BoardFile boardFile = null; boardFile = new BoardFile();
        boardFile.setFileSeq(1); boardFile.setFileName("파일명1");
        boardFile.setFileSize(1000); filelist.add(boardFile);
        boardFile = new BoardFile();
        boardFile.setFileSeq(2);
        boardFile.setFileName("파일명2");
        boardFile.setFileSize(25645);
        filelist.add(boardFile);
        board.setFilelist(filelist);

        logger.info("jsonTest2.....");

        System.out.println("jsonTest2");
        return board;
    }
    @RequestMapping(value = "/jsonTest3.do")
    public @ResponseBody
    Object jsonTest3() { //가상의 배열및 리스트에 데이터 add
        Board board = new Board();
        board.setSeq(1);
        board.setTitle("제목");
        board.setContent("내요내용내용");
        board.setRegdate(new Date());
        ArrayList<BoardFile> filelist = new ArrayList<BoardFile>();
        BoardFile boardFile = null; boardFile = new BoardFile();
        boardFile.setFileSeq(1); boardFile.setFileName("파일명1");
        boardFile.setFileSize(1000); filelist.add(boardFile);
        boardFile = new BoardFile();
        boardFile.setFileSeq(2);
        boardFile.setFileName("파일명2");
        boardFile.setFileSize(25645);
        filelist.add(boardFile);
        board.setFilelist(filelist);

        logger.info("jsonTest3.....");

        System.out.println("jsonTest3");
        return board;
    }
    @RequestMapping(value = "/jsonTest4.do")
    public @ResponseBody
    Object jsonTest4() { //가상의 배열및 리스트에 데이터 add
        Board board = new Board();
        board.setSeq(1);
        board.setTitle("제목");
        board.setContent("내요내용내용");
        board.setRegdate(new Date());
        ArrayList<BoardFile> filelist = new ArrayList<BoardFile>();
        BoardFile boardFile = null; boardFile = new BoardFile();
        boardFile.setFileSeq(1); boardFile.setFileName("파일명1");
        boardFile.setFileSize(1000); filelist.add(boardFile);
        boardFile = new BoardFile();
        boardFile.setFileSeq(2);
        boardFile.setFileName("파일명2");
        boardFile.setFileSize(25645);
        filelist.add(boardFile);
        board.setFilelist(filelist);

        logger.info("jsonTest4.....");

        System.out.println("jsonTest4");
        return board;
    }
}

