package com.ruchir.ArraysAndStrings;

public class RotateMatrix {
	public void rotate(int[][] matrix) {
		int temp = 0;
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][n - i];
				matrix[j][n - i] = temp;
			}
		}
	}
}