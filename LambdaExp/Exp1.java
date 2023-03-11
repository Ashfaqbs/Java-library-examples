package LambdaExp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exp1 {
	
	public static void main(String[] args) {
		
		
		
		ArrayList<Integer> nos = new ArrayList<>();
		for (int i = 0; i <=100; i++) 
			nos.add(i);
		
		
		
		//filter
		List<Integer> collect = nos.stream().filter(i -> i>10).collect(Collectors.toList());
		System.out.println(collect);

		//map
		List<Integer> collect1 = nos.stream().map(i -> i*2).collect(Collectors.toList());
		System.out.println(collect1);
		
		//for each 
		 nos.stream().filter( i -> i >2).forEach(System.out::print);
		 nos.stream().filter( i -> i >2).forEach(
				 t -> {
//					 System.out.print(t);
				 }
				 );


		
		
		
		
		
		
		
	}

}
