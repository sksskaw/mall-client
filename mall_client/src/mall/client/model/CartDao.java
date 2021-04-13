package mall.client.model;

import java.sql.*;
import java.util.*;
import mall.client.commons.DBUtil;
import mall.client.vo.*;

public class CartDao {
	
	private DBUtil dbutil;
	
	// �α����� ������ ��ٱ��� ����Ʈ ��������
	public List<Map<String, Object>> selectCartList(String clientMail){
		List<Map<String, Object>> list = new ArrayList<>();
		this.dbutil = new DBUtil();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.dbutil.getConnection();											//inner join		  					  //inner join ����
			String sql = "SELECT e.ebook_no, e.ebook_title, e.ebook_price, c.cart_date FROM cart c ,ebook e WHERE c.client_mail=? AND c.ebook_no = e.ebook_no";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, clientMail); // ���� �α����� ���� mail
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("ebookNo", rs.getInt("e.ebook_no"));
				map.put("ebookTitle", rs.getString("e.ebook_title"));
				map.put("ebookPrice", rs.getString("e.ebook_price"));
				map.put("cartDate", rs.getString("c.cart_date"));
				list.add(map);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.dbutil.close(rs, stmt, conn);
		}
		return list;
	}
}
