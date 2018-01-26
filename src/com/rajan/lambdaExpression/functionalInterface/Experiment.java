package com.rajan.lambdaExpression.functionalInterface;

public class Experiment {
	public static void main(String[] args) {
		Processor<Integer> processor = (Integer k) -> {
			System.out.println(k);
			return k;
		};

		processor.process(47);
	}
}
