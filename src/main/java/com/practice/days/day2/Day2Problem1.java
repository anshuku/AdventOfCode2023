package com.practice.days.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//
public class Day2Problem1 {
	
	public static void main(String[] args) {
		BufferedReader reader;
		String fileName = "src/test/resources/sample2.txt";
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			int sum = 0;

			Map<String, Integer> map = new HashMap<>();
			map.put("red", 12);
			map.put("green", 13);
			map.put("blue", 14);

			while (line != null) {
				int gameNum = Integer.parseInt(line.substring(line.indexOf(" ") + 1, line.indexOf(":")));
				System.out.println("game number - " + gameNum);
				String cubeSubsets = line.substring(line.indexOf(":") + 1);
				System.out.println("cube subsets - " + cubeSubsets);

				String[] subsetArr = cubeSubsets.split(";");

				boolean addGameNumFlag = true;

				for (String subset : subsetArr) {// 11 green, 1 blue, 2 red
					System.out.println("subset - " + subset);
					String[] balls = subset.split(",");

					Map<String, Integer> ballMap = new HashMap<>();

					for (String ball : balls) {// 11 green
						String[] ballValues = ball.trim().split(" ");
						ballMap.put(ballValues[1], Integer.parseInt(ballValues[0]));
					}
					if (ballMap.getOrDefault("red", 0) > 12 || ballMap.getOrDefault("green", 0) > 13
							|| ballMap.getOrDefault("blue", 0) > 14) {
						addGameNumFlag = false;
						break;
					}
				}
				if (addGameNumFlag) {
					sum += gameNum;
				}
				line = reader.readLine();
			}
			System.out.println("Sum - " + sum);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
