
package server_api.schoolBasicInfo;
/*
 * Created by aiden on 2017-06-29.
 * 참조 http://blog.naver.com/PostView.nhn?blogId=ddraemon1&logNo=220444202520
 */

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.Map;


public abstract class AbstractSchoolBasicInfoDAO extends DefaultTransactionDefinition {
		
	private static final long serialVersionUID = -7871436661447528271L;
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

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

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

		
	protected <SchoolBasicInfo> SchoolBasicInfo selectOne(String sqlId) {
		return selectOne(sqlId, null);
	}
	
	protected <SchoolBasicInfo> SchoolBasicInfo selectOne(String sqlId, Object param) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			SchoolBasicInfo data;
			if (null == param) {
				data = session.selectOne(sqlId);
			} else {
				data = session.selectOne(sqlId, param);
			}
			
			return data;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	protected <SchoolBasicInfo> List<SchoolBasicInfo> selectList(String sqlId) {
		return selectList(sqlId, null);
	}
	
	protected <SchoolBasicInfo> List<SchoolBasicInfo> selectList(String sqlId, Object param) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			List<SchoolBasicInfo> data;
			if (null == param) {
				data = session.selectList(sqlId);
			} else {
				data = session.selectList(sqlId, param);
			}
			
			return data;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}
	
	protected <K, V> Map<K, V> selectMap(String sqlId, String mapKey) {
		return selectMap(sqlId, null, mapKey);
	}
		
	protected <K, V> Map<K, V> selectMap(String sqlId, Object param, String mapKey) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			Map<K, V> data;
			if (null == param) {
				data = session.selectMap(sqlId, mapKey);
			} else {
				data = session.selectMap(sqlId, param, mapKey);
			}
			
			return data;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}
	
	protected Integer insert(String sqlId) {
		return insert(sqlId, null);
	}

	protected Integer insert(String sqlId, Object param) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			int data;
			if (null == param) {
				data = session.insert(sqlId);
			} else {
				data = session.insert(sqlId, param);
			}

			return data;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}
	
	protected Integer update(String sqlId) {
		return insert(sqlId, null);
	}
	
	protected Integer update(String sqlId, Object param) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			int data;
			if (null == param) {
				data = session.update(sqlId);
			} else {
				data = session.update(sqlId, param);
			}

			return data;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}	
	
	protected Integer delete(String sqlId) {
		return insert(sqlId, null);
	}

	protected Integer delete(String sqlId, Object param) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			int data;
			if (null == param) {
				data = session.delete(sqlId);
			} else {
				data = session.delete(sqlId, param);
			}

			return data;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Autowired
	PlatformTransactionManager transactionManager;
	 
	TransactionStatus status;
	 
	public void start() throws TransactionException {
		status = transactionManager.getTransaction(this);
	}

	public void commit() throws TransactionException {		
		if (!status.isCompleted()) {
			transactionManager.commit(status);
		}
	}

	public void rollback() throws TransactionException {
		if (!status.isCompleted()) {
			transactionManager.rollback(status);
		}
	}

	public void end() throws TransactionException {
		rollback();
	}
}
