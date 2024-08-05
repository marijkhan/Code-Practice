package org.practice.turing;

import java.util.Stack;

public class TuringPractice {
    public static void main(String[] args) {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        int result = calPoints(ops);
        System.out.println("The final score is: " + result);
    }

        public static int calPoints(String[] ops) {
            int result = 0;
            Stack<Integer> score = new Stack<Integer>();
            for (int i = 0; i < ops.length; i++) {
                String op = ops[i];
                if (isDigit(op)) {
                    score.push(Integer.valueOf(op));
                } else if (op.equals("C")) {
                    score.pop();
                } else if (op.equals("D")) {
                    score.push(2 * score.peek());
                } else if (op.equals("+")) {
                    int top = score.pop();
                    int newTop = top + score.peek();
                    score.push(top);
                    score.push(newTop);
                }
            }
            for (int i : score) {
                result += i;
            }
            return result;
        }

        private static boolean isDigit(String op) {
            try {
                Integer.parseInt(op);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

}
