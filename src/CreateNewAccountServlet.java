

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateNewAccount")
public class CreateNewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CreateNewAccountServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id=1;//use seeion.getsession here
		String account_type=request.getParameter("accounttype");
		CreateNewAccountDB db =new CreateNewAccountDB();
		System.out.println(account_type);
		db.AddNewAccount(user_id, account_type);
		long newaccountid=db.getNewAccountID(user_id);
		request.setAttribute("message", newaccountid);
		request.getRequestDispatcher("/UserLandingPage.jsp").forward(request, response);
	}

}
