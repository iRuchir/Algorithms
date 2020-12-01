package com.ruchir.ArraysAndStrings;

public class OneEditAway {
	public boolean isOneEditAway(String str1, String str2) {

		int charDiffCount = 0;

		int lengthDiff = str1.length() - str2.length();

		if (lengthDiff > 1 || lengthDiff < 0) {
			return false;
		} else if (lengthDiff == 1) {
			for (int i = 0, j = 0; i < str1.length(); j++, i++) {
				if (charDiffCount > 1) {
					return false;
				}
				if (str1.charAt(i) != str2.charAt(j)) {
					i++;
					charDiffCount++;
				}
			}
		} else if (lengthDiff == 0) {
			for (int i = 0; i < str1.length(); i++) {
				if (charDiffCount > 1) {
					return false;
				}
				if (str1.charAt(i) != str2.charAt(i)) {
					charDiffCount++;
				}
			}
		}

		return true;
	}
}
