

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBUtil;
import model.DcuUser;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	
		
		 String username=request.getParameter("username");
         System.out.println("User Input is: "+username);
         
     	
		 String password=request.getParameter("password");
         System.out.println("User Input is: "+password);
         
         List<DcuUser> userList=null;
         EntityManager em = DBUtil.getEmFactory().createEntityManager();
         String qString = "SELECT u from DcuUser u WHERE u.username = '" + username
         + "' AND u.userpass = '" + password + "'";
         
         TypedQuery<DcuUser> q = em.createQuery(qString, DcuUser.class);
         


         try {
             if(q.getResultList().isEmpty()) {
     
                 request.setAttribute("incorrect", "The username and/or password is incorrect");
                 request.getRequestDispatcher("/Login.jsp").forward(request, response);
             } 
             
             else 
             {
               //will go to Landing.jsp----
            	 
                 DcuUser found = q.getSingleResult();

                 session.setAttribute("user", found);
                 
                 System.out.println(found.getFirstname());
     
  
    
       //          request.getRequestDispatcher("/Login.jsp").forward(request, response);
                 
             }
         } catch (Exception e) {
             e.getMessage();
         } finally {
             em.close();
         }
        
	}

}

/*
  for (DcuUser u3:userList)

{
   System.out.println("check1");

  username +=u3.getUsername();
  password +=u3.getUserpass();
  userid +=u3.getUserid();
  firstname +=u3.getFirstname();
  lastname +=u3.getLastname();
  
}

session.setAttribute("list1", userList);

request.getRequestDispatcher("/output.jsp").forward(request, response);
 */
