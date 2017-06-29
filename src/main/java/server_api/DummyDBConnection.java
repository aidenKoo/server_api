package server_api;

import java.util.*;

/**
 * Created by aiden on 2017-06-27.
 */
public class DummyDBConnection {
    int sch_seq = 0;
    String sch_name = "한이음 고등학교";
    String sch_adrs = "서울시";
    double sch_locX=12;
    double sch_locY=34;
    int	sch_aftPrgm = 18;
    String	sch_feat = "인문계";
    double	sch_employ = 0.1;
    String	sch_found =  "설립구분";
    int	sch_phone = 01046115447;
    int	sch_tchNum = 27;
    int	sch_mTch = 13;
    int	sch_fTch = 11;
    int	sch_spTch = 3;
    double	sch_tchPerStu = 9;
    int	sch_mStu = 120;
    int	sch_fStu = 123;
    int	sch_totalStu = 243;
    double	sch_grade = 0.1;
    String	sch_foundDate = "20111110";
    public DummyDBConnection(){
    }
    public void setParmAtSQLQuery(String parm){                 //SQL 쿼리를 보내는 셋 메소드

    }
    public List getResult(){                                    // 쿼리문의 결과값을 리스트로 변환
        List listA = new ArrayList();
        listA.add(sch_seq );
        listA.add(sch_name);
        listA.add( sch_adrs);
        listA.add(sch_locX);
        listA.add(sch_locY);
        listA.add(sch_aftPrgm);
        listA.add(sch_feat);
        listA.add(sch_employ);
        listA.add(sch_found);
        listA.add(sch_phone);
        listA.add(sch_tchNum);
        listA.add(sch_mTch);
        listA.add(sch_fTch);
        listA.add(sch_spTch);
        listA.add(sch_tchPerStu);
        listA.add(sch_mStu);
        listA.add(sch_fStu);
        listA.add(sch_totalStu);
        listA.add(sch_grade);
        listA.add(sch_foundDate);

        return listA;
    }
}
