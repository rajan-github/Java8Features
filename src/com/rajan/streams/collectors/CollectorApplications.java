package com.rajan.streams.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.rajan.streams.menu.Dish;

public class CollectorApplications {
	public static long countTotalDishes(List<Dish> menu) {
		long howManyDishes = 0;
		if (menu != null) {
			howManyDishes = menu.stream().collect(Collectors.counting());
		}
		return howManyDishes;
	}

	public static Optional<Dish> findMostCalorieDish(List<Dish> menu) {
		Optional<Dish> mostCalorieDish = Optional.empty();
		if (menu != null) {
			Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
			mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
		}
		return mostCalorieDish;
	}

	public static long findTotalCaloriesInDishMenu(List<Dish> menu) {
		long totalCalories = 0;
		if (menu != null) {
			totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		}
		return totalCalories;
	}

	public static double getAverageCaloriesOfMenu(List<Dish> menu) {
		double averageCalories = 0;
		if (menu != null) {
			averageCalories = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
		}
		return averageCalories;
	}

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(new Dish("Pork", false, 800, Dish.Type.MEAT),
				new Dish("rice", true, 350, Dish.Type.OTHER), new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER), new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));

		System.out.println("Count total dishes in menu: " + CollectorApplications.countTotalDishes(menu));
		System.out.println("Find highest calorie dish in menu: " + CollectorApplications.findMostCalorieDish(menu));
		System.out.println("Find total calories of menu: " + CollectorApplications.findTotalCaloriesInDishMenu(menu));
		System.out.println("Find average calories of menu: " + CollectorApplications.getAverageCaloriesOfMenu(menu));
	}
}
