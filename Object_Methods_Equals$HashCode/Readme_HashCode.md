

Suppose you have a class called Person that represents a person with a name and an age:


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
     }
Now suppose you want to store a collection of Person objects in a HashSet, which is a collection that does not allow duplicate elements. In order for the HashSet to determine whether two Person objects are duplicates, it needs to use the hashCode() method.

## The hashCode() method is a method defined in the Object class that returns an integer value that represents the hash code of the object. The hash code is used to quickly determine whether two objects are likely to be equal. If two objects have the same hash code, it does not necessarily mean that they are equal, but if they have different hash codes, they are definitely not equal.

To use a HashSet with Person objects, you need to override the hashCode() method in the Person class to generate a hash code based on the name and age fields:


    @Override
    public int hashCode() {
    int result = 17;
    result = 31 * result + name.hashCode();
    result = 31 * result + age;
    return result;
      }
## In this implementation, the hashCode() method calculates the hash code by first initializing a result value to a prime number (17 in this case). Then, it multiplies the result by another prime number (31 in this case) and adds the hash code of the name field, as well as the age field. Finally, it returns the resulting hash code.

Now, when you add Person objects to a HashSet, the HashSet will use the hashCode() method to determine whether two objects are duplicates. For example:


    Set<Person> people = new HashSet<>();
     Person person1 = new Person("John", 30);
     Person person2 = new Person("John", 30);
     people.add(person1);
     people.add(person2);
     System.out.println(people.size()); // Output: 1
### In this example, we create two Person objects with the same name and age fields, and add them to a HashSet. Since we have overridden the hashCode() method to generate the same hash code for objects with the same name and age, the HashSet will consider these two objects to be duplicates and only store one of them.

## In summary, the hashCode() method in Java returns an integer value that represents the hash code of an object. The hash code is used to quickly determine whether two objects are likely to be equal. When working with collections like HashSet, you need to override the hashCode() method in your classes to generate a hash code based on the fields that determine object equality.


## The hash code of a Person object will be calculated based on the implementation of the hashCode() method that we've overridden in the Person class.

### In the implementation I showed earlier, the hash code is calculated based on the name and age fields, using the following formula:

    
    int result = 17;
    result = 31 * result + name.hashCode();
    result = 31 * result + age;
    return result;
    The hash code is calculated as follows:

We initialize the result variable to the prime number 17.
We multiply the result by the prime number 31.
We add the hash code of the name field (which is calculated using the hashCode() method of the String class).
We add the value of the age field.
We return the resulting hash code.
The specific value of the hash code will depend on the values of the name and age fields for the Person object. For example, if we create a Person object with the name "John" and age 30, the hash code will be:


    17 * 31 + "John".hashCode() * 31 + 30 = 3523137
If we create another Person object with the same name and age, its hash code will be the same, which will allow it to be considered equal to the first Person object when added to a HashSet or another collection that uses hash codes to determine equality.

### Note that the exact values of the constants used in the hashCode() method implementation (in this case, 17 and 31) are not critical, as long as they are prime numbers and relatively large. The important thing is that the implementation produces different hash codes for different objects and the same hash code for objects that are equal according to the equals() method.


# What happens we dont override the hashcode 

## If you don't override the hashCode() method and save objects in a Set or any other hash-based collection, the default implementation of hashCode() provided by the Object class will be used. This implementation generates a unique integer value for each object, based on the memory address where the object is stored.

## As a result, two objects that are considered equal by the equals() method may have different hash codes if their memory addresses are different. This can cause unexpected behavior when trying to use these objects in hash-based collections.

### For example, let's say you have a Person class with a name and age field, and you create two Person objects with the same name and age. If you save these objects in a HashSet without overriding the hashCode() method, the HashSet will treat these as two different objects and will allow them to be added to the set.


     Person person1 = new Person("John", 30);
     Person person2 = new Person("John", 30);
     Set<Person> persons = new HashSet<>();
     persons.add(person1);
     persons.add(person2);
     System.out.println(persons.size()); // Output: 2
### In this case, even though person1 and person2 are considered equal by the equals() method, they have different hash codes and are treated as different objects by the HashSet.

## To avoid this problem, it's important to override the hashCode() method in your class so that it produces the same hash code for objects that are considered equal by the equals() method. This will ensure that these objects are treated as the same object by hash-based collections.