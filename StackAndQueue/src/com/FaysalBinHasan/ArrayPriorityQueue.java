package com.FaysalBinHasan;


@SuppressWarnings("unchecked")
public class ArrayPriorityQueue implements PriorityQueue {

    /** The array container for the elements. */
    private Object[]         data;
    /** The number of elements in this queue. */
    private int              size;
    /** The default initial capacity. */
    private static final int DEFAULT_INITIAL_CAPACITY = 100;

    /**
     * Creates an empty queue with specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of this queue.
     */
    ArrayPriorityQueue(int initialCapacity) {
	// TODO
	// Create the data array of given capacity, and set size to 0.
    }

    /**
     * Creates an empty queue with default initial capacity.
     */
    ArrayPriorityQueue() {
	// TODO
	// Create the data array of default capacity, and set size to 0.
    }

    /**
     * Returns the number of elements in this queue.
     * 
     * @return the number of elements in this queue.
     */
    public int size() {
	// TODO
	return 0;			// TODO: REMOVE THIS LINE!
    }

    /**
     * Returns true if this queue is empty.
     * 
     * @return <tt>true</tt> if this queue is empty, or <tt>false</tt>
     *         otherwise.
     */
    public boolean isEmpty() {
	// TODO
	return true;			// TODO: REMOVE THIS LINE!
    }

    /**
     * Adds the specified object to this priority queue.
     * 
     * @param o the object to add.
     */
    public void add(Object o) {
	// TODO
	// 1. Check if it needs to resized, and if so, double the 
	//    capacity before continuing with addition.
	// 2. Start from the end, checking each element in the array
	//    to see if it's larger than the given new element 'o'.
	//    At each step, shift the elements in the right one position
	//    to the right to create a "hole" for the new element.
	// 3. Once the position is found - either because we're now in
	//    the 0'th position (all the existing elements are larger
	//    than 'o'), or we've found an element that is not larger,
	//    we add it to the hole.
	// 4. Adjust size and return.
    }

    /**
     * Gets the object with the maximum priority, and removes it from this
     * queue.
     * 
     * @return the object with the maximum priority.
     * @exception EmptyQueueException if this queue is empty.
     */
    public Object removeMax() {
        // TODO
	// 1. Check precondition and throw exception if necessary.
	// 2. Save a reference to the largest key which is in the last
	//    position in the array (index size-1).
	// 3. Put a null there to help GC.
	// 4. Adjust size and return the saved element reference.
	return null;			// TODO: REMOVE THIS LINE!
    }

    /**
     * Returns the object with the maximum priority, without removing it
     * from this queue.
     * 
     * @return the object with the maximum priority.
     * @exception EmptyQueueException if this queue is empty.
     */
    public Object getMax() {
        // TODO
	// 1. Check precondition and throw exception if necessary.
	// 2. Return the reference to the largest key which is in the last
	//    position in the array (index size-1).
	return null;			// TODO: REMOVE THIS LINE!
    }

    /**
     * Returns the index of this object within this queue, or -1
     * otherwise.
     * 
     * @param o the object to search for.
     * @return the index in the array, or <tt>-1</tt> otherwise.
     */
    private int indexOf(Object o) {
	// TODO
	// Since it's sorted, you MUST use binary search to find the
	// key. If not found, return -1.
	return -1;			// TODO: REMOVE THIS LINE!
    }

    /**
     * Returns true if the specific object exists in this queue.
     * 
     * @param o the object to search for.
     * @return <tt>true</tt> if the specified object exists in this queue,
     *         or <tt>false</tt> otherwise.
     */
    public boolean contains(Object o) {
	// TODO
	// Hint: re-use indexOf(). 
	return false;			// TODO: REMOVE THIS LINE!
    }

    /**
     * Removes the specified object, if it exists, from this queue.
     * 
     * @param o the object to remove.
     * @return <tt>true</tt> if the object was removed, or <tt>false</tt>
     *         otherwise.
     */
    public boolean remove(Object o) {
        // TODO
	// 1. First find it using indexOf(). If not found, return false.
	// 2. Shift all elements in the range [index+1,size-1] left by one
	//    position to fill the hole.
	// 3. Put null in the last position to help GC.
	// 3. Adjust size and return true.
	return false;			// TODO: REMOVE THIS LINE!
    }

    /**
     * Clears this queue of all elements.
     */
    public void clear() {
	// TODO
        // Null out all the elements to help GC, and then set the size to
        // 0. Leave the allocated array so that it can be used later
        // without having to create a new array.
    }

    /**
     * Returns an array representation of this queue, with the maximum
     * priority element as the first element and so on.
     * 
     * @return an array representation of this queue.
     */
    public Object[] toArray() {
	// TODO
	// Note that we want the highest priority element in the 0'th
	// position, so start from the end and iterate backwards.
	return null;			// TODO: REMOVE THIS LINE!
    }

    /**
     * A string representation of this queue, with the elements separated
     * by space and the list enclosed in "[ ]". The first element is the
     * maximum priority element.
     * 
     * @return a string representation of this queue.
     */
    public String toString() {
	// TODO
	// Note that we want the highest priority element in the 0'th
	// position, so start from the end and iterate backwards.
	return null;			// TODO: REMOVE THIS LINE!
    }

    /**
     * Tests this ArrayPriorityQueue class.
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        int[] data = { 13, 1, 19, 2, 5, 3, 17, -4, 7, 5 };

        ArrayPriorityQueue pq = new ArrayPriorityQueue();
        System.out.print("Adding to pq       :");
        for (int element : data) {
            System.out.print(" " + element);
            pq.add(new Integer(element));
        }
        System.out.println("");

        System.out.println("pq as string: " + pq);
        System.out.println("pa as array: "
                + java.util.Arrays.toString(pq.toArray()));

        System.out.print("Retrieving from pq:");
        for (int i = 0; i < data.length; i++) {
            int maxValue = (Integer) pq.getMax();
            int removedMaxValue = (Integer) pq.removeMax();
            assert maxValue == removedMaxValue;
            System.out.print(" " + maxValue);
        }
        System.out.println("");

        System.out.println("clearing out the pq");
        pq.clear();
        System.out.println("pq = " + pq);
    }
}
