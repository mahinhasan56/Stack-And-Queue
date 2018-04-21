package com.FaysalBinHasan;


public class ListStack implements Stack {

    /**
     * The reference to the dummy head node, the node after which is the
     * top of this stack.
     */
    private Node head;

    /** The number of items on this stack. */
    private int  size;

    /**
     * Creates an empty stack.
     */
    public ListStack() {
        // Create the dummy header and set size to 0.
        head = new Node(null, null);
        size = 0;
    }

    /**
     * Returns the current size of this stack.
     * 
     * @return the number of items on this stack
     */
    public int size() {
      int i=-1;
 // TODO
      for(Node n=head;n!=null;n=n.next)
      {
        i++;
      }
      return i;
// TODO: REMOVE THIS LINE!
    }

    /**
     * Tests if this stack is empty.
     * 
     * @return true if and only if this stack contains no items; false
     *         otherwise.
     */
    public boolean isEmpty() {
 // TODO
      if(size()==0)
      {
        return true;   // TODO: REMOVE THIS LINE!
      }else{
        return false;
      }
    }

    /**
     * Pushes an item onto the head of this stack.
     * 
     * @param item the item to be pushed onto this stack
     */
    public void push(Object item) {
        // TODO
 // 1. First create a node to put the item in.
 // 2. Add this node after the dummy head. Link the next node
 //    properly!
 // 3. Increment size.
      Node old=new Node(item,null);
      old.next=head;
      head=old;
    }

    /**
     * Removes the item at the head of this stack and returns that item as
     * the value of this function.
     * 
     * @return The item at the head of this stack
     * @throws java.util.EmptyStackException if this stack is empty
     */
    public Object pop() throws java.util.EmptyStackException {
        // TODO
 // 1. First check to see if the stack is non-empty, or else
 //    throw exception.
 // 2. Save a reference to the top of the stack node (the one after
 //    the dummy head), and save a reference to the element within it.
 // 3. Remove the node after the dummy head, and detach it.
 // 4. Decrement size.
 // 5. Help GC by null'ing out the saved node's element and next.
 // 6. Return the saved element in step 2.
      if(isEmpty()){
        throw  new java.util.EmptyStackException(); 
      }
         // TODO: REMOVE THIS LINE!
      Node old=head;
      Object val=old.element;
      head=head.next;
      old.element=null;
      old.next=null;
      return val;
    }

    /**
     * Looks at the item at the head of this stack without removing it
     * from this stack.
     * 
     * @return the item at the head of this stack
     * @throws java.util.EmptyStackException if this stack is empty
     */
    public Object peek() throws java.util.EmptyStackException {
        // TODO
 // 1. First check to see if the stack is non-empty, or else
 //    throw exception.
 // 2. Return a reference to the element within the top of the 
 //    stack node (the one after the dummy head).
       if(isEmpty())
       {
        throw  new java.util.EmptyStackException(); 
       }
         Object temp=head.element;
         return temp;
        // TODO: REMOVE THIS LINE!
    }

    /**
     * Clears this stack of all item.
     */
    public void clear() {
        // TODO
 // The "easy way" is to set head.next to null essentially making 
 // it an empty dummy-head-referenced linear list.
 // The "better way" is to remove each node from the list first (this
 // helps the GC). I'll accept the easy way.
 // Make sure you set the size to 0.
      head.next=null;
      size=0;
    }

    /**
     * Searches this stack to see if the specified item is on this stack,
     * and if so, how far it is from the head of stack (0 is the distance
     * if the item is on head of stack).
     * 
     * @param item the desired item
     * @return distance from head of stack (0-based) if the item is on
     *         this stack, <code>-1</code> otherwise
     */
    public int search(Object item) {
 // TODO
 // Since the top of the stack is after the dummy head of the list, 
 // we count the offset from the beginning. Start from head.next, 
 // and then advance until you find the element (if it exists), 
 // keeping a counter to count the offset from head. If found, 
 // return right away. If not found, then return -1.
      if(head!=null)
      {
      int idx=0;
      for(Node n=head;n.next!=null;n=n.next)
      {
        if(n.element.equals(item))
        {
           return idx;
        }
        idx++;
      }
      
      }
        return -1;    // TODO: REMOVE THIS LINE!
    }

