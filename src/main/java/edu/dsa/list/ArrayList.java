package edu.dsa.list;

import java.util.Objects;

/**
 * My own implementation of an ArrayList off
 * @param <E>
 */
public class ArrayList<E> implements List<E> {

    private static final int INITIAL_CAPACITY = 10;

    private E[] arr;
    private int size;

    /**
     * Creates a new ArrayList with the default initial capacity
     */
    public ArrayList(){
        this(INITIAL_CAPACITY);
    }

    /**
     * Creates a new ArrayList with a provided capacity
     * @param initialCapacity the initial capacity of the list
     * @throws NegativeArraySizeException if {@code initialCapacity} is negative
     * @throws IllegalArgumentException if {@code initialCapacity} is 0
     */
    public ArrayList(int initialCapacity){
        if (initialCapacity == 0){
            throw new IllegalArgumentException("initialCapacity cannot be 0");
        }
        arr = (E[]) new Object[initialCapacity];
        size = 0;
    }

    protected int getCapacity(){
        return arr.length;
    }

    protected boolean noSpaceAvailable(){
        return size() >= getCapacity();
    }

    protected void extend(){
        E[] expanded = (E[]) new Object[arr.length*2];
        if (size >= 0) {
            System.arraycopy(arr, 0, expanded, 0, size);
        }
        arr = expanded;
    }

    @Override
    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index != size()) {
            validateIndex(index);
        }
        if (noSpaceAvailable()) extend();

        for (int i = size(); i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        size++;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object e : arr){
            if (Objects.equals(o,e)){
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        validateIndex(index);
        return arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size(); i++){
            if (Objects.equals(o,arr[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size()-1; i >= 0; i--){
            if (Objects.equals(o,arr[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(E e) {
        int index = indexOf(e);
        if (index == -1){ return false; }
        remove(index);
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0){
            throw new ArrayIndexOutOfBoundsException("Index cannot be negative");
        }
        if (index >= size()){
            throw new ArrayIndexOutOfBoundsException("Index cannot be larger or equal the size of the array");
        }
        E oldVal = arr[index];
        for (int i = index; i < size(); i++){
            arr[i] = arr[i+1];
        }
        size--;
        return oldVal;
    }

    @Override
    public E set(int index, E element) {
        validateIndex(index);
        E oldVal = arr[index];
        arr[index] = element;
        return oldVal;
    }

    @Override
    public int size() {
        return size;
    }
}
