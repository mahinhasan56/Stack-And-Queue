package com.FaysalBinHasan;


public interface Stack {
    /**
     * Returns the current size of the stack.
     * 
     * @return the number of items on the stack.
     */
    int size();

    /**
     * Tests if this stack is empty.
     * 
     * @return true if and only if this stack contains no items; false
     *         otherwise.
     */
    boolean isEmpty();

    /**
     * Pushes an item onto the top of this stack.
     * 
     * @param item the item to be pushed onto this stack.
     */
    void push(Object item);

    /**
     * Removes the item at the top of this stack and returns that item as
     * the value of this function.
     * 
     * @return The item at the top of this stack.
     * @throws java.util.EmptyStackException if the stack is empty.
     */
    Object pop() throws java.util.EmptyStackException;

    /**
     * Looks at the item at the top of this stack without removing it from
     * the stack.
     * 
     * @return the item at the top of this stack.
     * @throws java.util.EmptyStackException if the stack is empty.
     */
    Object peek() throws java.util.EmptyStackException;

    /**
     * Clears this stack of all elements.
     */
    void clear();

    /**
     * Searches this stack to see if the specified item is on this stack,
     * and if so, how far it is from the top of stack (0 is the distance
     * if the item is on top of stack).
     * 
     * @param item the desired item.
     * @return distance from top of stack (0-based) if the item is on this
     *         stack, <code>-1</code> otherwise.
     */
    int search(Object item);

    /**
     * Returns a string representation of this stack. The string
     * representation consists of a list of the stack's items in the order
     * they are in this stack (with top of the stack first), enclosed in
     * square brackets ("[]"). Adjacent elements are separated by " "
     * (space), and there is a space after the opening '[' and a space
     * before the closing ']'.
     * 
     * @return a string representation of this stack.
     */
    String toString();

    /**
     * Returns the items on this stack as an array, with the top of the
     * stack as the first element.
     * 
     * @return an array containing the items in this stack.
     */
    Object[] toArray();

    /**
     * Compares the specified object with this stack for equality.
     * 
     * @param o object to be compared for equality with this stack
     * @return <tt>true</tt> if the specified object is equal to this
     *         stack
     */
    boolean equals(Object o);
}
