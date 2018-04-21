package com.FaysalBinHasan;
import java.util.*;
import java.io.*;

import junit.framework.TestCase;

/**
 * Testcases for {@link cse220.assign3.ArrayPriorityQueue} class.
 */
public class ArrayPriorityQueueTest extends TestCase {

    /**
     * Test method for
     * {@link cse220.assign3.ArrayPriorityQueue#ArrayPriorityQueue(int)}.
     */
    public final void testArrayPriorityQueueInt() {
        ArrayPriorityQueue pq = new ArrayPriorityQueue(100);
        assertNotNull(pq);
        assertEquals(0, pq.size());
        assertTrue(pq.isEmpty());
    }

    /**
     * Test method for
     * {@link cse220.assign3.ArrayPriorityQueue#ArrayPriorityQueue()}.
     */
    public final void testArrayPriorityQueue() {
        ArrayPriorityQueue pq = new ArrayPriorityQueue();
        assertNotNull(pq);
        assertEquals(0, pq.size());
        assertTrue(pq.isEmpty());
    }

    /**
     * Test method for {@link cse220.assign3.ArrayPriorityQueue#size()}.
     */
    public final void testSize() {
        Integer[] elements = { 13, 1, 19, 2, 5, 3 };
        ArrayPriorityQueue pq = new ArrayPriorityQueue();
        assertEquals(0, pq.size());
        for (int i = 0; i < elements.length; i++) {
            pq.add(elements[i]);
            assertEquals(i + 1, pq.size());
        }
    }

    /**
     * Test method for {@link cse220.assign3.ArrayPriorityQueue#isEmpty()}.
     */
    public final void testIsEmpty() {
        Integer[] elements = { 13, 1, 19, 2, 5, 3 };
        ArrayPriorityQueue pq = new ArrayPriorityQueue();
        assertTrue(pq.isEmpty());
        for (int i = 0; i < elements.length; i++) {
            pq.add(elements[i]);
            assertFalse(pq.isEmpty());
        }
    }

    /**
     * Test method for
     * {@link cse220.assign3.ArrayPriorityQueue#add(java.lang.Object)}.
     */
    public final void testAdd() {
        Integer[] elements = { 13, 1, 19, 2, 5, 3 };

        ArrayPriorityQueue pq = new ArrayPriorityQueue(elements.length);
        for (int i = 0; i < elements.length; i++) {
            pq.add(elements[i]);
            assertEquals(i + 1, pq.size());
        }
        assertFalse(pq.isEmpty());

        // Test resizing.
        try {
            pq.add(new Integer(100));
            pq.add(new Integer(32));
            assertEquals(new Integer(100), (Integer) pq.getMax());
        } catch (Exception ex) {
            fail("Resize not working");
        }
    }

    /**
     * Test method for {@link cse220.assign3.ArrayPriorityQueue#removeMax()}
     * .
     */
    public final void testRemoveMax() {
        Integer[] elements = { 13, 1, 19, 2, 5, 3 };
        Integer[] sorted = { 19, 13, 5, 3, 2, 1 };

        ArrayPriorityQueue pq = new ArrayPriorityQueue(elements.length);
        for (int i = 0; i < elements.length; i++) {
            pq.add(elements[i]);
            assertEquals(i + 1, pq.size());
        }
        assertFalse(pq.isEmpty());

        for (int i = 0; i < elements.length; i++) {
            Object o = pq.removeMax();
            assertEquals(sorted[i], o);
            assertEquals(elements.length - i - 1, pq.size());
        }

        assertEquals(0, pq.size());
        assertTrue(pq.isEmpty());

        // Test exception.
        try {
            pq.removeMax();
            fail("Failed to throw EmptyQueueException");
        } catch (EmptyQueueException ex) {
            ;
        } catch (Exception ex) {
            fail("Wrong type of exception thrown");
        }
    }

