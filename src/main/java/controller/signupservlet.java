package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupServlet
 */
//@WebServlet("/signupservlet")
public class signupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String s1=request.getParameter("fn");
		String s2=request.getParameter("ln");
		String s3=request.getParameter("ph");
		String s4=request.getParameter("r1");
		String s5=request.getParameter("cityName");
		String s6=request.getParameter("dob");
		String s7=request.getParameter("address");
		String[] s8=request.getParameterValues("ch1");
		
		//i am feching the values
		pw.println("<p> Form details is :</p><br>");
		pw.println("<p> First Name is : "+s1+"</p><br>");
		pw.println("<p> Last Name is : "+s2+"</p><br>");
		pw.println("<p> Phone Number is : "+s3+"</p><br>");
		pw.println("<p> Gender is : "+s4+"</p><br>");
		pw.println("<p> City Name is : "+s5+"</p><br>");
		pw.println("<p> DOB is : "+s6+"</p><br>");
		pw.println("<p> Address is : "+s7+"</p><br>");
		pw.println("<p> Qualification : "+Arrays.toString(s8)+"</p><br>");
		
		//I want to bind firstName, LastName and Phone with request object
		//void setAttribute(String key", Object value)
		//The above method is the method of HttpServletRequest interface
		//The above method is used to bind any object with request scope
		//The validity of the the object will avialable only for the current request to next resource
		request.setAttribute("nameKey",s1.concat(" ").concat(s2));
		request.setAttribute("phoneKey",s3);
		
		//getting the object of RequestDispacher
		RequestDispatcher rd=request.getRequestDispatcher("generatepassword");
		//rd.include(request,response);
		rd.forward(request, response);
		
	}

}