    /**
     * Returns a string representation of this stack, with the head of
     * this stack as the first element displayed. For example, if a stack
     * contains "A", "B", "C" and "D", with "A" being the top of the
     * stack, the returned String would contain "[ A B C D ]".
     * 
     * @return a string containing the items in this stack
     */
    public String toString() {
 // TODO
      String st="[ ";
      for(Node n=head;n.next!=null;n=n.next){
        st=st + n.element + " ";
      }
      return st + "]";
        // TODO: REMOVE THIS LINE!
    }

    /**
     * Returns the items on this stack as an array, with the head of the
     * stack as the first element.
     * 
     * @return an array containing the items in this stack
     */
    public Object[] toArray() {
      
 // TODO
      Object array[]=new Object[25];
      int i=0;
      for(Node n=head;n!=null;n=n.next){
        array[i]=n.element;
        i++;
      }
        return array;    // TODO: REMOVE THIS LINE!
    }

    /**
     * Checks if all the items of this stack are equal to the specified
     * one.
     * 
     * @param o the specified stack object
     * @return <code>true</code> if all the items match, or
     *         <code>false</code> otherwise
     */
    public boolean equals(Object o) {
        // First check if both refer to the same object.
        if (this == o)
            return true;
        // Then check to see if the specified object is null or not an
        // Stack at all.
        if (o == null || !(o instanceof Stack))
            return false;

        // Now that we know "o" is indeed a Stack, we can cast it to one
        // before we can call the methods of the Stack interface to look
        // at the stack data.
        Stack otherStack = (Stack) o;
        if (otherStack.size() != size()){
         return false;
    }else{
         Object arr[]=this.toArray();
         Object brr[]=otherStack.toArray();
         for(int i=0;i<size();i++)
         {
           if(arr[i].equals(brr[i]))
           {
             if(i==size()-1){
               return true;
             }
           }else{
             return false;
           }
         }
        }
        return false;

 // TODO
 // Now that we know both stacks are of the same size (same number
 // of items), we have to check items by items to see if
 // there is mismatch or not. Since we don't know how the other 
 // stack is implemented (note that we're using the Stack interface,
 // not a ListStack in the cast statement above), the easiest is 
 // to use the toArray methods of both this and the other stack, 
 // and compare the arrays element by element using the equals 
 // method.
   // TODO: REMOVE THIS LINE!
    }

    /**
     * Represents a node in a singly linked list.
     */
    private static class Node {
        /** The element within this node. */
        public Object element;
        /** Reference to the next node in the list. */
        public Node   next;

        /**
         * Constructs a new Node object with given element.
         * 
         * @param element the object inside the node
         * @param next the reference to the next node in the list
         */
        public Node(Object element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * Tests this ListStack class.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ListStack stack = new ListStack();
        for (int i = 0; i < data.length; i++) {
            System.out.println("push " + (i + 1) + ": " + data[i]);
            stack.push(new Integer(data[i]));
        }
        System.out.println("Stack = " + stack.toString());
        while (!stack.isEmpty()) {
            System.out.println("pop: " + stack.pop());
        }
        // this causes an exception.
        try {
            stack.pop();
        } catch (java.util.EmptyStackException e) {
            System.out
                    .println("java.util.EmptyStackException caught and ignored: "
                            + e);
        }

        // test resize
        for (int i = 0; i < data.length; i++) {
            System.out.println("push " + (i + 1) + ": " + data[i]);
            stack.push(new Integer(data[i]));
        }
        for (int i = 0; i < data.length; i++) {
            System.out.println("push " + (i + 1) + ": " + data[i]);
            stack.push(new Integer(data[i]));
        }
        while (!stack.isEmpty()) {
            System.out.println("pop: " + stack.pop());
        }

        // this causes an exception.
        try {
            stack.pop();
        } catch (java.util.EmptyStackException e) {
            System.out
                    .println("java.util.EmptyStackException caught and ignored: "
                            + e);
        }

        // this causes an exception.
        try {
            stack.peek();
        } catch (java.util.EmptyStackException e) {
            System.out
                    .println("java.util.EmptyStackException caught and ignored: "
                            + e);
        }
    }
}
