
# Java 8 Features

## Functional Interface

Interfaces with single abstract method qualifies to be called as Funtional Interface.
Catch: It can have multiple default and static methods


### Default and Static Methods

### Why static methods are introduced in java 8?
static methods restrict the implementation classes to override the provided behaviour of the Interface method and hence gives access to original behaviour via Interface Name.

### Are Interface static methods availabe to implementing classes by default?
No, static methods are available with Interface names only.


### Why diamond problem will not occur in Interface static methods?
Because static methods are not part of implementation classes.

### How default methods in interface cope up with diamond problem?
Default methods are called with Interface names only, so there is no ambiguity for diamond problem to occur.   
InterfaceName.super.methodName();

```java
public void eat() {
    // TODO Auto-generated method stub
    Animal.super.eat();
};
```

## Streams

Streams bring functional programming to java, and are supported starting java 8.

A stream is a sequence of elements supporting sequential and parallel aggregate operations.
A stream pipeline consists of a source, followed by zero or more intermediate operations, and a terminal operation.

### Stream source
Streams can be created from Collections, Lists, Sets, ints, longs, doubles, arrays, lines of a file

>source -> filter -> sort -> map -> collect

Stream operations are either intermediate or terminal operations.

### Intermediate Operations
such as filter, map or sort return a stream, so we can chain multiple intermediate operations.
anyMatch()
distinct()
filter()
findFirst()
flatmap()
map()
skip()
sorted()

-->
range()
limit()
peek()



### Terminal Operations
only one terminal operation is allowed
such as forEach, collect or reduce are either void or return a non-stream result
forEach()       applies same function to each element
collect         saves the elements into a collection

other options reduce the stream to a single summary element

-count()
-max()
-min()
-reduce()
-summaryStatistics()


-->
-sum()
-average() 


**For very large data sets, use ParallelStream to enable multiple threads**


## Optional
One thing which may go wrong in the matching and finding elements is that there might be a case when no element is returned by them. In such a case these methods simply return Null. This may be error-prone to the client codes and the client program needs to put a Null check. Java 8 comes up with a special class which helps solving this problem. The Optional class represents whether an object is assigned or unassigned (Null).

The methods like **findAny, findFirst, and reduce** (when called without providing an identity) return values wrapped under Optional. We can call all of the stream like operations on Optional as well. Below, we will look at the use of Optional in matching and finding operations.


```java
students.stream()
    .filter(student - > student.getScore() > 80)
    .findAny()
    .map(Student::getName)
    .ifPresent(System.out::println);
```

In the example above, we can see the use of findAny just after the filter. The findAny returns Optional instance. The map method here, though it looks like a stream operation, is called on Optional instance returned by findAny. The Optional class’s map method returns Optional. Now, the ifPresent simply performs the Null checking and executes the function passed to it, if the Optional instance contains a value inside it.

-->
ifPresent()



### Streams Collectors

The collectors sit in the last of a stream pipeline and help to accumulate the elements of stream in the form of data structures, this is nothing but the final output of the stream pipeline. The class Collectors is an utility class which has many factory methods to create various predefined collectors implementations.

The Collectors helps to reduce, summarise, group, and partition the elements in a stream. Although, there are many useful predefined collectors available, we can also write our own Stream Custom collectors.

### Overview of Stream.collect() Method
The collect() method is a Terminal Method on the streams pipeline. Which means, the method appear at the end of the pipeline. It performs mutable reduction operations on the elements of the stream to transform them into desired data structures.

Typically, elements from a collection are streamed at the beginning of a Stream pipe line. Next, the elements in the stream are operated, transformed, filtered, or rearranged using various intermediate operations. Finally using the terminal method of collect() the elements in the stream can be transformed back into desired collection. This transformation strategy is defined by the Collector, which is passed as a parameter to the collect() method.

Java 8 Streams API provides many predefined implementations of Collector interface via its implementation class of Collectors. 



### Collect Stream elements as List
Simplest way to collect Stream elements into a List is to used toList() method.

```java
List<Integer> inputList =  List.of(1, 2, 3, 4, 5 );

List<Integer> outputList = inputList
         .stream()
         .collect(Collectors.toList());
```
This collector by default accumulate elements in a new ArrayList. In order to use other implementations of List, we can use toCollection() method instead. For example, the in the next snippet, the elements are collected in a LinkedList.

```java
List<Integer> linkedList = inputList
         .stream()
         .collect(Collectors.toCollection(LinkedList::new));
```
### Collect Stream elements in UnmodifiableList()

In order to collect stream elements into an Unmodifiable List, we can make use of toUnmodifiableList() method.

```java
List<Integer> unmodifiableList = inputList
         .stream()
         .collect(Collectors.toUnmodifiableList());
```

### Collect Stream elements as Set
In order to collect the stream elements into a Set, we can use toSet() collector.

```java
Set<Integer> outputSet = inputList
        .stream()
        .collect(Collectors.toSet());
```
The toSet() collector by default collects the elements into a new HashSet instance. 
However, we can use toCollection() method with desired constructor supplier. For example, in the next snippet, we are collecting the elements in a TreeSet.

```java
Set<Integer> treeSet = inputList
        .stream()
        .collect(Collectors.toCollection(TreeSet::new));
```
### Collect Stream elements in UnmodifiableSet()

Similarly, we can collect the stream elements as part of an Unmodifiable Set using toUnmodifiableSet() method.

```java
Set<Integer> unmodifiableSet = inputList
        .stream()
        .collect(Collectors.toUnmodifiableSet());
```
### Collect Stream elements as Map
Using the toMap() collectors, we can collect stream elements into a Map. However, in order to create the map entries we need to provide key and value pairs. This is done by passing key function and value functions to the collector method.

