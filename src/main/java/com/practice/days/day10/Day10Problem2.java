package com.practice.days.day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day10Problem2 {
	
	public static void main(String[] args) {
		BufferedReader reader;
		String path = "src/main/resources/sample10.txt";
		
		try {
			reader = new BufferedReader(new FileReader(path));
			
			List<List<String>> list = new ArrayList<>();
			
			String line = reader.readLine();
			while(line != null) {
				
				List<String> currList = new ArrayList<>();
				currList.addAll(Arrays.asList(line.split("")));
				System.out.println("currList is " + currList);
				
				list.add(currList);
				
				line = reader.readLine();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
