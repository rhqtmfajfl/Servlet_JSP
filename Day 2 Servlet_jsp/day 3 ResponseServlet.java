package base;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/getHTML", "/getXML", "/getJSON", "/getImage" })   //servlet은 하난데 url case는 4가지로 나눠진다.
//텍스트 3개 이미지 1개

//temp에 넣어주세요 라는 파일의 자료를

public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();  //클라이언트가 사용하는 uri 부분을 꺼내고 있다.
		System.out.println(uri);
		String filename = "";
		String contentType = "";
		
		//텍스트 형식
		if (uri.endsWith("getHTML")) {   //추출된 uri가 getHTML로 끝나면 밑에 부분으로 출력해라.
			filename = "c:/Temp/sample.html";	
			contentType = "text/html; charset=utf-8";
		} else if (uri.endsWith("getXML")) { //추출된 uri가 getXML로 끝나면 밑에 부분으로 출력해라.
			filename = "c:/Temp/sample.xml";	
			contentType = "application/xml; charset=utf-8";
		} else if (uri.endsWith("getJSON")) { //추출된 uri가 getJSON로 끝나면 밑에 부분으로 출력해라.
			filename = "c:/Temp/sample.json";	
			contentType = "text/json; charset=utf-8";
		} else {
			filename = "c:/Temp/trans_duke.png";	   //file IO 운영체제에 알맞는 PATH 정보
			contentType = "image/png";  //이부분에서 png 형식이다라고 클라이언트에게 알려준다.
		}
		
		
		
		
		File f = new File(filename);  //file input stream
		// api 이름ㅇ ㅣreader나 writer 르ㅗ 끝나면 문자를 읽을때 사용  text에서 사용
		FileInputStream fis = new FileInputStream(f);
		response.setContentType(contentType);    
		//클라이언트에게 GET WRITE
		//GETOUTPUTSTREAM을 쓰는 이유는 이때 리터 되는 객첵는 서블릿 아웃풋스트림 객체이다.  서블릿 아웃풋스트림객체는?
		// 이미지
		if(contentType.startsWith("image")) {
			byte[] content = new byte[(int)f.length()];
			ServletOutputStream sos = response.getOutputStream();
			fis.read(content);
			sos.write(content);			
			sos.close();
		} else {
			InputStreamReader isr = new InputStreamReader(fis, "utf-8"); //바이트스트림을 문자스트림으로 바꿔주는 것이다.
			//이름안에 INPUT도 있고 READER도 있다 읽기모드로 하는 것을 쓰기용으로 변환해주는 것이다.
			//UTF-8에 맞게 동작시키겠다.
			//InputStreamReader  문자단위로 읽어들인다.
				
				InputStreamReader는 바이트 단위로 읽어 들이는 InputStream을 통해 데이터를 읽어 들여 문자 단위로 읽어 들이는 방식으로 변형한다는 의미이며,
OutputStreamWriter는 바이트 단위로 쓰는 OutputStream을 이용해서 문자 단위로 쓰는 것을 바이트 단위로 쓰도록 변형한다는 것을 의미합니다.
	
	
			BufferedReader br = new BufferedReader(isr);  //성능을 높이기 위해서 버퍼링리더 사용
			PrintWriter out = response.getWriter();   // 텍스트를 응답할때는 response.getWriter()
			//바이너리를 응답할때는 GETOUT
			String line = null; 
			while((line = br.readLine()) != null) 
				out.println(line);
			out.close();
			br.close();
			isr.close();			
		}		
		fis.close();
	}
}




CONTENT TYPE?
	Content-Type: text/html; charset=utf-8
Content-Type: multipart/form-data; boundary=something

컨텐츠의 컨텐츠 유형이 실제로 무엇인지를 알려줍니다.