```java
List<Student> students = List.of(
        new Student(1231L, "Strong", "Belwas"),
        new Student(42324L, "Barristan", "Selmy"),
        new Student(15242L, "Arthur", "Dayne")
);
        
Map<Long, String> idStudentNameMap = students
        .stream()
        .collect(Collectors.toMap(Student::getId, Student::getFirstName));
```
In the toMap() method we are passing two arguments, which are references to the Id and First Name getter methods. Now, when we print the accumulated map we get all the key value pairs.

```java
{42324=Barristan, 15242=Arthur, 1231=Strong}
```

### Collect Stream elements in UnmodifiableMap()

To create an Unmodifiable Map from the stream elements, we can use toUnmodifiableMap() method.

```java
Map<Long, String> unmodifiableMap = students
        .stream()
        .collect(Collectors.toUnmodifiableMap(Student::getId, Student::getFirstName));
```
To lean more about converting a List to Map using Streams please visit Examples of Converting List to Map using Streams.

### Join String elements from a Stream
Using the collectors implementation of joining(), we can concatenate String elements together.

The next example shows a Stream of Student, where the joining() method is used to concatenate the last names of all the students separated by comma. It also passes a pair of prefix and suffix.

```java
String concatenatedLastNames = students
         .stream()
         .map(Student::getLastName)
         .collect(Collectors.joining(",", "[", "]"));
```
Printing the output String we get the desired result

```java
[Belwas,Selmy,Dayne]
```

### Stream Collectors for numbers
We will go through some of the ready to use collectors, specifically used on the numerical data in Stream.

### Summarise Numerical Data in Stream
The Collectors provide useful methods which can be used on a Stream to generate useful metrics like sum, average, min and max using the numerical data (Integer, Long, or Double) within the stream elements.

```java
List<Student> students = List.of(
        new Student(1231L, "Strong", "Belwas", 50),
        new Student(42324L, "Barristan", "Selmy", 34),
        new Student(15242L, "Arthur", "Dayne", 40)
);

IntSummaryStatistics intSummaryStatistics = students
         .stream()
         .collect(Collectors.summarizingInt(Student::getAge));
        
System.out.println(intSummaryStatistics.getMax());
System.out.println(intSummaryStatistics.getMin());
System.out.println(intSummaryStatistics.getCount());
System.out.println(intSummaryStatistics.getAverage());
```
In this example, we are iterating through the stream of Student and generating statistical data based on the integer field of age using summarizingInt() method. The result of the statistical analysis is collected in a wrapper called as IntSummaryStatistics, from which we can get various stats like min, max, count and average to get the next result

```java
 50
 34
 3
 41.333333333333336
 ```
Similarly, we can also generate statistical data for Double, and Long numbers to get the statistics in the form of DoubleSummaryStatistics and LongSummaryStatistics respectively.

The summarizing collector is useful when, we want to pull various statistics about the numerical data. However, if we are interested only the specific metrics then there are collectors, which returns individual metrics. Next, we will see such collectors.

### Count the elements in Stream
The counting() method on the Collectors can be used to simply count the total number of elements in the stream.

```java
Long count = students
        .stream()
        .collect(Collectors.counting());
```
### Sum of Numbers in Stream
Collectors provide a way to sum up all the numeric data within a Stream. The methods summingInt(), summingDouble(), and summingLong() can be used to get sum of Integer, Double, and Long numbers respectively.

```java
int sum = students
         .stream()
         .collect(Collectors.summingInt(Student::getAge));
```

### Average of Numbers in Stream
We can find average of the numberical data from the stream using averagingInt(), averagingDouble(), and averagingLong() for integer, double, and long numbers respectively.

```java
double average = students
         .stream()
         .collect(Collectors.averagingInt(Student::getAge));
```

### Find min and max elements in Stream
Using the collector functions of minBy() and maxBy() and passing a comparator by can find the min and max element out of the stream.

```java
Optional<Student> student = students
        .stream()
        .collect(Collectors
                .minBy(Comparator.comparingInt(Student::getAge)));
```
In this example, we are using minBy() collector on the Student stream and passing it a comparator comparing based on the age. The we get is the youngest student.

Similarly we can find the oldest student by using maxBy().

### Group elements from Stream
The collector groupingBy() is used to group elements from the Stream. The first argument to this method is a classifier based on which the elements will be grouped. Moreover, we can pass another collector to specify how the grouped elements should be combined.

```java
Map<String, List<Student>> nameToStudentMap = students
        .stream()
        .collect(Collectors.groupingBy(Student::getFirstName, Collectors.toList()));        
```
In this example, we are grouping all the students with same first name. Students with the same name will be grouped together in a List. As an output we get a Map containing first name as a key, and list of grouped students as its value.

### Partition elements in Stream
The partitionBy() collectors is used to make two groups from the elements of a Stream. We can pass a predicate to the method based on which the method will create two collections, containing the elements that match the given predicate and the elements that don’t. The output will be a Map where key is the boolean and values will be the partitioned collections.

```java
Map<Boolean, List<Student>> partitionedStudents = students
        .stream()
        .collect(Collectors.partitioningBy(s-> s.getFirstName().toLowerCase().startsWith("a")));
```
In this example, the predicate finds the students, who’s first name starts with ‘a’. In other words, we are partitioning the students stream based on whether their first name starts with ‘a’ or not.


### maps vs flatmaps

### consumer
        void action(T t)

### supplier
        T get()

### function
        R apply(T t)

### predicate
        boolean test(T t)