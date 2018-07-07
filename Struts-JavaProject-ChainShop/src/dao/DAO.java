package dao;

import java.sql.Connection;

public interface DAO {
	//public boolean isRegisted();

	public boolean isRegisted(String inputAccount, String inputPassword);
	public Connection ConSQL(Connection con) throws InstantiationException, IllegalAccessException;
	//public void addInfotoDatabase();
	boolean isRegisted(String inputAccount, String inputPassword, Connection con);
}
