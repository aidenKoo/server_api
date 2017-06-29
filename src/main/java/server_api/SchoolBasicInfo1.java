package server_api;

import java.util.*;
import java.util.Date;


/**
 * Created by aiden on 2017-06-27.
 */
public class SchoolBasicInfo1 {
    int sch_seq;
    String sch_name;
    String sch_adrs;
    double sch_locX;
    double sch_locY;
    int	sch_aftPrgm;
    String	sch_feat;
    double	sch_employ;
    String	sch_found;
    int	sch_phone;
    int	sch_tchNum;
    int	sch_mTch;
    int	sch_fTch;
    int	sch_spTch;
    double	sch_tchPerStu;
    int	sch_mStu;
    int	sch_fStu;
    int	sch_totalStu;
    double	sch_grade;
    String	sch_foundDate;
    List listA;
    public SchoolBasicInfo1(){
    }
    public 	int 	 getSch_seq	(){ return sch_seq; }
    public 	String	 getSch_name	(){ return sch_name; }
    public 	String	 getSch_adrs	(){ return sch_adrs; }
    public 	double	 getSch_locX	(){ return	sch_locX; }
    public 	double	 getSch_locY	(){ return sch_locY; }
    public 	int	 getSch_aftPrgm	(){ return 	sch_aftPrgm	; }
    public 	String	 getSch_feat	(){ return 	sch_feat	; }
    public 	double	 getSch_employ	(){ return 	sch_employ	; }
    public 	String	 getSch_found	(){ return 	sch_found	; }
    public 	int	 getSch_phone	(){ return 	sch_phone	; }
    public 	int	 getSch_tchNum	(){ return 	sch_tchNum	; }
    public 	int	 getSch_mTch	(){ return 	sch_mTch	; }
    public 	int	 getSch_fTch	(){ return 	sch_fTch	; }
    public 	int	 getSch_spTch	(){ return 	sch_spTch	; }
    public 	double	 getSch_tchPerStu	(){ return sch_tchPerStu	; }
    public 	int	 getSch_mStu	(){ return sch_mStu	; }
    public 	int	 getSch_fStu	(){ return sch_fStu	; }
    public 	int	 getSch_totalStu	(){ return sch_totalStu	; }
    public 	double	 getSch_grade	(){ return sch_grade	; }
    public 	String	 getSch_foundDate	(){ return 	sch_foundDate	; }

    public 	void	setSch_seq	(	int 	sch_seq	)	{this.	sch_seq	=	sch_seq	; }
    public 	void	setSch_name	(	String	sch_name	)	{this.	sch_name	=	sch_name	; }
    public 	void	setSch_adrs	(	String	sch_adrs	)	{this.	sch_adrs	=	sch_adrs	; }
    public 	void	setSch_locX	(	double	sch_locX	)	{this.	sch_locX	=	sch_locX	; }
    public 	void	setSch_locY	(	double	sch_locY	)	{this.	sch_locY	=	sch_locY	; }
    public 	void	setsch_aftPrgm	(	int	sch_aftPrgm	)	{this.	sch_aftPrgm	=	sch_aftPrgm	; }
    public 	void	setSch_feat	(	String	sch_feat	)	{this.	sch_feat	=	sch_feat	; }
    public 	void	setSch_employ	(	double	sch_employ	)	{this.	sch_employ	=	sch_employ	; }
    public 	void	setSch_found	(	String	sch_found	)	{this.	sch_found	=	sch_found	; }
    public 	void	setSch_phone	(	int	sch_phone	)	{this.	sch_phone	=	sch_phone	; }
    public 	void	setSch_tchNum	(	int	sch_tchNum	)	{this.	sch_tchNum	=	sch_tchNum	; }
    public 	void	setSch_mTch	(	int	sch_mTch	)	{this.	sch_mTch	=	sch_mTch	; }
    public 	void	setSch_fTch	(	int	sch_fTch	)	{this.	sch_fTch	=	sch_fTch	; }
    public 	void	setSch_spTch	(	int	sch_spTch	)	{this.	sch_spTch	=	sch_spTch	; }
    public 	void	setSch_tchPerStu	(	double	sch_tchPerStu	)	{this.	sch_tchPerStu	=	sch_tchPerStu	; }
    public 	void	setSch_mStu	(	int	sch_mStu	)	{this.	sch_mStu	=	sch_mStu	; }
    public 	void	setSch_fStu	(	int	sch_fStu	)	{this.	sch_fStu	=	sch_fStu	; }
    public 	void	setSch_totalStu	(	int	sch_totalStu	)	{this.	sch_totalStu	=	sch_totalStu	; }
    public 	void	setSch_grade	(	double	sch_grade	)	{this.	sch_grade	=	sch_grade	; }
    public 	void	setSch_foundDate	(	String	sch_foundDate	)	{this.	sch_foundDate	=	sch_foundDate	; }


    public Object getBasicInfoBySeq(int thisSeq){
        DummyDBConnection dbc = new DummyDBConnection();
        dbc.setParmAtSQLQuery("SELECT * FROM basic_info WHERE sch_seq=" + thisSeq);
        List listA = dbc.getResult();
        sch_seq = Integer.parseInt(listA.get(0).toString());
        sch_name	=	listA.get(1).toString();
        sch_adrs	=	listA.get(2).toString();
        sch_locX	=	Double.parseDouble(listA.get(3).toString());
        sch_locY	=	Double.parseDouble(listA.get(4).toString());
        sch_aftPrgm	= Integer.parseInt(listA.get(5).toString());
        sch_feat	=	listA.get(6).toString();
        sch_employ	= Double.parseDouble(listA.get(7).toString());
        sch_found	=	listA.get(8).toString();
        sch_phone	= Integer.parseInt(listA.get(9).toString());
        sch_tchNum	= Integer.parseInt(listA.get(10).toString());
        sch_mTch	= Integer.parseInt(listA.get(11).toString());
        sch_fTch	= Integer.parseInt(listA.get(12).toString());
        sch_spTch	= Integer.parseInt(listA.get(13).toString());
        sch_tchPerStu	= Double.parseDouble(listA.get(14).toString());
        sch_mStu	= Integer.parseInt(listA.get(15).toString());
        sch_fStu	= Integer.parseInt(listA.get(16).toString());
        sch_totalStu	= Integer.parseInt(listA.get(17).toString());
        sch_grade	= Double.parseDouble(listA.get(18).toString());
        sch_foundDate	= listA.get(19).toString();
        return this;
    }

}
