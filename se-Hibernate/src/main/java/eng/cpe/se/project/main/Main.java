package eng.cpe.se.project.main;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import eng.cpe.se.project.model.User;
import eng.cpe.se.project.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session ss = HibernateUtil.openSession();
		
		Query query = ss.createQuery("from User u");

		List<User> a = (List<User>) query.list();
		for (User a1 : a) {
			System.out.println(a1.getUserId());
		}
		
		
		ss.close();
		
	}

}
