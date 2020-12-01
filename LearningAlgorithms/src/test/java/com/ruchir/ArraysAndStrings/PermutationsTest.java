package com.ruchir.ArraysAndStrings;

import org.junit.jupiter.api.Test;

class PermutationsTest {

	@Test
	void test() {
		System.out.println("This test ran.");
	}

	@Test
	void testPermutations() {
		Permutations permutations = new Permutations();
		String str = "ABCD";
		permutations.permutationsOfString("",str);
	}

}
