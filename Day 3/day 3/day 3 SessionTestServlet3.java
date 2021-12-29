
package base;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sessiontest3")
public class SessionTestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	  // get 방식이다
		// 쿼리문자를 줘야 한다.  안주면 action은 create이라는 것을 줬다면 세션 객체를  만든다.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	
	    String action = request.getParameter("action");
	    HttpSession session = null;
	    String msg = "action=create 또는 action=destroy를 전달하시오."; 
	    if(action != null && action.equals("create")) {
	    	session = request.getSession();// getSession(true)와 동일 
	    	if(session.isNew())  //is.New()는 세션이 이번에 만들어졌는지 확인하는 메소드
	    		msg = "세션 객체가 생성됨";
	    	else 
	    		msg = "세션 객체는 이미 생성되어 있었음";    	
	    } else if (action != null && action.equals("destroy")) {
	    	session = request.getSession(false);  //false를 주는 목적은  새로 만들계획은 없고 이미 만들어지만 그것을 리턴하고 없다면 만들고 싶지는 않아라는 의미 
	    	if(session != null) { // != null
	    		session.invalidate();  //세션객체가  사라져도 쿠키는 사라지지 않는다
	    		msg = "세션 객체가 삭제됨"; 
	    	} else 
	    		msg = "삭제할 세션 객체가 없음";    	
	    }
		 
		out.print("<h2>"+msg+"</h2>");  // 여기서 msg를 출력하게 해주면 출력문을 따로 여러번 안줘도 됨.
		out.close();
	}
}






///////////////////////////////////////

세션객체를 만들거나 삭제 할때

만들때 세션객체가 있으면 생성되었다고 나오고 
세션객체가 만들어지지 않아다면 세션객체를 만들고 세션객체가 생성되었다고 한다.
	
	/ 세션객체를 삭제할 때 살제 할게 없으면 삭제할 세션 객체가 없음 이라고 한다.

