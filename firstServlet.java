

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//매핑명 /first 톰캣은 대소문자 구별 한다.
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//첫번째 매개변수는 요청과 관련된것 , 두번째는 응답과 관련된 매개변수이다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  //dogetmethod 방식이 정해져 있다. //
		response.setContentType("text/html;charset=UTF-8");  //얘는 html 문서야 하고 하면 h1을 h1 태그에 알맞게 랜더링 한다.
//		response.setContentType("text/plain;charset=UTF-8");  //plain text하면 일반택스트로 인식해라는 의미 이다.  text/plain을
		// contentType을 제대로 작성해야 한다. charset을 제대로 작성을 안하면 ???로 표시된다.
		// getWriter하기 전에 생성해야 한다. 
		// response.~~~과 PrintWriter out = response.getWriter()는 같이 사용된다. 
		
		
		PrintWriter out = response.getWriter();  //response.getWriter() reponse쪽으로 getWriter을 넘겨 받게ㄸ사 텍스트 같은 것을 출력
		//getoutputsream 이미지 형식으로 출력하고 싶을때
		//출력하고 나면 close를 해줘야 한다.
		//브라우저에 나가게 하기 위해서는 클라이언트로의 reponse.getwrite를 이용해서 표시

		
		//tomcat은 가급적 close를 해줘야 한다.
		out.print("<h1>FirstServlet 수행 완료</h1>");
		out.print("<hr>");
		out.print("<h2>요청방식 : "+request.getMethod()+"<h2>");
		out.print("<h2>반가워용가리 "+request.getParameter("name")+"님!!<h2>");  //
		//get 방식 과 post 방식이 있다.
		
		
		out.close();
		System.out.println("서블릿에서의 표준출력은 어디로 나갈까용?");   ///---> 표준 출력 어디로 나가고 있다 알려줘야 한다.  톰캣을출력 시킬 콘솔에 표준 출력이 나오게 한다. 
		//이 소스의 내용을 톰캣이 인식을 하지 못하므로 다시 
		// 파일의 내용을 인식하게 하기 위해서는 톰캣이 자동으로 인식하지 못하기 때문에서블릿 같은 경우는 새로 만들면 톰캣 서버를 재가동 시켜야 된다.
		// 새로운 서블릿은 서버가 기동 될때 인식한다.
		//server의 톰갯을 restart 해주면 된다.
		// 브라우저에 보낼때는 아무 표시가 안된다.
		//서버에서 직접 클라이언트에서 호출 할때는 getWriter()하면 된다.
	
	}

}
