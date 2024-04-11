package com.practice.days.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//2098530125
public class Day9Problem1 {

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

			List<Long> nextElementList = new ArrayList<>();

			nextElementList.add(list.get(list.size() - 1));

			Long nextElement = nextElement(list, nextElementList);
			System.out.println("count " + count + " nextElement is " + nextElement);
			count++;
			sum += nextElement;
			System.out.println("sum is " + sum);

		}
		System.out.println("Final sum is " + sum);
	}

	public static Long nextElement(List<Long> list, List<Long> nextElementList) {
		// System.out.println("the list is " + list);

		long nextElement = 0;

		List<Long> currList = new ArrayList<>();

		for (int i = 0; i < list.size() - 1; i++) {
			currList.add(list.get(i + 1) - list.get(i));
		}

		List<Long> distinctList = currList.stream().distinct().collect(Collectors.toList());

		System.out.println("currList is " + currList);
		if (distinctList.size() == 1) {
			nextElementList.add(distinctList.get(0));
			System.out.println("nextElementList is " + nextElementList);
			nextElement = nextElementList.stream().reduce(0l, Long::sum);
			return nextElement;
		}
		System.out.println("last element of currList is " + currList.get(currList.size() - 1));
		nextElementList.add(currList.get(currList.size() - 1));
		return nextElement(currList, nextElementList);
	}

}
