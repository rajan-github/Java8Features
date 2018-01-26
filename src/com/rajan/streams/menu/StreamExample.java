package com.rajan.streams.menu;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.rajan.streams.menu.Dish.Type;

public class StreamExample {

	public List<Dish> getVegetarialDishes(List<Dish> menu) {
		Stream<Dish> dishes = menu.stream();
		return dishes.filter(Dish::isVegetarian).collect(toList());
	}

	public List<Dish> getThreeDishesWithHighCalory(List<Dish> menu) {
		Stream<Dish> dishes = menu.stream();
		return dishes.filter(dish -> dish.getCalories() > 300).limit(3).collect(toList());
	}

	public List<Dish> getFirstTwoMeatDishes(List<Dish> menu) {
		return menu.stream().filter(dish -> dish.getType() == Type.MEAT).limit(2).collect(toList());
	}

	public List<String> getListOfDishNames(List<Dish> menu) {
		return menu.stream().map(Dish::getName).collect(toList());
	}

	public List<Integer> getListOfDishNameLength(List<Dish> menu) {
		return menu.stream().map(dish -> dish.getName().length()).collect(toList());
	}

	public int countNumberOfDishes(List<Dish> menu) {
		return menu.stream().map(d -> 1).reduce(0, (x, y) -> x + y);
	}

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(new Dish("Pork", false, 800, Dish.Type.MEAT),
				new Dish("rice", true, 350, Dish.Type.OTHER), new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER), new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));

		System.out.println("Filtered vegetarian dishes are: ");
		System.out.println(new StreamExample().getVegetarialDishes(menu));
		System.out.println("Filtered high calory dishes: ");
		System.out.println(new StreamExample().getThreeDishesWithHighCalory(menu));
		System.out.println("First two meat dishes: ");
		System.out.println(new StreamExample().getFirstTwoMeatDishes(menu));
		System.out.println("List of dish names: ");
		System.out.println(new StreamExample().getListOfDishNames(menu));
		System.out.println("List of dish name length: ");
		System.out.println(new StreamExample().getListOfDishNameLength(menu));
		System.out.println("Total menu length: ");
		System.out.println(new StreamExample().countNumberOfDishes(menu));
	}
}
