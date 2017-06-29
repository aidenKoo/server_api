package server_api.DBConnecter.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Created by aiden on 2017-06-29.
 * 참조 http://blog.naver.com/PostView.nhn?blogId=ddraemon1&logNo=220444202520
 */
public class Sample {
    public static void main(String[] args){
        Sample s = new Sample();
        s.mybatis();
    }
    public  void mybatis(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config/DBContext/*-context.xml");
        BasicDAOImpl d = (BasicDAOImpl)ctx.getBean("basicDAO");
        String s = (String)d.select("server_api.sample.test");
        System.out.println(s);
    }
}
