import java.util.Arrays;

public class ArraySortedList<T extends Comparable<? super T>> implements SortedListInterface<T> {
    private T[] list;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArraySortedList() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(T newEntry) {
        if (size == list.length) {
            doubleCapacity();
        }

        int i = 0;
        while (i < size && newEntry.compareTo(list[i]) > 0) {
            i++;
        }

        for (int j = size; j > i; j--) {
            list[j] = list[j - 1];
        }

        list[i] = newEntry;
        size++;
    }

    private void doubleCapacity() {
        list = Arrays.copyOf(list, list.length * 2);
    }

    @Override
    public boolean remove(T anEntry) {
        int pos = getPosition(anEntry);
        if (pos > 0) {
            remove(pos);
            return true;
        }
        return false;
    }

    @Override
    public int getPosition(T anEntry) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = anEntry.compareTo(list[mid]);
            if (cmp == 0) return mid + 1;
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
        return -(low + 1);
    }

    @Override
    public T getEntry(int givenPosition) {
        if (givenPosition < 1 || givenPosition > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        return list[givenPosition - 1];
    }

    @Override
    public boolean contains(T anEntry) {
        return getPosition(anEntry) > 0;
    }

    @Override
    public T remove(int givenPosition) {
        if (givenPosition < 1 || givenPosition > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        T removed = list[givenPosition - 1];

        for (int i = givenPosition - 1; i < size - 1; i++) {
            list[i] = list[i + 1];
        }

        list[size - 1] = null;
        size--;
        return removed;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }

    @Override
    public int getLength() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(list, size);
    }
}