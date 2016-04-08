

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
public class CreateNewAccountDB {

	public CreateNewAccountDB() {
		// TODO Auto-generated constructor stub
	}
	public void AddNewAccount(int user_id , String account_type)
	{
		System.out.println("im here");
		BigDecimal active=new BigDecimal(1);
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		DcuAccount accounts=new DcuAccount();
		DcuUser user =new DcuUser();
		long accountid=getMAxAccountid()+1;
		System.out.print(accountid);
		user.setUserid(user_id);
		accounts.setDcuUser(user);
		accounts.setAcctype(account_type);
		//accounts.setBalance();
		accounts.setActive(active);
		accounts.setAccid(accountid);
		trans.begin();
		try
		{
			System.out.println("im here 2");
			em1.persist(accounts);
			em1.flush();
			trans.commit();
			
		}
		catch(Exception e)
		{
			
			trans.rollback();
		}
		finally
		{
			em1.close();
		}
		
	}
	@SuppressWarnings("rawtypes")
	protected long getMAxAccountid()
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		TypedQuery query =em1.createQuery(
				"SELECT max(d.accid) FROM DcuAccount d",DcuAccount.class);
		return (long) query.getSingleResult();
	}
	public long getNewAccountID(int userid)
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		TypedQuery query =em1.createQuery(
				"SELECT max(d.accid) FROM DcuAccount d where d.dcuUser.userid=:userid",DcuAccount.class)
				.setParameter("userid", userid);
		return (long) query.getSingleResult();
		
	}

}
