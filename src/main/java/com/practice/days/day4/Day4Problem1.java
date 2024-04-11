package com.practice.days.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//20407
public class Day4Problem1 {
	
	public static void main(String[] args) {
		BufferedReader reader;
		String filePath = "src/main/resources/sample4.txt";
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
			e.printStackTrace();
		}
	}
	

}
