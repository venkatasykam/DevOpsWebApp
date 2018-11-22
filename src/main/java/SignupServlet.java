import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SignupServlet extends HttpServlet {

	public DockerConnectMySQL dcm = new DockerConnectMySQL();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		dcm.createTable();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String userpwd = request.getParameter("userpwd");

		System.out.println("username: "+username);
		System.out.println("firstname: "+firstname);
		System.out.println("lastname: "+lastname);
		System.out.println("userpwd: "+userpwd);

		if(userExists(username,userpwd)){
			out.print("<h1><font color=red>Sorry username already exists</font></h1>");
			RequestDispatcher rd=request.getRequestDispatcher("signup.html");
			rd.include(request,response);
		}
		else{
			dcm.insertRecords(username,firstname,lastname,userpwd);
			RequestDispatcher rd=request.getRequestDispatcher("welcomeServlet");
			rd.forward(request,response);
		}

	out.close();
	}

	public boolean userExists(String inputUname, String inputPwd){

		boolean bln = false;
		if(dcm == null){
			DockerConnectMySQL dcm = new DockerConnectMySQL();
			dcm.createTable();
		}
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
