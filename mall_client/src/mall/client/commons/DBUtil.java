package mall.client.commons;

import java.sql.*;

public class DBUtil {

	// 1. DB �뿰寃� 
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mall","root","root");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// 2. DB�옄�썝(conn, stmt, rs) �빐�젣
	public void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
