package com.xworkz.hiber.tester;

import com.xworkz.hiber.dao.SchoolDAOIMPL;
import com.xworkz.hiber.entity.SchoolEntity;
import com.xworkz.hiber.util.Mysingleton;

public class SchoolTester {

	public static void main(String[] args) {
		try {
			SchoolEntity schoolEntity = new SchoolEntity("vidya peetha", "kalaburagi", 42, 29000);
			SchoolDAOIMPL daoimpl = new SchoolDAOIMPL();
			
			// create operation
			//daoimpl.save(schoolEntity);
			
			// read operation
			//daoimpl.returnById(2);
			
			// update operation
			//daoimpl.updateById("x-workz", 3);
			
			// delete operation
			//daoimpl.deleteById(2);
			
			//daoimpl.fetchAll();
			//daoimpl.fetchByFees(15000);
			//daoimpl.fecthNameById(4);
			daoimpl.fetchNameFeesById(5);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Mysingleton.getFactory().close();
		}

	}

}
