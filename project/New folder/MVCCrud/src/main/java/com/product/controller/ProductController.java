package com.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.product.dao.ProductDao;
import com.product.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	
	@RequestMapping("/")
	public String home(Model model)
	{
		//get all product and get all data on view by Model
		List<Product> products = productDao.getProducts();
		model.addAttribute("products", products);
		
		return "index";
	}
	
	//show add product form
	@RequestMapping("/add-product")
	public String addproduct(Model model)
	{
		model.addAttribute("title", "Add Product");
		return "add_product_form";
	}

	
	//handle add product
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request)   // @modelAttribute for fetch data
	{
		System.out.println(product);
		productDao.createProduct(product);
	  RedirectView	redirect = new RedirectView();
	  redirect.setUrl(request.getContextPath()+"/");
	  return redirect;
		
	}
	
	
	
	//delete handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId")int productId, HttpServletRequest request)
	{
		
		this.productDao.deleteProduct(productId);
		  RedirectView	redirect = new RedirectView();
		  redirect.setUrl(request.getContextPath()+"/");
		  return redirect;
		
	}
	
	
	//update Handler and if any send data use model and received data from pathVariable
	@RequestMapping("/update/{productId}")
	public String updateProduct(@PathVariable ("productId") int pid, Model model )
	{
		//hence get single product 
		Product product = this.productDao.singleProduct(pid);
		model.addAttribute("product", product);
		return "update_form";
	}
	
	
}
