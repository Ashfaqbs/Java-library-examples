package Optional_Class;

import java.util.Optional;

public class Optional_Demo {

	public static void main(String[] args) {
		
		
		
		String str = "not null";
//		if(str!=null)
//		{
//			System.out.println("null is present");
//		}else {
//			System.out.println(str.length());
//		}
		
		Optional<String> of = Optional.ofNullable(str);
		
		System.out.println(of.isPresent());
		System.out.println(of.get());
		
		System.out.println(of.orElse("not present"));
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
