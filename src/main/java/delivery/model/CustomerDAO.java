package delivery.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import delivery.model.dto.CustomerDTO;
import delivery.model.util.DBUtil;

public class CustomerDAO {
	
	//회원가입
	public static boolean addCustomer(CustomerDTO customer) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into customer values(?, ?, ?, ?)");
			pstmt.setString(1, customer.getUser_id());
			pstmt.setString(2, customer.getUser_name());
			pstmt.setString(3, customer.getUser_loc());
			pstmt.setString(4, customer.getUser_mobile());
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//id로 해당 id 고객의 모든 회원정보 반환
			public static CustomerDTO getCustomer(String user_id) throws SQLException{
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				CustomerDTO activist = null;
				
				try{
					con = DBUtil.getConnection();
					pstmt = con.prepareStatement("select * from customer where user_id=?");
					pstmt.setString(1, user_id);
					rset = pstmt.executeQuery();
					if(rset.next()){
						activist = new CustomerDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
					}
				}finally{
					DBUtil.close(con, pstmt, rset);
				}
				return activist;
			}
	
	//수정  
			//고객 id로 주소 수정하기
			public static boolean updateCustomerLoc(String user_id, String user_loc) throws SQLException{
				Connection con = null;
				PreparedStatement pstmt = null;
				try{
					con = DBUtil.getConnection();
					
					pstmt = con.prepareStatement("update customer set user_loc=? where user_id=?");
					pstmt.setString(1, user_loc);
					pstmt.setString(2, user_id);
					
					int result = pstmt.executeUpdate();
					if(result == 1){
						return true;
					}
				}finally{
					DBUtil.close(con, pstmt);
				}
				return false;
			}

		
			//회원탈퇴
			public static boolean deleteCustomer(String user_id) throws SQLException{
				Connection con = null;
				PreparedStatement pstmt = null;
				try{
					con = DBUtil.getConnection();
					pstmt = con.prepareStatement("delete from customer where user_id=?");
					pstmt.setString(1, user_id);
					int result = pstmt.executeUpdate();
					if(result == 1){
						return true;
					}
				}finally{
					DBUtil.close(con, pstmt);
				}
				return false;
			}

		
}
