package base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("FowardServlet 수행 시작");		
		RequestDispatcher rd = request.getRequestDispatcher("/htmlexam/first.html");// 컨텍스트패스 이후 부분을 줘야	   //여기서 edu를 붙이면 현재 프로젝의 context를 붙여서 찾는다 다른거 못 붙이게 하려고 
		//동일한 자원에 있는것만 forward 할 수 있게끔 강제 하기 위해서 
		// context에서 edu를 뺀 나머지만 찾는다.
		//getRequestDispatcher는 forward 객체 를 적는다. /htmlexam/first.html로 넘기겠어라는 의미이다.
		//컨택스트 패스 제외한 나머지 부분
		
		//RequestDispatcher rd = request.getRequestDispatcher("http://www.naver.com/");// 컨텍스트패스 이후 부분을 줘야	
		// 이부분에서 네이버를 forward는 안된다 동일한 프로젝트내에 없기 때문에
		// jsp나 servlet이면 가능하다.
		rd.forward(request, response);	 //forward로 하면 더이상 밑에게 실행이 안되도록 한다.
		
		System.out.println("FowardServlet 수행 종료");		
	}
}



URL, 절대 URI, 상대 URI

<img src=""> 이미지에 대한 정보를 줄때 url, 절대 uri, 상대 uri를 줘도 된다.
	
http://localhost:8080/edu/images/xxx.png
/edu/images/xxx.png
/edu로 싲가하면 웹앱을 찾아간다.
	
이미지 밑에 xxx.png를잧아갅다.
	/ 절대 를 찾아간다는 말은 /edu/images/xxx.png

../images/xxx.png 이런식으로 줬었다.

webapp - 밑에 htmlexam과
       - images가 있다.

	../images/xxx.png 이런식으로 줬었다. 
	/ 이런 식으로 주게 되면 이미지가 안나온다.
	/ 하지만 절대 경로로 주면 된다.
	
http://localhost:8080/edu/forward

http://localhost:8080/edu ../images/xxx.png 이렇게 적용된다.

그러면 하나 올라갔다가 이미지를 찾기 /때문에 

edu가 아예 없는 상태로

http://localhost:8080/images/xxx.png  이런식으로 찾게 된다.

그러므로 
ttp://localhost:8080/edu/images/xxx.png 이렇게 주던지
/edu/images/xxx.png 이렇게 줘야 한다.  얘는 서버주소와 포트번호가 자동으로 붙는다.
	

../images/xxx.png 얘는 사용하는게 그때 그때 다르다.	
	

