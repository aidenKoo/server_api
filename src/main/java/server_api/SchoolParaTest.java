package server_api;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.List;
import java.io.IOException;
import java.util.*;

/**
 * Created by aiden on 2017-06-29.
 */


public class SchoolParaTest{
        String name;
        String empNo;
        String deptName;
        String cellphone;


    public String getCellphone() {
           return cellphone;
    }

    public String getDeptName() {
           return deptName;
    }

    public  String getEmpNo() {
           return empNo;
    }

    public String getName() {
        return name;
    }
    public 	void	setCellphone	(	String	cellphone	)	{this.cellphone	=	cellphone	; }
    public 	void	setDeptName	(	String	deptName	)	{this.deptName		=	deptName	; }
    public 	void	setEmpNo	(	String	empNo	)	{this.empNo		=	empNo	; }
    public 	void	setName	(	String	name	)	{this.name		= name		; }

}

