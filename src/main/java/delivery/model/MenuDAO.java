package delivery.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import delivery.model.dto.MenuDTO;
import delivery.model.util.DBUtil;

public class MenuDAO {

	//diner_id를 가지고 있는 메뉴 정보 불러오기
	public static ArrayList<MenuDTO> getMenu(String diner_id) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MenuDTO> menu = null;
			
			try{
				con = DBUtil.getConnection();
				System.out.println("getMenu----" + diner_id);
				pstmt = con.prepareStatement("select * from menu where menu_diner_id=?");
				pstmt.setString(1, diner_id);
				rset = pstmt.executeQuery();
				menu = new ArrayList<MenuDTO>();
				while(rset.next()){
					menu.add(new MenuDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)) );
				}

			}finally{
				DBUtil.close(con, pstmt, rset);
			}
			return menu;
		}
}
