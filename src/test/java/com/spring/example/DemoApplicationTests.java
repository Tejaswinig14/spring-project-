package com.spring.example;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.spring.example.csvreader.ReadCsvData;
import com.spring.example.repository.Product;
import com.spring.example.service.ProductService;

@SpringBootTest
class DemoApplicationTests extends AbstractTestNGSpringContextTests{

	@Autowired 
	ReadCsvData readcsv;
	
	@Autowired
	ProductService dbservice;
	
   
	@Test(dataProvider="csvdata")    
	public void testMethod(String id,String name,String laptop){ 
		System.out.println("---Find record id "+id + "  in Database----");
		List<String> csvdata = new ArrayList<String>();
		csvdata.add(id);
		csvdata.add(name);
		csvdata.add(laptop);
				
		List<Product> all_db_product_record =dbservice.getProducts(); //read DB data
		for(Product productdb: all_db_product_record){
	
			if (csvdata.toString().equals(productdb.toString())) {
				System.out.println("Matching records found with " +id +" ------ "+csvdata.toString());
				break;
				}
			else{		
				System.out.println("No matching records found ");
			}
		}
		
	}
	
	
	
	@DataProvider(name="csvdata")
	public Object[][] dataProviderMethod() throws Exception {
		
		List<String[]> r = readcsv.loadcsv().readAll(); //load csv data
	    
	      Object [][] objArray = new Object[r.size()][r.get(0).length];
	      
	      for(int i=0;i< r.size();i++){
	    	 for(int j=0;j<r.get(i).length;j++){
	    	    
	    	    objArray[i][j] = r.get(i)[j];   
	    	 } 
	      }
	    	 return objArray;	    
}
	
}

