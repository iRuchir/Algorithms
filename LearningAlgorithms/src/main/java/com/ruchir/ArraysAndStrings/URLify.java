package com.ruchir.ArraysAndStrings;

public class URLify {
	public String urlifyString(String str) {
		String url = "";

		String[] splitStrings = str.split(" ");

		if (splitStrings.length > 1) {
			for (int i = 0; i < splitStrings.length - 1; i++) {
				url += splitStrings[i] + "%20";
			}
			url += splitStrings[splitStrings.length - 1];
		}

		System.out.println(url);
		return url;

	}
}
