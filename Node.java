package business_analyzer_assignment;

public class Node<T>{
    T data;
    Node<T> next;

    public  Node(T item) {
        this.data=item;
        this.next=null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}