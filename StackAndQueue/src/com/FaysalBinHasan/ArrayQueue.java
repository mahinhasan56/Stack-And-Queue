package com.FaysalBinHasan;


public class ArrayQueue implements Queue {

    /** The default initial capacity of a newly created queue. */
    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    /** The underlying array container. */
    private Object[]         data;

    /** The index of the first item in the queue. */
    private int front;
    
    /** The number of items in the queue. */
    private int size;

    /**
     * Creates an empty queue of specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the container.
     */
    public ArrayQueue(int initialCapacity) {
 // TODO
 // 1. Allocate data.
 // 2. Set front and size to be 0.
    this.front = 0;
    this.size=0;
    data =   new Object[initialCapacity];
    }

    /**
     * Creates an empty queue of default initial capacity.
     */
    public ArrayQueue() {
 // TODO
    data =   new Object[this.DEFAULT_INITIAL_CAPACITY];
    }

    /**
     * Returns the current size of the queue.
     * 
     * @return the number of items in the queue.
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
      if(data[front]== null)
        return true;   // TODO: REMOVE THIS LINE!
     return false;
    }

    /**
     * Puts an item at the end of this queue.
     * 
     * @param item the item to be put at the end of this queue.
     */
    public void enqueue(Object item) {
 // TODO
//  1. Check capacity and double the capacity if full
//  2. Find the index of the next available position, and put 
//     the item in that slot. See NOTE at the beginning of this
//     file for details on how to find the next available position.
//  3. Increment size
      if(size==data.length){
         Object[]tempArray=new Object[data.length*2];
         for(int i=0;i<data.length;i++)
         {
            tempArray[i]=data[i];
         }
         data=tempArray;
       }
      data[(front +size)%data.length]=item;
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
      if(size<=0){
       throw new EmptyQueueException();
      }
      Object array=data[front];
      data[front]=null;
      size--;
      front =(front+1)%data.length;
      return array;
        // TODO
 // 1. Pre-condition: The queue must not be empty, or else throw
 //    appropriate exception.
 // 2. Save a reference to the front of the queue. 
 //    - NO SHIFT REQUIRED.
 // 3. Set the element at front index to null (optional, to help GC).
 // 4. Increment front, wrapping if necessary.
 // 5. Decrement size.
 // 6. Return saved reference.
      
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
      if(size<=0)
      {
        throw new EmptyQueueException();
      }
 // TODO
 // 1. Check if empty, and throw exception if so
 // 2. Return the reference to the item in the front
        return data[front];   // TODO: REMOVE THIS LINE!
    }

    /**
     * Searches this stack to see if the specified item is in this queue,
     * and if so, how far it is from the front of queue (0 is the distance
     * if the item is at the front of this queue). Note that this is not
     * the same as indexOf() that we've used in other data structures -
     * indexOf returns the index of the array item that contains an item,
     * and search returns the distance (or offset) of an item from the
     * front of the queue.
     * 
     * @param item the desired item.
     * @return distance from front of queue (0-based) if the item is in
     *         this queue, <code>-1</code> otherwise.
     */
    public int search(Object item) {
      int i=front; 
      for(int j=0;j<size;j++)
      {
        if(item.equals(data[i]))
        {
          return j;
        }
        i=(i+1)%data.length;
      }
      return -1;
 // TODO
 // 1. Use two different variables - one starts at front and 
 //    advances through the cyclic array, and the other starts 
 //    at 0 and goes to size-1 in increments of 1
 // 2. Iterate and see if you find the item
 // 3. If so, return the offset from the front (the second
 //    variable!)
 // 4. Return -1 if not found
           // TODO: REMOVE THIS LINE!
    }

    /**
     * Removes the given item from this queue.
     * 
     * @param item the item to remove from this queue.
     * @return the removed item if it exists, or null otherwise.
     */
    public Object remove(Object item) {
        // TODO
      int k=search(item);
      if(k==-1){
      return null;
      }
      Object array=data[k];
      int j = size-k-1;
      int to=(front+k)%data.length;
      int from=(to+1)%data.length;
      for(int i=0;i<j;i++)
      {
        data[to] = data[from];
        to=from;
        from=(from+1)%data.length;
      }
      data[(front+size-1)%data.length]=null;
      size--;
      return array;
 // 1. Find the offset of the given item in this queue if exists
 // 2. If not, return null
 // 3. If it exists, shift all subsequent items to the left by
 //    one position to fill the hole
 // 4. Put a null in the last (now unused) slot
 // 5. Decrement size and return the specified item
          // TODO: REMOVE THIS LINE!
    }

    /**
     * Clears this queue of all items.
     */
    public void clear() {
 // TODO
        // Set all the existing items to null and then set the size to
        // be 0.
        for(int i=0;i<size;i++)
        {
          if(data[i]!=null)
          {
            data[i]=null;
          }
        }
        size=0;
    }

    /**
     * Returns the items in this queue as an array, with the front of the
     * queue as the first item.
     * 
     * @return an array containing the items in this queue.
     */
    public Object[] toArray() {
      Object[] array=new Object[size];
      int j=front;
      for(int i=0;i<size;i++)
      {
        array[i]=data[j];
        j=(j+1)%data.length;
      }
    return array;
    }
 // TODO
 // 1. Create an array of "size" capacity.
 // 2. Iterate over the elements of this queue, copy each
 //    element to the array. Use two indices to make life easy:
 //    one to iterate over the elements (starting from front),
 //    and the other starting at 0.
 // 3. Return the array.
           // TODO: REMOVE THIS LINE!
 

    /**
     * Returns a string representation of this queue, with the top of this
     * queue as the first item displayed.
     * 
     * @return a string containing the items in this queue.
     */
    public String toString() {
 // TODO  
      String st="[";
      int j=front;
      for(int i=0;i<size;i++){
        st=st+" "+data[j];
        j=(j+1)%data.length;
      }
      return st + " ]";
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
        if (otherQueue.size() != size)
        {
            return false;
        }else{
          Object arr[]=this.toArray();
          Object brr[]=otherQueue.toArray();
         for(int i=0;i<size;i++)
         {
           if(arr[i].equals(brr[i]))
           {
             if(i==size()-1)
             {
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
     * Tests this ArrayQueue class.
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(1);
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
