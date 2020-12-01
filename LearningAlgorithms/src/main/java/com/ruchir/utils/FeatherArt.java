package com.ruchir.utils;

public class FeatherArt {
	public static void main(String[] args) {
		for (int i = 0; i < 70; i++) {
			for (int j = 0; j < i + 1; j+=2) {
				System.out.print(0);
			}
			System.out.print(1);
			for (int j = 0; j < i + 1; j+=2) {
				System.out.print(0);
			}
			System.out.println();
		}
		for (int i = 32; i > 0; i--) {
			for (int j = i + 1; j > 0; j--) {
				System.out.print(0);
			}
			System.out.print(1);
			for (int j = i + 1; j > 0; j--) {
				System.out.print(0);
			}
			System.out.println();
		}
	}
}
