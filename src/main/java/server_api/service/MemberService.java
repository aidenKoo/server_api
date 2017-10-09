
        package server_api.service;

        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server_api.commons.Constant;
import server_api.dao.IMemberDao;

import java.util.HashMap;
import java.util.List;

        @Service("MemberService")
public class MemberService {
    private IMemberDao memberDao;

            @Autowired
            public MemberService(IMemberDao memberDao) {
                this.memberDao = memberDao;
            }


            public String getData(){
        return "I am a boy";
    }
    public List<HashMap<String, Object>> selectAll() {
        return memberDao.selectAll();
    }

//    public void joinMember(String id, String pwd, String pwd_Check, String name, String email, String phone, String admin){
//        HashMap<String, Object> params = new HashMap<String,Object>();
//        
//        if(pwd.equals(pwd_Check))
//        {
//            params.put(Constant.Member.USERID, id);
//            params.put(Constant.Member.PWD, pwd);
//            params.put(Constant.Member.NAME, name);
//            params.put(Constant.Member.EMAIL, email);
//            params.put(Constant.Member.PHONE, phone);
//            params.put(Constant.Member.ADMIN, admin);
//            memberDao.insertMember(params);
//        }
//        
//    }

    public void joinMember(HashMap<String, Object> params){

        if(params.get("pwd").equals(params.get("pwd_CHECK")))
        {
            memberDao.insertMember(params);
        }
    }


    public boolean login(String id, String pwd){
        HashMap<String, Object> result = memberDao.selectOne(id);
        if(result == null)
            return false;
        else {
            String oPwd = (String) result.get(Constant.Member.PWD);
            if (oPwd != null) if (oPwd.equals(pwd)) return true;
            return false;

        }
    }

    //회원 한명의 정보를 가져다주는 
    public HashMap<String, Object> getMemberInfo(String id){
        return memberDao.selectOne(id);
    }

    public void memberUpdate(HashMap<String, Object> params){

        if(params.get("pwd").equals(params.get("pwd_CHECK")))
        {
            HashMap<String, Object> record = memberDao.selectOne((String)params.get(Constant.Member.USERID));
            record.putAll(params); //원래있던거에 내가 받은걸로 수정
            memberDao.updateMember(record);
        }
    }
}
 


