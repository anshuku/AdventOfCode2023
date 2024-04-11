package com.practice.days.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//138915
public class Day6Problem1 {
	
	public static void main(String[] args) {
		BufferedReader reader;
		String path = "src/main/resources/sample6.txt";

		List<Integer> timeList = new ArrayList<>();
		List<Integer> distanceList = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();

			line = line.split(":")[1].trim();

			String[] timeArr = line.split(" ");

			for (String str : timeArr) {
				if (!str.isEmpty()) {
					timeList.add(Integer.parseInt(str.trim()));
				}
			}

			System.out.println("timeList - " + timeList);

			line = reader.readLine();
			line = line.split(":")[1].trim();

			String[] distanceArr = line.split(" ");

			for (String str : distanceArr) {
				if (!str.isEmpty()) {
					distanceList.add(Integer.parseInt(str.trim()));
				}
			}

			System.out.println("distanceList - " + distanceList);

		} catch (IOException e) {

		}

		int index = 0;
		int count = 0;
		int productCount = 1;

		for (Integer time : timeList) {
			for (int i = 0; i < time; i++) {
				if (i * (time - i) > distanceList.get(index)) {
					count++;
				}
			}
			System.out.println("for time " + time + " count is " + count);
			productCount *= count;
			count = 0;
			index++;
		}
		System.out.println("productCount - " + productCount);
	}

}
