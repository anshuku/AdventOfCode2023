package com.practice.days.day7;

import java.util.Comparator;

public class CardComparatorJok implements Comparator<String>{
	
	
	@Override
	public int compare(String s1, String s2) {
		
		s1 = s1.substring(0, 5);
		s2 = s2.substring(0, 5);

		System.out.println("s1 " + s1 + " s2 " + s2);
		
		int rank1 = getRank(s1, 0);
		int rank2 = getRank(s2, 0);
		
		int count = 1;
		
		while(rank1 == rank2) {
			rank1 = getRank(s1, count);
			rank2 = getRank(s2, count);
			count++;
		}
		System.out.println("rank1 - " + rank1 + " rank2 - " + rank2);
		return rank2 - rank1;
	}
	
	private int getRank(String s, int index) {
		
		char c = s.charAt(index);
		
		switch(c) {
		case 'A':
			return 1;
		case 'K':
			return 2;
		case 'Q':
			return 3;
		case 'T':
			return 4;
		case '9':
			return 5;
		case '8':
			return 6;
		case '7':
			return 7;
		case '6':
			return 8;
		case '5':
			return 9;
		case '4':
			return 10;
		case '3':
			return 11;
		case '2':
			return 12;
		case 'J':
			return 13;
		default:
			return 14;
		}
	}
}