package com.practice.days.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//13663968099527
public class Day8Problem2 {

	public static void main(String[] args) {
		BufferedReader reader;
		String path = "src/main/resources/sample8.txt";
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
			e.printStackTrace();
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

		for (String nodeEndingA : nodesEndWithAList) {

			int count = 0;
			long step = 0;
			String val = nodeEndingA;
			System.out.println("val is " + val);

			while (!val.endsWith("Z")) {

				if (count == instructions.length()) {
					count = 0;
				}

				char instruction = instructions.charAt(count);

				if (instruction == 'L') {
					val = map.get(val).get(0);
				} else {
					val = map.get(val).get(1);
				}

				// System.out.println("val is " + val);
				count++;
				step++;
			}

			System.out.println("step is " + step);

			lcmArr[i++] = step;
			System.out.println("maxStep is " + lcmArr[i - 1]);

		}
		for (long steps : lcmArr) {
			System.out.println("step in array is " + steps);
		}

		long lcm = lcmFind(lcmArr);
		System.out.println("lcm is " + lcm);
	}

	public static long lcmFind(long[] lcmArr) {

		long lcm = lcmArr[0];
		for (int i = 1; i < lcmArr.length; i++) {
			long currentNum = lcmArr[i];
			lcm = (lcm * currentNum) / (gcdFind(lcm, currentNum));
		}
		return lcm;
	}

	public static long gcdFind(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcdFind(b, a % b);
	}

}
