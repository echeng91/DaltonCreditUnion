

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CloseExistingAccountServlet")
public class CloseExistingAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CloseExistingAccountServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id=1;//use seeion.getsession here
		int account_id=5;//this value should come in from julies page as hidden input
		CloseAccountDB db =new CloseAccountDB();
		
		db.CloseAccount(user_id, account_id);
	}

}
