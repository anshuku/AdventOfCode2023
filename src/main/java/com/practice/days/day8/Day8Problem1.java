package com.practice.days.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//19199
public class Day8Problem1 {

	public static void main(String[] args) {
		BufferedReader reader;
		String path = "src/main/resources/sample8.txt";
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
			e.printStackTrace();
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

}
