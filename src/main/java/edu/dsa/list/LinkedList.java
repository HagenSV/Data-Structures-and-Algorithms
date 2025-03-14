package edu.dsa.list;

import java.util.Objects;

public class LinkedList<E> implements List<E> {

    private final ListNode<E> first = new ListNode<>(null);
    private ListNode<E> last = first;
    private int size = 0;

    /**
     * Appends an item to the end of the list
     *
     * @param e item to append
     * @return {@code true} if the item was appended to the list
     */
    @Override
    public boolean add(E e) {
        ListNode<E> node = new ListNode<>(e);
        last.next = node;
        last = node;
        size++;
        return true;
    }

    /**
     * Inserts an item at a given index
     *
     * @param index   index to place item at
     * @param element element to insert
     */
    @Override
    public void add(int index, E element) {
        //Do not use validate index if index == size();
        //In this case index == size is a valid input
        if (index != size()){
            validateIndex(index);
        }
        ListNode<E> curr = first;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }
        ListNode<E> insert = new ListNode<>(element);
        insert.next = curr.next;
        curr.next = insert;
        size++;
    }

    /**
     * Empties the list
     */
    @Override
    public void clear() {
        first.next = null;
        last = first;
        size = 0;
    }

    /**
     * Checks if a given value exists in the list
     *
     * @param o the value to search for
     * @return {@code true} if the value exists anywhere in the list
     */
    @Override
    public boolean contains(Object o) {
        ListNode<E> curr = first.next;
        while (curr != null){
            if (Objects.equals(curr.value,o)){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    /**
     * Gets the value at an index
     *
     * @param index index to get
     * @return value stored at the given index
     * @throws ArrayIndexOutOfBoundsException if provided index is invalid
     */
    @Override
    public E get(int index) {
        validateIndex(index);
        ListNode<E> curr = first.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.value;
    }

    /**
     * Gets the index of a given value
     *
     * @param o the value to search for
     * @return index of the given value or -1 if the value does not exist
     */
    @Override
    public int indexOf(Object o) {
        ListNode<E> curr = first.next;
        for (int i = 0; i < size(); i++){
            if (Objects.equals(curr.value,o)){
                return i;
            }
            curr = curr.next;
        }
        return -1;
    }

    /**
     * Checks if the list contains no elements
     *
     * @return {@code true} if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Finds the last occurrence of a value in the list
     *
     * @param o the value to search for
     * @return the index of the last occurrence of the value or -1 if the value does not exist
     */
    @Override
    public int lastIndexOf(Object o) {
        ListNode<E> node = first.next;
        int lastIdx = -1;
        for (int i = 0; i < size(); i++){
            if (Objects.equals(node.value,o)){
                lastIdx = i;
            }
            node = node.next;
        }
        return lastIdx;
    }

    /**
     * Removes the first occurrence of a given value from the list
     *
     * @param e the value to remove
     * @return {@code true} if the list changed
     */
    @Override
    public boolean remove(E e) {
        ListNode<E> curr = first.next;
        ListNode<E> prev = first;
        for (int i = 0; i < size(); i++){
            if (Objects.equals(curr.value,e)) {
                prev.next = curr.next;
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    /**
     * Removes the element at a given index
     *
     * @param index the index to remove
     * @return the value stored at that index
     * @throws ArrayIndexOutOfBoundsException if index is out of range (< 0 or >= size())
     */
    @Override
    public E remove(int index) {
        validateIndex(index);
        ListNode<E> curr = first.next;
        ListNode<E> prev = first;
        for (int i = 0; i < index; i++){
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        size--;
        return curr.value;
    }

    /**
     * Sets the value at an index
     *
     * @param index   the index to set
     * @param element the new value
     * @return the previous value stored in that position
     * @throws ArrayIndexOutOfBoundsException if index is out of range (< 0 or >= size())
     */
    @Override
    public E set(int index, E element) {
        validateIndex(index);
        ListNode<E> curr = first.next;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }
        E oldVal = curr.value;
        curr.value = element;
        return oldVal;
    }

    /**
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    private static class ListNode<E> {
        E value;
        ListNode<E> next;

        ListNode(E item){
            this.value = item;
            next = null;
        }
    }
}
