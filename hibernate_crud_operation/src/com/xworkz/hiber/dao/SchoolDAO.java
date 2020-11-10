package com.xworkz.hiber.dao;

import java.util.List;

import com.xworkz.hiber.entity.SchoolEntity;

public interface SchoolDAO {
	
	public void save(SchoolEntity entity);
	
	public SchoolEntity returnById(int id);
	
	public void updateById(String name, int id);
	
	public void deleteById(int id);
	
	public List<SchoolEntity> fetchAll();
	
	public SchoolEntity  fetchByFees(double fees);
	
	public String fecthNameById(int id);
	
	public Object[] fetchNameFeesById(int id);
	
	
	

}
