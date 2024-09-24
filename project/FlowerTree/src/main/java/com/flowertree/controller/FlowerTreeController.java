package com.flowertree.controller;

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
import com.flowertree.dao.FlowertreeDao;
import com.flowertree.model.FlowerTree;

@Controller
public class FlowerTreeController {
	
	@Autowired
	private FlowertreeDao flowertreeDao;

	@RequestMapping("/")
    public String home(Model model)
    //get all product and get all data on view by Model
   {	
	List<FlowerTree> flowerTrees = flowertreeDao.getFlowerTrees();
	model.addAttribute("flowerTrees", flowerTrees);
	return "index";
   }
	
	//show add flower data
	@RequestMapping("/add-flower")
	public String addFlowerTree(Model model)
	{
		model.addAttribute("title", "Add Flower");
		return "add_flowertree_form";
		
	}

	
	//handle add FlowerTree
	@RequestMapping(value = "/handle-flower", method = RequestMethod.POST)
	public RedirectView deleteFlowerTree(@ModelAttribute FlowerTree flowerTree, HttpServletRequest request) //@modelAttribute for fetch data
	{
		System.out.println(flowerTree);
		flowertreeDao.createFlower(flowerTree);
		RedirectView view = new RedirectView();
		view.setUrl(request.getContextPath()+"/");
		return view;	
	
}
	
	
	//Delete add FlowerTree
	@RequestMapping("/delete/{flowerTreeId}")
	public RedirectView handleFlowerTree(@PathVariable("flowerTreeId") int flowerTreeId, HttpServletRequest request)
	{
		this.flowertreeDao.deleteFlowerTree(flowerTreeId);
		RedirectView view = new RedirectView();
		view.setUrl(request.getContextPath()+"/");
		return view;	
	
}
	
	
	//update Handler and if any send data use model and recieve data from pathvariable
	@RequestMapping("/update/{flowerTreeId}")
	public String updateFlowerTree(@PathVariable("flowerTreeId")int flowerTreeId, Model model)
	{
		//here get single flower
		FlowerTree flowerTrees = this.flowertreeDao.getSingleFlowerTree(flowerTreeId);
		model.addAttribute("flowerTree", flowerTrees);
		
		return "update_form";
	}


	
}
