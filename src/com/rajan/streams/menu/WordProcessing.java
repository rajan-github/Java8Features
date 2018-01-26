package com.rajan.streams.menu;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordProcessing {

	public List<Integer> getWordLengths(List<String> words) {
		if (words != null) {
			return words.stream().map(String::length).collect(toList());
		} else {
			return new ArrayList<Integer>();
		}
	}

	public static void main(String[] args) {
		List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		System.out.println("Getting list of word size:");
		System.out.println(new WordProcessing().getWordLengths(words));
	}
}
