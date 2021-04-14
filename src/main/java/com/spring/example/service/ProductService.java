package com.spring.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.example.repository.Product;
import com.spring.example.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;


	public List<Product> getProducts() {
		 List<Product>list=this.repository.findAll(); 
		 return list;
	}

	public void readDB(){
		List<Product> all_db_product_record =getProducts();
		for(Product productdb: all_db_product_record){
			System.out.println(productdb);
		}
		}
	
	

}
