package mall.client.model;

import java.sql.*;
import java.util.*;
import mall.client.commons.DBUtil;
import mall.client.vo.Ebook;

public class EbookDao {
	private DBUtil dbutil = null;
	
	public List<Ebook> selectEbookListByPage(int beginRow, int rowPerPage){
		//필요 객체 초기화
		List<Ebook> list = new ArrayList<>();
		this.dbutil = new DBUtil();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbutil.getConnection();
			String sql = "SELECT * FROM ebook ORDER BY ebook_date DESC LIMIT ?, ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			System.out.println("selectEbookListByPage " + stmt); //디버깅
			
			while(rs.next()) {
				Ebook ebook = new Ebook();
				ebook.setEbookTitle(rs.getString("ebook_title"));
				ebook.setEbookPrice(rs.getInt("ebook_price"));
				ebook.setEbookImg(rs.getString("ebook_img"));
				list.add(ebook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbutil.close(rs, stmt, conn);
		}
		
		return list;
	}
}
