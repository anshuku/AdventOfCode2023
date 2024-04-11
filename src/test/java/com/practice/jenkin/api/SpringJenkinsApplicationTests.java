package com.practice.jenkin.api;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ansi.Ansi8BitColor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringJenkinsApplicationTests {

	public static Logger logger = LoggerFactory.getLogger(SpringJenkinsApplicationTests.class);

	@Ignore
	public void test1d1p1() {// 55621
		BufferedReader reader;
		String fileName = "src/test/resources/sample1.txt";

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

	@Ignore
	public void test2d1p2() {// 53587, 53592 -> The right calibration values for string "eighthree" is 83 and
								// for "sevenine" is 79.
		BufferedReader reader;
		String fileName = "src/test/resources/sample1.txt";
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

	@Test
	public void test3d2p1() {// 1734
		BufferedReader reader;
		String fileName = "src/test/resources/sample2.txt";
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

	@Ignore
	public void test4d2p2() {// 70387
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

	@Ignore
	public void test5d3p1() {// 532445
		BufferedReader reader;
		String fileName = "src/test/resources/sample3.txt";
		try {
			reader = new BufferedReader(new FileReader(fileName));
			int sum = 0;
			String line = reader.readLine();
			List<List<String>> numLists = new ArrayList<>();
			while (line != null) {
				numLists.add(Arrays.asList(line.split("")));
				line = reader.readLine();
			}
			List<String> numList = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
			for (int i = 0; i < numLists.size(); i++) {
				// System.out.println("Line:" + i + " " + numLists.get(0));
				for (int j = 0; j < numLists.get(i).size(); j++) {
					int num = 0;
					String numStr = "";
					int begin = i;
					if (numList.contains(numLists.get(i).get(j))) {
						begin = j - 1;
						numStr += numLists.get(i).get(j);
						for (int k = j + 1; k < numLists.get(i).size(); k++) {
							if (numList.contains(numLists.get(i).get(k))) {
								numStr += numLists.get(i).get(k);
							} else {
								j = k;
								break;
							}
						}
						num = Integer.parseInt(numStr);
						// System.out.print("Line:" + i + " num is " + num + " ");
						boolean check = checkSymbolNearForNum(num, i, begin, j, numLists, numList);
						if (check) {
							sum += num;
						}
					}
				}
				// System.out.println("===================================");
			}
			System.out.println("sum is " + sum);
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean checkSymbolNearForNum(int num, int lineNum, int begin, int end, List<List<String>> numLists,
			List<String> numList) {
		boolean symbolExists = false;
		System.out.println("Line: " + lineNum + " num is " + num + " begin is " + begin + " end is " + end);
		int s = begin < 0 ? 0 : begin;
		int e = end >= numLists.size() ? numLists.size() : end + 1;
		for (int i = s; i < e && lineNum - 1 >= 0; i++) {
			if (!numLists.get(lineNum - 1).get(i).equals(".") && !numList.contains(numLists.get(lineNum - 1).get(i))) {
				System.out.println("1 num is " + num + " i is " + i);
				return true;
			}
		}
		for (int i = s; i < e && lineNum + 1 < numLists.size(); i++) {
			if (!numLists.get(lineNum + 1).get(i).equals(".") && !numList.contains(numLists.get(lineNum + 1).get(i))) {
				System.out.println("2 num is " + num + " i is " + i);
				return true;
			}
		}
		if (begin >= 0 && !numLists.get(lineNum).get(begin).equals(".")
				&& !numList.contains(numLists.get(lineNum).get(begin))) {
			System.out.println("3 num is " + num);
			return true;
		}
		if (end <= numLists.size() && !numLists.get(lineNum).get(end).equals(".")
				&& !numList.contains(numLists.get(lineNum).get(end))) {
			System.out.println("4 num is " + num);
			return true;
		}
		return symbolExists;
	}

	@Ignore
	public void test6d3p2() {// 79842967
		BufferedReader reader;
		String fileName = "src/test/resources/sample3.txt";
		try {
			reader = new BufferedReader(new FileReader(fileName));
			int sum = 0;
			String line = reader.readLine();
			List<List<String>> numLists = new ArrayList<>();
			while (line != null) {
				numLists.add(Arrays.asList(line.split("")));
				line = reader.readLine();
			}
			List<String> numList = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
			for (int i = 0; i < numLists.size(); i++) {
				System.out.println("Line:" + i + " " + numLists.get(i));
				for (int j = 0; j < numLists.get(i).size(); j++) {
					int begin = i;
					int end = i;
					if (numLists.get(i).get(j).equals("*")) {
						begin = j - 1;
						end = j + 1;
						int product = checkNumNearAsterisk(i, begin, end, numLists, numList);
						if (product != 1) {
							sum += product;
						}
					}
				}
				System.out.println("===================================");
			}
			System.out.println("sum is " + sum);
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public int checkNumNearAsterisk(int lineNum, int begin, int end, List<List<String>> numLists,
			List<String> numList) {
		int product = 1, num = 0;
		List<Integer> numsToMultiply = new ArrayList<>();

		System.out.println("Line: " + lineNum + " begin is " + begin + " end is " + end);
		int s = begin < 0 ? 0 : begin;
		int e = end >= numLists.get(lineNum).size() ? numLists.get(lineNum).size() - 1 : end;
		// after * right to left
		if (end <= numLists.get(lineNum).size() && numList.contains(numLists.get(lineNum).get(end))) {
			StringBuilder numStr = new StringBuilder();
			numStr.append(numLists.get(lineNum).get(e));
			for (int k = e + 1; k <= numLists.get(lineNum).size(); k++) {
				if (numList.contains(numLists.get(lineNum).get(k))) {
					numStr.append(numLists.get(lineNum).get(k));
				} else {
					break;
				}
			}
			num = Integer.parseInt(numStr.toString());
			System.out.println("1 Line:" + lineNum + " num is " + num + " ");
			numsToMultiply.add(num);
		}

		// before * right to left
		if (begin >= 0 && numList.contains(numLists.get(lineNum).get(begin))) {
			StringBuilder numStr = new StringBuilder();
			numStr.append(numLists.get(lineNum).get(s));
			for (int k = s - 1; k >= 0; k--) {
				if (numList.contains(numLists.get(lineNum).get(k))) {
					numStr.append(numLists.get(lineNum).get(k));
				} else {
					break;
				}
			}
			numStr = numStr.reverse();
			num = Integer.parseInt(numStr.toString());
			System.out.println("2 Line:" + lineNum + " num is " + num + " ");
			numsToMultiply.add(num);
		}
		// Top line
		int topLine = lineNum - 1;
		if (topLine >= 0) {
			int finish = s + 1;
			StringBuilder numStr = new StringBuilder();
			if (numList.contains(numLists.get(topLine).get(s))) {
				numStr.append(numLists.get(topLine).get(s));
				for (int k = s - 1; k >= 0; k--) {
					if (numList.contains(numLists.get(topLine).get(k))) {
						numStr.append(numLists.get(topLine).get(k));
					} else {
						break;
					}
				}
				numStr = numStr.reverse();
				for (int k = finish; k < numLists.get(topLine).size(); k++) {
					if (numList.contains(numLists.get(topLine).get(k))) {
						numStr.append(numLists.get(topLine).get(k));
					} else {
						finish++;
						break;
					}
					finish++;
				}
				num = Integer.parseInt(numStr.toString());
				System.out.println("3 Line:" + topLine + " num is " + num);
				numsToMultiply.add(num);
			}

			while (finish <= e) {
				if (numList.contains(numLists.get(topLine).get(finish))) {
					StringBuilder numStr2 = new StringBuilder();
					numStr2.append(numLists.get(topLine).get(finish));
					for (int k = finish + 1; k < numLists.get(topLine).size(); k++) {
						if (numList.contains(numLists.get(topLine).get(k))) {
							numStr2.append(numLists.get(topLine).get(k));
						} else {
							break;
						}
					}
					if (numStr2.length() > 0) {
						num = Integer.parseInt(numStr2.toString());
						System.out.println("4 Line:" + topLine + " num is " + num + " ");
						numsToMultiply.add(num);
						break;
					}
				}
				finish++;
			}
		}
		// Bottom line
		int bottomLine = lineNum + 1;
		if (bottomLine < numLists.size()) {
			int finish = s + 1;
			StringBuilder numStr = new StringBuilder();
			if (numList.contains(numLists.get(bottomLine).get(s))) {
				numStr.append(numLists.get(bottomLine).get(s));
				for (int k = s - 1; k >= 0; k--) {
					if (numList.contains(numLists.get(bottomLine).get(k))) {
						numStr.append(numLists.get(bottomLine).get(k));
					} else {
						break;
					}
				}
				numStr = numStr.reverse();
				for (int k = finish; k < numLists.get(bottomLine).size(); k++) {
					if (numList.contains(numLists.get(bottomLine).get(k))) {
						numStr.append(numLists.get(bottomLine).get(k));
					} else {
						finish++;
						break;
					}
					finish++;
				}
				num = Integer.parseInt(numStr.toString());
				System.out.println("5 Line:" + bottomLine + " num is " + num);
				numsToMultiply.add(num);
			}

			while (finish <= e) {
				if (numList.contains(numLists.get(bottomLine).get(finish))) {
					StringBuilder numStr2 = new StringBuilder();
					numStr2.append(numLists.get(bottomLine).get(finish));
					for (int k = finish + 1; k < numLists.get(bottomLine).size(); k++) {
						if (numList.contains(numLists.get(bottomLine).get(k))) {
							numStr2.append(numLists.get(bottomLine).get(k));
						} else {
							break;
						}
					}
					if (numStr2.length() > 0) {
						num = Integer.parseInt(numStr2.toString());
						System.out.println("6 Line:" + bottomLine + " num is " + num + " ");
						numsToMultiply.add(num);
						break;
					}
				}
				finish++;
			}
		}
		if (numsToMultiply.size() == 2) {
			product = numsToMultiply.get(0) * numsToMultiply.get(1);
		}
		System.out.println("Line :" + lineNum + " count is " + numsToMultiply.size() + " product is " + product);
		return product;
	}

	@Ignore
	public void test7d4p1() {// 79842967
		BufferedReader reader;
		String filePath = "src/test/resources/sample4.txt";
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			int sum = 0;
			while (line != null) {
				int count = 1;
				boolean found = false;
				String[] strArr = line.split(":");
				for (String s : strArr) {
					System.out.println("count " + count + " " + s);
				}
				String[] numsWinArr = strArr[1].split("\\|");
				for (String s : numsWinArr) {
					System.out.println("Val " + s);
				}
				Set<Integer> winSet = new HashSet<>();
				String[] numWinArr = numsWinArr[0].trim().split(" ");
				for (String s : numWinArr) {
					if (s.trim().length() != 0) {
						winSet.add(Integer.parseInt(s));
						System.out.print("win num " + s);
					}
				}
				System.out.println();
				System.out.println();
				List<Integer> numList = new ArrayList<>();
				String[] myNumsArr = numsWinArr[1].trim().split(" ");
				for (String s : myNumsArr) {
					if (s.trim().length() != 0) {
						numList.add(Integer.parseInt(s));
						System.out.print("my num " + s);
					}
				}
				System.out.println();
				for (int i = 0; i < numList.size(); i++) {
					if (winSet.contains(numList.get(i))) {
						System.out.println("num " + numList.get(i) + " win num " + "my count " + count);
						count = count * 2;
						found = true;
					}
				}
				System.out.println("my count " + count);
				if (found) {
					sum += count / 2;
				}
				System.out.println("sum current " + sum);
				System.out.println("======================");
				line = reader.readLine();
			}
			System.out.print("sum " + sum);
			reader.close();
		} catch (IOException e) {

		}
	}

	@Ignore
	public void test8d4p2() {// 23806951
		BufferedReader reader;
		String filePath = "src/test/resources/sample4.txt";
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			int sum = 0;
			int[] numCountArr = new int[192];
			Arrays.fill(numCountArr, 1);
			int currIndex = 0;
			while (line != null) {
				int count = 0;
				currIndex++;
				String[] strArr = line.split(":");
				String[] numsWinArr = strArr[1].split("\\|");
				Set<Integer> winSet = new HashSet<>();
				String[] numWinArr = numsWinArr[0].trim().split(" ");
				for (String s : numWinArr) {
					if (s.trim().length() != 0) {
						winSet.add(Integer.parseInt(s));
						System.out.print("win num " + s);
					}
				}
				System.out.println();
				List<Integer> numList = new ArrayList<>();
				String[] myNumsArr = numsWinArr[1].trim().split(" ");
				for (String s : myNumsArr) {
					if (s.trim().length() != 0) {
						numList.add(Integer.parseInt(s));
						System.out.print("my num " + s);
					}
				}
				System.out.println();
				for (int i = 0; i < numList.size(); i++) {
					if (winSet.contains(numList.get(i))) {
						count++;
						System.out.println("win num " + numList.get(i) + " my count " + count);
					}
				}
				for (int i = currIndex; i < currIndex + count; i++) {
					numCountArr[i] += numCountArr[currIndex - 1];
					System.out.println("Card Num " + (i + 1) + " numCountArr " + numCountArr[i]);
				}
				System.out.println(strArr[0] + " my count " + numCountArr[currIndex - 1]);
				sum += numCountArr[currIndex - 1];
				System.out.println("sum current " + sum);
				System.out.println("======================");
				line = reader.readLine();

			}
			System.out.print("sum " + sum);
			reader.close();
		} catch (IOException e) {

		}
	}

	@Ignore
	public void test9d5p1() {// 227653707
		BufferedReader reader;
		String filePath = "src/test/resources/sample5.txt";
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			Map<String, String> seedMap = new HashMap<>();
			Map<String, Map<String, String>> seedToSoilMap = new HashMap<>();
			Map<String, Map<String, String>> soilToFertiliserMap = new HashMap<>();
			Map<String, Map<String, String>> fertiliserToWaterMap = new HashMap<>();
			Map<String, Map<String, String>> waterToLightMap = new HashMap<>();
			Map<String, Map<String, String>> lightToTemperatureMap = new HashMap<>();
			Map<String, Map<String, String>> temperatureToHumidityMap = new HashMap<>();
			Map<String, Map<String, String>> humidityToLocationMap = new HashMap<>();
			Set<Long> seedSet = new HashSet<>();
			Set<List<Long>> seedToSoilSet = new HashSet<>();
			Set<List<Long>> soilToFertiliserSet = new HashSet<>();
			Set<List<Long>> fertiliserToWaterSet = new HashSet<>();
			Set<List<Long>> waterToLightSet = new HashSet<>();
			Set<List<Long>> lightToTemperatureSet = new HashSet<>();
			Set<List<Long>> temperatureToHumiditySet = new HashSet<>();
			Set<List<Long>> humidityToLocationSet = new HashSet<>();
			while (line != null) {
				if (line.startsWith("seeds:")) {
					String seeds = line.substring(line.indexOf(":") + 1);
					String[] seedArr = seeds.trim().split(" ");
					for (String seed : seedArr) {
						seedMap.put("seeds", seed);
						System.out.println("curr seed " + seed);
						seedSet.add(Long.parseLong(seed));
					}
					line = reader.readLine();
				}

				if (line.startsWith("seed-to-soil map:")) {
					line = reader.readLine();
					int count = 1;
					while (line.trim().length() != 0) {
						String[] seedToSoilArr = line.trim().split(" ");
						Map<String, String> map = new HashMap<>();

						long destStart = Long.parseLong(seedToSoilArr[0]);
						long sourceStart = Long.parseLong(seedToSoilArr[1]);
						long range = Long.parseLong(seedToSoilArr[2]);

						map.put("sourceStart", String.valueOf(sourceStart));
						map.put("destStart", String.valueOf(destStart));
						map.put("range", String.valueOf(range));

						seedToSoilMap.put(String.valueOf(count), map);

						System.out.println("current seedToSoilMap " + seedToSoilMap.get(String.valueOf(count)));
//						System.gc();
						// seedToSoilMap2 = LongStream.range(0,
						// range).boxed().collect(Collectors.toMap(i-> i+sourceStart, i->i+destStart));
//						Set<String> set = LongStream.range(0, range).boxed().map(i -> i + sourceStart)
//								.collect(Collectors.toSet());
//						System.gc();

						List<Long> list = new ArrayList<>();
						list.add(sourceStart);
						list.add(sourceStart + range - 1);
						list.add(destStart);
						list.add(destStart + range - 1);

						seedToSoilSet.add(list);
						System.out.println("seedToSoilMap2 : count " + count + " " + seedToSoilSet);
						count++;
						line = reader.readLine();
					}
				}

				if (line.startsWith("soil-to-fertilizer map:")) {
					line = reader.readLine();
					int count = 1;
					while (line.trim().length() != 0) {
						String[] soilToFertiliserArr = line.trim().split(" ");
						Map<String, String> map = new HashMap<>();

						long destStart = Long.parseLong(soilToFertiliserArr[0]);
						long sourceStart = Long.parseLong(soilToFertiliserArr[1]);
						long range = Long.parseLong(soilToFertiliserArr[2]);

						map.put("sourceStart", String.valueOf(sourceStart));
						map.put("destStart", String.valueOf(destStart));
						map.put("range", String.valueOf(range));

						soilToFertiliserMap.put(String.valueOf(count), map);
						System.out.println("current map " + soilToFertiliserMap.get(String.valueOf(count)));
//						System.gc();
//						soilToFertiliserMap2 = LongStream.range(0, range).boxed()
//								.collect(Collectors.toMap(i -> i + sourceStart, i -> i + destStart));
//						System.gc();
//                    soilToFertiliserMap2.put(destStart, sourceStart);
//                    soilToFertiliserMap2.put(destStart+range-1, sourceStart+range-1);

						List<Long> list = new ArrayList<>();
						list.add(sourceStart);
						list.add(sourceStart + range - 1);
						list.add(destStart);
						list.add(destStart + range - 1);

						soilToFertiliserSet.add(list);

						System.out.println("soilToFertiliserMap2 : count " + count + " " + soilToFertiliserSet);

						count++;
						line = reader.readLine();
					}
				}

				if (line.startsWith("fertilizer-to-water map:")) {
					line = reader.readLine();
					int count = 1;
					while (line.trim().length() != 0) {
						String[] fertiliserToWaterArr = line.trim().split(" ");
						Map<String, String> map = new HashMap<>();

						long destStart = Long.parseLong(fertiliserToWaterArr[0]);
						long sourceStart = Long.parseLong(fertiliserToWaterArr[1]);
						long range = Long.parseLong(fertiliserToWaterArr[2]);

						map.put("sourceStart", String.valueOf(sourceStart));
						map.put("destStart", String.valueOf(destStart));
						map.put("range", String.valueOf(range));

						fertiliserToWaterMap.put(String.valueOf(count), map);

//						System.out.println("current map " + fertiliserToWaterMap.get(String.valueOf(count)));
//						System.gc();
//						fertiliserToWaterMap2 = LongStream.range(0, range).boxed()
//								.collect(Collectors.toMap(i -> i + sourceStart, i -> i + destStart));
//						System.gc();
//                    fertiliserToWaterMap2.put(destStart, sourceStart);
//                    fertiliserToWaterMap2.put(destStart+range-1, sourceStart+range-1);

						List<Long> list = new ArrayList<>();
						list.add(sourceStart);
						list.add(sourceStart + range - 1);
						list.add(destStart);
						list.add(destStart + range - 1);

						fertiliserToWaterSet.add(list);

						System.out.println("fertiliserToWaterMap2 : count " + count + " " + fertiliserToWaterSet);

						count++;
						line = reader.readLine();
					}
				}

				if (line.startsWith("water-to-light map:")) {
					line = reader.readLine();
					int count = 1;
					while (line.trim().length() != 0) {
						String[] waterToLightArr = line.trim().split(" ");
						Map<String, String> map = new HashMap<>();

						long destStart = Long.parseLong(waterToLightArr[0]);
						long sourceStart = Long.parseLong(waterToLightArr[1]);
						long range = Long.parseLong(waterToLightArr[2]);

						map.put("sourceStart", String.valueOf(sourceStart));
						map.put("destStart", String.valueOf(destStart));
						map.put("range", String.valueOf(range));

						waterToLightMap.put(String.valueOf(count), map);

						System.out.println("current map " + waterToLightMap.get(String.valueOf(count)));

//						System.gc();
//
//						waterToLightMap2 = LongStream.range(0, range).boxed()
//								.collect(Collectors.toMap(i -> i + sourceStart, i -> i + destStart));
//						System.gc();
//                    waterToLightMap2.put(destStart, sourceStart);
//                    waterToLightMap2.put(destStart+range-1, sourceStart+range-1);

						List<Long> list = new ArrayList<>();
						list.add(sourceStart);
						list.add(sourceStart + range - 1);
						list.add(destStart);
						list.add(destStart + range - 1);

						waterToLightSet.add(list);

						System.out.println("waterToLightMap2 : count " + count + " " + waterToLightSet);

						count++;
						line = reader.readLine();
					}
				}

				if (line.startsWith("light-to-temperature map:")) {
					line = reader.readLine();
					int count = 1;
					while (line.trim().length() != 0) {
						String[] lightToTemperatureArr = line.trim().split(" ");
						Map<String, String> map = new HashMap<>();

						long destStart = Long.parseLong(lightToTemperatureArr[0]);
						long sourceStart = Long.parseLong(lightToTemperatureArr[1]);
						long range = Long.parseLong(lightToTemperatureArr[2]);

						map.put("sourceStart", String.valueOf(sourceStart));
						map.put("destStart", String.valueOf(destStart));
						map.put("range", String.valueOf(range));

						lightToTemperatureMap.put(String.valueOf(count), map);

						System.out.println("current map " + lightToTemperatureMap.get(String.valueOf(count)));

//						System.gc();
//						lightToTemperatureMap2 = LongStream.range(0, range).boxed()
//								.collect(Collectors.toMap(i -> i + sourceStart, i -> i + destStart));
//						System.gc();
//                    lightToTemperatureMap2.put(destStart, sourceStart);
//                    lightToTemperatureMap2.put(destStart+range-1, sourceStart+range-1);

						List<Long> list = new ArrayList<>();
						list.add(sourceStart);
						list.add(sourceStart + range - 1);
						list.add(destStart);
						list.add(destStart + range - 1);

						lightToTemperatureSet.add(list);

						System.out.println("lightToTemperatureMap2 : count " + count + " " + lightToTemperatureSet);

						count++;
						line = reader.readLine();
					}
				}

				if (line.startsWith("temperature-to-humidity map:")) {
					line = reader.readLine();
					int count = 1;
					while (line.trim().length() != 0) {
						String[] temperatureToHumidityArr = line.trim().split(" ");
						Map<String, String> map = new HashMap<>();

						long destStart = Long.parseLong(temperatureToHumidityArr[0]);
						long sourceStart = Long.parseLong(temperatureToHumidityArr[1]);
						long range = Long.parseLong(temperatureToHumidityArr[2]);

						map.put("sourceStart", String.valueOf(sourceStart));
						map.put("destStart", String.valueOf(destStart));
						map.put("range", String.valueOf(range));

						temperatureToHumidityMap.put(String.valueOf(count), map);

						System.out.println("current map " + temperatureToHumidityMap.get(String.valueOf(count)));
//						System.gc();
//						temperatureToHumidityMap2 = LongStream.range(0, range).boxed()
//								.collect(Collectors.toMap(i -> i + sourceStart, i -> i + destStart));
//						System.gc();
//                    temperatureToHumidityMap2.put(destStart, sourceStart);
//                    temperatureToHumidityMap2.put(destStart+range-1, sourceStart+range-1);

						List<Long> list = new ArrayList<>();
						list.add(sourceStart);
						list.add(sourceStart + range - 1);
						list.add(destStart);
						list.add(destStart + range - 1);

						temperatureToHumiditySet.add(list);

						System.out
								.println("temperatureToHumidityMap2 : count " + count + " " + temperatureToHumiditySet);

						count++;
						line = reader.readLine();
					}
				}

				if (line.startsWith("humidity-to-location map:")) {
					line = reader.readLine();
					int count = 1;
					while (line != null) {
						String[] humidityToLocationArr = line.trim().split(" ");
						Map<String, String> map = new HashMap<>();

						long destStart = Long.parseLong(humidityToLocationArr[0]);
						long sourceStart = Long.parseLong(humidityToLocationArr[1]);
						long range = Long.parseLong(humidityToLocationArr[2]);

						map.put("sourceStart", String.valueOf(sourceStart));
						map.put("destStart", String.valueOf(destStart));
						map.put("range", String.valueOf(range));

						humidityToLocationMap.put(String.valueOf(count), map);

						System.out.println("current map " + humidityToLocationMap.get(String.valueOf(count)));
//						System.gc();
//						humidityToLocationMap2 = LongStream.range(0, range).boxed()
//								.collect(Collectors.toMap(i -> i + sourceStart, i -> i + destStart));
//						System.gc();
//                    humidityToLocationMap2.put(destStart, sourceStart);
//                    humidityToLocationMap2.put(destStart+range-1, sourceStart+range-1);

						List<Long> list = new ArrayList<>();
						list.add(sourceStart);
						list.add(sourceStart + range - 1);
						list.add(destStart);
						list.add(destStart + range - 1);

						humidityToLocationSet.add(list);

						System.out.println("humidityToLocationMap2 : count " + count + " " + humidityToLocationSet);

						count++;
						line = reader.readLine();
					}
				}
				line = reader.readLine();
			}

			int count = 0;
			long locationMin = Long.MAX_VALUE;

			for (Long seed : seedSet) {

				long soil = seed;

				for (List list : seedToSoilSet) {

					if (seed >= (long) list.get(0) && seed <= (long) list.get(1)) {
						soil = (long) list.get(2) + seed - (long) list.get(0);
						break;
					}
				}

				System.out.println("soil " + count + " for seed " + seed + " is " + soil);

				long fertiliser = soil;

				for (List list : soilToFertiliserSet) {

					if (soil >= (long) list.get(0) && soil <= (long) list.get(1)) {
						fertiliser = (long) list.get(2) + soil - (long) list.get(0);
						break;
					}
				}

				System.out.println("fertiliser " + count + " for soil " + soil + " is " + fertiliser);

				long water = fertiliser;

				for (List list : fertiliserToWaterSet) {

					if (fertiliser >= (long) list.get(0) && fertiliser <= (long) list.get(1)) {
						water = (long) list.get(2) + fertiliser - (long) list.get(0);
						break;
					}
				}

				System.out.println("water " + count + " for fertiliser " + fertiliser + " is " + water);

				long light = water;

				for (List list : waterToLightSet) {

					if (water >= (long) list.get(0) && water <= (long) list.get(1)) {
						light = (long) list.get(2) + water - (long) list.get(0);
						break;
					}
				}

				System.out.println("light " + count + " for water " + water + " is " + light);

				long temperature = light;

				for (List list : lightToTemperatureSet) {

					if (light >= (long) list.get(0) && light <= (long) list.get(1)) {
						temperature = (long) list.get(2) + light - (long) list.get(0);
						break;
					}
				}

				System.out.println("temperature " + count + " for light " + light + " is " + temperature);

				long humidity = temperature;

				for (List list : temperatureToHumiditySet) {

					if (temperature >= (long) list.get(0) && temperature <= (long) list.get(1)) {
						humidity = (long) list.get(2) + temperature - (long) list.get(0);
						break;
					}
				}

				System.out.println("humidity " + count + " for temperature " + temperature + " is " + humidity);

				long location = humidity;

				for (List list : humidityToLocationSet) {

					if (humidity >= (long) list.get(0) && humidity <= (long) list.get(1)) {
						location = (long) list.get(2) + humidity - (long) list.get(0);
						break;
					}
				}

				System.out.println("location " + count + " for humidity " + humidity + " is " + location);
				count++;

				locationMin = Math.min(locationMin, location);

				System.out.println("locationMin " + count + " is " + locationMin);
			}

			System.out.println("Min location is " + locationMin);
			reader.close();
		} catch (IOException e) {

		}
	}

	@Ignore
	public void test10d5p2() {// 78775051
		BufferedReader reader;
		String filePath = "src/test/resources/sample5.txt";
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			Map<String, String> seedMap = new HashMap<>();
			Map<String, Map<String, String>> seedToSoilMap = new HashMap<>();
			Map<String, Map<String, String>> soilToFertiliserMap = new HashMap<>();
			Map<String, Map<String, String>> fertiliserToWaterMap = new HashMap<>();
			Map<String, Map<String, String>> waterToLightMap = new HashMap<>();
			Map<String, Map<String, String>> lightToTemperatureMap = new HashMap<>();
			Map<String, Map<String, String>> temperatureToHumidityMap = new HashMap<>();
			Map<String, Map<String, String>> humidityToLocationMap = new HashMap<>();
			List<Long> seedList = new ArrayList<>();
			Set<List<Long>> seedToSoilSet = new HashSet<>();
			Set<List<Long>> soilToFertiliserSet = new HashSet<>();
			Set<List<Long>> fertiliserToWaterSet = new HashSet<>();
			Set<List<Long>> waterToLightSet = new HashSet<>();
			Set<List<Long>> lightToTemperatureSet = new HashSet<>();
			Set<List<Long>> temperatureToHumiditySet = new HashSet<>();
			Set<List<Long>> humidityToLocationSet = new HashSet<>();
			while (line != null) {
				if (line.startsWith("seeds:")) {
					String seeds = line.substring(line.indexOf(":") + 1);
					String[] seedArr = seeds.trim().split(" ");
					for (String seed : seedArr) {
						seedMap.put("seeds", seed);
						System.out.println("curr seed " + seed);
						seedList.add(Long.parseLong(seed));
					}
					line = reader.readLine();
				}

				if (line.startsWith("seed-to-soil map:")) {
					line = reader.readLine();
					int count = 1;
					while (line.trim().length() != 0) {
						String[] seedToSoilArr = line.trim().split(" ");
						Map<String, String> map = new HashMap<>();

						long destStart = Long.parseLong(seedToSoilArr[0]);
						long sourceStart = Long.parseLong(seedToSoilArr[1]);
						long range = Long.parseLong(seedToSoilArr[2]);

						map.put("sourceStart", String.valueOf(sourceStart));
						map.put("destStart", String.valueOf(destStart));
						map.put("range", String.valueOf(range));

						seedToSoilMap.put(String.valueOf(count), map);

						System.out.println("current seedToSoilMap " + seedToSoilMap.get(String.valueOf(count)));
//						System.gc();
						// seedToSoilMap2 = LongStream.range(0,
						// range).boxed().collect(Collectors.toMap(i-> i+sourceStart, i->i+destStart));
//						Set<String> set = LongStream.range(0, range).boxed().map(i -> i + sourceStart)
//								.collect(Collectors.toSet());
//						System.gc();

						List<Long> list = new ArrayList<>();
						list.add(sourceStart);
						list.add(sourceStart + range - 1);
						list.add(destStart);
						list.add(destStart + range - 1);

						seedToSoilSet.add(list);
						System.out.println("seedToSoilMap2 : count " + count + " " + seedToSoilSet);
						count++;
						line = reader.readLine();
					}
				}

				if (line.startsWith("soil-to-fertilizer map:")) {
					line = reader.readLine();
					int count = 1;
					while (line.trim().length() != 0) {
						String[] soilToFertiliserArr = line.trim().split(" ");
						Map<String, String> map = new HashMap<>();

						long destStart = Long.parseLong(soilToFertiliserArr[0]);
						long sourceStart = Long.parseLong(soilToFertiliserArr[1]);
						long range = Long.parseLong(soilToFertiliserArr[2]);

						map.put("sourceStart", String.valueOf(sourceStart));
						map.put("destStart", String.valueOf(destStart));
						map.put("range", String.valueOf(range));

						soilToFertiliserMap.put(String.valueOf(count), map);
						System.out.println("current map " + soilToFertiliserMap.get(String.valueOf(count)));
//						System.gc();
//						soilToFertiliserMap2 = LongStream.range(0, range).boxed()
//								.collect(Collectors.toMap(i -> i + sourceStart, i -> i + destStart));
//						System.gc();
//                    soilToFertiliserMap2.put(destStart, sourceStart);
//                    soilToFertiliserMap2.put(destStart+range-1, sourceStart+range-1);

						List<Long> list = new ArrayList<>();
						list.add(sourceStart);
						list.add(sourceStart + range - 1);
						list.add(destStart);
						list.add(destStart + range - 1);

						soilToFertiliserSet.add(list);

						System.out.println("soilToFertiliserMap2 : count " + count + " " + soilToFertiliserSet);

						count++;
						line = reader.readLine();
					}
				}

				if (line.startsWith("fertilizer-to-water map:")) {
					line = reader.readLine();
					int count = 1;
					while (line.trim().length() != 0) {
						String[] fertiliserToWaterArr = line.trim().split(" ");
						Map<String, String> map = new HashMap<>();

						long destStart = Long.parseLong(fertiliserToWaterArr[0]);
						long sourceStart = Long.parseLong(fertiliserToWaterArr[1]);
						long range = Long.parseLong(fertiliserToWaterArr[2]);

						map.put("sourceStart", String.valueOf(sourceStart));
						map.put("destStart", String.valueOf(destStart));
						map.put("range", String.valueOf(range));

						fertiliserToWaterMap.put(String.valueOf(count), map);

//						System.out.println("current map " + fertiliserToWaterMap.get(String.valueOf(count)));
//						System.gc();
//						fertiliserToWaterMap2 = LongStream.range(0, range).boxed()
//								.collect(Collectors.toMap(i -> i + sourceStart, i -> i + destStart));
//						System.gc();
//                    fertiliserToWaterMap2.put(destStart, sourceStart);
//                    fertiliserToWaterMap2.put(destStart+range-1, sourceStart+range-1);

						List<Long> list = new ArrayList<>();
						list.add(sourceStart);
						list.add(sourceStart + range - 1);
						list.add(destStart);
						list.add(destStart + range - 1);

						fertiliserToWaterSet.add(list);

						System.out.println("fertiliserToWaterMap2 : count " + count + " " + fertiliserToWaterSet);

						count++;
						line = reader.readLine();
					}
				}

				if (line.startsWith("water-to-light map:")) {
					line = reader.readLine();
					int count = 1;
					while (line.trim().length() != 0) {
						String[] waterToLightArr = line.trim().split(" ");
						Map<String, String> map = new HashMap<>();

						long destStart = Long.parseLong(waterToLightArr[0]);
						long sourceStart = Long.parseLong(waterToLightArr[1]);
						long range = Long.parseLong(waterToLightArr[2]);

						map.put("sourceStart", String.valueOf(sourceStart));
						map.put("destStart", String.valueOf(destStart));
						map.put("range", String.valueOf(range));

						waterToLightMap.put(String.valueOf(count), map);

						System.out.println("current map " + waterToLightMap.get(String.valueOf(count)));

//						System.gc();
//
//						waterToLightMap2 = LongStream.range(0, range).boxed()
//								.collect(Collectors.toMap(i -> i + sourceStart, i -> i + destStart));
//						System.gc();
//                    waterToLightMap2.put(destStart, sourceStart);
//                    waterToLightMap2.put(destStart+range-1, sourceStart+range-1);

						List<Long> list = new ArrayList<>();
						list.add(sourceStart);
						list.add(sourceStart + range - 1);
						list.add(destStart);
						list.add(destStart + range - 1);

						waterToLightSet.add(list);

						System.out.println("waterToLightMap2 : count " + count + " " + waterToLightSet);

						count++;
						line = reader.readLine();
					}
				}

				if (line.startsWith("light-to-temperature map:")) {
					line = reader.readLine();
					int count = 1;
					while (line.trim().length() != 0) {
						String[] lightToTemperatureArr = line.trim().split(" ");
						Map<String, String> map = new HashMap<>();

						long destStart = Long.parseLong(lightToTemperatureArr[0]);
						long sourceStart = Long.parseLong(lightToTemperatureArr[1]);
						long range = Long.parseLong(lightToTemperatureArr[2]);

						map.put("sourceStart", String.valueOf(sourceStart));
						map.put("destStart", String.valueOf(destStart));
						map.put("range", String.valueOf(range));

						lightToTemperatureMap.put(String.valueOf(count), map);

						System.out.println("current map " + lightToTemperatureMap.get(String.valueOf(count)));

//						System.gc();
//						lightToTemperatureMap2 = LongStream.range(0, range).boxed()
//								.collect(Collectors.toMap(i -> i + sourceStart, i -> i + destStart));
//						System.gc();
//                    lightToTemperatureMap2.put(destStart, sourceStart);
//                    lightToTemperatureMap2.put(destStart+range-1, sourceStart+range-1);

						List<Long> list = new ArrayList<>();
						list.add(sourceStart);
						list.add(sourceStart + range - 1);
						list.add(destStart);
						list.add(destStart + range - 1);

						lightToTemperatureSet.add(list);

						System.out.println("lightToTemperatureMap2 : count " + count + " " + lightToTemperatureSet);

						count++;
						line = reader.readLine();
					}
				}

				if (line.startsWith("temperature-to-humidity map:")) {
					line = reader.readLine();
					int count = 1;
					while (line.trim().length() != 0) {
						String[] temperatureToHumidityArr = line.trim().split(" ");
						Map<String, String> map = new HashMap<>();

						long destStart = Long.parseLong(temperatureToHumidityArr[0]);
						long sourceStart = Long.parseLong(temperatureToHumidityArr[1]);
						long range = Long.parseLong(temperatureToHumidityArr[2]);

						map.put("sourceStart", String.valueOf(sourceStart));
						map.put("destStart", String.valueOf(destStart));
						map.put("range", String.valueOf(range));

						temperatureToHumidityMap.put(String.valueOf(count), map);

						System.out.println("current map " + temperatureToHumidityMap.get(String.valueOf(count)));
//						System.gc();
//						temperatureToHumidityMap2 = LongStream.range(0, range).boxed()
//								.collect(Collectors.toMap(i -> i + sourceStart, i -> i + destStart));
//						System.gc();
//                    temperatureToHumidityMap2.put(destStart, sourceStart);
//                    temperatureToHumidityMap2.put(destStart+range-1, sourceStart+range-1);

						List<Long> list = new ArrayList<>();
						list.add(sourceStart);
						list.add(sourceStart + range - 1);
						list.add(destStart);
						list.add(destStart + range - 1);

						temperatureToHumiditySet.add(list);

						System.out
								.println("temperatureToHumidityMap2 : count " + count + " " + temperatureToHumiditySet);

						count++;
						line = reader.readLine();
					}
				}

				if (line.startsWith("humidity-to-location map:")) {
					line = reader.readLine();
					int count = 1;
					while (line != null) {
						String[] humidityToLocationArr = line.trim().split(" ");
						Map<String, String> map = new HashMap<>();

						long destStart = Long.parseLong(humidityToLocationArr[0]);
						long sourceStart = Long.parseLong(humidityToLocationArr[1]);
						long range = Long.parseLong(humidityToLocationArr[2]);

						map.put("sourceStart", String.valueOf(sourceStart));
						map.put("destStart", String.valueOf(destStart));
						map.put("range", String.valueOf(range));

						humidityToLocationMap.put(String.valueOf(count), map);

						System.out.println("current map " + humidityToLocationMap.get(String.valueOf(count)));
//						System.gc();
//						humidityToLocationMap2 = LongStream.range(0, range).boxed()
//								.collect(Collectors.toMap(i -> i + sourceStart, i -> i + destStart));
//						System.gc();
//                    humidityToLocationMap2.put(destStart, sourceStart);
//                    humidityToLocationMap2.put(destStart+range-1, sourceStart+range-1);

						List<Long> list = new ArrayList<>();
						list.add(sourceStart);
						list.add(sourceStart + range - 1);
						list.add(destStart);
						list.add(destStart + range - 1);

						humidityToLocationSet.add(list);

						System.out.println("humidityToLocationMap2 : count " + count + " " + humidityToLocationSet);

						count++;
						line = reader.readLine();
					}
				}
				line = reader.readLine();
			}

			int count = 0;
			long locationMin = Long.MAX_VALUE;

			for (Long seed : seedList) {

				seed = seedList.get(count);

				for (long seedStart = seed; seedStart < seed + seedList.get(count + 1); seedStart++) {

					long soil = seedStart;

					for (List list : seedToSoilSet) {

						if (seedStart >= (long) list.get(0) && seedStart <= (long) list.get(1)) {
							soil = (long) list.get(2) + seedStart - (long) list.get(0);
							break;
						}
					}

					// System.out.println("soil " + count + " for seed " + seedStart + " is " +
					// soil);

					long fertiliser = soil;

					for (List list : soilToFertiliserSet) {

						if (soil >= (long) list.get(0) && soil <= (long) list.get(1)) {
							fertiliser = (long) list.get(2) + soil - (long) list.get(0);
							break;
						}
					}

					// System.out.println("fertiliser " + count + " for soil " + soil + " is " +
					// fertiliser);

					long water = fertiliser;

					for (List list : fertiliserToWaterSet) {

						if (fertiliser >= (long) list.get(0) && fertiliser <= (long) list.get(1)) {
							water = (long) list.get(2) + fertiliser - (long) list.get(0);
							break;
						}
					}

					// System.out.println("water " + count + " for fertiliser " + fertiliser + " is
					// " + water);

					long light = water;

					for (List list : waterToLightSet) {

						if (water >= (long) list.get(0) && water <= (long) list.get(1)) {
							light = (long) list.get(2) + water - (long) list.get(0);
							break;
						}
					}

					// System.out.println("light " + count + " for water " + water + " is " +
					// light);

					long temperature = light;

					for (List list : lightToTemperatureSet) {

						if (light >= (long) list.get(0) && light <= (long) list.get(1)) {
							temperature = (long) list.get(2) + light - (long) list.get(0);
							break;
						}
					}

					// System.out.println("temperature " + count + " for light " + light + " is " +
					// temperature);

					long humidity = temperature;

					for (List list : temperatureToHumiditySet) {

						if (temperature >= (long) list.get(0) && temperature <= (long) list.get(1)) {
							humidity = (long) list.get(2) + temperature - (long) list.get(0);
							break;
						}
					}

					// System.out.println("humidity " + count + " for temperature " + temperature +
					// " is " + humidity);

					long location = humidity;

					for (List list : humidityToLocationSet) {

						if (humidity >= (long) list.get(0) && humidity <= (long) list.get(1)) {
							location = (long) list.get(2) + humidity - (long) list.get(0);
							break;
						}
					}

					// System.out.println("location " + count + " for humidity " + humidity + " is "
					// + location);

					locationMin = Math.min(locationMin, location);

					// System.out.println("locationMin " + count + " is " + locationMin);

				}

				count = count + 2;
				System.gc();
				if (count >= seedList.size()) {
					break;
				}
			}

			System.out.println("Min location is " + locationMin);
			reader.close();
		} catch (IOException e) {

		}
	}

	@Ignore
	public void test11d6p1() {// 138915
		BufferedReader reader;
		String path = "src/test/resources/sample6.txt";

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

	@Ignore
	public void test12d6p2() {// 27340847
		BufferedReader reader;
		String path = "src/test/resources/sample6.txt";

		long time = 0l;
		long distance = 0l;

		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();

			line = line.split(":")[1].trim();
			time = Long.parseLong(line.replaceAll(" ", ""));
			System.out.println("time - " + time);

			line = reader.readLine();
			line = line.split(":")[1].trim();
			distance = Long.parseLong(line.replaceAll(" ", ""));

			System.out.println("distance - " + distance);

		} catch (IOException e) {

		}

		long count = 0;
		for (long i = 0; i < time; i++) {
			if (i * (time - i) > distance) {
				count++;
			}
		}

		System.out.println("for time " + time + " count is " + count);

	}

	@Ignore
	public void test13d7p1() {// 250120186
		BufferedReader reader;
		String path = "src/test/resources/sample7.txt";
		List<String> list = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();

			while (line != null) {
				list.add(line);
				line = reader.readLine();
			}

			System.out.println("list " + list);

		} catch (IOException e) {

		}

		List<String> list5Kind = new ArrayList<>(); // AAAAA 1
		List<String> list4Kind = new ArrayList<>(); // AAAAB 2
		List<String> listFullHouse = new ArrayList<>(); // AAABB 2
		List<String> list3kind = new ArrayList<>(); // AAABC 3
		List<String> list2Pair = new ArrayList<>(); // AABBC 3
		List<String> list1Pair = new ArrayList<>(); // AABCD 4
		List<String> listHighKind = new ArrayList<>(); // ABCDE 5

		Set<String> set = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();

		for (String cardsBid : list) {

			String s = cardsBid.substring(0, 5);
			String[] cardArr = s.split("");

			set.addAll(Arrays.asList(cardArr));

			if (set.size() == 1) {
				list5Kind.add(cardsBid);

			} else if (set.size() == 5) {
				listHighKind.add(cardsBid);

			} else if (set.size() == 4) {
				list1Pair.add(cardsBid);

			} else if (set.size() == 3) {

				for (String str : cardArr) {
					map.put(str, map.getOrDefault(str, 0) + 1);
				}

				System.out.println("String " + s + " has map" + map);

				if (map.values().contains(3)) {
					list3kind.add(cardsBid);

				} else {
					list2Pair.add(cardsBid);

				}

				map.clear();

			} else {

				for (String str : cardArr) {
					map.put(str, map.getOrDefault(str, 0) + 1);
				}

				System.out.println("String " + s + " has map" + map);

				if (map.values().contains(3)) {
					listFullHouse.add(cardsBid);

				} else {
					list4Kind.add(cardsBid);

				}
				map.clear();
			}
			System.out.println("set " + set);
			set.clear();
		}

		list.clear();

		System.out.println("listHighKind " + listHighKind);

		listHighKind.sort(new CardComparator());

		System.out.println("listHighKind sorted " + listHighKind);
		System.out.println("list1Pair " + list1Pair);

		list1Pair.sort(new CardComparator());

		System.out.println("list1Pair sorted " + list1Pair);
		System.out.println("list2Pair " + list2Pair);

		list2Pair.sort(new CardComparator());

		System.out.println("list2Pair sorted " + list2Pair);
		System.out.println("list3kind " + list3kind);

		list3kind.sort(new CardComparator());

		System.out.println("list3kind sorted " + list3kind);
		System.out.println("listFullHouse " + listFullHouse);

		listFullHouse.sort(new CardComparator());

		System.out.println("listFullHouse sorted " + listFullHouse);
		System.out.println("list4Kind " + list4Kind);

		list4Kind.sort(new CardComparator());

		System.out.println("list4Kind sorted " + list4Kind);
		System.out.println("list5Kind " + list5Kind);

		list5Kind.sort(new CardComparator());

		System.out.println("list5Kind sorted " + list5Kind);

		list.addAll(listHighKind);
		list.addAll(list1Pair);
		list.addAll(list2Pair);
		list.addAll(list3kind);
		list.addAll(listFullHouse);
		list.addAll(list4Kind);
		list.addAll(list5Kind);

		System.out.println("list " + list);

		int count = 1;
		long product = 0;
		for (String s : list) {
			long bid = Long.parseLong(s.substring(6));
			product += bid * count;
			count++;
		}
		System.out.println("product " + product);
	}

	@Ignore
	public void test14d7p2() {// 250665248

		BufferedReader reader;
		String path = "src/test/resources/sample7.txt";
		List<String> list = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();

			while (line != null) {
				list.add(line);
				line = reader.readLine();
			}

			System.out.println("list " + list);

		} catch (IOException e) {

		}

		List<String> list5Kind = new ArrayList<>(); // AAAAA 1 done
		List<String> list4Kind = new ArrayList<>(); // AAAAB 2
		List<String> listFullHouse = new ArrayList<>(); // AAABB 2
		List<String> list3kind = new ArrayList<>(); // AAABC 3
		List<String> list2Pair = new ArrayList<>(); // AABBC 3
		List<String> list1Pair = new ArrayList<>(); // AABCD 4 done
		List<String> listHighKind = new ArrayList<>(); // ABCDE 5 done

		Set<String> set = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();

		for (String cardsBid : list) {

			String s = cardsBid.substring(0, 5);
			String[] cardArr = s.split("");

			for (String str : cardArr) {
				map.put(str, map.getOrDefault(str, 0) + 1);
			}

			set.addAll(Arrays.asList(cardArr));

			if (set.size() == 1) {
				list5Kind.add(cardsBid);

			} else if (set.size() == 5 && !set.contains("J")) {
				listHighKind.add(cardsBid);

			} else if (set.size() == 5 && set.contains("J")) {
				list1Pair.add(cardsBid);

			} else if (set.size() == 4 && !set.contains("J")) {
				list1Pair.add(cardsBid);

			} else if (set.size() == 4 && set.contains("J")) {// || (map.getOrDefault("J", 0) == 2 ||
																// map.getOrDefault("J", 0) == 1) - ABCJJ or AAJBC so 3
																// kind with higher priority
				list3kind.add(cardsBid);

			} else if (set.size() == 3 && !set.contains("J")) {
				System.out.println("String " + s + " has map" + map);

				if (map.values().contains(3)) {
					list3kind.add(cardsBid);

				} else {
					list2Pair.add(cardsBid);

				}

				map.clear();

			} else if (set.size() == 3 && set.contains("J")) {// JJJAB or AAABJ or JJAAB or AABBJ
				System.out.println("String " + s + " has map" + map);

				if (map.values().contains(3)) {// && (map.getOrDefault("J", 0) == 3 || map.getOrDefault("J", 0) == 1)
												// both has AAAAB
					list4Kind.add(cardsBid);

				} else if (map.values().contains(2) && map.getOrDefault("J", 0) == 2) {// AAAAB
					list4Kind.add(cardsBid);

				} else {// AAABB
					listFullHouse.add(cardsBid);

				}

				map.clear();

			} else if (set.size() == 2 && !set.contains("J")) {
				System.out.println("String " + s + " has map" + map);

				if (map.values().contains(3)) {
					listFullHouse.add(cardsBid);

				} else {
					list4Kind.add(cardsBid);

				}
				map.clear();
			} else {// AAAAJ or JJJJA or JJJAA or AAJJJ
				System.out.println("String " + s + " has map" + map);

				list5Kind.add(cardsBid);

			}
			System.out.println("set " + set);
			set.clear();
			map.clear();
		}

		list.clear();

		System.out.println("listHighKind " + listHighKind);

		listHighKind.sort(new CardComparatorJok());

		System.out.println("listHighKind sorted " + listHighKind);
		System.out.println("list1Pair " + list1Pair);

		list1Pair.sort(new CardComparatorJok());

		System.out.println("list1Pair sorted " + list1Pair);
		System.out.println("list2Pair " + list2Pair);

		list2Pair.sort(new CardComparatorJok());

		System.out.println("list2Pair sorted " + list2Pair);
		System.out.println("list3kind " + list3kind);

		list3kind.sort(new CardComparatorJok());

		System.out.println("list3kind sorted " + list3kind);
		System.out.println("listFullHouse " + listFullHouse);

		listFullHouse.sort(new CardComparatorJok());

		System.out.println("listFullHouse sorted " + listFullHouse);
		System.out.println("list4Kind " + list4Kind);

		list4Kind.sort(new CardComparatorJok());

		System.out.println("list4Kind sorted " + list4Kind);
		System.out.println("list5Kind " + list5Kind);

		list5Kind.sort(new CardComparatorJok());

		System.out.println("list5Kind sorted " + list5Kind);

		list.addAll(listHighKind);
		list.addAll(list1Pair);
		list.addAll(list2Pair);
		list.addAll(list3kind);
		list.addAll(listFullHouse);
		list.addAll(list4Kind);
		list.addAll(list5Kind);

		System.out.println("list " + list);

		int count = 1;
		long product = 0;
		for (String s : list) {
			long bid = Long.parseLong(s.substring(6));
			product += bid * count;
			count++;
		}
		System.out.println("product " + product);
	}

	@Ignore
	public void test15d8p1() {// 19199
		BufferedReader reader;
		String path = "src/test/resources/sample8.txt";
		Map<String, List<String>> map = new HashMap<>();
		String instructions = "";

		try {

			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();

			while (line != null) {
				instructions = line;

				line = reader.readLine();
				line = reader.readLine();

				while (line != null) {

					line = line.replaceAll("\\(", "").replaceAll("\\)", "");

					String[] nodes = line.split("=");

					String[] choiceArr = nodes[1].trim().split(",");

					List<String> choices = Arrays.asList(choiceArr[0].trim(), choiceArr[1].trim());

					System.out.println(
							"choices " + choices + " for vals - " + choiceArr[0].trim() + " " + choiceArr[1].trim());

					map.put(nodes[0].trim(), choices);

					line = reader.readLine();
				}

			}

		} catch (IOException e) {

		}
		System.out.println("instruction is " + instructions + " map " + map);

		String val = "AAA";
		int count = 0;
		int step = 0;
		while (!val.equals("ZZZ")) {

			if (count == instructions.length()) {
				count = 0;
			}

			char instruction = instructions.charAt(count);

			if (instruction == 'L') {
				val = map.get(val).get(0);
			} else {
				val = map.get(val).get(1);
			}

			System.out.println("val is " + val);
			count++;
			step++;
		}

		System.out.println("step is " + step);
	}

	@Ignore
	public void test16d8p2() {//13663968099527
		BufferedReader reader;
		String path = "src/test/resources/sample8.txt";
		Map<String, List<String>> map = new HashMap<>();
		String instructions = "";
		List<String> nodesEndWithAList = new ArrayList<>();

		try {

			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();

			while (line != null) {
				instructions = line;

				line = reader.readLine();
				line = reader.readLine();

				while (line != null) {

					line = line.replaceAll("\\(", "").replaceAll("\\)", "");
					String[] nodes = line.split("=");

					String[] choiceArr = nodes[1].trim().split(",");

					List<String> choices = Arrays.asList(choiceArr[0].trim(), choiceArr[1].trim());

					System.out.println(
							"choices " + choices + " for vals - " + choiceArr[0].trim() + " " + choiceArr[1].trim());

					String startNode = nodes[0].trim();

					map.put(startNode, choices);

					if (startNode.endsWith("A")) {
						nodesEndWithAList.add(startNode.trim());
					}

					line = reader.readLine();
				}

			}

		} catch (IOException e) {

		}
		System.out.println("instruction is " + instructions + " map " + map);
		System.out.println("nodesEndWithA is " + nodesEndWithAList);

//		String val1 = nodesEndWithAList.get(0);
//		String val2 = nodesEndWithAList.get(1);
//		String val3 = nodesEndWithAList.get(2);
//		String val4 = nodesEndWithAList.get(3);
//		String val5 = nodesEndWithAList.get(4);
//		String val6 = nodesEndWithAList.get(5);
//		
//		int count = 0;
//		long step = 0;
//
//		while (!val1.endsWith("Z") || !val2.endsWith("Z") || !val3.endsWith("Z") || !val4.endsWith("Z") || !val5.endsWith("Z") || !val6.endsWith("Z")) {
//
//			if (count == instructions.length()) {
//				count = 0;
//			}
//
//			char instruction = instructions.charAt(count);
//
//			if (instruction == 'L') {
//				val1 = map.get(val1).get(0);
//				val2 = map.get(val2).get(0);
//				val3 = map.get(val3).get(0);
//				val4 = map.get(val4).get(0);
//				val5 = map.get(val5).get(0);
//				val6 = map.get(val6).get(0);
//			} else {
//				val1 = map.get(val1).get(1);
//				val2 = map.get(val2).get(1);
//				val3 = map.get(val3).get(1);
//				val4 = map.get(val4).get(1);
//				val5 = map.get(val5).get(1);
//				val6 = map.get(val6).get(1);
//			}

//			System.out.println("instruction is " + instruction);
//			System.out.println("val1 is " + val1);
//			System.out.println("val2 is " + val2);
//			System.out.println("val3 is " + val3);
//			System.out.println("val4 is " + val4);
//			System.out.println("val5 is " + val5);
//			System.out.println("val6 is " + val6);
			
//			if(step % 100000000 == 0) {
//				System.out.println("step is " + step);
//			}
//			count++;
//			step++;
//		}
//		System.out.println("step is " + step);
		
		long[] lcmArr = new long[nodesEndWithAList.size()];
		int i = 0;

		for(String nodeEndingA : nodesEndWithAList) {
			
			int count = 0;
			long step = 0;
			String val = nodeEndingA;
			System.out.println("val is " + val);
			
			while(!val.endsWith("Z")) {
				
				if(count == instructions.length()) {
					count = 0;
				}
				
				char instruction = instructions.charAt(count);
				
				if(instruction == 'L') {
					val = map.get(val).get(0);
				} else {
					val = map.get(val).get(1);
				}
				
				//System.out.println("val is " + val);
				count++;
				step++;
			}
			
			System.out.println("step is " + step);
			
			lcmArr[i++] = step;
			System.out.println("maxStep is " + lcmArr[i-1]);
			
		}
		for(long steps: lcmArr) {
			System.out.println("step in array is " + steps);
		}
		
		long lcm = lcmFind(lcmArr);
		System.out.println("lcm is " + lcm);

	}

	public long lcmFind(long[] lcmArr) {

		long lcm = lcmArr[0];
		for (int i = 1; i < lcmArr.length; i++) {
			long currentNum = lcmArr[i];
			lcm = (lcm * currentNum) / (gcdFind(lcm, currentNum));
		}
		return lcm;
	}

	public long gcdFind(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcdFind(b, a % b);
	}
	
	@Ignore
	public void test17d9p1() {//2098530125
		BufferedReader reader;
		String path = "src/test/resources/sample9.txt";
		List<List<Long>> sequenceList = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
			
			int counter = 1;
			while(line != null) {
				
				List<Long> currList = Arrays.asList(line.split(" ")).stream().map(i -> Long.parseLong(i)).toList();
				
				sequenceList.add(currList);
				System.out.println("count " + counter + " currList is " + currList);
				counter++;
				line = reader.readLine();
			}
			
		} catch (IOException e) {
			
		}
		System.out.println("sequenceList is " + sequenceList);
		
		int sum = 0;
		int count = 1;
		
		for(List<Long> list: sequenceList) {
			
			List<Long> nextElementList = new ArrayList<>();
		
			nextElementList.add(list.get(list.size()-1));
			
			Long nextElement = nextElement(list, nextElementList);
			System.out.println("count " + count + " nextElement is " + nextElement);
			count++;
			sum += nextElement;
			System.out.println("sum is " + sum);
			
		}
		System.out.println("Final sum is " + sum);
	}
	
	public Long nextElement(List<Long> list, List<Long> nextElementList) {
		//System.out.println("the list is " + list);
		
		long nextElement = 0;
		
		List<Long> currList = new ArrayList<>();
		
		for(int i = 0; i<list.size()-1; i++) {
			currList.add(list.get(i+1)-list.get(i));
		}
		
		List<Long> distinctList = currList.stream().distinct().collect(Collectors.toList());
		
		System.out.println("currList is " + currList);
		if(distinctList.size() == 1) {
			nextElementList.add(distinctList.get(0));
			System.out.println("nextElementList is " + nextElementList);
			nextElement = nextElementList.stream().reduce(0l, Long:: sum);
			return nextElement;
		}
		System.out.println("last element of currList is " + currList.get(currList.size()-1));
		nextElementList.add(currList.get(currList.size()-1));
		return nextElement(currList, nextElementList);
		
	}
	
	
	@Ignore
	public void test18d9p2() {//1016
		BufferedReader reader;
		String path = "src/test/resources/sample9.txt";
		List<List<Long>> sequenceList = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
			
			int counter = 1;
			while(line != null) {
				
				List<Long> currList = Arrays.asList(line.split(" ")).stream().map(i -> Long.parseLong(i)).toList();
				
				sequenceList.add(currList);
				System.out.println("count " + counter + " currList is " + currList);
				counter++;
				line = reader.readLine();
			}
			
		} catch (IOException e) {
			
		}
		System.out.println("sequenceList is " + sequenceList);
		
		int sum = 0;
		int count = 1;
		
		for(List<Long> list: sequenceList) {
			
			List<Long> prevElementList = new ArrayList<>();
		
			System.out.println("initial list is " + list);
			
			Long prevElement = prevElement(list, prevElementList);

			prevElement = list.get(0) - prevElement;
			
			System.out.println("count " + count + " prevElement is " + prevElement);
			count++;
			sum += prevElement;
			System.out.println("sum is " + sum);
			
		}
		System.out.println("Final sum is " + sum);
	}
	
	public Long prevElement(List<Long> list, List<Long> prevElementList) {
		
		long prevElement = 0;
		
		List<Long> currList = new ArrayList<>();
		
		for(int i = 0; i<list.size()-1; i++) {
			currList.add(list.get(i+1)-list.get(i));
		}
		
		List<Long> distinctList = currList.stream().distinct().collect(Collectors.toList());
		
		System.out.println("currList is " + currList);
		
		if(distinctList.size() == 1) {
			prevElementList.add(distinctList.get(0));
			System.out.println("prevElementList is " + prevElementList);
			int multiplier = 1;
			for(long num: prevElementList) {
				num = num*multiplier;
				prevElement += num;
				multiplier = multiplier == 1 ? -1 : 1;
			}
			return prevElement;
		}
		System.out.println("first element of currList is " + currList.get(0));
		prevElementList.add(currList.get(0));
		return prevElement(currList, prevElementList);
		
	}
	
	@Test
	public void test19d10p1() {//
		BufferedReader reader;
		String path = "src/test/resources/sample10.txt";
		
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
			
		}
		
		
	}
	
	@Test
	public void test20d10p2() {//
		BufferedReader reader;
		String path = "src/test/resources/sample10.txt";
		
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
			
		}
		
		
	}
	
	@Test
	public void test21d11p1() {//
		BufferedReader reader;
		String path = "src/test/resources/sample11.txt";
		
		List<String> list = new ArrayList<>();
		
		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
			
			while(line != null) {
				
				
				line = reader.readLine();
				
			}
		} catch(IOException e) {
			
		}
		
		
	}
	

}
