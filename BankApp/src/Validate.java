
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginpkg.Login;

import dbclass.DBOperation;

public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Validate() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname =request.getParameter("uname");
		String passwd = request.getParameter("passwd");
		String type = request.getParameter("type");
		
		
		/*boolean valid = false;
		String login[] = {"abc", "xyz" };
	
		for(int i=0; i<login.length; i++ ){
			if (uname.equals(login[i]) && passwd.equals(login[i]))
					valid = true;
		}  */
		Login login = new Login(uname, passwd, type);
		
		if(DBOperation.validate(login)){
			
			HttpSession session = request.getSession(true);
			session.setAttribute("uname", uname);
			session.setAttribute("passwd", passwd);
			session.setAttribute("type", type);
			
			session.setAttribute("login", login);
			RequestDispatcher rd;
			
			if(type.equalsIgnoreCase("manager"))
					 rd = request.getRequestDispatcher("welcomeManager.jsp");
			else if(type.equalsIgnoreCase("clerk"))
					 rd = request.getRequestDispatcher("welcomeClerk.jsp");
			else	 rd = request.getRequestDispatcher("welcomeUser.jsp");
				
				rd.forward(request,response);
		}else {

			RequestDispatcher rd = request.getRequestDispatcher("login.jsp?msg=Invalid User Name and Password");
			rd.forward(request,response);
			//	response.sendRedirect("LoginPage.do?msg=Invalid User Name and Password");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
