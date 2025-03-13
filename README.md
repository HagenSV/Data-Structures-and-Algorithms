# Data Structures and Algorithms in Java

Recruiters, feel free to quiz me on any of the algorithms I have implemented.

In this repository, I will implement various Data Structures and Algorithms as I see fit.
## Planned Features
**Data Structures**
- [ ] Lists
  - [x] ArrayList
  - [ ] LinkedList
  - [ ] DoubleLinkedList
  - [ ] CircularLinkedList
- [ ] Stack
- [ ] Queue
- [ ] Trees

**Algorithms**
- [ ] Sorting Algorithms
  - [ ] Merge Sort
  - [ ] Heap Sort
  - [ ] Bucket Sort

---
## ArrayList
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