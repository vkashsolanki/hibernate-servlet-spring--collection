package com.productapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.productapp.model.Product;

//itself create object and manage life cycle
@Component
public class ProductDao {

	// inject data in object of hibernate
	@Autowired
	private HibernateTemplate hibernateTemplate; // pending setter n getter
	
	
	
	

public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//  To create data
	@tran
	public void createProduct(Product product) {
		this.hibernateTemplate.save(product);

	}

	// get all product

	public List<Product> geProducts() {

		List<Product> products = this.hibernateTemplate.loadAll(Product.class);

		return products;

	}

	// delete the product single
	@Transactional
	public void deleteProduct(int id) {
		// fetch data from load method
		Product load = this.hibernateTemplate.load(Product.class, id);
		// delete data form delete method
		this.hibernateTemplate.delete(load);
	}

	// get the single product

	public Product getProduct(int pid) {

		return this.hibernateTemplate.get(Product.class, pid);
	}

}
