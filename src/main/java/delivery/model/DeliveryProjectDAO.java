package delivery.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import delivery.model.dto.DeliveryProjectDTO;
import delivery.model.util.DBUtil;

public class DeliveryProjectDAO {
	//모든 식당 검색해서 반환
		public static ArrayList<DeliveryProjectDTO> getAllDeliveryProject(String diner_id) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<DeliveryProjectDTO> list = null;
			try{
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from delivery_project");
				rset = pstmt.executeQuery();
				
				list = new ArrayList<DeliveryProjectDTO>();
				while(rset.next()){
					list.add(new DeliveryProjectDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9)) );
				}
			}finally{
				DBUtil.close(con, pstmt, rset);
			}
			return list;
		}
}
