package StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

	
	
	
	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> ar= new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			ar.add(i);
		}
	//without stream api 
		Iterator<Integer> iterator = ar.iterator();
//		
//		while(iterator.hasNext())
//		{
//			Integer next = iterator.next();
//			if(next%2==0)
//			{
//				System.out.println(next);
//			}
//			
//		}
		
		//with stream api 
//     Stream<Integer> stream = ar.stream();
//     
//     List<Integer> collect = stream.filter(i -> i%2==0).collect(Collectors.toList());
//     System.out.println(collect);
		
		//List<Integer> collect5 = ar.stream().map(i -> i*100).collect(Collectors.toList());
//		System.out.println(collect5);

//     
//     List<Integer> collect2 = ar.stream().filter(i -> i>2).collect(Collectors.toList());
//     System.out.println(collect2);
//		
//     List<Integer> collect3 = ar.stream().filter(i -> i%2!=0).collect(Collectors.toList());
//		System.out.println(collect3);
//		
//		List<Integer> list = ar.stream().filter(i -> i>50).collect(Collectors.toList());
//		System.out.println(list);
//		List<Integer> collect4 = ar.stream().filter(i -> i%7==0).collect(Collectors.toList());
//		System.out.println(collect4);
		
		List<Integer> collect5 = ar.stream().map(i -> i*100).collect(Collectors.toList());
		System.out.println(collect5);

		//using of streams in array 
		
		String names [] = {
			"Ashu", "sonu","monu","chinu","ash"	
		};
		
		//1
		Stream<String> stream1 = Stream.of(names);
		List<String> collect = stream1.filter(i -> (i.charAt(0)=='A')||(i.charAt(0)=='a')).collect(Collectors.toList());
		System.out.println(collect);
		
		//2 
		Stream<String> stream2 = Arrays.stream(names);
		
		
		
//		Object[] array = collect.toArray();
//		String name[]=(String [])array;
//		
		
		
		ar.stream().forEach(   e -> {
			System.out.println(e);
		});
		
	//important Stream methods
		
		//filter (to filter the objects in a collections)
		
		ArrayList<Integer> arrl = new ArrayList<>();
		for (int j = 0; j < 50; j++) {
			arrl.add(j);
		}
		
		//to filter multiples of 5
		List<Integer> collect2 = arrl.stream().filter(i -> i %5==0).collect(Collectors.toList());
		System.out.println(collect2);
		
		
		List<Integer> collect3 = arrl.stream().filter( i -> i<=10).collect(Collectors.toList());
		
		//map (modify the objects and store it in new collections)
		
		List<Integer> collect4 = arrl.stream().map(i -> i*0).collect(Collectors.toList());
		
		List<Integer> collect6 = arrl.stream().map(i -> i/10).collect(Collectors.toList());
		
		//sort
		List<Integer> collect7 = arrl.stream().sorted().collect(Collectors.toList());
		System.out.println(collect7);
		
		//min
		Integer integer = arrl.stream().min((x,y) -> x.compareTo(y)).get();
		System.out.println(integer);
		
		
		//max 
		Integer integer2 = arrl.stream().max((x,y) -> x.compareTo(y)).get();
		System.out.println(integer2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
