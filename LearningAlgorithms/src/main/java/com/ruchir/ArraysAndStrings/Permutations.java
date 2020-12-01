package com.ruchir.ArraysAndStrings;

public class Permutations {

	public void permutationsOfString(String fixed, String str) {

		if (str.equals("")) {
			System.out.println(fixed);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			String leftover = str.substring(0,i) + str.substring(i+1);
			System.out.println(fixed+","+str.charAt(i)+","+leftover);
			permutationsOfString(fixed+str.charAt(i), leftover);
//			System.out.println(fixed + "," + str);
		}

	}

}