package delivery.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MenuDAO {
	public static boolean addActivist(ActivistDTO activist) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into activist values(?, ?, ?, ?)");
			pstmt.setString(1, activist.getId());
			pstmt.setString(2, activist.getName());
			pstmt.setString(3, activist.getPassword());
			pstmt.setString(4, activist.getMajor());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	//수정  
	//기부자 id로 주요 기부 내용 수정하기
	public static boolean updateActivist(String activistId, String major) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update activist set major=? where activist_id=?");
			pstmt.setString(1, major);
			pstmt.setString(2, activistId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}


	//??? 삭제
	//sql - delete from activist where activist_id=?
	public static boolean deleteActivist(String activistId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from activist where activist_id=?");
			pstmt.setString(1, activistId);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	//id로 해당 기부자의 모든 정보 반환
	public static ActivistDTO getActivist(String activistId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ActivistDTO activist = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from activist where activist_id=?");
			pstmt.setString(1, activistId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				activist = new ActivistDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return activist;
	}

	//???모든 기부자 검색해서 반환
	//sql - select * from activist
	public static ArrayList<ActivistDTO> getAllActivists() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ActivistDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from activist");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<ActivistDTO>();
			while(rset.next()){
				list.add(new ActivistDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)) );
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
