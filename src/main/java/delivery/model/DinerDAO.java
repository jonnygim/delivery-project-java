package delivery.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import delivery.model.dto.DinerDTO;
import delivery.model.util.DBUtil;

public class DinerDAO {

	//모든 식당 검색해서 반환
	public static ArrayList<DinerDTO> getAllDiners() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DinerDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from diner");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<DinerDTO>();
			while(rset.next()){
				list.add(new DinerDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)) );
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
}
