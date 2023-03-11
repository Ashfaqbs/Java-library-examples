package Object_Methods_Equals$HashCode;

import java.util.HashSet;
import java.util.Set;

public class Person {

	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	//1
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + name.hashCode();
		result = 31 * result + age;
		return result;
	}


	//2
	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Person other = (Person) obj;
		return name.equals(other.name) && age == other.age;
	}


	//Note
	//	If we dont overide the equals it works like == ,i.e for non primitive it tries to check the ref pointing to same data 
	//but objects are created by 
	public static void main(String[] args) {

		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello");

		System.out.println(str1 == str2); // true - str1 and str2 point to the same memory location
		System.out.println(str1 == str3); // false - str1 and str3 point to different memory locations, even though
		// their content is the same

		Person person1 = new Person("John", 30);
		Person person2 = new Person("John", 30);

		System.out.println(person1 == person2);// getting false but content is same but refrence is pointing to other
		// memory

		System.out.println(person1.equals(person2));//now ref might be pointing to diff memory but content is checked as we have overrided the equals method

		//		Even though person1 and person2 have the same name and age, 
		//		they are different object instances with different memory addresses. Therefore, if you use the == operator to compare them, it will return false.
		//
		//				Instead, you can use the equals() method 
		//				to compare them based on their content, like this:





		Set<Person> people = new HashSet<>();
		Person person3 = new Person("John", 30);
		Person person4 = new Person("John", 30);
		people.add(person3);
		people.add(person4);
		System.out.println(people.size()); // Output: 1
		//we have added 2, but both had same has code it considers other as duplicate and added only one
		//Why it considered the as duplicate because the content was same ,but if the object has diffrent content then it will have different hashcode and 
		//and while adding into the set it wont have same content and added to the set


		
//		SC-1
//		Person person3 = new Person("John", 30);
//		Person person4 = new Person("John", 30);
//		System.out.println(person3.hashCode());
//		System.out.println(person4.hashCode());
//		o/p
//		71767076
//		71767076

//		SC-2
		
//		Person person3 = new Person("John", 30);
//		Person person4 = new Person("John", 31);
//		System.out.println(person3.hashCode());
//		System.out.println(person4.hashCode());
//		o/p
//		71767076
//		71767077

		
	}
}
