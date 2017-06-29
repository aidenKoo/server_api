
package server_api.DBConnecter.dao;
/*
 * Created by aiden on 2017-06-29.
 * 참조 http://blog.naver.com/PostView.nhn?blogId=ddraemon1&logNo=220444202520
 */

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


public abstract class AbstractBaseDAO extends DefaultTransactionDefinition {
		
	private static final long serialVersionUID = -7871436661447528271L;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
		
	protected <T> T selectOne(String sqlId) {
		return selectOne(sqlId, null);
	}
	
	protected <T> T selectOne(String sqlId, Object param) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			T data;
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

	protected <T> List<T> selectList(String sqlId) {
		return selectList(sqlId, null);
	}
	
	protected <T> List<T> selectList(String sqlId, Object param) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			List<T> data;
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
