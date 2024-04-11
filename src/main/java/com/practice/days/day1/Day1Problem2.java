package com.practice.days.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

//53587, 53592 -> The right calibration values for string "eighthree" is 83 and
//for "sevenine" is 79.
public class Day1Problem2 {

	public static void main(String[] args) {// 55621

		BufferedReader reader;
		String fileName = "src/main/resources/sample1.txt";
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			int sum = 0;
			while (line != null) {
				HashMap<String, String> map = new HashMap<>();
				map.put("one", "1");
				map.put("two", "2");
				map.put("three", "3");
				map.put("four", "4");
				map.put("five", "5");
				map.put("six", "6");
				map.put("seven", "7");
				map.put("eight", "8");
				map.put("nine", "9");
				System.out.println("initial - " + line);

				StringBuilder sb = new StringBuilder();
//            line = line.replaceAll("one", "1");
//            line = line.replaceAll("two", "2");
//            line = line.replaceAll("three", "3");
//            line = line.replaceAll("four", "4");
//            line = line.replaceAll("five", "5");
//            line = line.replaceAll("six", "6");
//            line = line.replaceAll("seven", "7");
//            line = line.replaceAll("eight", "8");
//            line = line.replaceAll("nine", "9");
				for (int i = 0; i < line.length(); i++) {
					String num = line.substring(i, i + 1);
					if (map.values().contains(num)) {
						sb.append(num);
						continue;
					}
					for (int j = i + 3; j <= line.length() && j < i + 6; j++) {
						String str = line.substring(i, j);
						if (map.keySet().contains(str)) {
							sb.append(map.get(str));
							// i = j-1;
							break;
						}
					}
				}
				System.out.println(sb);

				String s = String.valueOf(sb.charAt(0)) + String.valueOf(sb.charAt(sb.length() - 1));
				System.out.println(s);
				sum += Integer.parseInt(s);
				System.out.println(sum);
				System.out.println("=======================================");
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
