package com.practice.days.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//1734 or 70387
public class Day2Problem1 {
	
	public static void main(String[] args) {
		
		BufferedReader reader;
		String fileName = "src/main/resources/sample2.txt";
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			int sum = 0;

			while (line != null) {
				int gameNum = Integer.parseInt(line.substring(line.indexOf(" ") + 1, line.indexOf(":")));
				System.out.println("game number - " + gameNum);
				String cubeSubsets = line.substring(line.indexOf(":") + 1);
				System.out.println("cube subsets - " + cubeSubsets);

				String[] subsetArr = cubeSubsets.split(";");

				boolean addGameNumFlag = true;

				Map<String, Integer> map = new HashMap<>();
				map.put("red", 0);
				map.put("green", 0);
				map.put("blue", 0);

				for (String subset : subsetArr) {// 11 green, 1 blue, 2 red
					System.out.println("subset - " + subset);
					String[] balls = subset.split(",");

					Map<String, Integer> ballMap = new HashMap<>();

					for (String ball : balls) {// 11 green
						String[] ballValues = ball.trim().split(" ");
						ballMap.put(ballValues[1], Integer.parseInt(ballValues[0]));
					}

					map.put("red", Math.max(map.get("red"), ballMap.getOrDefault("red", 0)));
					map.put("green", Math.max(map.get("green"), ballMap.getOrDefault("green", 0)));
					map.put("blue", Math.max(map.get("blue"), ballMap.getOrDefault("blue", 0)));

				}
				sum += map.get("red") * map.get("green") * map.get("blue");
				line = reader.readLine();
			}
			System.out.println("Sum - " + sum);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