    /**
     * Test method for {@link cse220.assign3.ArrayPriorityQueue#getMax()}.
     */
    public final void testGetMax() {
        Integer[] elements = { 13, 1, 19, 2, 5, 3 };
        Integer[] sorted = { 19, 13, 5, 3, 2, 1 };

        ArrayPriorityQueue pq = new ArrayPriorityQueue(elements.length);
        for (int i = 0; i < elements.length; i++) {
            pq.add(elements[i]);
            assertEquals(i + 1, pq.size());
        }
        assertFalse(pq.isEmpty());

        assertEquals(pq.getMax(), sorted[0]);

        while (!pq.isEmpty())
            pq.removeMax();

        // Test exception.
        try {
            pq.getMax();
            fail("Failed to throw EmptyQueueException");
        } catch (EmptyQueueException ex) {
            ;
        } catch (Exception ex) {
            fail("Wrong type of exception thrown");
        }
    }

    /**
     * Test method for
     * {@link cse220.assign3.ArrayPriorityQueue#contains(java.lang.Object)}.
     */
    public final void testContains() {
        Integer[] elements = { 13, 1, 19, 2, 5, 3 };

        ArrayPriorityQueue pq = new ArrayPriorityQueue(elements.length);

        for (int i = 0; i < elements.length; i++) {
            assertFalse(pq.contains(elements[i]));
        }

        for (int i = 0; i < elements.length; i++) {
            pq.add(elements[i]);
            assertTrue(pq.contains(elements[i]));
        }

        while (!pq.isEmpty()) {
            Object removed = pq.removeMax();
            assertFalse(pq.contains(removed));
        }
    }

    /**
     * Test method for
     * {@link cse220.assign3.ArrayPriorityQueue#remove(java.lang.Object)}.
     */
    public final void testRemove() {
        Integer[] elements = { 13, 1, 19, 2, 5, 3 };

        ArrayPriorityQueue pq = new ArrayPriorityQueue(elements.length);

        for (int i = 0; i < elements.length; i++) {
            assertFalse(pq.contains(elements[i]));
        }

        for (int i = 0; i < elements.length; i++) {
            pq.add(elements[i]);
            assertTrue(pq.contains(elements[i]));
        }

        while (!pq.isEmpty()) {
            Object removed = pq.removeMax();
            assertFalse(pq.contains(removed));
        }
    }

    /**
     * Test method for {@link cse220.assign3.ArrayPriorityQueue#clear()}.
     */
    public final void testClear() {
        Integer[] elements = { 13, 1, 19, 2, 5, 3 };

        ArrayPriorityQueue pq = new ArrayPriorityQueue(elements.length);

        pq.clear();
        assertEquals(0, pq.size());

        for (int i = 0; i < elements.length; i++) {
            pq.add(elements[i]);
        }

        pq.clear();
        assertEquals(0, pq.size());
        for (int i = 0; i < elements.length; i++) {
            assertFalse(pq.contains(elements[i]));
        }
    }

    /**
     * Test method for {@link cse220.assign3.ArrayPriorityQueue#toArray()}.
     */
    public final void testToArray() {
        Integer[] elements = { 13, 1, 19, 2, 5, 3 };

        ArrayPriorityQueue pq = new ArrayPriorityQueue(elements.length);

        Object[] result = pq.toArray();
        assertEquals(0, result.length);

        for (int i = 0; i < elements.length; i++) {
            pq.add(elements[i]);
        }
        
        result = pq.toArray();
        Object[] expected = { 19, 13, 5, 3, 2, 1 };
        assertTrue(java.util.Arrays.equals(expected, result));
    }

    /**
     * Test method for {@link cse220.assign3.ArrayPriorityQueue#toString()}.
     */
    public final void testToString() {
        Integer[] elements = { 13, 1, 19, 2, 5, 3 };

        ArrayPriorityQueue pq = new ArrayPriorityQueue(elements.length);

        assertEquals("[ ]", pq.toString());

        for (int i = 0; i < elements.length; i++) {
            pq.add(elements[i]);
        }
        
        String result = pq.toString();
        String expected = "[ 19 13 5 3 2 1 ]";
        assertEquals(expected, result);
    }

}
