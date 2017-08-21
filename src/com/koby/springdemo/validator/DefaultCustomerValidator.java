package com.koby.springdemo.validator;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.koby.springdemo.entity.Customer;

@Component
public class DefaultCustomerValidator implements CustomerValidator {
	

	@Override
	public HashMap<String, String> validateCustomer(Customer theCustomer) {
		
	   final String ALPHABETIC_LETTERS="[a-zA-Z]+";
	   
	   final String EMAIL_REGEX_PATTERN="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
										+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	   
	   HashMap<String, String> errorMap=new HashMap<>();
	   
		//check to see if fields are correct
		
		//validate First Name
		if(theCustomer.getFirstName().isEmpty())
			errorMap.put("firstName", "Is requierd !");
		else if(!theCustomer.getFirstName().matches(ALPHABETIC_LETTERS))
			errorMap.put("firstName", "Only Alphabetic latters are allowed !");
		else if(theCustomer.getFirstName().length()==1)
			errorMap.put("firstName", "minimum 2 letters !");
			
		//Validate Last Name
		if(theCustomer.getLastName().isEmpty())
			errorMap.put("lastName", "Is requierd !");
		else if(!theCustomer.getLastName().matches(ALPHABETIC_LETTERS))
			errorMap.put("lastName", "Only Alphabetic latters are allowed");
		else if(theCustomer.getLastName().length()==1)
			errorMap.put("firstName", "minimum 2 letters !");
		
		//validate Email
		if(theCustomer.getEmail().isEmpty())
			errorMap.put("email", "Is requierd !");
		else if(!theCustomer.getEmail().matches(EMAIL_REGEX_PATTERN))
			errorMap.put("email", "Only a valid email address is allowed!");
		
		return errorMap;
	}

	

}
