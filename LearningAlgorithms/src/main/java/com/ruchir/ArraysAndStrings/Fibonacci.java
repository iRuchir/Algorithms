package com.ruchir.ArraysAndStrings;

public class Fibonacci {

	int nthFibo(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		else {
			return nthFibo(n - 2) + nthFibo(n - 1);
		}
	}
	
	int nthFiboWithCache(int n, int[] alreadyExists) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		else {
			if(alreadyExists[n]>0) {
				return alreadyExists[n];
			}
			alreadyExists[n] = nthFiboWithCache(n - 2, alreadyExists) + nthFiboWithCache(n - 1, alreadyExists);
			return alreadyExists[n];
		}
	}

}
