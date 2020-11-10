package com.xworkz.hiber.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Mysingleton {
	
	private static SessionFactory factory;
	public static SessionFactory getFactory() {
		return factory;
	}
	
	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			factory = configuration.buildSessionFactory();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
