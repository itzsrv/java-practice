HashMap
#################################




curl -s "https://www.youtube.com/watch?v=APL28XpFP0c"|grep -o '"baseUrl":"https://www.youtube.com/api/timedtext[^"]*lang=en'|cut -d \" -f4|sed 's/\\u0026/\&/g'|xargs curl -Ls|grep -o '<text[^<]*</text>'|sed -E 's/<text start="([^"]*)".*>(.*)<.*/\1 \2/'|sed 's/\xc2\xa0/ /g;s/&amp;/\&/g'|recode xml|awk '{$1=sprintf("%02d:%02d:%02d",$1/3600,$1%3600/60,$1%60)}1'|awk 'NR%n==1{printf"%s ",$1}{sub(/^[^ ]* /,"");printf"%s"(NR%n?FS:RS),$0}' n=2|awk 1 >> file.txt

Now we will look at various map implementations available in **java.util** package. We will also see concurrency troubles, even when we use concurrent HashMap and workaround to resolve it.

We have so many map implementations, let's go and inspect the first class where it all
began

### 1. java.util.HashTable

This is the legacy associative array implementation where the first Java release had only HashTable. This was the time when Collections package was not even existing. So at that time hash table was the only implementation of an associative array in Java. So later on when collections framework came in this became like a legacy class because Collection Framework had HashMap implementation and so hash table was
retrofitted by implementing Map Interface.

Hash table has a unique advantage in terms of thread safety, all the public API is on a hash table has
synchronized keyword on it meaning, it is thread safe, that means if a thread is currently writing into the map (suppose we are calling put from one thread), another thread which is trying to get something has to wait until the put is completed. So that means it's the entire map is locked so it actually appears like a good thing but it's not really a good thing because it is an overhead in an environment where we write the map contents many times in the beginning and later on we do only read. 

That is the price you would pay for making each and every method synchronized. That's all about hash table and any given day you don't reallyhave to use hash table in your application programming so you can
simply ignore this class from now on. 

Going on to the most popular implementation of map interface which is 

### 2. java.util.HashMap 

so this hash map implementation historically or otherwise satisfies most of the requirements for
map use cases and hash map implementation is not thread safe, meaning, concurrent threads updating hash map (suppose we have a thread continually putting content and another thread continually reading from
that map), there may be chances where the the reading thread can see data that was not completely written or things like that. So this map is not thread safe,  the calls doesn't block each other.

Also another interesting aspect of HashMap is that the **iteration of a HashMap**. It's not guaranteed in the order of putting the keys. Suppose we put three key values into a HashMap, later on, there is no guarantee that when we read or iterate over the key set we get the same order of insertion. 

And another point regarding **HashMap is that it allows you to insert null keys** and there are not too many use cases where you would want to use them but that is one of the features that is out there
available on a hash map. 

If you want to really use HashMap in a concurrent environment, only way is to use all concurrent primitives that are available, like synchronize keywords or locks and things like that. 

Most of the enterprise applications populate the map once and they read many times from many threads. So given this type of utility HashMap  is a very good candidate for your application where you throw in a bunch of key value pairs initially and then later only read from the map.

Let's move on to the next interesting implementation of a map interface, this is 
 
### 3. java.util.LinkedHashMap 

it's very similar to HashMap in the implementation but the interesting aspect is that, in the LinkedHashMap, the iteration is guaranteed in insertion order. So that means if we insert keys and values into the HashMap, later when you try to iterate through the key set of the HashMap  you're
guaranteed to get the same order in which those keys values pair were inserted in the map, back to you. 

So this can be used in scenarios where insertion order is of some significance to you. For example suppose you want to load a bunch of employee names from database and then store some information against
those names in the map and suppose you already have sorted your output based on some DB logic that you want to reflect the front-end. So it's always safe to place them onto a LinkedHashMap so that from wherever you return the list, you get the list in the the same order of insertion. So that means the ordering is preserved.

So how that is maintained internally is by using a doubly linked list, of all entries in the hash
map. So that is an internal extra double linked list is used inside LinkedHashMap meaning some extra additional space concerns are there but you know given the benefits that we get those can be ignored.


So now moving on to the next type of map implementation which is TreeMap which actually implements the SortedMap as well as the NavigableMap interfaces. 

### 3. java.util.TreeMap

SortedMap and NavigableMap interfaces are basically interfacesthat guarantees or provides you contact
methods. 

SortedMap provided you contract based on the sorted order of the keys that were inserted in the map. And a NavigableMap provides you very convenient methods which gives you approximately lookup, like you can lookup ceal or floor based on the key. Suppose you want to get a key which is nearest to the key that you are looking for, that type of operations can be achieved using the NavigableMap interface and TreeMap is the default implementation in the JDK for SortedMap and NavigableMap. 

The main benefit of TreeMap apart from the convenience method that comes from NavigableMap interface is that iteration is guaranteed in natural sorted order of keys. So that means you keep on inserting keys into the database (let's assume we are inserting a java.lang.String keys into the TreeMap) so the so you keep on inserting keys and value pairs, later we can see that the keys are automatically sorted for you in
the natural order. 

So that is a very beneficial scenario where you suppose want to have a map between the country and capitals of the countries and you eventually want to show the country names in the sorted order so you don't have to really worry about achieving that sorting, instead what you can do is use TreeMap and insert the country versus capital in whatever order you like but when you retrieve them, the key set you get the
country names in sorted order so that is a benefit of TreeMap.

So internally it uses a Red-Black Tree implementation which provides you the sorted appearance
of the keys. 

Now going on to another interesting HashMap that we generally don't use in our applications which is 

### 4. java.util.IdentityHashMap 

In IdentityHashMap the most interesting aspect is that it uses the identity to check the key equality that means it's checks if key one double equals key two instead of calling the equals method on the keys so this is used in deep copying or a class object is used as a key of things like that. 

So memory footprint of an IdentityHashMap is comparatively smaller than a hash map and it's it has several benefits like that.

So suppose you are constructing a map with **interned strings** that means strings that are already out there in the string pool, you could use the IdentityHashMap and save some space.

So next map implementation that we should know about is 

### 5. java.util.EnumMap 

EnumpMap class definition says 
```java
EnumMap <K extends Enum<K>, V> 
```
So this is a map that takes Enum as key and the enum type that you mentioned must come from a single Enum type that is specified explicitly or implicitly when the map is created. 

So another point that we should know is that null keys are not permitted in EnumMap. So for that matter null Keys are not permitted in hash table als, it throws a null pointer error. 

EnumMap is not synchronized neither was TreeMap or LinkedHashMap.

Iterator does not fail fast, what does that mean so there is a point you would have come across an error called **concurrent modification exception**. What that essentially means is that, when you are trying to read from a certain list or a map, some other thread or this current thread itself is trying to modify that list or map, so in that kind of scenario **concurrent modification exception is thrown**. 

So the point you should remember is that concurrent modification exception has nothing to do with multiple threads it can happen in single thread also. so how that happens in single thread let's have a quick look  using some code and try to simulate a concurrent modification exception.

```java
Class ConcurrentExcep{
    private static void main(String[] args){
        Map<String, Integer> scores = new HashMap<>();

        scores.put("user1", 6);
        scores.put("user2", 6);
        scores.put("user3", 6);
        scores.put("user4", 6);
        scores.put("user5", 6);
        scores.put("user6", 6);
        scores.put("user7", 6);
        scores.put("user8", 6);

        //Now I'm going to get an iterator for the key set. 

        Iterator<String> userItr = scores.keySet().iterator();

        while(userItr.hasNext()){
            System.out.println(scores.get(userItr.next())); 
            scores.put("user9", 6);
        }

    }
} 
```

```java
Exception in thread "main" java.util.ConcurrentModificationException
        at java.base/java.util.HashMap$HashIterator.nextNode(HashMap.java:1597)
        at java.base/java.util.HashMap$KeyIterator.next(HashMap.java:1620)
        at collections.ConcurrentExcep.main(ConcurrentExcep.java:24)
```



So here you go I got a concurrent modification exception exactly at the line where I was trying to insert the item and iterate over the map key.

So that is concurrent modification exception. 

But there arecertain map implementations that kind of doesn't fail like this. So EnumMap iterator does not fail fast that means if you create an EnumMap and add some enumeration key value pairs into the EnumMap and then do the same exercise you iterate all the keys and then try to put something into the map in between, it does not fail like that. So that that means iterator does not fail
fast.

Now let's proceed on to another kind of map that is available in Java which is 

### 6. java.util.WeakHashMap 

This is something that we should use when you're when we are creating a **cache** or something like that because WeakHashMap is used to store the keys in weak reference. So we should know what exactly is a weak reference. 

So a weak reference is a reference type in java which tells the **Garbage Collector** that if the only reference to the weak reference type (whatever it's contained in the weak reference) is as a HashMap key, the garbage collector is free to collect that object. You don't have to have that object hanging around.

So that is the concept behind weak reference. So in a WeakHashMap, that means the elements in the hashmap can be reclaimed by the garbage collector if there are no other strong reference to the object. 

A strong reference is when you say object something like,

```java
Employee e = new Employee();

HashMap hashmap = new HashMap();
hashmap.put(e, some_value);
``` 


So that e is a strong reference because it's an object that you explicitly created and associated at the same time. 

Weak references is that a reference that can be garbage collected if only the reference occurrence is not in the form of a strong reference. 

That means suppose you insert an employee into the WeakHashMap and then somehow the employee goes out of scope in your application, that means the Garbage Collector is free to recollect or reclaim the space used by that element that you just inserted in the WeakHashMap. 

The keys that you insert into a WeakHashMap gets wrapped in **java.lang.ref.WeakReference**.  So this is
useful only say if lifetime of cache, (the entries) is determined by external reference to the key, not the value. The value will also get removed from the map but more important that it is focused on the  key's availability, if it is a strong reference or a weak reference.

In Java there is yet another type of reference available which is called **soft reference** and soft
reference is very much like the weak reference where in weak reference,  the garbage collector can garbage collect the weak reference anytime if the only reference is of the weak type, but soft means it is kind of a weak reference type but the garbage collection will wait until there is is really need to do garbage collection, like if there is a garbage collection pressure in the heap.

**there is a WeakHashMap and the keys are wrapped in weak reference and hence if there are no strong references to your keys, the garbage collector is free to reclaim that space.** And hence this is very useful when you're creating a cache of values and that is one of the biggest use of WeakHashMap and you are guaranteed with some cleanliness in your overall application. 

In Java there's no soft HashMap, like we talked about soft reference but there are no Soft HashMap in Java.

Let's take a look at an example of WeakHashMap:

```java
public class WeakHMap {
    public static void main(String[] args) {
        Map<Order, Integer> orders = new WeakHashMap<>();
        
        orders.put(new Order(1, "detail of order1"), 100);
        orders.put(new Order(2, "detail of order2"), 200);

        //these two objects order1 and order2 does not have any strong reference here 

        //lets create one strong reference

        Order order3 = new Order(3, "detail of order3");

        orders.put(order3, 300);
         

        //so the garbage collector is free to collect them 

        System.out.println(orders.size());

        System.gc();

        System.out.println(orders.size());

        //3
        //1 
        //--> this should be the expected behaviour
    }
}


class Order {
    int orderId;
    String details;

    public Order(int anId, String theDetails){
        orderId = anId;
        details = theDetails;
    }
}
```

So that is the significance of WeakHashMap, where we create HashMap of cache values, that's WeakHashMap usage. 

**Now let's go to the synchronized world or the concurrent world of maps** 

So the first way to get us an instance of a synchronized map in Java is using 
### 1. Collections.synchronizedMap(aMap) 

and pass a reference to already constructed map to it that automatically converts your current map instance into a synchronized map and returns to you. 

So this is like a Decorator Pattern Example where you're adding additional behavior to the object that's being passed to it. 

And this map is a fully synchronized map, means, the returned synchronized map instance that you get in your hand, has synchronized in all its public methods, that means all the reads and writes would block the threads, thats doing some other operations. 

So it is provided as a convenience, it's in theory similar to HashTable that we have seen, the synchronized map, and you can use or you can not use it, and most of the time there is no need to really use synchronized map and **Collections.synchronizedMap()**, this synchronizedMap API call returns you a synchronized map internal class instance and wraps around passed map instance aside we've talked about and marks all the API's as synchronized.

So that gives you complete thread safety but you know if  you are very serious about concurrent programming this is not the  kind of thread safety that you would like to have so you can try to find out more details on the other type of maps like concurrent maps etc and then think of using those kind of Maps instead of a synchronized map. 

so speaking of which  **java.util.concurrent** has a lot of utility classes that came with Java 5 where the new concurrent modules were added so 

**java.util.concurrent.ConcurrentHashMap** 

supports full concurrency during retrieval, that means retrieval operations does not block at all. 

Reads can happen fast while the writes require a lock. The writes does not require a lock on the entire map table, instead there is something called segments that are created in ConcurrentHashMap and each segment contains a set of buckets in it so that means a write lock may be required only on one segment at any given time and suppose you're another thread that is writing into the map, is writing to a different segment, it can happily acquire that lock and work. So that means even writing has a very less amount of locking involved.

By default the ConcurrentHashMap is divided into sixteen segments and you can add sixteen threads to write into the hash map at the given time. 

And iterations on a ConcurrentHashMap does not throw concurrent modification exception, and even within the same thread. So it can be used, well in cases where a lot of concurrent addition happens followed by a lot of concurrent reads. 

In a ConcurrentHashMap null Keys are not allowed. so why null keys are not allowed is because if the map.get(null) returns a null object, it is not sure if a null is not mapped or if null is mapped to a null value. 

So in non concurrent map world we could check with the contains API but in a concurrent environment values can change between API calls as the API's itself are not atomic. That means even when you are using a ConcurrentHashMap you would have to use a certain locking or some other techniques to make sure when multiple threads operate on the ConcurrentHashMap, like you know suppose incrementing a count or
something like that, kind of use case you can have some good practices in place like synchronizing it or some other couple of techniques that I'm going to show in place.

So now let's look at some examples:

of a behavior of ConcurrentHashMap so for that what I'm going to do is I'm
going to create an example class called a concurrent map example so here what we
are going to do is we are going to create a map of certain when location
versus some orders coming from that location and then in from multiple
threads we will update that order count concurrently and see how it behaves so
now let's go and create a static reference to a map which a string of
location and long order count and call it as orders and let's create a new
concurrent ashmac so we created a ConcurrentHashMap instance and let's
create a main method but we are going to add some initial setup to the orders so
let's put a key called Bombay and no orders have come from Bombay yet so we
are putting a 0 long and then let's create another location called Beijing
and that also has 0 orders now let's create another location called London
and 0 orders now another location New York and 0 orders from that location now
let's create a through two threads and keep on imprinting incrementing the
order count in those two threads and see what happens so here I'm going to create
an executor service executors dot new fixed threat role of -
sighs - I'm going to create two threats and I'm going to say service dot submit
I'm going to say process order method I'm going to add a static method here
ConcurrentHashMap example static process orders and I'm going to create
submit two tasks that means I'm running two threads in parallel and then I'm
waiting for my termination for a second say time unit one second and then I'm
going to shut down my service so here what we are doing is we are going to
create two threads that'll eventually add or increase the orders in our order
map so let me provide the process orders API which is going to be static void
process orders this is going to iterate over the keys so I'm going to say for
stream key or city in orders dot key set I'm going to add 50 orders so I equal to
0 I less than 50 i plus plus I'm going to get city get sorry map dot get so I'm
going to say long old order equal to MA orders dot get the city name and then
I'm going to orders dot put city comma old order plus one so I'm going to
increment the orders in a for loop and I'm going to do it 50 times so for each
city I am going to place 50 orders per thread and I'm running two threads and
at the end of running two threads I should have 100 orders against each city
name if everything runs correctly so now let's say add system.out.println orders
at the end so now let's run this example and see what happens in this when we use
ConcurrentHashMap and we are running two operations on the hash map and we
are updating the values using two threads so now let us example and see
what happens so at the end of one second I waited for one second to complete
everything so I see that hundred orders are pretend in this map as expected but
at the same time this is multiple thread environment and there are chances that
this can go wrong so what I'm going to do is I'm going to continually run this
example I'm going to go to my command line and using a script I am going to
continually run this example and observe my output okay so I'm going to go to my
example project out and look at the class which is in scratch I guess let me
find out find out my name this class
okay so that's it so let's go to that path and invoke a command line
continuously so and see the output now I go to the documents workspace example
example out production example scratch sorry I gotta go back here and I'm going
to say well sure do Java scratch dot this name confirm the hashmap example
and then so this humming we're calling infinitely and observing the output so
I'm running see first I got 100 hundred looking good so far suddenly see what
happened here's the surprise I got 52 on Beijing and New York now then I again
got a 86 here and some times so that means the map is behaving strange or our
application rather is behaving very strange under multiple threads so no
matter if we use ConcurrentHashMap or any other you know such things you know
your application can go and behave real weird way like this okay so why is that
because these operations orders got get and orders got put these are not atomic
operations it has to you know this so it can be easily made atomic if we just
synchronize this whole thing here and the calls will wait before one thread
can update and at the end we will see the same value so what is the fun in
that let's try to do something else right so
what I'm going to do is I'm going to to address this problem where we are
getting inconsistent output I am going to use one way to fix this is to use
atomic law so in Java I think as of Java 5 these atomic types were implemented
this atomic type are guaranteed is as per the Java memory model specification
atomic types writes all its change before any other read happens
in the memory so given that anatomic lung should add this our concern here so
here what I'm going to do is I'm going to insert a new atomic long and do the
same for all the other cities I an atomic long and I cannot do this so what
we can do here is ordered orders dot get ki sorry it's a city and it returns an
atomic long on which we can say get an increment so this is an atomic operation
on the atomic long and all the changes the variable will be published to the
memory and whatever threads try to do this again we will see they're the most
current value of the atomic long and it should have consistent output as hundred
in all the cities when I run multiple times so now let's just do a test run
and as you can see in the test run we are getting 100 as the output now let's
go and run it in the infinite loop and observe our output so I'm going to keep
an eye on this output for a while and as you can see it's consistently printing
100 hundred hundred hundred which is very good so this is one of the ways to
make such operations safe when you use multiple threads modifying some values
of the map after getting it so that is using atomic long also you could use the
replace API on the on the map which replaces which returns a true only when
it can do a the values passed on the parameters matches the current value in
the hashmap so that is the another API called a replace that that helps in 2d
in this kind of situations now let's continue our discussion on concurrent
hash map so what we have seen is the operations on ConcurrentHashMap are
not atomic and you should still be concerned about areas where multiple
threads for modify your map after checking some keys
or pulling some key and then putting some value back into the map those kind
of scenarios you should judiciously check or use atomic variables as
possible as what we have seen now let's go ahead and see another yet another
implementation in Java you reckon current is the concurrent skip list map
in Java concurrent what this is a scalable concurrent NavigableMap and
sort of map implementation so this is the equivalent of TreeMap in the
concurrent world so that's the important point of about concurrent skip list map
so it behaves like the TreeMap which gives you all the NavigableMap
interface API is like approximate lookups and things like that also sort
of map interface implementation where the keys will be sorted in the natural
ordering so a plus it brings the concurrent behavior just like the
ConcurrentHashMap where the parallel rights are very rarely blocked and the
reads are never blocked also concurrent skip lists map guarantees average order
of log n performance on a wide variety of operations ConcurrentHashMap does
not guarantee operation time as part of its contract so one difference between
concurrent Skip list map and concurrent the hash map is that there is no
performance contract in the ConcurrentHashMap also concurrent skip list a map
has a performance contract of order of log n in most of the operations so that
kind of concludes the various maps in our java jdk as of today so in coming
weeks i am going to publish more videos in the concurrency or multi-threaded
programming and some other topics such as garbage collection which will be of
interest so please stay tuned subscribe if you like like the content please
leave a comment if you liked it or if you have any questions or criticism
please leave a comment on that too thank you