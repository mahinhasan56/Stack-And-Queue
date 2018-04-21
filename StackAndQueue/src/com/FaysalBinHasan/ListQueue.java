package com.FaysalBinHasan;



public class ListQueue implements Queue {

    /**
     * The reference to the dummy head node (front of this queue is then
     * head.next).
     */
    private Node head;

    /** The reference to the tail node. */
    private Node tail;

    /** The number of items in this queue. */
    private int  size;

    /**
     * Creates an empty queue.
     */
    public ListQueue() {
        // Create the dummy head, and set size to 0.
        head = new Node(null, null);

        // Tail also refers to dummy head for the empty list.
        tail = head;
        size = 0;
    }

    /**
     * Returns the current size of this queue.
     * 
     * @return the number of items in this queue.
     */
    public int size() {
 // TODO
      return size;   // TODO: REMOVE THIS LINE!
    }

    /**
     * Tests if this queue is empty.
     * 
     * @return true if and only if this queue contains no items; false
     *         otherwise.
     */
    public boolean isEmpty() {
 // TODO
      if(size()==0){
        return true;   // TODO: REMOVE THIS LINE!
      }else{
        return false;
      }
    }

    /**
     * Puts an item at the end of this queue.
     * 
     * @param item the item to be put at the end of this queue.
     */
    public void enqueue(Object item) {
 // TODO
        // Since enqueue adds the new item at the end of the underlying
        // list, we use the tail node as the predecessor. After adding
 // a new node with the given item in it, update tail and size. 
      Node mn=new Node (item,null);
        if(head.next==null){
        head.next=mn;
        tail=mn;
        }
        else{
          tail.next=mn;
          tail=mn;
        }
        size++;
      }

    /**
     * Removes the item from the front of this queue and returns that item
     * as the value of this function.
     * 
     * @return The item in the front this queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    public Object dequeue() throws EmptyQueueException {
 // TODO
 // 1. Precondition: throw exception if queue is empty
 // 2. Save a reference to the front item (head.next.item)
 // 3. Remove the first real node (head.next) and detach it
 //    from the list
 // 4. SPECIAL CASE - if the size of the queue was 1, the tail
 //    referred to the node that was just removed, so tail must
 //    now be adjusted to refer to the dummy head
 // 5. Adjust size
 // 6. Return the item saved in step 2
      if(size()==0){
        throw new EmptyQueueException();
      }
      Object val=head.next.element;
      Node rm=head;
      head=head.next;
      if(size()==1){
        tail=head;
      }
      size--;
      rm.element=null;
      rm.next=null;
      rm=null;
      return val;
   // TODO: REMOVE THIS LINE!
    }

    /**
     * Looks at the item in the front of this queue without removing it
     * from the queue.
     * 
     * @return the item in the front of this queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    public Object peek() throws EmptyQueueException {
        if(size()==0){
        throw new EmptyQueueException();
      }
      Object temp=head.next.element;
      return temp;
 // TODO
   // TODO: REMOVE THIS LINE!
    }

    /**
     * Removes the given item from this queue.
     * 
     * @param item the item to remove from this queue.
     * @return the removed item if it exists, or null otherwise.
     */
    public Object remove(Object item) {
      Node rm=null;
      Node n=null;
      for(n=head.next;n.next!=null;n=n.next){
        if(n.next.element.equals(item))
        {
          rm=n.next;
          n.next=n.next.next;
        }
      }
      if(rm==null)
      {
        return null;
      }
      Object temp=rm.element;
      //GC
      rm.element=null;
      rm.next=null;
      rm=null;
      size--;
      return temp;
    }
        // TODO
 // First find a reference to the node containing the given item
 // by iterating over the items in the queue starting from the 
 // front (head.next). NOTE: this is a singly-linked list, so we
 // must also have the predecessor of the node in question to be
 // able to remove it. The easy way is to iterate using "lock-step"
 // method, keeping two references in lock-step.
 // If it doesn't exist, simply return null.
 // Otherwise, save a reference to the item within the node, and
 // then remove the node completely.
 // Adjust size and return the item that was removed.
  // TODO: REMOVE THIS LINE!


    /**
     * Clears this queue of all items.
     */
    public void clear() {
 // TODO
 // Easy method: set dummy head's next to null, making the list 
 // empty, and set size to 0.
 // Better, but harder method: remove all the nodes after the 
 // dummy head, setting each item within to be null, and then set 
 // the size to be 0.
 // I'll accept the easy way.
      head.next=null;
      size=0;
    }

    /**
     * Searches this stack to see if the specified item is in this queue,
     * and if so, how far it is from the front of queue (0 is the distance
     * if the item is at the front of this queue).
     * 
     * @param item the desired item.
     * @return distance from front of queue (0-based) if the item is in
     *         this queue, <code>-1</code> otherwise.
     */
    public int search(Object item) {
 // TODO
 // Start from the head.next, searching for the node containing the
 // item. Keep a counter to see how many steps you've taken. If
 // found, return the counter. If you've searched all items, and
 // it's not found, return -1.
     int k=0;
     for(Node n=head.next;n!=null;n=n.next)
     {
       if(n.element.equals(item)){
         return k;
       }// TODO: REMOVE THIS LINE!
        k++;
     }
     return -1;
    }

