import java.util.ArrayList;
import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    int index;
    ArrayList<Integer> array;

    public PeekingIterator(Iterator<Integer> iterator) {
        array = new ArrayList<>();
        index = -1;

        iterator.forEachRemaining(num -> array.add(num));
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return array.get(index + 1);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        index++;
        return array.get(index);
    }

    @Override
    public boolean hasNext() {
        return index + 1 < array.size();
    }
}