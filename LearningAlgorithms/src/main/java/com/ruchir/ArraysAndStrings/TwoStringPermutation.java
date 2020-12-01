package com.ruchir.ArraysAndStrings;

import java.util.Arrays;

public class TwoStringPermutation {
	public boolean isPermutation(String str1, String str2) {

		// are caps allowed, and are caps == small characters?

		if (str1.length() != str2.length()) {
			return false;
		}

		boolean isCharacterPresent = false;

		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					isCharacterPresent = true;
				}
			}
			if (!isCharacterPresent) {
				return false;
			}
			isCharacterPresent = false;
		}

		return true;
	}

	public boolean isPermutationSorted(String str1, String str2) {

		// are caps allowed, and are caps == small characters?

		if (str1.length() != str2.length()) {
			return false;
		}

		char[] str1Chars = str1.toCharArray();
		char[] str2Chars = str2.toCharArray();

		Arrays.sort(str1Chars);
		Arrays.sort(str2Chars);
		if (String.valueOf(str1Chars).equals(String.valueOf(str2Chars)))
			return true;
		else
			return true;
	}
}
