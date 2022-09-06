SET
#####################

  - Insertion order is not preserved
  - Duplicates are not allowed (not added, returns false)
  - this class permits null element




## HashSet


- This class implements the {@code Set} interface, backed by a hash table (actually a HashMap instance).

- This class permits the null element.

- This class offers constant time performance for the basic operations ({@code add}, {@code remove}, {@code contains} and {@code size}), assuming the hash function disperses the elements properly among the buckets.  Iterating over this set requires time proportional to the sum of the {@code HashSet} instance's size (the number of elements) plus the "capacity" of the backing {@code HashMap} instance (the number of buckets).  Thus, it's very important not to set the initial capacity too high (or the load factor too low) if iteration performance is important.

- <strong>Note that this implementation is not synchronized.</strong> If multiple threads access a hash set concurrently, and at least one of the threads modifies the set, it <i>must</i> be synchronized externally. This is typically accomplished by synchronizing on some object that naturally encapsulates the set.

- If no such object exists, the set should be "wrapped" using the {@link Collections#synchronizedSet Collections.synchronizedSet} method.  This is best done at creation time, to prevent accidental unsynchronized access to the set:<pre>   Set s = Collections.synchronizedSet(new HashSet(...));</pre>

- the iterators returned by this class's iterator method are <i>fail-fast</i>: if the set is modified at any time after the iterator is created, in any way except through the iterator's own {@code remove} method, the Iterator throws a {@link ConcurrentModificationException}. Thus, in the face of concurrent modification, the iterator fails quickly and cleanly, rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future.

- Note that the fail-fast behavior of an iterator cannot be guaranteed as it is, generally speaking, impossible to make any hard guarantees in the presence of unsynchronized concurrent modification.  Fail-fast iterators throw {@code ConcurrentModificationException} on a best-effort basis. Therefore, it would be wrong to write a program that depended on this exception for its correctness: <i>the fail-fast behavior of iterators should be used only to detect bugs.</i>




## LinkedHashSet


- Hash table and linked list implementation of the {@code Set} interface, with predictable iteration order.  This implementation differs from {@code HashSet} in that it maintains a doubly-linked list running through all of its entries.  This linked list defines the iteration ordering, which is the order in which elements were inserted into the set (<i>insertion-order</i>).  Note that insertion order is <i>not</i> affected if an element is <i>re-inserted</i> into the set.  (An element {@code e} is reinserted into a set {@code s} if {@code s.add(e)} is invoked when {@code s.contains(e)} would return {@code true} immediately prior to the invocation.)

- <p>This implementation spares its clients from the unspecified, generally chaotic ordering provided by {@link HashSet}, without incurring the increased cost associated with {@link TreeSet}.  It can be used to produce a copy of a set that has the same order as the original, regardless of the original set's implementation: 
  
```java  
  {     
    void foo(Set<String> s) {         
      Set<String> copy = new LinkedHashSet<>(s);         
      ...     
    } 
  }
  ```
  
  This technique is particularly useful if a module takes a set on input, copies it, and later returns results whose order is determined by that of the copy.  (Clients generally appreciate having things returned in the same order they were presented.)


- <p>This class provides all of the optional {@code Set} operations, and permits null elements.  Like {@code HashSet}, it provides constant-time performance for the basic operations ({@code add}, {@code contains} and {@code remove}), assuming the hash function disperses elements properly among the buckets.  Performance is likely to be just slightly below that of {@code HashSet}, due to the added expense of maintaining the linked list, with one exception: Iteration over a {@code LinkedHashSet} requires time proportional to the <i>size</i> of the set, regardless of its capacity.  Iteration over a {@code HashSet} is likely to be more expensive, requiring time proportional to its <i>capacity</i>.

- <p>A linked hash set has two parameters that affect its performance: <i>initial capacity</i> and <i>load factor</i>.  They are defined precisely as for {@code HashSet}.  Note, however, that the penalty for choosing an excessively high value for initial capacity is less severe for this class than for {@code HashSet}, as iteration times for this class are unaffected by capacity.

- 
-
-
-

## NavigableSet



## SortedSet Interface

 - first()
 - last()
 - headSet(Object o)
 - tailSet()
 - subSet()
 - comparator()           returns Comparator Object, incase of DNSO returns null.
 - 



## TreeSet

- A {@link NavigableSet} implementation based on a {@link TreeMap}. The elements are ordered using their {@linkplain Comparable natural ordering}, or by a {@link Comparator} provided at set creation time, depending on which constructor is used

- <p>This implementation provides guaranteed log(n) time cost for the basic operations ({@code add}, {@code remove} and {@code contains}).

- <p>Note that the ordering maintained by a set (whether or not an explicit comparator is provided) must be <i>consistent with equals</i> if it is to correctly implement the {@code Set} interface.  (See {@code Comparable} or {@code Comparator} for a precise definition of <i>consistent with equals</i>.)  This is so because the {@code Set} interface is defined in terms of the {@code equals} operation, but a {@code TreeSet} instance performs all element comparisons using its {@code compareTo} (or {@code compare}) method, so two elements that are deemed equal by this method are, from the standpoint of the set, equal.  The behavior of a set <i>is</i> well-defined even if its ordering is inconsistent with equals; it just fails to obey the general contract of the {@code Set} interface.

-
-
-

