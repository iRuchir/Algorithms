package com.ruchir.ArraysAndStrings;

public class StringCompression {
	public StringBuilder getCompressedString(String str) {

		if (str.length() < 2) {
			return new StringBuilder(str);
		}

		StringBuilder compressedString = new StringBuilder();

		char currentCharacter = 0;
		char previousCharacter = str.charAt(0);
		int counter = 1;

		for (int i = 1; i < str.length(); i++) {
			currentCharacter = str.charAt(i);
			if (previousCharacter != currentCharacter) {
				compressedString.append(previousCharacter + "" + counter);
				previousCharacter = currentCharacter;
				counter = 1;
			} else {
				counter++;
			}
		}
		compressedString.append(previousCharacter + "" + counter);

		return compressedString.length() < str.length() ? compressedString : new StringBuilder(str);
	}
}
