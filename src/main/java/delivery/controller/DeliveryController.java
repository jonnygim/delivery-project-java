package delivery.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.exception.NotExistException;
import delivery.model.DeliveryService;
import delivery.model.dto.CustomerDTO;

@WebServlet("/delivery")
public class DeliveryController extends HttpServlet {
	public DeliveryController() {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String command = request.getParameter("command");

		try {

			

			if (command.equals("dinerInfoAll")) {
				dinerInfoAll(request, response);
			} else if (command.equals("menuInfo")) {
				menuInfo(request, response);
			} else if (command.equals("customerInsert")) {
				customerInsert(request, response);
			} else if (command.equals("customerDelete")) {
				customerDelete(request, response);
			} else if (command.equals("customerUpdate")) {
				customerUpdate(request, response);
			} else if (command.equals("userLogin")) {
				userLogin(request, response);
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}

	}
	
	// 로그인
	public void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String url = "dinerInfo.jsp";
		
		if (user_id != null) {
			try {
				request.setAttribute("user_id", DeliveryService.getCustomer(user_id));
				
				System.out.println("---");
				HttpSession session = request.getSession();
				System.out.println(session.getId()); // 고유한 session 구분하기 위한 값

				// 데이터 저장
				session.setAttribute("user_id", user_id);
				session.setAttribute("user_pw", user_pw);
				request.setAttribute("dinerInfoAll", DeliveryService.getAllDiners());
				request.getRequestDispatcher(url).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		} else {

		}
	}

	// 모든 매장 검색 - 검색된 데이터 출력 화면[dinerInfo.jsp]
	public void dinerInfoAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		System.out.println("dinerInfoAll------");
		try {
			request.setAttribute("dinerInfoAll", DeliveryService.getAllDiners());
			url = "dinerInfo.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 매장이 취급하는 음식 검색 - 검색 데이터 출력화면[menu.jsp]
	public void menuInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("menuInfo", DeliveryService.getMenu(request.getParameter("diner_id")));
			url = "menuInfo.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 회원가입
	protected void customerInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String loc = request.getParameter("loc");
		String mobile = request.getParameter("mobile");

		// 해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
		// if(id != null && id.length() !=0 && name != null) {

		CustomerDTO customer = new CustomerDTO(id, pw, name, loc, mobile);
		try {
			boolean result = DeliveryService.addCustomer(customer);
			if (result) {
				request.setAttribute("customer", customer);
				request.setAttribute("successMsg", "가입 완료");
				url = "customerDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 회원 탈퇴
	public void customerDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String user_id = request.getParameter("user_id");
			if (DeliveryService.deleteCustomer(user_id)) {
				request.setAttribute("activistAll", DeliveryService.getAllCustomers());
				url = "customerList.jsp";
			} else {
				request.setAttribute("errorMsg", "재 실행 해 주세요");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", "진행중인 Delivery Project가 있습니다");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 회원 주소 수정 - 상세정보 확인 jsp[customerDetail.jsp]
	public void customerUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String user_id = request.getParameter("user_id");
			String user_loc = request.getParameter("user_loc");
			DeliveryService.updateCustomerLoc(user_id, user_loc);
			request.setAttribute("customer", DeliveryService.getCustomer(request.getParameter("user_id")));
			url = "customerDetail.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
