package com.FaysalBinHasan;

import java.util.*;
import java.io.*;
import junit.framework.TestCase;

/**
 * Testcases for {@link cse220.assign3.ListStack}.
 */
public class ListStackTest extends TestCase {

    /**
     * Test method for {@link cse220.assign3.ListStack#ListStack()}.
     */
    public final void testListStack() {
        @SuppressWarnings("unused")
        ListStack stack = new ListStack();
    }

    /**
     * Test method for {@link cse220.assign3.ListStack#push(Object)}.
     */
    public final void testPush() {
        ListStack stack = new ListStack();
        for (int i = 0; i < 10; i++)
            stack.push(new Integer(i));
        assertEquals(10, stack.size());
        assertEquals(new Integer(9), stack.peek());
    }

    /**
     * Test method for {@link cse220.assign3.ListStack#pop()}.
     */

    public final void testPop() {
        ListStack stack = new ListStack();
        for (int i = 0; i < 10; i++)
            stack.push(new Integer(i));
        for (int i = 9; i >= 0; i--)
            assertEquals(new Integer(i), stack.pop());
        // Any additional pop should throw an exception now
        try {
            stack.pop();
            fail("Should raise a java.util.EmptyStackException");
        } catch (java.util.EmptyStackException e) {
            // do nothing
        }
    }

    /**
     * Test method for {@link cse220.assign3.ListStack#peek()}.
     */
    public final void testPeek() {
        ListStack stack = new ListStack();
        for (int i = 0; i < 10; i++) {
            stack.push(new Integer(i));
            assertEquals(new Integer(i), stack.peek());
        }
        // clear the stack, and try to peek, which should throw a
        // java.util.EmptyStackException.
        while (!stack.isEmpty())
            stack.pop();
        try {
            stack.peek();
            fail("Should raise a java.util.EmptyStackException");
        } catch (java.util.EmptyStackException e) {
            // do nothing
        }
    }

    /**
     * Test method for {@link cse220.assign3.ListStack#clear()}.
     */
    public final void testClear() {
        ListStack stack = new ListStack();
        stack.clear();
        assertEquals(0, stack.size());
        for (int i = 0; i < 10; i++)
            stack.push(i);
        assertEquals(10, stack.size());
        stack.clear();
        assertEquals(0, stack.size());
        for (int i = 0; i < 10; i++)
            stack.push(i);
        assertEquals(10, stack.size());
        stack.clear();
        assertEquals(0, stack.size());
    }

    /**
     * Test method for {@link cse220.assign3.ListStack#isEmpty()}.
     */

    public final void testIsEmpty() {
        ListStack stack = new ListStack();
        assertTrue(stack.isEmpty());
        for (int i = 0; i < 10; i++) {
            stack.push(new Integer(i));
            assertFalse(stack.isEmpty());
        }
        assertFalse(stack.isEmpty());
        for (int i = 0; i < 10; i++) {
            assertFalse(stack.isEmpty());
            stack.pop();
        }
        assertTrue(stack.isEmpty());
    }

    /**
     * Test method for {@link cse220.assign3.ListStack#size()}.
     */
    public final void testSize() {
        ListStack stack = new ListStack();
        assertEquals(0, stack.size());
        for (int i = 0; i < 10; i++) {
            stack.push(new Integer(i));
            assertEquals(i + 1, stack.size());
        }
        assertFalse(stack.isEmpty());
        for (int i = 0; i < 10; i++) {
            assertEquals(10 - i, stack.size());
            stack.pop();
        }
        assertEquals(0, stack.size());
    }

    /**
     * Test method for {@link cse220.assign3.ListStack#search(Object)}.
     */
    public final void testSearch() {
        ListStack stack = new ListStack();
        assertEquals(-1, stack.search(new Integer(0)));
        for (int i = 0; i < 10; i++) {
            stack.push(new Integer(i));
            assertEquals(0, stack.search(new Integer(i)));
        }
        assertEquals(9, stack.search(new Integer(0)));
        assertEquals(0, stack.search(new Integer(9)));
        assertEquals(-1, stack.search(new Integer(10)));
    }

    /**
     * Test method for {@link cse220.assign3.ListStack#toArray()}.
     */
    public final void testToArray() {
        ListStack stack = new ListStack();
        for (int i = 0; i < 10; i++) {
            stack.push(new Integer(i));
        }
        Object[] a = stack.toArray();
        int j = 9;
        for (int i = 0; i < 10; i++, j--) {
            assertEquals(new Integer(j), a[i]);
        }
    }

    /**
     * Test method for
     * {@link cse220.assign3.ListStack#equals(java.lang.Object)}.
     */
    public final void testEqualsObject() {
        ListStack stack = new ListStack();
        for (int i = 0; i < 10; i++) {
            stack.push(new Integer(i));
        }
        assertTrue(stack.equals(stack));
        assertFalse(stack.equals(null));

        ListStack stack1 = new ListStack();
        assertFalse(stack.equals(stack1));
        assertFalse(stack1.equals(stack));

        for (int i = 0; i < 10; i++) {
            stack1.push(new Integer(i));
        }
        assertTrue(stack.equals(stack1));
        assertTrue(stack1.equals(stack));
    }

    /**
     * Test method for {@link cse220.assign3.ListStack#toString()}.
     */
    public final void testToString() {
        ListStack stack = new ListStack();
        for (int i = 0; i < 10; i++) {
            stack.push(new Integer(i));
        }
        String result = stack.toString();
        final String expected = "[ 9 8 7 6 5 4 3 2 1 0 ]";
        assertEquals(expected, result);
    }
}
