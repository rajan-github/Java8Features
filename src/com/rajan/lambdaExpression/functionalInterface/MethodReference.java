package com.rajan.lambdaExpression.functionalInterface;

import java.util.Arrays;
import java.util.List;

public class MethodReference {
	public static void main(String[] args) {
		List<String> str = Arrays.asList("a", "b", "A", "B");
		// str.sort((s1, s2) -> s1.compareTo(s2));
		str.sort(String::compareToIgnoreCase);
		System.out.println(str);
	}
}
