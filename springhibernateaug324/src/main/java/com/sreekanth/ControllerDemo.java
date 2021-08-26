package com.sreekanth;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Employee;
import model.EmployeeDao;

@Controller
public class ControllerDemo {

	private ApplicationContext conn;

	@RequestMapping("/home")
	public String view1() {
		return "home";
	}

	@RequestMapping("/register")
	public String view2(Model m) {
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Employee emp = conn.getBean("info", Employee.class);
		m.addAttribute("bean", emp);
		return "register";
	}

	@RequestMapping("/store")
	public String view3(@ModelAttribute("bean") Employee e, Model m) {
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		obj.saveData(e);
		m.addAttribute("msg", "Record insert successfully...");
		return "register";
	}

	@RequestMapping("/view")
	public String view4(Model m) {
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		List list = obj.displayData();
		
			m.addAttribute("data", list);

		

		return "view";

	}
	@RequestMapping("/find")
	public String view5(Model m) {
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Employee emp = conn.getBean("info", Employee.class);
		m.addAttribute("bean",emp);
		
		return "search";
		
	}
	@RequestMapping("/search")
	public String view5(@ModelAttribute("bean")Employee e,Model m) {
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		List list = obj.searchData(e);
		if(!list.isEmpty()){
           m.addAttribute("li",list);			
		}
		else {
			m.addAttribute("msg","oops! record not found");
		}
				return "search";
		
	}
	@RequestMapping("/update")
	public String view6(@ModelAttribute("bean") Employee emp, Model m) {
		
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml"); 
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		obj.updateData(emp);
		m.addAttribute("msg","Record update sucessfully");
		return "search";
	}
	@RequestMapping("/delete")
	public String view7(@ModelAttribute("bean") Employee emp,Model m) {
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		obj.deleteData(emp);
		m.addAttribute("msg","recoed delete Sucessfully");
		return "search";
		
	}
}
