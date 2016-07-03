package com.java8.streams;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestJava8BookStreams {

	public static void main(String[] args) {
		TestJava8BookStreams bookStreams = new TestJava8BookStreams();
		bookStreams.test();
	}

	private void test() {
		List<Dish> menu = Dish.getDises();
		/*
		 * 
		 * List<String> threeHighCaloricDishNames = menu.stream().filter(d ->
		 * d.getCalories() > 300).map(Dish::getName)
		 * .limit(3).collect(toList());
		 * System.out.println(threeHighCaloricDishNames);
		 * 
		 * List<Dish> vegetarianDishes =
		 * menu.stream().filter(Dish::isVegetarian).collect(toList());
		 * System.out.println(vegetarianDishes);
		 * 
		 * // unique List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 3, 2, 4);
		 * numbers.stream().filter(i -> i % 2 ==
		 * 0).distinct().forEach(System.out::println);
		 * 
		 * // limit menu.stream().filter(d -> d.getCalories() >
		 * 300).limit(2).map(Dish::getName).forEach(System.out::println); //
		 * skip menu.stream().filter(d -> d.getCalories() >
		 * 300).skip(2).map(Dish::getName).forEach(System.out::println);
		 * 
		 * // word length
		 * menu.stream().map(Dish::getName).map(String::length).forEach(System.
		 * out::println);
		 * 
		 * 
		 * // flattening streams menu.stream().map(Dish::getName).map(s ->
		 * s.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::
		 * println);
		 */

		// Square of numbers
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
		numbers1.stream().map(d -> d * 2).forEach(System.out::println);

		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(3, 4);

		List<int[]> mappedList = list1.stream().flatMap(i -> list2.stream().map(j -> new int[] { i, j }))
				.collect(toList());
		/*
		 * for (int[] ks : mappedList) { for (int k = 0; k < ks.length; k++) {
		 * System.out.println(ks[k]); } }
		 */

		List<int[]> mappedList1 = list1.stream().flatMap(i -> list2.stream().filter(j -> {
			// System.out.println(j+i);
			return (j + i) % 3 == 0;
		})

				.map(j -> {
					// System.out.println(i+ "-"+j);
					return new int[] { i, j };
				})).collect(toList());

		System.out.println(mappedList1);
		for (int[] ks : mappedList1) {
			for (int k = 0; k < ks.length; k++) {
				System.out.println(ks[k]);
			}
		}

		// anyMatch
		if (menu.stream().anyMatch(d -> d.isVegetarian())) {
			System.out.println("menu is slightly vegetarian");
		}

		// allMatcgh
		if (!menu.stream().allMatch(d -> d.isVegetarian())) {
			System.out.println("All not vegetarian");
		}
		// none match
		if (!menu.stream().noneMatch(d -> d.isVegetarian())) {
			System.out.println("There are vegetarian");
		}

		// findAny

		menu.stream().filter(d -> d.isVegetarian()).findAny().ifPresent(System.out::println);

		list1.stream().map(d -> d * d).filter(d -> d % 3 == 0).findFirst().ifPresent(System.out::println);

		System.out.println(list1.stream().reduce(0, (a, b) -> a + b));

		System.out.println(list1.stream().reduce(0, Integer::sum));
		Optional<Integer> optional = list1.stream().reduce(Integer::sum);

		System.out.println(list1.stream().reduce(Integer::max));
		System.out.println(list1.stream().reduce(Integer::min));

		System.out.println(menu.stream().map(d -> 1).reduce(0, Integer::sum));

		// mapping to a numeric stream
		System.out.println(menu.stream().mapToInt(Dish::getCalories).sum());

		IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
		Stream<Integer> iStraem = intStream.boxed();
		System.out.println(iStraem.reduce(0, (a, b) -> a + b));

		OptionalInt int1 = menu.stream().mapToInt(Dish::getCalories).max();
		int max = int1.orElse(0);

		System.out.println(IntStream.rangeClosed(0, 100).filter(i -> i % 2 == 0).count());

		// pythogorad triple

		IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100).boxed().filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
						.map(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }))
				.limit(5).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));
		;

		// stream of strings
		Stream<String> streams = Stream.of("ass", "fdsfs", "eee");
		streams.map(String::toUpperCase).forEach(System.out::println);

		try (Stream<String> fileStream = Files
				.lines(Paths.get("/home/abhi/workspace/ds/java/src/com/java8/streams/wordscount.txt"))) {
			fileStream.map(line -> line.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			FileReader fileReader = new FileReader(
					new File("/home/abhi/workspace/ds/java/src/com/java8/streams/wordscount.txt"));
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			bufferedReader.lines().map(t -> t.split(" ")).flatMap(Arrays::stream).distinct()
					.forEach(System.out::println);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// streams from iterate and generate
		Stream.iterate(0, n -> n + 2).limit(5).forEach(System.out::println);

		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(5)
				.forEach(t -> System.out.println(t[0] + "," + t[1]));

		Stream.generate(Math::random).limit(5).forEach(System.out::println);

	}
}
