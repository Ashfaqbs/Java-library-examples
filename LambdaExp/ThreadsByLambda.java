package LambdaExp;

import java.util.Iterator;
import java.util.Scanner;

public class ThreadsByLambda  {
	
	public static void main(String[] args) {
		
		Runnable r1= () -> {
			
			Suminterface s1 = (a,b) -> {
				System.out.println(a+" "+b);
				return a+b;
			};
			
			int j = s1.cal(1,2);
			System.out.println(j);
			
			
			for (int i = 0; i <5; i++) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Runnable r2 = () -> { 
			
			MyFunctionalInf f1 = () ->
			{
				System.out.println("Hello");
			};
			
			
			f1.m1();
		};
		
		
		r1.run();
		r2.run();
		
		
		
		
		
		
		
		
		
	}

}
