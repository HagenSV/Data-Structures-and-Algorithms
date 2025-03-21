package edu.dsa.list;

import java.util.Objects;

public class DoubleLinkedList<E> implements List<E> {

    private final ListNode<E> first;
    private final ListNode<E> last;
    private int size;

    public DoubleLinkedList(){
        first = new ListNode<>(null);
        last = new ListNode<>(null);
        first.next = last;
        last.prev = first;
        size = 0;
    }

    /**
     * Appends an item to the end of the list
     *
     * @param e item to append
     * @return {@code true} if the item was appended to the list
     */
    @Override
    public boolean add(E e) {
        ListNode<E> node = new ListNode<>(e);
        last.prev.next = node;
        node.prev = last.prev;
        node.next = last;
        last.prev = node;
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

        if (index >= size()/2){
            ListNode<E> curr = last;
            for (int i = size(); i > index; i--){
                curr = curr.prev;
            }
            ListNode<E> insert = new ListNode<>(element);
            insert.next = curr;
            insert.prev = curr.prev;
            curr.prev = insert;
            insert.prev.next = insert;
            size++;
        } else {
            ListNode<E> curr = first;
            for (int i = 0; i < index; i++){
                curr = curr.next;
            }
            ListNode<E> insert = new ListNode<>(element);
            insert.next = curr.next;
            insert.prev = curr;
            curr.next = insert;
            insert.next.prev = insert;
            size++;
        }
    }

    /**
     * Empties the list
     */
    @Override
    public void clear() {
        first.next = null;
        last.prev = null;
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

        if (index >= size()/2){
            ListNode<E> curr = last;
            for (int i = size(); i > index; i--){
                curr = curr.prev;
            }
            return curr.value;
        }

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
        ListNode<E> node = last.prev;
        for (int i = size()-1; i >= 0; i--){
            if (Objects.equals(node.value,o)){
                return i;
            }
            node = node.prev;
        }
        return -1;
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
                curr.next.prev = prev;
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
    //TODO: rework method to take advantage of doubly linked list properties
    public E remove(int index) {
        validateIndex(index);
        ListNode<E> curr = first.next;
        ListNode<E> prev = first;
        for (int i = 0; i < index; i++){
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        curr.next.prev = prev;
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
    //TODO: rework method to take advantage of doubly linked list properties
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
        ListNode<E> prev;

        ListNode(E item){
            this.value = item;
            next = null;
        }
    }
}

