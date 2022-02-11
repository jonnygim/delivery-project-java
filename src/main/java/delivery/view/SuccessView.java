package delivery.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/succ")
public class SuccessView extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("final------");
		PrintWriter out = response.getWriter();
		
		//이미 데이터값까지 보유한 세션객체 획득해서 활용
		HttpSession session = request.getSession();
		out.println(session.getAttribute("user_id") + "님의 주문이 완료되었습니다.");
		out.println("<br><br><a href=\"index.html\">메인 화면 이동</a>");
	}

}
