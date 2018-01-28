package com.rajan.numericStream.pythagoreanTriple;

import java.util.stream.IntStream;

public class PythagoreanStream {

	/**
	 * This method generates all pythagorean triples within the range(start and
	 * end). Pythagorean triple(a,b,c) is one which satisfies a^2+b^2=c^2.
	 * 
	 * @param start
	 * @param end
	 */
	public static void printPythagoreanTriplet(int start, int end) {
		IntStream.rangeClosed(start, end).boxed()
				.map(a -> IntStream.rangeClosed(a, end).boxed()
						.map(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) })
						.filter(array -> array[0] * array[0] + array[1] * array[1] == array[2] * array[2]))
				.map(arrayStream -> arrayStream.findFirst()).filter(optional -> optional.isPresent())
				.map(optional -> optional.get())
				.forEach((array) -> System.out.println(array[0] + "-" + array[1] + "-" + array[2]));

	}

	public static void main(String[] args) {
		printPythagoreanTriplet(1, 100);

	}
}