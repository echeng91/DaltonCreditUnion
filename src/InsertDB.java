import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import customTools.DBUtil;
import model.DcuUser;

public class InsertDB {

	public static void iDB(String username, String password, String firstName, String lastName) {
		
		
		DcuUser add=new DcuUser();
		add.setUsername(username);
		add.setUserpass(password);
		add.setFirstname(firstName);
		add.setLastname(lastName);
		
	    
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		trans.begin();
		try {
		em.persist(add);
		trans.commit();
		} 
		catch (Exception e) 
		{
		System.out.println(e);
		trans.rollback();
		} 
		finally 
		{
		em.close();
		}
		
		
	
		
	}

}
