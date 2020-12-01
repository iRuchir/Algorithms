package com.ruchir.ArraysAndStrings;

public class PowerOf2 {

	void calculatePowerOf2(int n) {
		
		for (int i = 0; Math.pow(2, i) <=n; i++) {
			System.out.println(Math.pow(2, i));
		}
	}
	
	int calculatePowerOf2Recursive(int n) {
		if(n<0) {
			System.out.println(0);
			return 0;
		}
		if(n==0) {
			System.out.println(1);
			return 1;
		}
		else {
			int previous = calculatePowerOf2Recursive(n/2);
			int current = 2*previous;
			System.out.println(current);
			return current;
		}
	}
}
