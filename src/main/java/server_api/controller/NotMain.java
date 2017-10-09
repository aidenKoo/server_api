package server_api.controller;
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

@Controller
public class NotMain {

    protected Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("/test1.do")
    public String hi(Model model) throws Exception {

        logger.info("test1.....");

        System.out.println("test1");

        return "index";

    }
     /*
     http://localhost:8080/synthesis.do?schMasterInfo=[{"sch_name":"1"}]
     */
    @RequestMapping(value = "/synthesis.do",method= RequestMethod.GET)
    public @ResponseBody
    List<SchMasterInfo> stringSynthesis (@RequestParam("schMasterInfo") String schMasterInfo, HttpServletRequest req) throws Exception {

                        List<SchMasterInfo> schList = null;
                try {
                        //SchoolParaTest[] emp = new ObjectMapper().readValue(empJson, SchoolParaTest[].class); // 배열로 받기
                    List<SchMasterInfo> requestedSchMasterInfos = new ObjectMapper().readValue(schMasterInfo, new TypeReference<java.util.List<SchMasterInfo>>() { });//list로받기

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


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                return schList;
            }
}
