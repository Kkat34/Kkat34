/**
 * A class of bags whose entries are stored in a fixed-size array.
 *
 * @author Frank M. Carrano, Timothy M. Henry
 * @version 5.1
 */
public final class ArrayBag<T> implements BagInterface<T> {
	private final T[] bag;
	private int numberOfEntries;
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	/**
	 * Creates an empty bag having a given capacity.
	 *
	 * @param desiredCapacity The integer capacity desired.
	 */
	public ArrayBag(int desiredCapacity) {
		if (desiredCapacity > MAX_CAPACITY) {
			throw new IllegalStateException("Attempt to create a bag " + "whose capacity exceeds " + "allowed maximum.");
		}
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[desiredCapacity];
		bag = tempBag;
		numberOfEntries = 0;
		integrityOK = true;
	}


	/**
	 * Adds a new entry to this bag.
	 *
	 * @param newEntry The object to be added as a new entry.
	 * @return True if the addition is successful, or false if not.
	 */
	@Override
	public boolean add(T newEntry) {
		checkIntegrity();
		boolean result = true;
		if (isArrayFull()) {
			result = false;
		} else { // Assertion: result is true here
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		} // end if

		return result;
	} // end add

	/**
	 * Retrieves all entries that are in this bag.
	 *
	 * @return A newly allocated array of all the entries in this bag.
	 */
	// public <T> T[] toArray() //OK
	@Override
	public T[] toArray() // OK
	{
		checkIntegrity();

		// The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast

		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = bag[index];
		} // end for
		return result;
		// Note: The body of this method could consist of one return statement,
		// if you call Arrays.copyOf
	} // end toArray

	/**
	 * Sees whether this bag is empty.
	 *
	 * @return True if this bag is empty, or false if not.
	 */
	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty

	/**
	 * Gets the current number of entries in this bag.
	 *
	 * @return The integer number of entries currently in this bag.
	 */
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	} // end getCurrentSize

	/**
	 * Counts the number of times a given entry appears in this bag.
	 *
	 * @param anEntry The entry to be counted.
	 * @return The number of times anEntry appears in this ba.
	 */
	@Override
	public int getFrequencyOf(T anEntry) {
		checkIntegrity();
		int counter = 0;

		for (int index = 0; index < numberOfEntries; index++) {
			if (anEntry.equals(bag[index])) {
				counter++;
			} // end if
		} // end for

		return counter;
	} // end getFrequencyOf

	/**
	 * Tests whether this bag contains a given entry.
	 *
	 * @param anEntry The entry to locate.
	 * @return True if this bag contains anEntry, or false otherwise.
	 */
	@Override
	public boolean contains(T anEntry) {
		checkIntegrity();
		return getIndexOf(anEntry) > -1; // or >= 0
	} // end contains

	/** Removes all entries from this bag. */
	@Override
	public void clear() {
		while (!isEmpty()) {
			remove();
		}
	} // end clear

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 *
	 * @return Either the removed entry, if the removal was successful, or null.
	 */
	@Override
	public T remove() {
		checkIntegrity();
		return removeEntry(numberOfEntries - 1);
	} // end remove

	/**
	 * Removes one occurrence of a given entry from this bag.
	 *
	 * @param anEntry The entry to be removed.
	 * @return True if the removal was successful, or false if not.
	 */
	@Override
	public boolean remove(T anEntry) {
		checkIntegrity();
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	} // end remove

	// Returns true if the array bag is full, or false if not.
	private boolean isArrayFull() {
		return numberOfEntries >= bag.length;
	} // end isArrayFull

	// Locates a given entry within the array bag.
	// Returns the index of the entry, if located,
	// or -1 otherwise.
	// Precondition: checkIntegrity has been called.
	private int getIndexOf(T anEntry) {
		int where = -1;
		boolean found = false;
		int index = 0;

		while (!found && (index < numberOfEntries)) {
			if (anEntry.equals(bag[index])) {
				found = true;
				where = index;
			} // end if
			index++;
		} // end while

		// Assertion: If where > -1, anEntry is in the array bag, and it
		// equals bag[where]; otherwise, anEntry is not in the array.

		return where;
	} // end getIndexOf

	// Removes and returns the entry at a given index within the array.
	// If no such entry exists, returns null.
	// Precondition: 0 <= givenIndex < numberOfEntries.
	// Precondition: checkIntegrity has been called.
	private T removeEntry(int givenIndex) {
		T result = null;

		if (!isEmpty() && (givenIndex >= 0)) {
			result = bag[givenIndex]; // Entry to remove
			int lastIndex = numberOfEntries - 1;
			bag[givenIndex] = bag[lastIndex]; // Replace entry to remove with last entry
			bag[lastIndex] = null; // Remove reference to last entry
			numberOfEntries--;
		} // end if

		return result;
	} // end removeEntry

	// Throws an exception if this object is not initialized.
	private void checkIntegrity() {
		if (!integrityOK) {
			throw new SecurityException("ArrayBag object is corrupt.");
		}
	} // end checkIntegrity

	// =================== New methods ======================================
	/**
	 * Combines all elements from this bag and another bag into a new bag.
	 *
	 * @param otherBag The other bag to combine with this bag.
	 * @return A new ArrayBag containing all elements from both bags.
	 */

	public ArrayBag<T> union(ArrayBag<T> otherBag) {
		ArrayBag<T> result = new ArrayBag<>(this.numberOfEntries + otherBag.numberOfEntries);
		for (T item : this.toArray()) result.add(item);
		for (T item : otherBag.toArray()) result.add(item);
		return result;
	}

	/**
	 * Finds common elements between this bag and another bag.
	 *
	 * @param otherBag The other bag to intersect with.
	 * @return A new ArrayBag containing the intersection of both bags.
	 */
	public ArrayBag<T> intersection(ArrayBag<T> otherBag) {
		ArrayBag<T> result = new ArrayBag<>();
		boolean[] counted = new boolean[otherBag.numberOfEntries];

		for (T item : this.toArray()) {
			for (int i = 0; i < otherBag.numberOfEntries; i++) {
				if (!counted[i] && item.equals(otherBag.bag[i])) {
					result.add(item);
					counted[i] = true;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Finds the difference between this bag and another bag.
	 *
	 * @param otherBag The other bag to subtract from this bag.
	 * @return A new ArrayBag containing the difference.
	 */
	public ArrayBag<T> difference(ArrayBag<T> otherBag) {
		ArrayBag<T> result = new ArrayBag<>();
		int[] frequencies = new int[otherBag.numberOfEntries];

		for (T item : this.toArray()) {
			int index = otherBag.getIndexOf(item);
			if (index == -1 || frequencies[index] >= otherBag.getFrequencyOf(item)) {
				result.add(item);
			} else {
				frequencies[index]++;
			}
		}
		return result;
	}

	/**
	 * Replaces a specific element in this bag with another element.
	 *
	 * @param oldEntry The element to be replaced.
	 * @param newEntry The element to replace with.
	 * @return True if the replacement is successful, false otherwise.
	 */
	public boolean replace(T oldEntry, T newEntry) {
		int index = getIndexOf(oldEntry);
		if (index >= 0) {
			bag[index] = newEntry;
			return true;
		}
		return false;
	}

	/**
	 * Converts this bag into a set by removing duplicates.
	 *
	 * @return A new ArrayBag containing only unique elements from this bag.
	 */
	public ArrayBag<T> toSet() {
		ArrayBag<T> result = new ArrayBag<>();
		for (T item : this.toArray()) {
			if (!result.contains(item)) result.add(item);
		}
		return result;
	}

	/**
	 * Finds the most frequent element in this bag.
	 *
	 * @return The most frequent element, or null if the bag is empty.
	 */

	public T getMostFrequentItem() {
		if (isEmpty()) return null;
		T mostFrequent = null;
		int maxCount = 0;
		for (T item : this.toArray()) {
			int count = getFrequencyOf(item);
			if (count > maxCount) {
				maxCount = count;
				mostFrequent = item;
			}
		}
		return mostFrequent;
	}

	/**
	 * Checks if this bag is a subset of another bag.
	 *
	 * @param otherBag The other bag to compare with.
	 * @return True if this bag is a subset of the other bag, false otherwise.
	 */
	public boolean isSubsetOf(ArrayBag<T> otherBag) {
		for (T item : this.toArray()) {
			if (getFrequencyOf(item) > otherBag.getFrequencyOf(item)) return false;
		}
		return true;
	}

	/**
	 * Checks if this bag is equal to another bag. Two bags are equal if they
	 * contain the same elements with the same frequencies, regardless of order.
	 *
	 * @param otherBag The other bag to compare with.
	 * @return True if both bags are equal, false otherwise.
	 */

	public boolean areEqual(ArrayBag<T> otherBag) {
		if (this.numberOfEntries != otherBag.numberOfEntries) return false;
		for (T item : this.toArray()) {
			if (getFrequencyOf(item) != otherBag.getFrequencyOf(item)) return false;
		}
		return true;
	}

	/**
	 * Returns a string representation of this bag.
	 *
	 * @return A string representation of the bag's contents.
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[ ");
		for (int i = 0; i < numberOfEntries; i++) {
			result.append(bag[i]);
			if (i < numberOfEntries - 1) result.append(", ");
		}
		return result.append(" ]").toString();
	}

} // end ArrayBag
