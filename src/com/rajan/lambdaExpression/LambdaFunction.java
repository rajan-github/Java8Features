package com.rajan.lambdaExpression;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaFunction {

	public static void main(String[] args) {
		List<Apple> apples = Arrays.asList(new Apple(150), new Apple(120), new Apple(190), new Apple(56));
		apples.sort(new Comparator<Apple>() {

			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
		});
		System.out.println(apples);

		apples = Arrays.asList(new Apple(150), new Apple(120), new Apple(190), new Apple(56));
		apples.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		System.out.println(apples);

		apples = Arrays.asList(new Apple(150), new Apple(120), new Apple(190), new Apple(56));
		apples.sort(Apple::compareTo);
		System.out.println(apples);
	}

}

class AppleComparator implements Comparator<Apple> {
	@Override
	public int compare(Apple arg0, Apple arg1) {
		return arg0.getWeight().compareTo(arg1.getWeight());
	}

}

class Apple implements Comparable<Apple> {

	private String color;
	private double size;
	private Double weight;

	public Apple(double weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Apple other) {
		double diff = weight - other.weight;
		int returnValue;
		if (diff < 0) {
			returnValue = -1;
		} else if (diff > 0) {
			returnValue = 1;

		} else {
			returnValue = 0;
		}
		return returnValue;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", size=" + size + ", weight=" + weight + "]";
	}

}
