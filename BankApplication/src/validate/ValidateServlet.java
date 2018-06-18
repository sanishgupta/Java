package validate;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ValidateServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				String uname =request.getParameter("uname");
				String passwd = request.getParameter("passwd");
				boolean valid = false;
				
				
				
				String login[] = {"abc", "xyz" };
			
				for(int i=0; i<login.length; i++ ){
					if (uname.equals(login[i]) && passwd.equals(login[i]))
							valid = true;
				}
				if(valid == true){
					
					HttpSession session = request.getSession(true);
					session.setAttribute("uname", uname);
					session.setAttribute("passwd", passwd);
					
					RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
					rd.forward(request,response);
				}else {

					RequestDispatcher rd = request.getRequestDispatcher("LoginPage.do?msg=Invalid User Name and Password");
					rd.forward(request,response);
					//	response.sendRedirect("LoginPage.do?msg=Invalid User Name and Password");
				}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
