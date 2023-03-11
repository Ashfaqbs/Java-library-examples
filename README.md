# Java 8 Features
This project contains examples of Java 8 features and concepts, including lambdas, streams, functional interfaces, default methods, and more. 

## Default Methods and Static Methods in Interface

   public interface Default_And_Static_Methods_In_Interfaces {

    Default Methods 

	 default void default_method() {
	   	System.out.println("We are default method of interface");
	  }
    
    
	
	  Static Methods
	  static void static_method() {
		System.out.println("We are static method of interface");
	  }
    
    
	  Abstarct methods
	  void add(int a , int b);
     }
  
 ### Testing class   
     
      public class Test_Default$Static_Methods  implements Default_And_Static_Methods_In_Interfaces{
      @Override
	   public void add(int a, int b) {
		// TODO Auto-generated method stub
		
	    }
     public static void main(String[] args) {
	
	  Test_Default$Static_Methods methods = new Test_Default$Static_Methods();
	  methods.default_method();
    //	methods.static_method();//will get error , as we cant inherit static methods of  a interface
    Default_And_Static_Methods_In_Interfaces.static_method();	
     }
     }
     
     
 
 
##  Method References

      List<String> words = Arrays.asList("Java", "is", "a", "great", "language");
      words.sort(String::compareToIgnoreCase);
      
      
      
## Date and Time API
   Java 8 introduced a new Date and Time API that provides a more comprehensive way to handle dates and times.
   
     LocalDate today = LocalDate.now();
      LocalDate futureDate = today.plusDays(10);


## Lambdas


    List<Integer> numbers = Arrays.asList(1, 5, 10, 15, 20);
    List<Integer> filteredNumbers = numbers.stream()
                                        .filter(n -> n > 10)
                                        .map(n -> n * n)
                                        .collect(Collectors.toList());


## Optional class 

In Java 8, the “java.util” package included an optional class.The public final class “Optional” is used to handle NullPointerException in a Java program. 
You may give other code or values to execute using Optional.Thus, optional reduces the number of null checks required to avoid a nullPointerException.
You may use the Optional class to prevent the application from crashing and terminating unexpectedly. The Optional class 
has methods for checking the existence of a value for a given variable.

      public class Optional_Class {
	     public static void main(String[] args) { 
	        String[] str = new String[10]; 
	        Optional<String>checkNull =
	                        Optional.ofNullable(str[5]); 
	        if (checkNull.isPresent()) { 
	            String word = str[5].toLowerCase(); 
	            System.out.print(str); 
	         } else
	            System.out.println("string is null"); 
	       } 
        }
        
        
        
## Functional  Interfaces

package Java_8;

A Functional Interface is an interface that has exactly one abstract method

 method  -> public void firstInt_method(); no body but it can have static methods or default methods The @FunctionalInterface annotation prevents abstract methods from being accidentally added to functional interfaces
by adding this interface we cant add more than 1 abstract method in this interface now we can take this method abstract_func(); do the lambda exp and all A basic example of the Lambda Expression is:
(x,y) -> x+y

         @FunctionalInterface
        public interface Functional_Interfaces {
   
	      void abstract_func(int x,int y);
	   
         default void default_Fun()
         {
           System.out.println("This is default method");
         }

	      static void sub() {
		   System.out.println("This is static method");
	    }
      
      
 below are the object methods but doesn't have body and we wont get any error as it has only one abstract method
	       
         
         @Override
	        String toString();
  
	         @Override
         	 boolean equals(Object obj);
 
             }
             
             
 ## forEach_Method_In_Iterable_Interface
 
 public class forEach_Method_In_Iterable_Interface {


In Java 8, the Java.lang interface now supports a “forEach” function. 
Iterable that can iterate over the collection’s items.
The Iterable interface has a default method called “forEach.” Collection classes use it to iterate items,
which extends the Iterable interface.You may send Lambda Expression as an argument to the “forEach” method,
which accepts the Functional Interface as a single parameter.	
	
	  public static void main(String[] args) {
		  // TODO Auto-generated method stub

		  List<String> subList = new ArrayList<String>();
		  subList.add("Carrot");
		  subList.add("Potato");
		  subList.add("Cauliflower");
		  subList.add("LadyFinger");
		  subList.add("Tomato");
		   System.out.println("------------Vegetable List--------------");

		    subList.forEach(data -> {

			   System.out.println(data);
	      	});

    //	        or
 
    //		subList.forEach(data -> System.out.println(data));
   
	     }

      }




## Stream API


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
    	
       		while(iterator.hasNext())
       	{
   			Integer next = iterator.next();
     		if(next%2==0)
         {
   			System.out.println(next);
     			}
      		
  	   	}
### with stream api 
         Stream<Integer> stream = ar.stream();
     
      List<Integer> collect = stream.filter(i -> i%2==0).collect(Collectors.toList());
          System.out.println(collect);
		
	       List<Integer> collect5 = ar.stream().map(i -> i*100).collect(Collectors.toList());
      	  System.out.println(collect5);

          
          List<Integer> collect2 = ar.stream().filter(i -> i>2).collect(Collectors.toList());
          System.out.println(collect2);
     		
          List<Integer> collect3 = ar.stream().filter(i -> i%2!=0).collect(Collectors.toList());
      	System.out.println(collect3);
     	
     		 List<Integer> list = ar.stream().filter(i -> i>50).collect(Collectors.toList());
     		 System.out.println(list);
     		 List<Integer> collect4 = ar.stream().filter(i -> i%7==0).collect(Collectors.toList());
           System.out.println(collect4);
		
		     List<Integer> collect5 = ar.stream().map(i -> i*100).collect(Collectors.toList());
		     System.out.println(collect5);
   
### using of streams in array 
		
	       	String names [] = {
		     	  "Ashu", "sonu","monu","chinu","ash"	
		       };
		
	   	//1
	    	Stream<String> stream1 = Stream.of(names);
	   	  List<String> collect = stream1.filter(i -> (i.charAt(0)=='A')||(i.charAt(0)=='a')).collect(Collectors.toList());
		     System.out.println(collect);
		
	    	//2 
	     	Stream<String> stream2 = Arrays.stream(names);
		
		
		
   	 	   Object[] array = collect.toArray();
 	       String name[]=(String [])array;
	
		
		
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

