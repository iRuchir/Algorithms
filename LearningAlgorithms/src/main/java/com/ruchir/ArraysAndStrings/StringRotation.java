package com.ruchir.ArraysAndStrings;

public class StringRotation {
	public boolean isRotationOf(String s1, String s2) {

		// Base cases
		if (s1.length() == 0) {
			return false;
		}

		if (s1.length() < 3 && s2.length() < 3) {
			return true;
		}

		// Method 1: Brute-force, rotate string by one character each time and check
		// equality
		/*
		 * String temp = s1; for (int i = 0; i < s1.length(); i++) { if
		 * (temp.equals(s2)) { return true; } temp = rotateStringBy(temp, 1); }
		 */

		// Method 2: Keep moving cursor to check if s1.substring is substring of s2
		/*
		 * int offset = 0; for (int i = 0; i < s1.length(); i++) { if
		 * (s2.contains(s1.substring(i))) { offset = i; break; } }
		 * System.out.println(offset + "," + s1.substring(offset, s1.length()) +
		 * s1.substring(0, offset)); if ((s1.substring(offset, s1.length()) +
		 * s1.substring(0, offset)).equals(s2)) { return true; }
		 */

		// Method 3: Either first half or second half of string will be intact is other
		// string
		// so if not first half then second half

		// Checking second half

		/*
		 * int length = s1.length(); int ind = s2.indexOf(s1.substring(s1.length() /
		 * 2));
		 * 
		 * if (ind >= 0) { return (s1.substring(length / 2 - ind, length) +
		 * s1.substring(0, length / 2 - ind)).equals(s2); } else { ind =
		 * s2.indexOf(s1.substring(0, s1.length() / 2)); return (s1.substring(length -
		 * ind, length) + s1.substring(0, length - ind)).equals(s2); }
		 */

		// Method 4: If s2 is substring of s1s1, then return true

		if ((s1 + s1).contains(s2))
			return true;
		else
			return false;
	}

	public String rotateStringBy(String s, int count) {
		StringBuilder result = new StringBuilder(s);
		char temp = 0;
		for (int i = 0; i < count; i++) {
			temp = s.charAt(s.length() - 1);
			for (int j = s.length() - 2; j >= 0; j--) {

				result.setCharAt(j + 1, result.charAt(j));
			}
			result.setCharAt(0, temp);
		}
		System.out.println(result);
		return result.toString();
	}
}
