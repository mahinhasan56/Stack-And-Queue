package com.FaysalBinHasan;
import java.util.*;
import java.io.*;
import junit.framework.TestCase;

/**
 * Testcases for {@link cse220.assign3.ExprEvaluator} class.
 */
public class ExprEvaluatorTest extends TestCase {

    /**
     * Test method for
     * {@link cse220.assign3.ExprEvaluator#evaluate(java.lang.String)}.
     */
    public final void testEvaluate() {
        String[] exprList = { "5 3 +", "5 3 -", "6 3 /", "6 3 *",
                "3 8 * 2 +", "8 4 / 2 *", "5 1 2 + 4 * + 3 -" };
        int[] expected = { 8, 2, 2, 18, 26, 4, 14 };
        for (int i = 0; i < exprList.length; i++) {
            int result = 0;
            try {
                result = ExprEvaluator.evaluate(exprList[i]);
            } catch (IllegalArgumentException ex) {
                fail("unexpected IllegalArgumentException thrown");
            }
            assertEquals(expected[i], result);
        }

        String[] badExprList = { " 8 4 + 2", "8 3 ^" };
        for (String bad : badExprList) {
            try {
                @SuppressWarnings("unused")
                int result = ExprEvaluator.evaluate(bad);
                fail("expected IllegalArgumentException thrown");
            } catch (IllegalArgumentException ex) {
                ;
            } catch (Exception ex) {
                fail("unexpected exception thrown");
            }
        }
    }
}
