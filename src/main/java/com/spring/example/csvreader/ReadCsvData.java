package com.spring.example.csvreader;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@Component
public class ReadCsvData {
	
	public CSVReader loadcsv() throws IOException, CsvException
	{
		CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\Inputs\\ReadCSVfile.csv"));
		return reader;
		
	}
	
	

}