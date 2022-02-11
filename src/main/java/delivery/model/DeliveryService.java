package delivery.model;

import java.sql.SQLException;
import java.util.ArrayList;

import delivery.exception.NotExistException;
import delivery.model.dto.CustomerDTO;
import delivery.model.dto.DinerDTO;
import delivery.model.dto.MenuDTO;
import delivery.exception.MessageException;



public class DeliveryService {
	
	//모든 매장 검색 
		public static ArrayList<DinerDTO> getAllDiners() throws SQLException,NotExistException{
			ArrayList<DinerDTO> dinerNameAll = DinerDAO.getAllDiners();
			if(dinerNameAll == null){
				throw new NotExistException("검색하는 매장이 미 존재합니다.");
			}
			return dinerNameAll;
		}
	
	//음식 검색	
		public static MenuDTO getMenu(String diner_id) throws SQLException,NotExistException{
			MenuDTO menu_name = MenuDAO.getMenu(diner_id);
			if(menu_name == null){
				throw new NotExistException("검색하는 음식이 미 존재합니다.");
			}
			return menu_name;
		}
	
	//회원 검색	
		public static boolean addCustomer(CustomerDTO customer) throws MessageException{
			boolean result = false;
			try{
				result = CustomerDAO.addCustomer(customer);
			}catch(SQLException s){
				throw new MessageException("이미 존재하는 ID입니다 다시 시도 하세요");
			}
			return result;
		}
		
	//회원 삭제(탈퇴)
		public static boolean deleteCustomer(String user_id) throws SQLException, NotExistException{
			notExistCustomer(user_id);
			boolean result = CustomerDAO.deleteCustomer(user_id);
			if(!result){
				throw new NotExistException("회원 정보 삭제 실패");
			}
			return result;
		}
		
		public static void notExistCustomer(String user_id) throws NotExistException, SQLException{
			CustomerDTO customer = CustomerDAO.getCustomer(user_id);
			if(customer == null){
				throw new NotExistException("검색하는 회원이 미 존재합니다.");
			}
		}
		
		public static ArrayList<CustomerDTO> getAllCustomers() throws SQLException{
			return CustomerDAO.getAllCustomers();
		}
		
		//회원정보(주소) 수정 메소드
		public static boolean updateCustomerLoc(String user_id, String user_loc) throws SQLException, NotExistException{		
			notExistCustomer(user_id);
			boolean result = CustomerDAO.updateCustomerLoc(user_id, user_loc);
			if(!result){
				throw new NotExistException("회원 주소 정보 갱신 실패");
			}
			return result;
		}
		
		public static CustomerDTO getCustomer(String user_id) throws SQLException, NotExistException{
			CustomerDTO customer = CustomerDAO.getCustomer(user_id);
			if(customer == null){
				throw new NotExistException("검색하는 회원이 미 존재합니다.");
			}
			return customer;
		}
		
}
