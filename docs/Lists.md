[Back](../README.md)

# ArrayList

An ArrayList is a list implementation that stores data in an array.
The array has some capacity and is expanded when it runs out of space.
This makes ArrayLists more efficient for accessing elements by index, as the index can be used to directly access the element in the array.
When appending an element, the array may need to grow, which is an `O(n)` operation, otherwise the operation is only `O(1)`.

## Interesting Problems
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

## Use Cases
Appending and accessing elements to an ArrayList is a constant time operation, `O(1)`.
This makes ArrayLists great for use cases where you are storing and accessing data, especially when you don't know how much data will be stored.
Meanwhile, removing items is O(n), unless you removing items from the end of the list.
Removing from the end of the list (index `size()-1`) is constant time.
This behavior makes ArrayLists perfect for implementing stack data structures where the end of the list is the top of the stack.

---

# LinkedList

A LinkedList is a list implementation that stores data in nodes.
Each node contains a single value with a reference to the next node in the list.

## ArrayList vs LinkedList
ArrayLists and LinkedLists are both List implementations, but they have different performance characteristics.
ArrayLists store data in arrays, allowing them to access elements by index in constant time, `O(1)`.
On the other hand, LinkedLists store data in nodes, making them more efficient for adding and removing elements in certain cases.
When appending an element to an ArrayList, the array may need to grow, which is an `O(n)` operation.
When inserting an element to an ArrayList, every value after the inserted value needs to be shifted up by 1, which is an `O(n)` operation.
When appending an element to a LinkedList, the operation is always `O(1)`, all you need to do is to update the last node in the list to point to the new node as the last node.
Similarly, prepending an element to a LinkedList is also a constant time operation.
When inserting an element to a LinkedList, the operation is `O(n)`, as you need to traverse the list to find the correct position to insert the element.

When removing an element from an ArrayList, each subsequent value in the array needs to be shifted down by 1, which is an `O(n)` operation, unless you remove from the end of the list, which is an `O(1)`.
When removing an element from the beginning LinkedList, the operation is `O(1)`, otherwise it will be `O(n)`, since you need to traverse the list to find the item to remove.

As you can see ArrayLists and LinkedLists are quite similar, but the LinkedList is faster at some specific operations.
The use cases of these advantages will be discussed in the next section.

## Use Cases
As mentioned before, adding elements to the beginning or end of a LinkedList is a constant time operation, `O(1)`.
Removing elements from the beginning of a LinkedList is also a constant time operation.
This makes LinkedLists excellent for implementing stack or queue data structures.
A queue could be implemented by adding items to the end of the list and removing them from the beginning.
A queue could be implemented by adding and removing items from the beginning of the list.
This contrasts from the ArrayList implementation of a stack where using the end of the list as the top of the stack is more efficient.

ArrayLists and LinkedLists have comparable performance when used to create a stack, however a LinkedList is more efficient than an ArrayList when used to create a queue.

---

# DoubleLinkedList

A DoubleLinkedList is a modified version of a LinkedList.
Rather than each node only pointing to the next node in the list, each node also points to the previous node in the list.
This makes it easier to traverse the list in both directions, making it more efficient for certain operations.