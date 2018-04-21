package com.FaysalBinHasan;


public class ExprEvaluator {

  
    public static int evaluate(String expr) {
        ArrayStack exprStack = new ArrayStack();
        java.util.Scanner scanner = new java.util.Scanner(expr);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int operand = scanner.nextInt();
                exprStack.push(operand);
            } else {
                
                if (exprStack.size() < 2)
                    throw new IllegalArgumentException(
                            "bad arguments for +");

                // Pop the two operands from the stack, keeping in mind
                // the order they were pushed onto the stack.
                int op2 = (Integer) exprStack.pop();
                int op1 = (Integer) exprStack.pop();

                // Get the operator from the input.
                String operator = scanner.next();

		// TODO
		// Now operator contains either a legal operator -
		// "+", "-", "*" or "/" - or an illegal one. 
		// Pre-condition: all these operators are binary, so the 
		// operand stack must have AT LEAST 2 elements. If not,
		// throw an IllegalArgumentException. Otherwise, pop the
		// two top elements from the stack into two local variables
		// that will be the operands for this operator. Now check
		// which operator it is (e.g., operator.equals("+")), and
		// compute the result. Then push the result back onto the
		// stack. If the operator is not one of the allowed ones,
		// throw the exception listed above.
            }
        }

        // At this point, the expression is completely evaluated, and the
        // stack must contain ONLY the result, and nothing else;
        // otherwise, the expression is not well-formed.
        if (exprStack.size() != 1)
            throw new IllegalArgumentException(
                    "stack has remaining elements");

        return (Integer) exprStack.pop();
    }

    /**
     * Tests this ExprEvaluator class.
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        String[] exprList = { "5 3 +", "5 3 -", "6 3 /", "6 3 *",
                "3 8 * 2 +", "8 4 / 2 *", "5 1 2 + 4 * + 3 -", "8 4 + 2",
                "8 3 ^" };
        for (String expr : exprList) {
            try {
                System.out.println("evaluate(" + expr + ") = "

                + ExprEvaluator.evaluate(expr));
            } catch (IllegalArgumentException ex) {
                System.err
                        .println("Illegal expression: \"" + expr + "\"");
            }
        }
    }

}
