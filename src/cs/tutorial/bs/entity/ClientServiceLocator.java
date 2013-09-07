package cs.tutorial.bs.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import cs.tutorial.bs.entity.Client;
import cs.tutorial.bs.entity.Client;
import cs.tutorial.bs.entity.Client;



public class ClientServiceLocator {

	public Boolean saveClient(Client r) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Boolean b = false;
		try {
			transaction = session.beginTransaction();
			session.save(r);  
			transaction.commit();
			b = true;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return b;
	}
	
	public Boolean updateClient(Client r) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Boolean b = false;
		try {
			transaction = session.beginTransaction();
			session.update(r);  
			transaction.commit();
			b = true;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return b;
	}

	public List<Client> listClients() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<Client> clients = 
					(List<Client>) session.createQuery("from Client").list();
			transaction.commit();
			session.close();
			return clients;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			session.close();
			return null;
		} finally {
			if (session.isOpen())	
			session.close();
		}
	}

	public Client getClient(int clientID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query q =  session
					.createQuery("SELECT r FROM Client r WHERE r.clientID = :clientID");
			q.setParameter("clientID", clientID);
			List<Client> lr = (List<Client>) q.list();
			transaction.commit();
			if (lr.isEmpty()) {
				session.close();
				return null;
			}else {
				session.close();	
				return lr.get(0);
			}
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			session.close();
			return null;
		} finally {
			if (session.isOpen())	
			session.close();
		}
	}
	
	public boolean isClientNumberValid(int clientID) {
		boolean found = false;
		
		List<Client> listClients = listClients();
		for (Client r : listClients) {
			if (r.getClientID() == clientID) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public List<Integer> getClientNumbers() {
		int index = 0;
		List<Integer> li = new ArrayList<Integer>(10);
		List<Client> listClients = listClients();
		for (Client r : listClients) {
			li.add(index, r.getClientID());
			index++;
		}
		
		return li;
	}
	
	public boolean removeClient(int clientID) {
		boolean remove = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query q =  session.createQuery("DELETE Client r WHERE r.clientID = :clientID");
			q.setParameter("clientID", clientID);
			int val = q.executeUpdate();
			System.out.println("_______REMOVE_______________" + val);
			transaction.commit();
			if (val != 0) 
				remove = true;
			session.close();
			return remove;
		} catch (HibernateException e) {
			transaction.rollback();
			session.close();
			return false;
		} finally {
			if (session.isOpen())	
			session.close();
		}
	}
	
	public List<Client> getClients(int max, int index) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query q = session.createQuery("from Client");

			transaction.commit();
			session.close();
			return q.setMaxResults(max).setFirstResult(index).list();			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			session.close();
			return null;
		} finally {
			if (session.isOpen())	
			session.close();
		}
	}
	
	/*
	//get all clients made in a period
	public List<Client> getAllAvailableClients(String fromDate, String toDate) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			List<Client> clientList = null;
			
			String delims = "/";
			String[] data1 = fromDate.split(delims);       
			String year1 = data1[2];
			String month1 = data1[0];  
			String day1 = data1[1];  
			String newFromDate = year1.concat(month1).concat(day1);
						
			String[] data2 = toDate.split(delims); 
			String year2 = data2[2];    
			String month2 = data2[0];   
			String day2 = data2[1];  
			String newToDate = year2.concat(month2).concat(day2);
        	
			Query q = session.createQuery("from Client b where b.clientDate.compareTo(:newFromDate)>=0 AND b.clientDate.compareTo(:newToDate)<=0");
			//Query q = session.createQuery("from Client");
			
			
			transaction.commit();
			clientList = listClients();
			
			//for (Client b : (List<Client>)q.list()) {
			//	clientList.remove(getClient(b.getClientNumber()));
			//}
			return q.list();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}   */

	
}
