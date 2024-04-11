package com.practice.days.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.practice.days.day7.CardComparator;

//250120186
public class Day7Problem1 {
	
	public static void main(String[] args) {

		BufferedReader reader;
		String path = "src/main/resources/sample7.txt";
		List<String> list = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();

			while (line != null) {
				list.add(line);
				line = reader.readLine();
			}

			System.out.println("list " + list);

		} catch (IOException e) {

		}

		List<String> list5Kind = new ArrayList<>(); // AAAAA 1
		List<String> list4Kind = new ArrayList<>(); // AAAAB 2
		List<String> listFullHouse = new ArrayList<>(); // AAABB 2
		List<String> list3kind = new ArrayList<>(); // AAABC 3
		List<String> list2Pair = new ArrayList<>(); // AABBC 3
		List<String> list1Pair = new ArrayList<>(); // AABCD 4
		List<String> listHighKind = new ArrayList<>(); // ABCDE 5

		Set<String> set = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();

		for (String cardsBid : list) {

			String s = cardsBid.substring(0, 5);
			String[] cardArr = s.split("");

			set.addAll(Arrays.asList(cardArr));

			if (set.size() == 1) {
				list5Kind.add(cardsBid);

			} else if (set.size() == 5) {
				listHighKind.add(cardsBid);

			} else if (set.size() == 4) {
				list1Pair.add(cardsBid);

			} else if (set.size() == 3) {

				for (String str : cardArr) {
					map.put(str, map.getOrDefault(str, 0) + 1);
				}

				System.out.println("String " + s + " has map" + map);

				if (map.values().contains(3)) {
					list3kind.add(cardsBid);

				} else {
					list2Pair.add(cardsBid);

				}

				map.clear();

			} else {

				for (String str : cardArr) {
					map.put(str, map.getOrDefault(str, 0) + 1);
				}

				System.out.println("String " + s + " has map" + map);

				if (map.values().contains(3)) {
					listFullHouse.add(cardsBid);

				} else {
					list4Kind.add(cardsBid);

				}
				map.clear();
			}
			System.out.println("set " + set);
			set.clear();
		}

		list.clear();

		System.out.println("listHighKind " + listHighKind);

		listHighKind.sort(new CardComparator());

		System.out.println("listHighKind sorted " + listHighKind);
		System.out.println("list1Pair " + list1Pair);

		list1Pair.sort(new CardComparator());

		System.out.println("list1Pair sorted " + list1Pair);
		System.out.println("list2Pair " + list2Pair);

		list2Pair.sort(new CardComparator());

		System.out.println("list2Pair sorted " + list2Pair);
		System.out.println("list3kind " + list3kind);

		list3kind.sort(new CardComparator());

		System.out.println("list3kind sorted " + list3kind);
		System.out.println("listFullHouse " + listFullHouse);

		listFullHouse.sort(new CardComparator());

		System.out.println("listFullHouse sorted " + listFullHouse);
		System.out.println("list4Kind " + list4Kind);

		list4Kind.sort(new CardComparator());

		System.out.println("list4Kind sorted " + list4Kind);
		System.out.println("list5Kind " + list5Kind);

		list5Kind.sort(new CardComparator());

		System.out.println("list5Kind sorted " + list5Kind);

		list.addAll(listHighKind);
		list.addAll(list1Pair);
		list.addAll(list2Pair);
		list.addAll(list3kind);
		list.addAll(listFullHouse);
		list.addAll(list4Kind);
		list.addAll(list5Kind);

		System.out.println("list " + list);

		int count = 1;
		long product = 0;
		for (String s : list) {
			long bid = Long.parseLong(s.substring(6));
			product += bid * count;
			count++;
		}
		System.out.println("product " + product);
	}
	
}
