package com.FaysalBinHasan;


import junit.framework.TestCase;


public class ListQueueTest extends TestCase {

    /**
     * Test method for {@link cse220.assign3.ListQueue#ListQueue()}.
     */
    public final void testListQueue() {
        @SuppressWarnings("unused")
        ListQueue queue = new ListQueue();

    }

    /**
     * Test method for {@link cse220.assign3.ListQueue#enqueue(Object)}.
     */
    public final void testEnqueue() {
        ListQueue queue = new ListQueue();
        for (int i = 0; i < 10; i++)
            queue.enqueue(new Integer(i));
        assertEquals(10, queue.size());
        assertEquals(new Integer(0), queue.peek());
    }

    /**
     * Test method for {@link cse220.assign3.ListQueue#dequeue()}.
     */
    public final void testDequeue() {
        ListQueue queue = new ListQueue();
        for (int i = 0; i < 10; i++)
            queue.enqueue(new Integer(i));
        for (int i = 0; i < 10; i++)
            assertEquals(new Integer(i), queue.dequeue());
        // Any additional dequeue now should throw a EmptyQueueException.
        try {
            queue.dequeue();
            fail("Should raise a EmptyQueueException");
        } catch (EmptyQueueException e) {
            // do nothing
        }
    }

    /**
     * Test method for {@link cse220.assign3.ListQueue#peek()}.
     */
    public final void testPeek() {
        ListQueue queue = new ListQueue();
        for (int i = 0; i < 10; i++)
            queue.enqueue(new Integer(i));
        for (int i = 0; i < 10; i++) {
            assertEquals(new Integer(i), queue.peek());
            assertEquals(new Integer(i), queue.dequeue());
        }
        // Now the queue is empty, so a peek should throw a
        // EmptyQueueException.
        try {
            queue.dequeue();
            fail("Should raise a EmptyQueueException");
        } catch (EmptyQueueException e) {
            // do nothing
        }
    }

    /**
     * Test method for {@link cse220.assign3.ListQueue#clear()}.
     */
    public final void testClear() {
        ListQueue queue = new ListQueue();
        queue.clear();
        assertEquals(0, queue.size());
        for (int i = 0; i < 10; i++)
            queue.enqueue(i);
        assertEquals(10, queue.size());
        queue.clear();
        assertEquals(0, queue.size());
        for (int i = 0; i < 10; i++)
            queue.enqueue(i);
        assertEquals(10, queue.size());
        queue.clear();
        assertEquals(0, queue.size());
    }

    /**
     * Test method for {@link cse220.assign3.ListQueue#remove(Object)}.
     */
    public final void testRemove() {
        ListQueue queue = new ListQueue();
        assertEquals(-1, queue.search(0));
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        assertEquals(10, queue.size());
        assertNull(queue.remove(1011));
        assertEquals(10, queue.size());

        assertNotNull(queue.remove(4));
        assertEquals(9, queue.size());
        assertEquals(-1, queue.search(4));
        assertEquals(4, queue.search(5));
    }

    /**
     * Test method for {@link cse220.assign3.ListQueue#isEmpty()}.
     */
    public final void testIsEmpty() {
        ListQueue queue = new ListQueue();
        assertTrue(queue.isEmpty());
        for (int i = 0; i < 10; i++) {
            queue.enqueue(new Integer(i));
            assertFalse(queue.isEmpty());
        }
        for (int i = 0; i < 10; i++) {
            assertFalse(queue.isEmpty());
            assertEquals(new Integer(i), queue.dequeue());
        }
        assertTrue(queue.isEmpty());
    }

    /**
     * Test method for {@link cse220.assign3.ListQueue#size()}.
     */
    public final void testSize() {
        ListQueue queue = new ListQueue();
        assertEquals(0, queue.size());
        for (int i = 0; i < 10; i++) {
            queue.enqueue(new Integer(i));
            assertEquals(i + 1, queue.size());
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(10 - i, queue.size());
            assertEquals(new Integer(i), queue.dequeue());
        }
        assertEquals(0, queue.size());
    }

    /**
     * Test method for {@link cse220.assign3.ListQueue#search(Object)}.
     */
    public final void testSearch() {
        ListQueue queue = new ListQueue();
        assertEquals(-1, queue.search(new Integer(0)));
        for (int i = 0; i < 10; i++) {
            queue.enqueue(new Integer(i));
            assertEquals(i, queue.search(new Integer(i)));
        }
        assertEquals(0, queue.search(new Integer(0)));
        assertEquals(9, queue.search(new Integer(9)));
        assertEquals(-1, queue.search(new Integer(10)));
    }

    /**
     * Test method for {@link cse220.assign3.ListQueue#toArray()}.
     */
    public final void testToArray() {
        ListQueue queue = new ListQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(new Integer(i));
        }
        Object[] a = queue.toArray();
        for (int i = 0; i < 10; i++) {
            assertEquals(new Integer(i), a[i]);
        }
    }

    /**
     * Test method for
     * {@link cse220.assign3.ListQueue#equals(java.lang.Object)}.
     */
    public final void testEqualsObject() {
        ListQueue queue = new ListQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(new Integer(i));
        }
        assertTrue(queue.equals(queue));
        assertFalse(queue.equals(null));

        ListQueue queue1 = new ListQueue();
        assertFalse(queue.equals(queue1));
        assertFalse(queue1.equals(queue));

        for (int i = 0; i < 10; i++) {
            queue1.enqueue(new Integer(i));
        }
        assertTrue(queue.equals(queue1));
        assertTrue(queue1.equals(queue));
    }

    /**
     * Test method for {@link cse220.assign3.ListQueue#toString()} .
     */
    public final void testToString() {
        ListQueue queue = new ListQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(new Integer(i));
        }
        String result = queue.toString();
        final String expected = "[ 0 1 2 3 4 5 6 7 8 9 ]";
        assertEquals(expected, result);
    }

}
