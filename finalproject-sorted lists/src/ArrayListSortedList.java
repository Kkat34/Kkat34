import java.util.ArrayList;

public class ArrayListSortedList<T extends Comparable<? super T>> implements SortedListInterface<T> {
    private ArrayList<T> list;

    public ArrayListSortedList() {
        list = new ArrayList<>();
    }

    @Override
    public void add(T newEntry) {
        int i = 0;
        while (i < list.size() && newEntry.compareTo(list.get(i)) > 0) {
            i++;
        }
        list.add(i, newEntry);
    }

    @Override
    public boolean remove(T anEntry) {
        return list.remove(anEntry);
    }

    @Override
    public int getPosition(T anEntry) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = anEntry.compareTo(list.get(mid));
            if (cmp == 0) return mid + 1;
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
        return -(low + 1);
    }

    @Override
    public T getEntry(int givenPosition) {
        if (givenPosition < 1 || givenPosition > list.size()) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        return list.get(givenPosition - 1);
    }

    @Override
    public boolean contains(T anEntry) {
        return list.contains(anEntry);
    }

    @Override
    public T remove(int givenPosition) {
        if (givenPosition < 1 || givenPosition > list.size()) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        return list.remove(givenPosition - 1);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int getLength() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        if (list.isEmpty()) {
            return (T[]) new Comparable[0];
        }

        T[] array = (T[]) java.lang.reflect.Array.newInstance(list.get(0).getClass(), list.size());
        return list.toArray(array);
    }
}

