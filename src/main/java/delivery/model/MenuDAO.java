package delivery.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import delivery.model.dto.MenuDTO;
import delivery.model.util.DBUtil;

public class MenuDAO {

	//diner_id를 가지고 있는 메뉴 정보 불러오기
	public static MenuDTO getMenu(String diner_id) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MenuDTO menu = null;
			
			try{
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from menu where diner_id=?");
				pstmt.setString(1, diner_id);
				rset = pstmt.executeQuery();
				if(rset.next()){
					menu = new MenuDTO(rset.getString(1), rset.getString(2), rset.getString(3));
				}
			}finally{
				DBUtil.close(con, pstmt, rset);
			}
			return menu;
		}
}
