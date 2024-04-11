package com.practice.days.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//55621
public class Day1Problem1 {

	public static void main(String[] args) {// 55621

		BufferedReader reader;
		String fileName = "src/main/resources/sample1.txt";

		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			int sum = 0;
			while (line != null) {
				StringBuilder sb = new StringBuilder();
				for (char c : line.toCharArray()) {
					if (c >= '1' && c <= '9') {
						sb.append(c);
					}
				}
				String s = String.valueOf(sb.charAt(0)) + String.valueOf(sb.charAt(sb.length() - 1));
				sum += Integer.parseInt(s);
				// read next line
				line = reader.readLine();
			}
			System.out.println(sum);

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
