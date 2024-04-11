package com.practice.days.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//23806951
public class Day4Problem2 {
	
	public static void main(String[] args) {
		BufferedReader reader;
		String filePath = "src/main/resources/sample4.txt";
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
			e.printStackTrace();
		}
		
	}
	

}
