package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GeneratePassword
 */
@WebServlet("/generatepassword")
public class generatepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public generatepassword() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//I am fetching binded object with request scope
		//I am invoking or calling object getAttribute(String 
		
		
		
		String name=(String) request.getAttribute("nameKey");
		String phone=(String) request.getAttribute("phoneKey");
		
		out.println("<h3><font color='blue'>"+name+ "<br>"+phone+"</font></h3>");
		String firstTwoCharFromName=name.substring(0,2);
		String lastTwoCharFromName=name.substring(name.length()-2);
		String lastFourDigitFromPhone=phone.substring(phone.length()-4);
		
		String finalPass=firstTwoCharFromName.concat(lastTwoCharFromName).concat(lastFourDigitFromPhone);
		
		out.println("<h3><font color='red'>"+"Your Password Is : "+finalPass+"</font></h3>");
		out.println("<h3><font color='Purple'>"+"User name Is : "+phone+"</font></h3>");

		ServletContext ctx=getServletContext();
		
		//binding the object with servletContext
		ctx.setAttribute("userKey", phone);
		ctx.setAttribute("passKey", finalPass);
		
		
		out.println("<a href='login.html'>Login here....</a>");
	}

}