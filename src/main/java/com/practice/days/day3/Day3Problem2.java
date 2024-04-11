package com.practice.days.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//79842967
public class Day3Problem2 {
	
	public static void main(String[] args) {
		BufferedReader reader;
		String fileName = "src/main/resources/sample3.txt";
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
	
	public static int checkNumNearAsterisk(int lineNum, int begin, int end, List<List<String>> numLists,
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

	

}
