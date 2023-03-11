package LambdaExp;



public class LambdaDemo  { 
			
	public static void main(String[] args) {
		
		
		//Anonymous class	
//		MyFunctionalInf ff = new MyFunctionalInf() {
//			
//			@Override
//			public void m1() {
//				// TODO Auto-generated method stub
//			System.out.println("from anonmyous class");	
//			}
//		};
//		
//		
//		ff.m1(); 
		
		
		
		MyFunctionalInf d1 = () -> {
			System.out.println(" Hi guys");
			
			
		};
		
		d1.m1();
		
		MyFunctionalInf d2 = () -> {
			
			System.out.println("hello from 2");
		};
		
		
		d2.m1();
		
		
	Runnable d3 = () -> System.out.println("demo 1");
	
		d3.run();
		
		
		
		Suminterface s1 = ( a, b) ->   a+b;
			 
		

	System.out.println(	s1.cal(2, 3));
	
	
	
	StringLengthFunc t1 = (s )-> {
return s.length();
	};
		
	//or

//	StringLengthFunc t1 = s ->   s.length();

	
	System.out.println(t1.len("apple"));
	
	
	
	}
}

