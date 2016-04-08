

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 InsertDB iDB=new InsertDB();
		
		 String username=request.getParameter("username");
         System.out.println("User Input is: "+username);
         
     	
		 String password=request.getParameter("password");
         System.out.println("User Input is: "+password);
     	
		 String FirstName=request.getParameter("FirstName");
         System.out.println("User Input is: "+FirstName);
         
		 String LastName=request.getParameter("LastName");
         System.out.println("User Input is: "+LastName);
         
        
         
         InsertDB.iDB(username,password,FirstName, LastName);
         
	}

}
