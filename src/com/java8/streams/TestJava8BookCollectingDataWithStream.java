package com.java8.streams;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;import org.omg.PortableInterceptor.DISCARDING;

import static java.util.stream.Collectors.*;

import com.java8.streams.TestJava8BookCollectingDataWithStream.CaloricLevel;

public class TestJava8BookCollectingDataWithStream {
	public enum CaloricLevel {
		DIET, NORMAL, FAT
	};

	public static void main(String[] args) {
		TestJava8BookCollectingDataWithStream dataWithStream = new TestJava8BookCollectingDataWithStream();
		dataWithStream.test();
	}

	private void test() {
		List<Dish> menu = Dish.getDises();

		// count
		System.out.println(menu.stream().collect(counting()));
		System.out.println(menu.stream().count());

		// Max
		menu.stream().map(Dish::getCalories).reduce(Integer::max).ifPresent(System.out::println);
		menu.stream().collect(maxBy(Comparator.comparing(Dish::getCalories))).ifPresent(System.out::println);

		// Summarizing
		System.out.println(menu.stream().map(Dish::getCalories).reduce(Integer::sum));
		System.out.println(menu.stream().collect(summingInt(Dish::getCalories)));
		System.out.println(menu.stream().collect(averagingInt(Dish::getCalories)));
		menu.stream().collect(summarizingInt(Dish::getCalories)).getMax();

		// joining
		System.out.println(menu.stream().map(Dish::getName).collect(joining(",")));
		// System.out.println(menu.stream().collect(joining()));

		// generalized reducing collector
		System.out.println(menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum)));

		System.out.println(menu.stream().map(Dish::getCalories).collect(reducing(Integer::max)));

		// grouping by
		Map<Dish.Type, List<Dish>> map1 = menu.stream().collect(groupingBy(Dish::getType));
		System.out.println(map1);

		Map<CaloricLevel, List<Dish>> map2 = menu.stream().collect(groupingBy(d -> {
			if (d.getCalories() <= 400) {
				return CaloricLevel.DIET;
			} else if (d.getCalories() <= 700) {
				return CaloricLevel.NORMAL;
			}

			else {
				return CaloricLevel.FAT;
			}

		}));
		System.out.println(map2);

		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> map3 = menu.stream().collect(groupingBy(Dish::getType, groupingBy(d -> {
			if (d.getCalories() <= 400) {
				return CaloricLevel.DIET;
			} else if (d.getCalories() <= 700) {
				return CaloricLevel.NORMAL;
			}

			else {
				return CaloricLevel.FAT;
			}

		})));
		System.out.println(map3);
		
		Map<Dish.Type, Long> map4 = menu.stream().collect(groupingBy(Dish::getType, counting()));
		System.out.println(map4);
		
		Map<Dish.Type, Optional<Dish>> map5 = menu.stream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparing(Dish::getCalories))));
		System.out.println(map5);
		
		Map< Dish.Type, Dish> map6 = menu.stream().collect(groupingBy(Dish::getType, Collectors.collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
		System.out.println(map6);
		
		Map<Dish.Type, Integer> map7 = menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
		System.out.println(map7);
		
		
		Map<Dish.Type, Set<CaloricLevel>> map8 = menu.stream().collect(groupingBy(Dish::getType, Collectors.mapping(d -> {
			if (d.getCalories() <= 400) {
				return CaloricLevel.DIET;
			} else if (d.getCalories() <= 700) {
				return CaloricLevel.NORMAL;
			}

			else {
				return CaloricLevel.FAT;
			}}, Collectors.toSet())));
		
		System.out.println(map8);
		
		Map<Boolean, List<Dish>> map9 = menu.stream().collect(partitioningBy(Dish::isVegetarian));
		System.out.println(map9);
		
		Map<Boolean, Map<Dish.Type, List<Dish>>> map10 =menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
		System.out.println(map10);
		
		menu.stream().collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
	}
}
