// The Java Stream API is a powerful and expressive tool introduced in Java 8 for processing collections of data in a functional and declarative manner. It allows you to perform complex data manipulation operations on collections, such as filtering, mapping, reducing, and sorting, using a fluent and concise syntax. Here's a comprehensive overview of the Java Stream API, covering various scenarios and operations:

// Creating a Stream:

// From a Collection: Use the stream() or parallelStream() method on a Collection to obtain a sequential or parallel stream, respectively.
// From an Array: Use the Arrays.stream(array) method to create a stream from an array.
// From a Range of Numbers: Use the IntStream, LongStream, or DoubleStream class to generate a stream of numbers within a specified range.
// From a Supplier: Use the Stream.generate(supplier) or Stream.iterate(seed, unaryOperator) methods to create a stream from a supplier or iterate operation.
// From I/O Operations: Use the BufferedReader.lines() method to create a stream from a file or other I/O sources.
// Stream Operations:

// Intermediate Operations:
// Filtering: Use filter(Predicate) to include elements based on a condition.
// Mapping: Use map(Function) to transform elements based on a mapping function.
// FlatMapping: Use flatMap(Function) to transform elements and flatten the resulting stream.
// Sorting: Use sorted() or sorted(Comparator) to sort the stream elements.
// Limiting and Skipping: Use limit(long) to limit the number of elements and skip(long) to skip elements from the stream.
// Distinct Elements: Use distinct() to obtain unique elements from the stream.
// Terminal Operations:
// Collecting: Use collect(Collector) to accumulate elements into a collection or perform custom operations.
// Reducing: Use reduce(identity, BinaryOperator) to perform reduction operations like sum, max, min, or custom operations.
// Aggregating: Use count(), max(comparator), min(comparator), average(), or sum() to obtain aggregate values.
// Iterating: Use forEach(consumer) to perform an action on each element of the stream.
// Matching: Use anyMatch(predicate), allMatch(predicate), or noneMatch(predicate) to check if any, all, or no elements satisfy a condition.
// Finding: Use findFirst() or findAny() to retrieve the first or any element from the stream, respectively.
// Conversion: Use toArray() or toList() to convert the stream into an array or list.
// Grouping and Partitioning: Use groupingBy(classifier) or partitioningBy(predicate) to group or partition elements based on specific criteria.
// Joining: Use joining(delimiter) to concatenate elements into a single string with a delimiter.
// Stream to Primitive Stream: Use mapToXxx() (e.g., mapToInt(), mapToLong(), mapToDouble()) to convert a stream to a primitive stream.
// Parallel Processing: Use parallel() or parallelStream() to process the stream in parallel for improved performance.
// Stream Pipelines:

// A stream pipeline consists of a source, zero or more intermediate operations, and a terminal operation.
// Intermediate operations are lazily evaluated, meaning they are only executed when a terminal operation is invoked.
// Pipelines can be chained together to form a sequence of transformations on the data.
// Stream pipelines can be parallelized using the parallel() method to leverage multiple threads for enhanced performance.
// Stream Performance and Optimization:

// Streams offer internal optimizations, such as short-circuiting, lazy evaluation, and parallel processing, to improve performance.
// Avoid stateful intermediate operations that rely on shared mutable state.
// Prefer using primitive streams (IntStream, LongStream, DoubleStream) for numerical computations to avoid boxing and unboxing overhead.
// Use parallel streams judiciously, as they may not always result in improved performance and may introduce additional complexity.
// Stream Exception Handling:

// Unlike traditional for-each loops, streams don't throw checked exceptions.
// Use the try-catch block within the stream pipeline to handle checked exceptions explicitly.
// Stream Use Cases:

// Filtering and Transformation: Filtering and transforming elements based on specific conditions.
// Aggregation and Summarization: Performing computations such as sum, average, max, min, or counting.
// Searching and Matching: Searching for specific elements or checking if elements satisfy certain conditions.
// Sorting and Comparing: Sorting elements based on specific criteria.
// Grouping and Partitioning: Grouping elements based on specific attributes or partitioning elements into different groups.
// IO and File Processing: Performing operations on files or processing data from I/O streams.
// The Java Stream API is a versatile tool that provides a concise and expressive way to manipulate and process data. By leveraging its various operations and techniques, you can write cleaner, more readable, and more maintainable code.

