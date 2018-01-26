package com.rajan.streams.menu;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamOfIntegers {
	public List<Integer> getDistinctEvenNumber(List<Integer> numList) {
		if (numList != null) {
			Stream<Integer> intStream = numList.stream();
			return intStream.filter(i -> i % 2 == 0).distinct().collect(toList());
		}
		return new ArrayList<>();
	}

	public List<Integer> getDistinctEvenNumberAfter2ndElement(List<Integer> numList) {
		if (numList != null) {
			return numList.stream().filter(i -> i % 2 == 0).distinct().skip(2).collect(toList());
		}
		return new ArrayList<>();
	}

	public List<Integer> getSquareOfNumberList(List<Integer> numList) {
		if (numList != null) {
			return numList.stream().map(i -> i * i).collect(toList());
		}
		return new ArrayList<>();
	}

	public List<Integer[]> getAllPairsOfLists(List<Integer> list1, List<Integer> list2) {
		if (list1 != null && list2 != null) {
			return list1.stream().flatMap(i -> list2.stream().map(j -> new Integer[] { i, j })).collect(toList());
		}
		return new ArrayList<>();
	}

	public List<Integer[]> getPairsOfListsDivisibleBy3(List<Integer> list1, List<Integer> list2) {
		if (list1 != null && list2 != null) {
			return list1.stream().flatMap(i -> list2.stream().map(j -> new Integer[] { i, j }))
					.filter(array -> (array[0] + array[1]) % 3 == 0).collect(toList());
		}
		return new ArrayList<>();
	}

	public static void main(String[] args) {
		List<Integer> numberSet = Arrays.asList(1, 2, 3, 4, 5, 2, 4, 5, 6, 2, 4, 5, 6, 6, 7, 4, 3, 5, 6, 3, 90, 5, 56,
				6);
		System.out.println("Filtering even and distinct integers: ");
		System.out.println(new StreamOfIntegers().getDistinctEvenNumber(numberSet));
		System.out.println("Filtering even and skipping distinct integers: ");
		System.out.println(new StreamOfIntegers().getDistinctEvenNumberAfter2ndElement(numberSet));
		System.out.println("Squares of list: ");
		System.out.println(new StreamOfIntegers().getSquareOfNumberList(numberSet));
		System.out.println("All pairs of list: ");
		// System.out.println(new StreamOfIntegers().getAllPairsOfLists(numberSet,
		// numberSet));
		for (Integer[] array : new StreamOfIntegers().getAllPairsOfLists(numberSet, numberSet)) {
			System.out.println(Arrays.toString(array));
		}

		System.out.println("All pairs devided by 3: ");
		// System.out.println(new StreamOfIntegers().getAllPairsOfLists(numberSet,
		// numberSet));
		for (Integer[] array : new StreamOfIntegers().getPairsOfListsDivisibleBy3(numberSet, numberSet)) {
			System.out.println(Arrays.toString(array));
		}

	}
}
