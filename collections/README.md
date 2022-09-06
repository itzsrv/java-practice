Collections API
##################


Data Sets

Variables

```java
int x;
x = 10;
int y = 20;
```

To represent 10000 variables, we need to declare 10000 variables.
 - not a good practice, infact worst practive
 - code readability is going down
 - code complexity is going up

Hence, to resolve these issues, we have array.

Arrays

```java
Student[] students = new Student[10000];

int[] variables = {10,20};
```

But there are some problems with array:
 - fixed in size
 - can hold only homogenous datatype elements
 - arrays concept is not backed by standard datastructure, meaning no standard operation support is there, its just primitive memory level concept. So, there are not readymade methods available to user, for every requirement, user has to write code like, sorting, insertion, elements presence check etc

```java  
students[0] = new Student();
students[1] = new Guardian();

Error: 
compilation error : incompatible type
    found Guardian
    required Student

```

One possible solution

```java
Object[] obj = new Object[1000];
obj[0] = new Student();
obj[1] = new Customer();
```

To overcome these problems, we can go with Collections.
 - not fixed in size, growable in nature
 - not homogenous, can add both homogenous and heterogenous objects
 - every collection class is based on some standard datastructure, so ready-made methods are there to support





 Collection   
  Collection is group of individual objects represented as a single entitiy.

  In java, we are provided with **Collection Framework**, (meaning Classes and Interfaces) to represent group of objects and **Collections Class**, that is a utility class that have several utility methods for Collection Object.

  Like for example, sorting, searching etc.


There are 9 key Interfaces in Collection framework:

Collection Interface

List 


Set


Queue


Map
