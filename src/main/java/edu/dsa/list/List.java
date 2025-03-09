package edu.dsa.list;

/**
 * Shared interface for my custom implementations of Lists to make them interchangeable in code.
 * Long term goal is to make them implement {@code java.util.List}
 * @param <E> the type of elements in the list
 */
public interface List<E> {

    /**
     * Appends an item to the end of the list
     * @param e item to append
     * @return {@code true} if the item was appended to the list
     */
    boolean add(E e);

    /**
     * Inserts an item at a given index
     * @param index index to place item at
     * @param element element to insert
     */
    void add(int index, E element);

    /**
     * Empties the list
     */
    void clear();

    /**
     * Checks if a given value exists in the list
     * @param o the value to search for
     * @return {@code true} if the value exists anywhere in the list
     */
    boolean contains(Object o);

    /**
     * Gets the value at an index
     * @param index index to get
     * @return value stored at the given index
     */
    E get(int index);

    /**
     * Gets the index of a given value
     * @param o the value to search for
     * @return index of the given value or -1 if the value does not exist
     */
    int indexOf(Object o);

    /**
     * Checks if the list contains no elements
     * @return {@code true} if the list is empty
     */
    boolean isEmpty();

    /**
     * Finds the last occurrence of a value in the list
     * @param o the value to search for
     * @return the index of the last occurrence of the value or -1 if the value does not exist
     */
    int lastIndexOf(Object o);

    /**
     * Removes the first occurrence of a given value from the list
     * @param e the value to remove
     * @return {@code true} if the list changed
     */
    boolean remove(E e);

    /**
     * Removes the element at a given index
     * @param index the index to remove
     * @return the value stored at that index
     */
    E remove(int index);

    /**
     * Sets the value at an index
     * @param index the index to set
     * @param element the new value
     * @return the previous value stored in that position
     */
    E set(int index, E element);

    /**
     *
     * @return the size of the list
     */
    int size();
}
