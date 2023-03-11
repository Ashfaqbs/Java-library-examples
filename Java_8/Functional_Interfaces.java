package Java_8;

//A Functional Interface is an interface that has exactly one abstract method

// method  -> public void firstInt_method(); no body but it can have static methods or default methods
//The @FunctionalInterface annotation prevents abstract methods from being accidentally added to functional interfaces
//by adding this interface we cant add more than 1 abstract method in this interface now
//now we can take this method abstract_func(); do the lambda exp and all A basic example of the Lambda Expression is:
//(x,y) -> x+y

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

	// below are the object methods but doesn't have body and we wont get any error
	// as it has only one abstract method
	@Override
	String toString();

	@Override
	boolean equals(Object obj);

}
