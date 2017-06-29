
package server_api.DBConnecter.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public class BasicDAOImpl extends AbstractBaseDAO implements BasicDAO {

	private static final long serialVersionUID = -2920396419915886645L;

	// 조회
	public Object select(String sqlId) {
		return super.selectOne(sqlId);
	}		
	public Object select(String sqlId, Object param) {
		return super.selectOne(sqlId, param);
	}
	
	// 수정,등록,삭제
	public int    mod(String sqlId, Object param){
		return super.update(sqlId, param);
	}
	public int    mod(String sqlId){
		return super.update(sqlId);
	}
	public int    add(String sqlId, Object param){
		return super.insert(sqlId, param);
	}
	public int    del(String sqlId, Object param){
		return super.delete(sqlId, param);
	}
	
	// 다건조회
	public <T> List<T> list(String sqlId){
		return super.selectList(sqlId);
	}
	public <T> List<T> list(String sqlId, Object param){
		return super.selectList(sqlId, param);
	}
	
	public void transactionStart() {
		super.start();
	}
	
	public void transactionCommit() {
		super.commit();
	}
	
	public void transactionRollback() {
		super.rollback();
	}
	
	public void transactionEnd() {
		super.end();
	}
}
