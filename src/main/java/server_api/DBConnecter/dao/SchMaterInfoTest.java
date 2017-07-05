package server_api.DBConnecter.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/*
 * Created by aiden on 2017-06-29.
 * 참조 http://blog.naver.com/PostView.nhn?blogId=ddraemon1&logNo=220444202520
 */
public class SchMaterInfoTest {
    public static void main(String[] args){
        SchMaterInfoTest s = new SchMaterInfoTest();
        SchMasterInfo requestedSchMasterInfo = new SchMasterInfo();
        requestedSchMasterInfo.setSch_seq(1);
        System.out.println(requestedSchMasterInfo.getSch_seq());

        s.mybatis(requestedSchMasterInfo);
    }
    public  void mybatis(SchMasterInfo requestedSchMasterInfo){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config/DBContext/*-context.xml");

        SchMasterInfoMasterInfoDAOImpl d = (SchMasterInfoMasterInfoDAOImpl)ctx.getBean("schMasterInfoDAO");

/*
        SchoolBasicInfoDAOService d = (SchoolBasicInfoDAOService)ctx.getBean("schoolBasicInfoDAO");
*/
        System.out.println(requestedSchMasterInfo.getSch_seq());
        List<SchMasterInfo> schList = (List<SchMasterInfo>) d.list("server_api.SchMasterInfo.getSchMasterInfos",requestedSchMasterInfo);
             System.out.println("결과값: " + schList);

/*        String s = (String)d.select("server_api.SchMasterInfo",requestedSchoolBasicInfo);
        System.out.println("결과값: " + s);*/


        System.out.println("종료");
    }
}
