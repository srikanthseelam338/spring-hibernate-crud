package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDao {
	private Configuration con;
	private SessionFactory factory;
	private Session session;
	private Transaction t;

	public void saveData(final Employee e) {
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		session.save(e);
		t.commit();

	}

	public List displayData() {
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List list =session.createQuery("from Employee").list();
		return list;
	}

	public List searchData(Employee e) {
	List li = new ArrayList();
	con = new Configuration().configure("hibernate.cfg.xml");
	factory = con.buildSessionFactory();
	session = factory.openSession();
	t = session.beginTransaction();
	List list =session.createQuery("from Employee").list();
	Iterator it =list.iterator();
	while(it.hasNext()) {
		Employee emp=(Employee)it.next();
if(e.getEmpcode()==emp.getEmpcode()|| (e.getEmail().equals(emp.getEmail()) || (e.getDesignation().equals(emp.getDesignation())||(e.getEmpname().equals(emp.getEmpname()))))){
			Employee obj = new Employee();
			obj.setEmpcode(emp.getEmpcode());
			obj.setEmpname(emp.getEmpname());
			obj.setEmail(emp.getEmail());
			obj.setDesignation(emp.getDesignation());
			li.add(obj);
		}
	}
		return li;
	}

	public void updateData(Employee emp) {
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();	
		Employee obj = session.get(Employee.class, emp.getEmpcode());
		obj.setEmpname(emp.getEmpname());
		obj.setDesignation(emp.getDesignation());
		obj.setEmail(emp.getEmail());
		session.update(obj);
		t.commit();
	}

	public void deleteData(Employee emp) {
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();	
		Employee obj = session.get(Employee.class, emp.getEmpcode());
		session.delete(obj);
		t.commit();
		
		
		
	}

	

	
}