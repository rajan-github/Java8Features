package com.rajan.streams.fibonacciSeries;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * This prints the tuples of fibonacci series. It starts with (0,1) and prints
 * (1,1), (1,2), (1,3)..up to the 10. This is an example of infinite stream and
 * uses iterate method of Stream interface.
 * 
 * @author rajan
 *
 */
public class FibonacciSeries {
	public static void main(String[] args) {
		Stream.iterate(new int[] { 0, 1 }, n -> new int[] { n[1], n[0] + n[1] }).limit(10)
				.map((array) -> Arrays.toString(array)).forEach(System.out::println);
	}
}
