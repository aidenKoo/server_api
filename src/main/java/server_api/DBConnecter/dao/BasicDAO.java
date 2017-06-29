package server_api.DBConnecter.dao;

import java.util.List;


public interface BasicDAO {
		
	public Object select(String sqlId);	
	public Object select(String sqlId, Object param);
	public int    mod   (String sqlId, Object param);
	public int    mod   (String sqlId);
	public int    add   (String sqlId, Object param);
	public int    del   (String sqlId, Object param);
	
	public <T> List<T> list(String sqlId);
	public <T> List<T> list(String sqlId, Object param);
	
	public void transactionStart();
	public void transactionCommit();
	public void transactionRollback();
	public void transactionEnd();
}
