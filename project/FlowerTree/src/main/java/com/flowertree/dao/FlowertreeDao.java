package com.flowertree.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.flowertree.model.FlowerTree;


@Component
public class FlowertreeDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//create FlowerTree
	@Transactional
	public void createFlower(FlowerTree flowerTree)
	{
		this.hibernateTemplate.saveOrUpdate(flowerTree);
		
	}
	
	//Get all FlowerTree
	public List<FlowerTree> getFlowerTrees()
	{
		
		List<FlowerTree> load = this.hibernateTemplate.loadAll(FlowerTree.class);
		return load;
		 
	}
	
	//delete single FlowerTree
	@Transactional
	public void deleteFlowerTree(int flowerTreeId)
	{
		//First of all get data and delete data by id
		FlowerTree flowerTree = this.hibernateTemplate.load(FlowerTree.class, flowerTreeId);
		this.hibernateTemplate.delete(flowerTree);
		
	}
	
	//single data get
	public FlowerTree getSingleFlowerTree(int flowerTreeId )
	
	{
	 
		return this.hibernateTemplate.get(FlowerTree.class, flowerTreeId);
	}
	
	
	
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
