package com.practice.days.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//27340847
public class Day6Problem2 {
	
	public static void main(String[] args) {
		BufferedReader reader;
		String path = "src/main/resources/sample6.txt";

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
			e.printStackTrace();
		}

		long count = 0;
		for (long i = 0; i < time; i++) {
			if (i * (time - i) > distance) {
				count++;
			}
		}

		System.out.println("for time " + time + " count is " + count);
	}
	
}
