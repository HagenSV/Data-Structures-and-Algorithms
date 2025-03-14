## ArrayList

An ArrayList is a list implementation that stores data in an array.
The array has some capacity and is expanded when it runs out of space.
This makes ArrayLists more efficient for accessing elements by index, as the index can be used to directly access the element in the array.
When appending an element, the array may need to grow, which is an `O(n)` operation, otherwise the operation is only `O(1)`.

### Interesting Problems
I came across an interesting problem when developing my custom ArrayList implementation.
**When the array runs out of capacity, how much should it be expanded by?**
Expanding the capacity by one every single time results in improved space efficiency, assuring the array is never larger than it needs to be.
This decision comes at the cost of speed, turning an operation which could be `O(1)` into an `O(n)` operation every time, which is not acceptable.
For now, I went with expanding the array to 2x its previous size.
When I come up with realistic use cases for ArrayLists, I will revisit this growth factor to possibly better tune it for speed and memory efficiency.

**What if the initial capacity provided is zero?**
I hadn't considered the possibility of the capacity being zero when making the expand method.
This problem could easily be solved by modifying the expand method to grow the array by 2x+1,
but this solution didn't appeal to me. Is there a case where it is necessary for the initial capacity to be zero?
After much thought, I concluded that if a small initial capacity is absolutely necessary, an initial capacity of one would be sufficient for reducing memory usage.
Therefore, for now at least, I've decided to prohibit an initial capacity of zero.

### Use Cases
Appending and accessing elements to an ArrayList is a constant time operation, `O(1)`.
This makes ArrayLists great for use cases where you are storing and accessing data, especially when you don't know how much data will be stored.
Meanwhile, remove items is O(n), except when removing items from the end of the list.
Removing from the end of the list (index `size()-1`) is constant time, making ArrayLists perfect for implementing stack data structures.

---

## LinkedList

A LinkedList is a list implementation that stores data in nodes.
Each node contains a single value with a reference to the next node in the list.
This makes LinkedLists much more efficient for adding and removing elements than ArrayLists.
When appending an element, the array managed by the ArrayList may need to grow, which is an `O(n)` operation.
When appending an element to a LinkedList, the operation is always `O(1)`, all you need is to update the last node in the list to point to the new node as the last node.
Similarly, when removing an element from an ArrayList, each subsequent value in the array needs to be shifted down by 1, which is an `O(n)` operation.
When removing an element from a LinkedList, the operation is always `O(1)`, all you need.

### ArrayList vs LinkedList
ArrayLists and LinkedLists are both List implementations, but they have different performance characteristics.
ArrayLists store data in arrays, making them more efficient for accessing elements by index.
On the other hand, LinkedLists store data in nodes, making them more efficient for adding and removing elements.
This gives each list implementation their own unique use cases.
ArrayLists great for accessing and modifying existing data, while LinkedLists are cases where data is frequently added or deleted.

LinkedLists are much better suited for implementing Queues, as adding and removing elements from the front of the list is a constant time operation.
ArrayLists, on the other hand, are better suited for implementing Stacks, as adding and removing elements from the end of the list is a constant time operation.

---

## DoubleLinkedList

A DoubleLinkedList is a modified version of a LinkedList.
Rather than each node only pointing to the next node in the list, each node also points to the previous node in the list.
This makes it easier to traverse the list in both directions, making it more efficient for certain operations.