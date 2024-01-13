package business_analyzer_assignment;

import java.util.*;

public interface List<T> {

    void add(T item);


    int size();

    Iterator<T> iterator();
    ListIterator<T> listIterator();

    boolean contains(T item);

    T get(int row);
}
