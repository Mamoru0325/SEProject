package eng.cpe.se.project.main;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import eng.cpe.se.project.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session ss = HibernateUtil.openSession();
		
		Query query = ss.createQuery("from Account a where a.accountId = :accountId");
		query.setParameter("accountId", 1);
		System.out.println();
		
		ss.close();
		
	}

}
