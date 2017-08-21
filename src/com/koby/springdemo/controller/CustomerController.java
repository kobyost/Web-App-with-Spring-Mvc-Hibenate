package com.koby.springdemo.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koby.springdemo.entity.Customer;
import com.koby.springdemo.service.CustomerService;
import com.koby.springdemo.validator.CustomerValidator;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//Inject CustomerService
	@Autowired
	private CustomerService customerService;
	
	////Inject CustomerValidator
	@Autowired
	private CustomerValidator cutsomerValidator;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel){
		
		//get customer from the dao
		List<Customer> theCustomers=customerService.getCustomers();
		
		//add the customers to the model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		//Create model attribute to bind the form data
		Customer theCustomer=new Customer();
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer,Model theModel){
		
		
		//need to use validator and validate customer
		HashMap<String, String> errorMap= cutsomerValidator.validateCustomer(theCustomer);
		
		if(errorMap.isEmpty()){
			// no errors save the customer using service
			customerService.saveCustomer(theCustomer);
		}
		else{
			//need to display the errors in the appropriate form fields
			theModel.addAttribute("errorMap", errorMap);
			 return "customer-form";
		}
		
		
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@ModelAttribute("customerId")int theId, Model theModel ){
		
		//get the customer from db
		Customer theCustomer=customerService.getCustomer(theId);
		
		//set customer as a model attribute to load to the form
		theModel.addAttribute("customer", theCustomer);
		
		//send to the form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int theId){
		
		//delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}

}