    /**
     * Returns a string representation of this stack, with the top of this
     * stack as the first item displayed. For example, if a stack contains
     * "A", "B", "C" and "D", with "A" being the top of the stack, the
     * returned String would contain "[ A B C D ]".
     * 
     * @return a string containing the items in this stack.
     */
    public String toString() {
      
 // TODO
      String st="[ ";
      for(Node n=head.next;n!=null;n=n.next)
      {
        st=st + n.element + " ";   // TODO: REMOVE THIS LINE!
      }
      return st + "]";
    }

    /**
     * Returns the items in this queue as an array, with the front of the
     * queue as the first item.
     * 
     * @return an array containing the items in this queue.
     */
    public Object[] toArray() {
 // TODO
      Object array[]=new Object[size];
      int i=0;
      for(Node n=head.next;n!=null;n=n.next){
        array[i]=n.element;
        i++;
      }
        return array; 
          // TODO: REMOVE THIS LINE!
    }

    /**
     * Checks if all the items of this queue are equal to the specified
     * one.
     * 
     * @param o the specified queue object.
     * @return <code>true</code> if all the items match, or
     *         <code>false</code> otherwise.
     */
    public boolean equals(Object o) {
        // First check if both refer to the same object.
        if (this == o)
            return true;
        // Then check to see if the specified object is null or not an
        // Queue at all.
        if (o == null || !(o instanceof Queue))
            return false;

        // Now that we know "o" is indeed a Queue, but we don't know what
        // is the underlying implementation, and hence cannot look at
        // internal data. We can of course use the toArray method to
        // extract the data, and then compare with equality.
        Queue otherQueue = (Queue) o;
        if (otherQueue.size() != size){
            return false;
    }else{
         Object arr[]=this.toArray();
         Object brr[]=otherQueue.toArray();
         for(int i=0;i<size;i++)
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
    }

 // TODO
 // Easiest is to simply get the elements of this queue in an
 // array (this.toArray()), and the elements of the "other"
 // queue in another array (otherQueue.toArray()), and then
 // compare element by element using the equals method.
  // TODO: REMOVE THIS LINE!

    /**
     * Represents a node in a singly-linked list.
     */
    private static class Node {
        /** The element within this node. */
        public Object element;
        /** Reference to the next node in the list. */
        public Node   next;

        /**
         * Constructs a new Node object with given item.
         * 
         * @param element the object inside the node.
         * @param next the reference to the next node in the list.
         */
        public Node(Object element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * Tests this ListQueue class.
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        ListQueue q = new ListQueue();
        q.enqueue(5);
        System.out.println("Queue = " + q.toString());
        q.enqueue(6);
        System.out.println("Queue = " + q.toString());
        q.enqueue(6);
        System.out.println("Queue = " + q.toString());
        Object[] a = q.toArray();
        for (int i = 0; i < a.length; i++)
            System.out.println("Queue array[" + i + "]  = " + a[i]);

        Object item = q.dequeue();
        System.out.println("dequeue = " + item);
        item = q.dequeue();
        System.out.println("dequeue = " + item);
        try {
            // queue is empty, so dequeue will throw exception.
            q.dequeue();
        } catch (EmptyQueueException e) {
            System.out.println("Exception caught: " + e.toString());
        }

        // make more space, and fill it up again.
        // q.ensureCapacity(3);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        System.out.println("Queue = " + q.toString());

        System.out.println("Q's size (expected 3) = " + q.size());
        System.out.println("Q's front (expected 6) = " + q.peek());
        q.dequeue();
        System.out.println("Q's front (expected 7) = " + q.peek());
        q.dequeue();
        System.out.println("Q's front (expected 8) = " + q.peek());

        // This part checks if removing all the items in the queue and
        // then adding back the item works.
        q.enqueue(new Integer(15));
        q.enqueue(new Integer(21));
        System.out.println("Q is now: " + q);
        // Save the queue in an array, and dequeue all to empty it out.
        a = q.toArray();
        while (!q.isEmpty())
            q.dequeue();

        System.out.println("Q is now (after dequeuing all): " + q);

        // and add the items back. Should have the same items again.
        for (Object e : a)
            q.enqueue(e);
        System.out.println("Q is now: " + q);
        // This part checks if clearing all the items in the queue and
        // then adding back the item works.
        q.enqueue(new Integer(15));
        q.enqueue(new Integer(21));
        System.out.println("Q is now: " + q);
        // Save the queue in an array, and dequeue all to empty it out.
        a = q.toArray();
        q.clear();

        System.out.println("Q is now (after clearing): " + q);

        // and add the items back. Should have the same items again.
        for (Object e : a)
            q.enqueue(e);
        System.out.println("Q is now: " + q);
    }
}
