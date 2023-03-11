package Java_8;

//In Java 8, you may add non-abstract methods to interfaces,

//allowing you to create interfaces with method implementation. To construct interfaces with method implementation, use the Default and Static keywords. Lambda Expression functionality is mostly enabled through default approaches.
//
//You may extend the functionality of your libraries’ 
//interfaces by using default methods. This ensures that the code 
//created for previous versions is compatible with the newer interfaces (binary compatibility).

public interface Default_And_Static_Methods_In_Interfaces {

	default void default_method() {
		System.out.println("We are default method of interface");
	}
}

class derived_class implements Default_And_Static_Methods_In_Interfaces {

	public static void main(String[] args) {
		derived_class obj1 = new derived_class();
		obj1.default_method();

		// Output We are default method of interface
		// create a class outside and implement
	}
}