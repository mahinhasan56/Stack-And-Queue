package com.FaysalBinHasan;


public interface PriorityQueue {

    /**
     * Returns the number of elements in this queue.
     * 
     * @return the number of elements in this queue.
     */
    int size();

    /**
     * Returns true if this queue is empty.
     * 
     * @return <tt>true</tt> if this queue is empty, or <tt>false</tt>
     *         otherwise.
     */
    boolean isEmpty();

    /**
     * Adds the specified object to this priority queue.
     * 
     * @param o the object to add.
     */
    void add(Object o);

    /**
     * Gets the object with the maximum priority, and removes it from this
     * queue.
     * 
     * @return the object with the maximum priority.
     * @exception EmptyQueueException if this queue is empty.
     */
    Object removeMax();

    /**
     * Returns the object with the maximum priority, without removing it
     * from this queue.
     * 
     * @return the object with the maximum priority.
     * @exception EmptyQueueException if this queue is empty.
     */
    Object getMax();

    /**
     * Returns true if the specific object exists in this queue.
     * 
     * @param o the object to search for.
     * @return <tt>true</tt> if the specified object exists in this queue,
     *         or <tt>false</tt> otherwise.
     */
    boolean contains(Object o);

    /**
     * Removes the specified object, if it exists, from this queue.
     * 
     * @param o the object to remove.
     * @return <tt>true</tt> if the object was removed, or <tt>false</tt>
     *         otherwise.
     */
    boolean remove(Object o);

    /**
     * Clears this queue of all elements.
     */
    void clear();

    /**
     * Returns an array representation of this queue, with the maximum
     * priority element as the first element and so on.
     * 
     * @return an array representation of this queue.
     */
    Object[] toArray();

    /**
     * A string representation of this queue, with the elements separated
     * by space and the list enclosed in "[ ]". The first element is the
     * maximum priority element.
     * 
     * @return a string representation of this queue.
     */
    String toString();
}
