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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/doLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String userName=request.getParameter("un");	
		String password=request.getParameter("pw");
		
		// geting the object ServletContext
		
		ServletContext ctx = getServletContext();
		
		String bindedUserName = (String)ctx.getAttribute("userKey");
		String bindedPassword = (String)ctx.getAttribute("passKey");
		
		//out.println(userName+ " "+password);
		
		//out.println(bindedUserName+" "+bindedPassword);
		
		if(userName.equalsIgnoreCase(bindedUserName) && password.equals(bindedPassword))
		{
			response.sendRedirect("Success.html");
		}else
		{
			response.sendRedirect("error.html");
		}	
		
	}

}
