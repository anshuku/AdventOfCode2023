package com.practice.days.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//532445
public class Day3Problem1 {
	
	public static void main(String[] args) {
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
	

	public static boolean checkSymbolNearForNum(int num, int lineNum, int begin, int end, List<List<String>> numLists,
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

	

}
