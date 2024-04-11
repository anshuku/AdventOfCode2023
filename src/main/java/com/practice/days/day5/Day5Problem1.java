package com.practice.days.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//227653707
public class Day5Problem1 {
	
	public static void main(String[] args) {
		BufferedReader reader;
		String filePath = "src/main/resources/sample5.txt";
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
			e.printStackTrace();
		}
		
	}
	

}