// Note: The examples provided in each scenario are not exhaustive and serve as a starting point to understand the concepts and syntax. For more detailed information and advanced use cases, refer to the Java documentation or dedicated resources on the Java Stream API.
  
  
  

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        // Creating a Stream from a List
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filtering: Get even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // Mapping: Double each number
        List<Integer> doubledNumbers = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Doubled numbers: " + doubledNumbers);

        // Sorting: Sort the numbers in descending order
        List<Integer> sortedNumbers = numbers.stream()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());
        System.out.println("Sorted numbers: " + sortedNumbers);

        // Reducing: Get the sum of all numbers
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        // Aggregating: Get the maximum number
        int max = numbers.stream()
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println("Max: " + max);

        // Iterating: Print each number
        numbers.stream()
                .forEach(System.out::println);

        // Matching: Check if any number is greater than 10
        boolean anyGreaterThanTen = numbers.stream()
                .anyMatch(n -> n > 10);
        System.out.println("Any number greater than 10? " + anyGreaterThanTen);

        // Conversion: Convert the stream to an array
        Integer[] numbersArray = numbers.stream()
                .toArray(Integer[]::new);
        System.out.println("Array: " + Arrays.toString(numbersArray));
    }
}


// op

// Even numbers: [2, 4, 6, 8, 10]
// Doubled numbers: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
// Sorted numbers: [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
// Sum: 55
// Max: 10
// 1
// 2
// 3
// 4
// 5
// 6
// 7
// 8
// 9
// 10
// Any number greater than 10? false
// Array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample {
    public static void main(String[] args) {
        // Creating a list of persons
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 25),
                new Person("Dave", 35),
                new Person("Eve", 30)
        );

        // Grouping persons by age
        Map<Integer, List<Person>> personsByAge = persons.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        // Printing the groups
        for (Map.Entry<Integer, List<Person>> entry : personsByAge.entrySet()) {
            int age = entry.getKey();
            List<Person> group = entry.getValue();
            System.out.println("Age: " + age);
            System.out.println("Persons: " + group);
            System.out.println();
        }
    }
}

class Person {
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
    public String toString() {
        return name;
    }
}



// op

// Age: 25
// Persons: [Alice, Charlie]

// Age: 30
// Persons: [Bob, Eve]

// Age: 35
// Persons: [Dave]



// The collect method in the Java Stream API is a terminal operation used to accumulate the elements of a stream into a mutable result container, such as a collection, array, or custom data structure. It allows you to perform various operations on the stream elements and collect the results into a desired format. The collect method takes a Collector as its argument, which defines how the elements should be collected.

// The Collector interface provides a set of predefined static methods in the Collectors class that represent commonly used collectors. These collectors can be combined and customized to achieve different collecting behaviors. Here are some common operations that can be performed using the collect method:

// Accumulating Elements into a Collection:

// toList(): Collects the elements into a List.
// toSet(): Collects the elements into a Set.
// toCollection(collectionSupplier): Collects the elements into a specific Collection type provided by the collectionSupplier function.
// Accumulating Elements into an Array:

// toArray(): Collects the elements into an array.
// toArray(generator): Collects the elements into an array using the provided generator function to determine the array type.
// Grouping Elements:

// groupingBy(classifier): Groups the elements based on a classification function (e.g., property or key) into a Map.
// partitioningBy(predicate): Partitions the elements into two groups based on a predicate, creating a Map with true and false keys.
// Aggregating Elements:

// counting(): Counts the number of elements in the stream.
// summingXxx(): Calculates the sum of elements of a numeric type (int, long, double).
// averagingXxx(): Calculates the average of elements of a numeric type.
// maxBy(comparator), minBy(comparator): Finds the maximum or minimum element based on a comparator.
// Joining Elements:

// joining(): Concatenates the elements into a single String using the specified delimiter.
// joining(delimiter, prefix, suffix): Concatenates the elements with a delimiter, prefix, and suffix.
// Reducing Elements:

// reducing(identity, binaryOperator): Applies a binary operator to the elements, accumulating them into a single value.
// reducing(binaryOperator): Applies a binary operator to the elements, returning an Optional as the result.
// Custom Collectors:

// You can create custom collectors by implementing the Collector interface. This allows you to define custom behavior for accumulating, combining, and finishing the collection process.
// Here's an example that demonstrates some of the collecting operation
  


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "is", "a", "popular", "programming", "language");

        // Collecting into a List
        List<String> collectedList = words.stream()
                .collect(Collectors.toList());
        System.out.println("List: " + collectedList);

        // Collecting into a Set
        List<String> collectedSet = words.stream()
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Set: " + collectedSet);

        // Collecting into a joined String
        String collectedString = words.stream()
                .collect(Collectors.joining(" "));
        System.out.println("String: " + collectedString);
    }
}



// // op
// List: [Java, is, a, popular, programming, language]
// Set: [Java, a, is, language, popular, programming]
// String: Java is a popular programming language

  
  
