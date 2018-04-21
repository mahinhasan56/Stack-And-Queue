package com.FaysalBinHasan;


public class ArrayStackTest extends TestCase {

    /**
     * Test method for {@link cse220.assign3.ArrayStack#ArrayStack(int)}.
     */
    public final void testArrayStackInt() {
        @SuppressWarnings("unused")
        ArrayStack stack = new ArrayStack(10);
    }

    /**
     * Test method for {@link cse220.assign3.ArrayStack#ArrayStack()}.
     */
    public final void testArrayStack() {
        @SuppressWarnings("unused")
        ArrayStack stack = new ArrayStack();
    }

    /**
     * Test method for {@link cse220.assign3.ArrayStack#push(Object)}.
     */
    public final void testPush() {
        ArrayStack stack = new ArrayStack(10);
        for (int i = 0; i < 10; i++)
            stack.push(i);
        assertEquals(10, stack.size());
        assertEquals(9, stack.peek());
        // Now rest resize
        for (int i = 10; i < 20; i++)
            stack.push(i);
        assertEquals(20, stack.size());
        assertEquals(19, stack.peek());
    }

    /**
     * Test method for {@link cse220.assign3.ArrayStack#pop()}.
     */
    public final void testPop() {
        ArrayStack stack = new ArrayStack(10);
        for (int i = 0; i < 10; i++)
            stack.push(i);
        for (int i = 9; i >= 0; i--)
            assertEquals(i, stack.pop());
        // Any additional pop should throw an exception now
        try {
            stack.pop();
            fail("Should raise a java.util.EmptyStackException");
        } catch (java.util.EmptyStackException e) {
            // do nothing
        }
    }

    /**
     * Test method for {@link cse220.assign3.ArrayStack#peek()}.
     */
    public final void testPeek() {
        ArrayStack stack = new ArrayStack(10);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            assertEquals(i, stack.peek());
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
     * Test method for {@link cse220.assign3.ArrayStack#clear()}.
     */
    public final void testClear() {
        ArrayStack stack = new ArrayStack();
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
     * Test method for {@link cse220.assign3.ArrayStack#isEmpty()} .
     */

    public final void testIsEmpty() {
        ArrayStack stack = new ArrayStack(10);
        assertTrue(stack.isEmpty());
        for (int i = 0; i < 10; i++) {
            stack.push(i);
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
     * Test method for {@link cse220.assign3.ArrayStack#size()}.
     */
    public final void testSize() {
        ArrayStack stack = new ArrayStack(10);
        assertEquals(0, stack.size());
        for (int i = 0; i < 10; i++) {
            stack.push(i);
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
     * Test method for {@link cse220.assign3.ArrayStack#search(Object)}.
     */
    public final void testSearch() {
        ArrayStack stack = new ArrayStack(10);
        assertEquals(-1, stack.search(0));
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            assertEquals(0, stack.search(i));
        }
        assertEquals(9, stack.search(0));
        assertEquals(0, stack.search(9));
        assertEquals(-1, stack.search(10));
    }

    /**
     * Test method for {@link cse220.assign3.ArrayStack#toArray()} .
     */
    public final void testToArray() {
        ArrayStack stack = new ArrayStack(10);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        Object[] a = stack.toArray();
        int j = 9;
        for (int i = 0; i < 10; i++, j--) {
            assertEquals(j, ((Integer) a[i]).intValue());
        }
    }

    /**
     * Test method for
     * {@link cse220.assign3.ArrayStack#equals(java.lang.Object)}.
     */
    public final void testEqualsObject() {
        ArrayStack stack = new ArrayStack(10);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        assertTrue(stack.equals(stack));
        assertFalse(stack.equals(null));

        ArrayStack stack1 = new ArrayStack(10);
        assertFalse(stack.equals(stack1));
        assertFalse(stack1.equals(stack));

        for (int i = 0; i < 10; i++) {
            stack1.push(i);
        }
        assertTrue(stack.equals(stack1));
        assertTrue(stack1.equals(stack));
    }

    /**
     * Test method for {@link cse220.assign3.ArrayStack#toString()}.
     */
    public final void testToString() {
        ArrayStack stack = new ArrayStack(10);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        String strVersion = stack.toString();
        final String strVersion1 = "[ 9 8 7 6 5 4 3 2 1 0 ]";
        assertEquals(strVersion1, strVersion);
    }
}
