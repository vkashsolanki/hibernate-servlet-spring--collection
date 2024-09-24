package com.product.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.product.model.Product;


@Component
//@ComponentScan(basePackages = {"com.product"})
public class ProductDao {
	
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	// Create Product
	@Transactional
	public void createProduct(Product product)
	{
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	// Get all product
	public List<Product> getProducts()
	{
		List<Product> load = this.hibernateTemplate.loadAll(Product.class);
		 
		return load;
		
	}
	
	// Delete Product Single
	@Transactional
	public void deleteProduct(int id)
	{
		//first get then delete data
		Product pt = this.hibernateTemplate.load(Product.class, id);
		this.hibernateTemplate.delete(pt);
		
	}
	
	
	//Get Sinlge product Product
	
	public Product singleProduct(int id)
	{
		return this.hibernateTemplate.get(Product.class, id);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
