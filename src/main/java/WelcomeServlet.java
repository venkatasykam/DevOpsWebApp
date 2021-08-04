import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class WelcomeServlet extends HttpServlet {  
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	  
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
			  
		String username=request.getParameter("username");  
		
		out.print("<body align=center><h1><font color=green>Login Success, Welcome "+username+"</font><body><br/><br/><br/><a href=index.jsp>Logout</a><br/>");  
			  
		out.close();  
	}  
	
	public void meth1(){
		System.out.println("meth1");
	}
	public void meth2(){
		System.out.println("meth1");
	}
	public void meth3(){
		System.out.println("meth1");
	}
	public void meth4(){
		System.out.println("meth1");
	}
	public void meth5(){
		System.out.println("meth1");
	}
	public void meth6(){
		System.out.println("meth1");
	}
	public void meth7(){
		System.out.println("meth1");
	}
	public void meth8(){
		System.out.println("meth1");
	}
	public void meth9(){
		System.out.println("meth1");
	}
	public void meth10(){
		System.out.println("meth1");
	}
	
}  
