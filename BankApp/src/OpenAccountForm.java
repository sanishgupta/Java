

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbclass.DBOperation;

import randomnumber.RandomAccountNumber;

import account.Account;

public class OpenAccountForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OpenAccountForm() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		 
		
		int accountNumber = RandomAccountNumber.accountNumber();
		 String firstName = request.getParameter("fname");
		 String lastName = request.getParameter("lname");
		 String password = request.getParameter("passwd");
		 int age = Integer.parseInt(request.getParameter("age"));
		 String gender = request.getParameter("sex");
		 String maritualStatus = request.getParameter("matstatus");
		 String address = request.getParameter("address");
		
		 String city = request.getParameter("city");
		 String country = request.getParameter("country");
		 
		  Account acc = new Account(accountNumber, firstName, lastName, password, age, gender, maritualStatus, address, city, country);
		
		 try {
			if(DBOperation.openAccount(acc)){
				out.println("Account Number is : " + accountNumber);
			}
			else{
				out.println("Account not created");
			}
		} catch (SQLException e) {
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
