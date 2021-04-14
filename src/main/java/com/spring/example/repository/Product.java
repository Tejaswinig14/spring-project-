package com.spring.example.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT_TBL")
public class Product {

public Product() {	
	}

	@Id // set the primary key
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	

	@Column(name= "laptop")
	private String laptop;


	public Product(int id, String name, String laptop) {
		super();
		this.id = id;
		this.name = name;
		this.laptop = laptop;
		System.out.println(id + name + laptop);
	}
	@Override
	public String toString() {
		return "[" + id + ", " + name + ", " + laptop + "]";
	}
		
}
