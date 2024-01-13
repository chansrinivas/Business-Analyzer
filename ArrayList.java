package business_analyzer_assignment;

import java.util.ListIterator;

public class ArrayList<T> implements List<T> {
    private Object[] arr = new Object[10];
    private int size;

    /**
     * Method to get the value at the specified position
     * @param pos position in the array
     * @return T
     */
    public T get(int pos) {
        if (pos < 0 || pos >= size)
            throw new IndexOutOfBoundsException(pos + " is out of bounds.");
        return (T) arr[pos];
    }

    /**
     * Method to add an item to the arraylist
     * @param item value that needs to be added
     */
    public void add(T item) {
        if (size == arr.length)
            grow_array();
        arr[size++] = item;
    }

    /**
     * Method to increase the size of the array
     */
    private void grow_array() {
        T[] new_arr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++)
            new_arr[i] = (T) arr[i];
        arr = new_arr;
    }

    /**
     * Method to check if the array contains a particular element
     * @param item Item that needs to be checked
     * @return boolean value
     */
    @Override
    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method returns the size of the array
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    public static class ArrayListIterator<T> implements ListIterator<T> {
        private int nextIndex = 0;
        private int size = 0;
        private T[] arr = (T[]) new Object[10];

        @Override
        public boolean hasNext() {
            return nextIndex < size && nextIndex >= 0;
        }

        @Override
        public T next() {
            return arr[nextIndex++];
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public T previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }
    }

    @Override

    public Iterator<T> iterator() {
        return (Iterator<T>) new ArrayListIterator<T>();
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ArrayListIterator<T>();
    }


}
