


## toString(): 
This method returns a string representation of the object. The default implementation provided by the Object class returns a string consisting of the object's class name and its memory address. You may want to override this method to provide a more meaningful string representation of your object.

## clone(): 
This method creates a copy of the object. The default implementation provided by the Object class creates a shallow copy of the object, meaning that only the object's fields are copied, not any objects that the fields reference. If you want to create a deep copy of the object, you will need to override this method.

## compareTo(): 
This method is used for sorting objects in collections such as List or TreeSet. If you want your objects to be sortable, you will need to implement this method.

## finalize(): 
This method is called by the garbage collector before an object is removed from memory. If you need to perform any cleanup actions before the object is removed, you can override this method.

It's important to note that you should only override these methods if it makes sense for your class. For example, if your class is not meant to be cloned, you may not need to override the clone() method. Similarly, if your class does not need to be sorted, you may not need to override the compareTo() method.


## compareTo(): 
 The compareTo() method is used for comparing objects and is typically used for sorting objects in collections such as List or TreeSet. It's defined in the Comparable interface, which must be implemented by any class that wants to be sortable.

Here's an example of a Person class that implements the Comparable interface and overrides the compareTo() method to sort by age:

     public class Person implements Comparable<Person> {
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

    @Override
    public int compareTo(Person otherPerson) {
        return Integer.compare(this.age, otherPerson.age);
    }
     }
In this example, the compareTo() method compares the age of two Person objects and returns a negative integer if the age of this object is less than the age of otherPerson, a positive integer if the age of this object is greater than the age of otherPerson, or zero if the ages are equal.

Here's an example of using the compareTo() method to sort a list of Person objects:

    List<Person> persons = new ArrayList<>();
     persons.add(new Person("John", 30));
     persons.add(new Person("Mary", 25));
     persons.add(new Person("Bob", 40));

     Collections.sort(persons);

         for (Person person : persons) {
    System.out.println(person.getName() + " " + person.getAge());
        }
  In this example, the Collections.sort() method is used to sort the list of Person objects. Because the Person class implements the Comparable interface and overrides the compareTo() method to sort by age, the list is sorted by age. The output of this program would be:

       O/P
       Mary 25
       John 30
         Bob 40