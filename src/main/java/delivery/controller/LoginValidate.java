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

@WebServlet("/loginpage")
public class LoginValidate extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String url = "dinerInfo.jsp";
//		request.setAttribute("activist", ProbonoService.getActivist(request.getParameter("activistId")));
		try {
			if (user_id != null) {
				request.setAttribute("user_id", DeliveryService.getCustomer(user_id));
				System.out.println("---");
				HttpSession session = request.getSession();
				System.out.println(session.getId()); // 고유한 session 구분하기 위한 값
				
				// 데이터 저장
				session.setAttribute("user_id", user_id);
				session.setAttribute("user_pw", user_pw);
				
				request.getRequestDispatcher(url).forward(request, response);
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}

