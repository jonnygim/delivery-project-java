package delivery.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginValidate extends HttpServlet {

	public LoginValidate() {
		System.out.println("생성자");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		if (id != null && id.equals("user")) {
			System.out.println("user 입력 확인");

			request.getRequestDispatcher("dinerInfo").forward(request, response);

		} else {

		}

	}

}

