package com.practice.days.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//1016
public class Day9Problem2 {

	public static void main(String[] args) {
		BufferedReader reader;
		String path = "src/main/resources/sample9.txt";
		List<List<Long>> sequenceList = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();

			int counter = 1;
			while (line != null) {

				List<Long> currList = Arrays.asList(line.split(" ")).stream().map(i -> Long.parseLong(i)).toList();

				sequenceList.add(currList);
				System.out.println("count " + counter + " currList is " + currList);
				counter++;
				line = reader.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("sequenceList is " + sequenceList);

		int sum = 0;
		int count = 1;

		for (List<Long> list : sequenceList) {

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

	public static Long prevElement(List<Long> list, List<Long> prevElementList) {

		long prevElement = 0;

		List<Long> currList = new ArrayList<>();

		for (int i = 0; i < list.size() - 1; i++) {
			currList.add(list.get(i + 1) - list.get(i));
		}

		List<Long> distinctList = currList.stream().distinct().collect(Collectors.toList());

		System.out.println("currList is " + currList);

		if (distinctList.size() == 1) {
			prevElementList.add(distinctList.get(0));
			System.out.println("prevElementList is " + prevElementList);
			int multiplier = 1;
			for (long num : prevElementList) {
				num = num * multiplier;
				prevElement += num;
				multiplier = multiplier == 1 ? -1 : 1;
			}
			return prevElement;
		}
		System.out.println("first element of currList is " + currList.get(0));
		prevElementList.add(currList.get(0));
		return prevElement(currList, prevElementList);

	}

}
