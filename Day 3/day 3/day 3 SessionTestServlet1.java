package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessiontest1")
public class SessionTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int member_v=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int local_v=0;		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();  //세션객체를 새로만들거나 이미 만들어진 세션객체를 활용해라
		if(session.getAttribute("cnt") == null)  //cnt라는이름의 객체를 보관하는데 null이면 보관된적이 없다.
			session.setAttribute("cnt", new int[1]); // 데이터를 저장할 방을 등록 //cnt라는 이름으로 원소하나짜리 int 배열을 하나 보관하고 있다.
		int[] session_v = (int[])session.getAttribute("cnt"); //
		session_v[0] += 10; //첫번째 원소값을 10만큼 증가시켜주고 있다.
		member_v += 10;
		local_v += 10;
		out.print("<ul>");
		//브라우저화면에 보여준다.
		out.print("<li>멤버변수 : "+ member_v +"</li>");
		out.print("<li>지역변수 : "+ local_v +"</li>");
		out.print("<li>세션객체에저장된배열원소 : "+ session_v[0] +"</li>");
		out.print("</ul>");
		out.close();		
	}
}



여기서

Set-Cookie : JSESSIONID=1A6CE11243DD5066D2476BB9ECECFC22; Path=/edu; HttpOnly

>>로 들어가서 Application을 누르고 storage의 Cookies를 누르면 저장된 쿠키를 알 수 있다.
 현재는 유효서버가 하나이므로 localhost:8080만 있다.

응답할때의  헤더 장보는 set-cooki가 브라우저 정보를 보면 알 수 잇다.
	
	/ eud 를 보면  Path = /edu로 되어잇다.

멤버변수에 있던것은 모두 공유된다.
	
	/ 하지만 세션객체에 있던 것에서는 값이 공유가 되지 않는다.

