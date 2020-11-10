package com.xworkz.hiber.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.xworkz.hiber.entity.SchoolEntity;
import com.xworkz.hiber.util.Mysingleton;

public class SchoolDAOIMPL implements SchoolDAO {
	private SessionFactory factory= Mysingleton.getFactory();

	@Override
	public void save(SchoolEntity entity) {
		System.out.println("invoked Save method");
		Session session = this.factory.openSession();
		System.out.println("created session");
		try {
			session.beginTransaction();
			Serializable ser = session.save(entity);
			session.getTransaction().commit();
			System.out.println(ser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(Objects.nonNull(session)) {
				session.close();
			}
		}

	}

	@Override
	public SchoolEntity returnById(int id) {
		
		Session session = this.factory.openSession();
		
		try {
			
			session.beginTransaction();
			SchoolEntity schoolEntity = session.get(SchoolEntity.class, id);
			session.getTransaction().commit();
			System.out.println(schoolEntity);
			return schoolEntity;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(Objects.nonNull(session))
				session.close();
		}
		return null;
	
	
	}

	@Override
	public void updateById(String name, int id) {
		
		Session session = this.factory.openSession();
		try {
			session.beginTransaction();
			SchoolEntity entity = session.get(SchoolEntity.class, id);
			if(entity!=null) {
				System.out.println("entity found, procceding to update");
				entity.setName(name);
				session.update(entity);
				System.out.println(entity);
			}else {
				System.out.println("entity is null");
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(Objects.nonNull(session)) {
				session.close();
			}
		}
	}

	@Override
	public void deleteById(int id) {
		
		Session session = this.factory.openSession();
		try {
			session.beginTransaction();
			SchoolEntity entity = session.load(SchoolEntity.class, id);
			if(entity!=null) {
				System.out.println("entity found");
				session.delete(entity);
				System.out.println(entity);
			} else {
				System.out.println("entity not found");
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(Objects.nonNull(session)) {
				session.close();
			}
		}
	}

	@Override
	public List<SchoolEntity> fetchAll() {
	Session session = 	this.factory.openSession();
		try {
			Query query = session.getNamedQuery("fetchAll");
			List<SchoolEntity> list = query.getResultList();
			
			Iterator<SchoolEntity> iterator = list.iterator();
			
			while(iterator.hasNext()) {
				//SchoolEntity entity = iterator.next();
				System.out.println(iterator.next());
			}
		} finally {
			if(Objects.nonNull(session)) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public SchoolEntity fetchByFees(double fees) {
		
		Session session = this.factory.openSession();
		
		try {
			Query query = session.getNamedQuery("fetchByFees");
			query.setParameter("fe", fees);
			List<SchoolEntity> list = query.getResultList();
			
			Iterator iterator = list.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} finally {
			if(Objects.nonNull(session)) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public String fecthNameById(int id) {
		Session session = this.factory.openSession();
		String hql = "select school.name from SchoolEntity school where school.id='"+id+"'";
		try {
			Query query = session.createQuery(hql);
			String result = (String)query.uniqueResult();
				System.out.println(result);
		} finally {
			if(Objects.nonNull(session))
				session.close();
		}
		return null;
	}

	@Override
	public Object[] fetchNameFeesById(int id) {
		Session session = this.factory.openSession();
		
		String hql = "select school.name,school.fees from  SchoolEntity school where school.id=:id";
		try {
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
		Object[] result =(Object[]) query.uniqueResult();
		System.out.println(result);
		return result;
		} finally {
			if(Objects.nonNull(session)) {
				session.close();
			}
		}
	}

	/*@Override
	public String fecthNameById(int id) {
		
		Session session = this.factory.openSession();
		try {
			Query query = session.getNamedQuery("fecthNameById");
			query.setParameter("i", id);
			String result =query.uniqueResult();
			if(result!=null) {
				System.out.println(result);
			}
			else {
				System.out.println("result is empty");
			}
		} finally {
			if(Objects.nonNull(session)) {
				session.close();
			}
		}
		return null;
	}*/

}
