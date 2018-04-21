package com.FaysalBinHasan;

import junit.framework.TestCase;

/**
 * Test cases for {@link cse220.assign3.ArrayQueue}.
 */
public class ArrayQueueTest extends TestCase {

    /**
     * Test method for {@link cse220.assign3.ArrayQueue#ArrayQueue(int)}.
     */
    public final void testArrayQueueInt() {
        @SuppressWarnings("unused")
        ArrayQueue queue = new ArrayQueue(10);
    }

    /**
     * Test method for {@link cse220.assign3.ArrayQueue#ArrayQueue()}.
     */
    public final void testArrayQueue() {
        @SuppressWarnings("unused")
        ArrayQueue queue = new ArrayQueue();

    }

    /**
     * Test method for {@link cse220.assign3.ArrayQueue#enqueue(Object)}.
     */
    public final void testEnqueue() {
        ArrayQueue queue = new ArrayQueue(10);
        for (int i = 0; i < 10; i++)
            queue.enqueue(i);
        assertEquals(10, queue.size());
        assertEquals(0, queue.peek());

        // Test resize
        for (int i = 0; i < 10; i++)
            queue.enqueue(i);
        assertEquals(20, queue.size());
        assertEquals(0, queue.peek());
    }

    /**
     * Test method for {@link cse220.assign3.ArrayQueue#dequeue()} .
     */
    public final void testDequeue() {
        ArrayQueue queue = new ArrayQueue(10);
        for (int i = 0; i < 10; i++)
            queue.enqueue(i);
        for (int i = 0; i < 10; i++)
            assertEquals(i, queue.dequeue());
        // Any additional dequeue now should throw a EmptyQueueException.
        try {
            queue.dequeue();
            fail("Should raise a EmptyQueueException");
        } catch (EmptyQueueException e) {
            // do nothing
        }
    }

    /**
     * Test method for {@link cse220.assign3.ArrayQueue#peek()}.
     */
    public final void testPeek() {
        ArrayQueue queue = new ArrayQueue(10);
        for (int i = 0; i < 10; i++)
            queue.enqueue(i);
        for (int i = 0; i < 10; i++) {
            assertEquals(i, queue.peek());
            assertEquals(i, queue.dequeue());
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
     * Test method for {@link cse220.assign3.ArrayQueue#clear()}.
     */
    public final void testClear() {
        ArrayQueue queue = new ArrayQueue();
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
     * Test method for {@link cse220.assign3.ArrayQueue#isEmpty()} .
     */
    public final void testIsEmpty() {
        ArrayQueue queue = new ArrayQueue(10);
        assertTrue(queue.isEmpty());
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            assertFalse(queue.isEmpty());
        }
        for (int i = 0; i < 10; i++) {
            assertFalse(queue.isEmpty());
            assertEquals(i, queue.dequeue());
        }
        assertTrue(queue.isEmpty());
    }

    /**
     * Test method for {@link cse220.assign3.ArrayQueue#size()}.
     */
    public final void testSize() {
        ArrayQueue queue = new ArrayQueue(10);
        assertEquals(0, queue.size());
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            assertEquals(i + 1, queue.size());
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(10 - i, queue.size());
            assertEquals(i, queue.dequeue());
        }
        assertEquals(0, queue.size());
    }

    /**
     * Test method for {@link cse220.assign3.ArrayQueue#search(Object)}.
     */
    public final void testSearch() {
        ArrayQueue queue = new ArrayQueue(10);
        assertEquals(-1, queue.search(0));
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            assertEquals(i, queue.search(i));
        }
        assertEquals(0, queue.search(0));
        assertEquals(9, queue.search(9));
        assertEquals(-1, queue.search(10));
    }

    /**
     * Test method for {@link cse220.assign3.ArrayQueue#remove(Object)}.
     */
    public final void testRemove() {
        ArrayQueue queue = new ArrayQueue(10);
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
     * Test method for {@link cse220.assign3.ArrayQueue#toArray()} .
     */
    public final void testToArray() {
        ArrayQueue queue = new ArrayQueue(10);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        Object[] a = queue.toArray();
        for (int i = 0; i < 10; i++) {
            assertEquals(i, a[i]);
        }
    }

    /**
     * Test method for
     * {@link cse220.assign3.ArrayQueue#equals(java.lang.Object)}.
     */
    public final void testEqualsObject() {
        ArrayQueue queue = new ArrayQueue(10);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        assertTrue(queue.equals(queue));
        assertFalse(queue.equals(null));

        ArrayQueue queue1 = new ArrayQueue(10);
        assertFalse(queue.equals(queue1));
        assertFalse(queue1.equals(queue));

        for (int i = 0; i < 10; i++) {
            queue1.enqueue(i);
        }
        assertTrue(queue.equals(queue1));
        assertTrue(queue1.equals(queue));
    }

    /**
     * Test method for {@link cse220.assign3.ArrayQueue#toString()}.
     */
    public final void testToString() {
        ArrayQueue queue = new ArrayQueue(10);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        String strVersion = queue.toString();
        final String strVersion1 = "[ 0 1 2 3 4 5 6 7 8 9 ]";
        assertEquals(strVersion1, strVersion);
    }
}
