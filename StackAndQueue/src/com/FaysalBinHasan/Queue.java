package com.FaysalBinHasan;

public interface Queue {
    /**
     * Returns the current size of this queue.
     * 
     * @return the number of items in this queue.
     */
    int size();

    /**
     * Tests if this queue is empty.
     * 
     * @return true if and only if this queue contains no items; false
     *         otherwise.
     */
    boolean isEmpty();

    /**
     * Puts an item at the end of this queue.
     * 
     * @param item the item to be put at the end of this queue.
     * @exception EmptyQueueException if the queue is full, and the
     *                implementation does not automatically resize the
     *                underlying container to accommodate the new item.
     */
    void enqueue(Object item) throws EmptyQueueException;

    /**
     * Removes the item from the front of this queue and returns that item
     * as the value of this function.
     * 
     * @return The item in the front this queue.
     * @throws EmptyQueueException if this queue is empty.
     */
    Object dequeue() throws EmptyQueueException;

    /**
     * Looks at the item in the front of this queue without removing it
     * from this queue.
     * 
     * @return the item in the front of this queue.
     * @throws EmptyQueueException if this queue is empty.
     */
    Object peek() throws EmptyQueueException;

    /**
     * Removes the given item from this queue.
     * 
     * @param item the item to remove from this queue.
     * @return the removed item if it exists, or null otherwise.
     */
    Object remove(Object item);

    /**
     * Clears this queue of all elements.
     */
    void clear();

    /**
     * Searches this stack to see if the specified item is in this queue,
     * and if so, how far it is from the front of queue (0 is the distance
     * if the item is at the front of this queue).
     * 
     * @param item the desired item.
     * @return distance from front of queue (0-based) if the item is in
     *         this queue, <code>-1</code> otherwise.
     */
    int search(Object item);

    /**
     * Returns a string representation of this queue. The string
     * representation consists of a list of the queue's items in the order
     * they are in this queue (with front of this stack first), enclosed
     * in square brackets ("[]"). Adjacent elements are separated by " "
     * (space), and there is a space after the opening '[' and a space
     * before the closing ']'.
     * 
     * @return a string representation of this queue.
     */
    String toString();

    /**
     * Returns the items in this queue as an array, with the front of the
     * queue as the first element.
     * 
     * @return an array containing the items in this queue.
     */
    Object[] toArray();

    /**
     * Compares the specified object with this queue for equality.
     * 
     * @param o object to be compared for equality with this queue
     * @return <tt>true</tt> if the specified object is equal to this
     *         queue
     */
    boolean equals(Object o);

}
