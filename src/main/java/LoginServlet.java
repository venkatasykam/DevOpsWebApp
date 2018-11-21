import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class LoginServlet extends HttpServlet {
	
	public DockerConnectMySQL dcm = null;
	
	public LoginServlet(){
		
		DockerConnectMySQL dcm = new DockerConnectMySQL();
		dcm.createTable();
	
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	  
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
			  
		String inputUname = request.getParameter("username");  
		String inputPwd = request.getParameter("userpwd");

		System.out.println("inputUname: "+inputUname);
		System.out.println("inputPwd: "+inputPwd);
		

		if(userExists(inputUname,inputPwd)){
			RequestDispatcher rd=request.getRequestDispatcher("welcomeServlet");  
			rd.forward(request,response);  
		}else{  
			out.print("<h1><font color=red>Sorry username or password error</font></h1>");  
			RequestDispatcher rd=request.getRequestDispatcher("LoginPage.html");  
			rd.include(request,response);  
		}  

	out.close();  
	}
	
	public boolean userExists(String inputUname, String inputPwd){
		
		boolean bln = false;
		
		String userDetails = dcm.getUser(inputUname,inputPwd);
		
		if(userDetails.equals("nouser")){
			
			bln = false;
		
		}else{

			String[] userDetailsArray = userDetails.split(":");

			if(userDetailsArray[0].equals(inputUname) && userDetailsArray[3].equals(inputPwd)){
				bln = true;
			}
		}

		return bln;
	}
}