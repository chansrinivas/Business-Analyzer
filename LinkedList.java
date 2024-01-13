package business_analyzer_assignment;
import java.util.*;

public class LinkedList<T> implements List<T> {
    Node<T> head;
    private Node<T> tail;
    int size;

    public LinkedList() {
        head = new Node<>(null);
        tail = null;
        size = 0;
    }

    /**
     * Method adds new element to the linkedlist
     * @param item the item to be added
     */
    @Override
    public void add(T item) {
        Node<T> node = new Node<>(item);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /**
     * Method returns the size of the linkedlist
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    public static class LinkedListIterator<T> implements Iterator<T> {
        private Node<T> current;
        public LinkedListIterator(Node<T> head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.getData();
            current = current.getNext();
            return data;
        }

        public Iterator<T> iterator() {
            return new LinkedListIterator<>(current);
        }
    }

    /**
     * Method checks if the linkedlist contains a value
     * @param data the item to be checked
     * @return boolean value
     */

    @Override
    public boolean contains(T data) {

        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Method to get the value at a particular position
     * @param index index in the list
     * @return T
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public Node<T> getNode(int pos) {
        if(pos<0 || pos>=size)
            return null;
        Node<T> prev = head;
        for(int i=0; i<size; i++){
            prev = prev.next;
        }
        return prev;
    }
}