package com.clientea.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.clientea.configuration.Page;
import com.clientea.model.Product;




@Controller
@RequestMapping("/home")

public class ControllerBasic {
	
	
	public List<Product> getProducts(){
		
		ArrayList<Product> product = new ArrayList<>();
		
		product.add(new Product(1, "Nombre 1", "Descripcion", 500, 25));
		product.add(new Product(2, "Nombre 2", "Descripcion", 500, 25));
		product.add(new Product(3, "Nombre 3", "Descripcion", 500, 25));
		product.add(new Product(4, "Nombre 4", "Descripcion", 500, 25));
		
		return product;
	}
	
	@GetMapping(path = {"/product", "/"})
	public String saludar(Model model) {
		model.addAttribute("products", this.getProducts());
		return "index";
	}
	
	@GetMapping(path = "/public")
	public ModelAndView product() {
		ModelAndView modelAndView = new ModelAndView(Page.HOME);
		modelAndView.addObject("products", this.getProducts());
		return modelAndView;
	}
}
