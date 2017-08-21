package com.koby.springdemo.validator;

import java.util.HashMap;

import com.koby.springdemo.entity.Customer;

public interface CustomerValidator {

	public HashMap<String , String> validateCustomer(Customer theCustomer);
}
