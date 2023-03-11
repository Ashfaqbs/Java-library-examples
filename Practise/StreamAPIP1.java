package Practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamAPIP1 {

	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<Integer>();

		for (int i = -50; i <= 100; i++) {
			numbers.add(i);
		}

		numbers.add(-43);
		for (int i = -50; i <= 100; i++) {
			numbers.add(i);
		}
		System.out.println("Before Distinct "+ numbers.size());
		System.out.println("List ORG");
		numbers.forEach(i -> System.out.print(i + " "));
		System.out.println("/////////////////////////////////");

		List<Integer> collect = numbers.stream().filter(i -> i > 0).collect(Collectors.toList());
		System.out.println("List Filter");
		collect.forEach(i -> System.out.print(i + " "));
		System.out.println("/////////////////////////////////");

		System.out.println("List ORG");
		numbers.forEach(i -> System.out.print(i + " "));
		System.out.println("/////////////////////////////////");

		System.out.println("List Map");
		List<Integer> collect2 = numbers.stream().map(i -> i * 5).collect(Collectors.toList());
		collect2.forEach(i -> System.out.print(i + " "));

		System.out.println("/////////////////////////////////");

		System.out.println("List ORG");
		numbers.forEach(i -> System.out.print(i + " "));
		System.out.println("/////////////////////////////////");
		
		
		List<Integer> collect3 = numbers.stream().distinct().collect(Collectors.toList());
		System.out.println("List Distinct");
		collect3.forEach(i -> System.out.print(i + " "));
		System.out.println("/////////////////////////////////");
		System.out.println("Before Distinct "+ collect3.size());


	}

}
