day3
package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sessiontest2")
public class SessionTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	
		out.print("생성된 세션객체의 ID : "+session.getId());  //세션 아이디에 대한 코드 getId()
		out.print("<br>세션 객체가 생성된 시간 : "   //
				      + new Date(session.getCreationTime()));  //이 모트를 통해서 세션객체가 만들어진 시간
		out.print("<br>현재 시간 : " + new Date());
		out.close();
	}
}


//////////////////////////////////

세션객체 id 와


세션객체가 만들어진 시간은 변함ㅇ ㅣ없다.
	
	
그런데 이때 크롬에서의 세션 id 와 edge에서의 세션 id의 

세션객체가 생성된 시간이 다르다 그리고 id도 다르다.
	
	



