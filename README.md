# Data Structures and Algorithms in Java

Recruiters, feel free to quiz me on any of the algorithms I have implemented.

In this repository, I will implement various Data Structures and Algorithms as I see fit.
## Planned Features
Click on an item to read more
**Data Structures**
- [ ] [Lists](./docs/Lists.md)
  - [x] ArrayList
  - [X] LinkedList
  - [X] DoubleLinkedList
  - [ ] CircularLinkedList
- [ ] Stack
- [ ] Queue
- [ ] Trees

**Algorithms**
- [ ] Sorting Algorithms
  - [ ] Selection Sort
  - [ ] Bubble Sort
  - [ ] Insertion Sort
  - [ ] Quick Sort
  - [ ] Merge Sort
  - [ ] Heap Sort
  - [ ] Counting Sort
  - [ ] Radix Sort
  - [ ] Bucket Sort
- Compression Algorithms
  - [ ] Huffman Coding
  - [ ] Run Length Encoding
  - [ ] LZW Compression

---

## Design Considerations

When initially creating my List interface, I had the goal of eventually making my List implementations extend the `java.util.List` interface.
However, I realized that this could be an opportunity to make my own design decisions.
As of now, my List interface functions as a subset of `java.util.List`, only containing the methods critical for basic list functionality.
This may change in the future as I make design considerations.
Take, for example, the `indexOf` method.
In the java standard library, `indexOf` returns -1 if the element is not found.
This works fine, but results in repeated checks if the result is -1 when looking for the index of an element. Such as the example below:
```java
int index = list.indexOf(element);
if (index != -1) {
    // do something with index
}
```
Here, optional values come to mind. Optional values are a cornerstone of some other languages, but not Java.
Optional values are rarely encountered when using the Java standard library.
Since I am making my own list implementations, this provides the perfect opportunity to look into using optional values in various ways.
Another use case could be returning Optional values instead of throwing exceptions for bad indexes in methods such as `get`, `remove`, and `set`.
This would allow the user to check if the value is present before using it, and would be more in line with the functional programming paradigm.
Is this a good idea? I'm not sure yet, but it's something to consider.
As of now, `indexOf` returns -1 if the element is not found, and the methods `get`, `remove`, and `set` throw exceptions for bad indexes, keeping in line with the java standard library.
Java has a builtin Optional class that I could use, but I would like to keep with the theme of designing everything myself to learn more about the thought process behind these design decisions.
Perhaps once I am confident that using optional values is a good idea and I have a good idea of how to properly implement them, I will make the change.