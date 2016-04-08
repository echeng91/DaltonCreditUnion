import customTools.DBUtil;
import model.DcuAccount;
import model.DcuTransaction;
import model.DcuUser;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;
public class CloseAccountDB {

	public CloseAccountDB() {
		// TODO Auto-generated constructor stub
	}
	
	public void CloseAccount(int user_id ,int account_id)
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		int active=0;
		TypedQuery<DcuAccount> query=em1.createQuery(
				"Update DcuAccount acc set acc.active=:active where acc.dcuUser.userid=:userid and acc.accid=:accountid",DcuAccount.class)
				.setParameter("accountid", account_id)
				.setParameter("userid",user_id)
				.setParameter("active", active);
		trans.begin();
		System.out.println("im here");
		try
		{   
			System.out.println("im here 2");
			query.executeUpdate();
			trans.commit();
		}
		catch(Exception e)
		{
			System.out.println("im here 3");
			trans.rollback();
		}
		finally
		{
			em1.close();
		}
		
	}

}
