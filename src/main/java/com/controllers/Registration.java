package com.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojos.EmpPojo;

@Controller
public class Registration {
	
	@RequestMapping(value="/savedetails")
	public String empDetails(EmpPojo pojo ){
		
		System.out.println(pojo.getId()+""+pojo.getName()+""+pojo.getCompany()+""+pojo.getSalary());
		
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		session.save(pojo);
		session.beginTransaction().commit();
		session.close();
		
		
		
		return "login";
	}

}
