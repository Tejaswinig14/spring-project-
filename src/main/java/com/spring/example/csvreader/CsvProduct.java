package com.spring.example.csvreader;

import org.springframework.stereotype.Component;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@AllArgsConstructor
@Data
public class CsvProduct {

	@Override
	public String toString() {
		return "CsvProduct [id=" + id + ", name=" + name + ", laptops=" + laptops + "]";
	}

	@CsvBindByName(column = "Id", required = true)
	private int id;
	
	@CsvBindByName(column = "Name", required = true)
	private String name;
	
	@CsvBindByName(column = "Laptops", required = true)
	private String laptops;
	
}
