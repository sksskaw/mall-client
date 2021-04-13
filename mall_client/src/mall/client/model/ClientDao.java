package mall.client.model;

import java.sql.*;
import mall.client.commons.DBUtil;
import mall.client.vo.*;

public class ClientDao {
	private DBUtil dbutil;
	
	public Client login(Client client) {
		this.dbutil = new DBUtil();
		Client returnCLient = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.dbutil.getConnection();
			String sql = "SELECT * FROM client WHERE client_mail=? AND client_pw=PASSWORD(?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, client.getClientMail());
			stmt.setString(2, client.getClientPw());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				returnCLient = new Client();
				returnCLient.setClientMail(rs.getString("client_mail"));
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			this.dbutil.close(rs, stmt, conn);
		}
		
		return returnCLient;
	}
}
