package com.controllers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojos.EmpPojo;



@Controller
public class LoginEmployee {
	
	@RequestMapping(value="/loginbro")
	public String loginEmp(@RequestParam("id") Integer id , @RequestParam("name") String name,Model m){
		System.out.println("login method triggered..");
		System.out.println(id+"::"+name);
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("from EmpPojo where id= :id and name= :name");
		
		query.setParameter("id", id);
		query.setParameter("name", name);
		
	List list=query.list();
	if(list.isEmpty()){
		System.out.println("invalid credentials stop him in login page dude..");
		m.addAttribute("message", "you have entered invalid credentials bro");
		return "login";
	}else{
		System.out.println("valid credentials...forward to profile page");
		Query query2 = session.createQuery("from EmpPojo");
		List<EmpPojo> list2 = query2.list();
		for (EmpPojo empPojo : list2) {
			System.out.println(empPojo.getId()+" "+empPojo.getName()+" "+empPojo.getCompany()+" "+empPojo.getSalary());
			
		}
		m.addAttribute("emplist", list2);		
		
		
		return "profile";
	}
		
		
		
		
		
	}

}
