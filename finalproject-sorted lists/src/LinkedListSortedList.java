public class LinkedListSortedList<T extends Comparable<? super T>> implements SortedListInterface<T> {
    private Node firstNode;
    private int size;

    public LinkedListSortedList() {
        firstNode = null;
        size = 0;
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this(data, null);
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        Node current = firstNode;
        Node previous = null;

        while (current != null && newEntry.compareTo(current.data) > 0) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            newNode.next = firstNode;
            firstNode = newNode;
        } else {
            newNode.next = current;
            previous.next = newNode;
        }

        size++;
    }

    @Override
    public boolean remove(T anEntry) {
        Node current = firstNode;
        Node previous = null;

        while (current != null && !current.data.equals(anEntry)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            if (previous == null) {
                firstNode = firstNode.next;
            } else {
                previous.next = current.next;
            }
            size--;
            return true;
        }

        return false;
    }

    @Override
    public int getPosition(T anEntry) {
        Node current = firstNode;
        int position = 1;

        while (current != null) {
            int comparison = anEntry.compareTo(current.data);
            if (comparison == 0) {
                return position;
            } else if (comparison < 0) {
                return -(position);
            }
            current = current.next;
            position++;
        }

        return -(position);
    }

    @Override
    public T getEntry(int givenPosition) {
        if (givenPosition < 1 || givenPosition > size) {
            throw new IndexOutOfBoundsException("Invalid position.");
        }

        Node current = firstNode;
        for (int i = 1; i < givenPosition; i++) {
            current = current.next;
        }

        return current.data;
    }

    @Override
    public boolean contains(T anEntry) {
        return getPosition(anEntry) > 0;
    }

    @Override
    public T remove(int givenPosition) {
        if (givenPosition < 1 || givenPosition > size) {
            throw new IndexOutOfBoundsException("Invalid position.");
        }

        T result;

        if (givenPosition == 1) {
            result = firstNode.data;
            firstNode = firstNode.next;
        } else {
            Node previous = firstNode;
            for (int i = 1; i < givenPosition - 1; i++) {
                previous = previous.next;
            }
            Node toRemove = previous.next;
            result = toRemove.data;
            previous.next = toRemove.next;
        }

        size--;
        return result;
    }

    @Override
    public void clear() {
        firstNode = null;
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
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        if (isEmpty()) {
            return (T[]) new Comparable[0];
        }

        T[] array = (T[]) java.lang.reflect.Array.newInstance(firstNode.data.getClass(), size);
        Node current = firstNode;
        int index = 0;

        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }

        return array;
    }
}