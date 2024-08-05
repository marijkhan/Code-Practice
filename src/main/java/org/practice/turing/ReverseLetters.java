package org.practice.turing;

import java.util.List;

public class ReverseLetters {
/*
Given a string S, return the "reversed" string where all characters that are not letters stay in the same place, and all letters reverse their positions.

Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf=ghIj!!"
Output: "j-Ih-gfE=dCba!!"
 */
/////
/////
    /*
    Approach:
    [ 0 , 1, 2, 3]
    [ a , b, -, c]
    1. Find length of letters - 3
    2. Iterate letters:
        - check if letter s[0] = a -> swap
        - check s[3 - 0] -> if letter (c) -> swap [c, b, -, a]
        - check if letter s[1] = b -> swap
        - check s[3 - 1] = s[2] -> if letter (-)
     */

    public static String reverseOnlyLetters(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) { // iterate
            if (!Character.isLetter(chars[i])) {
                i++;
            } else if (!Character.isLetter(chars[j])) {
                j--;
            } else {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s1 = "ab-cd";
        String s2 = "a-bC-dEf=ghIj!!";
        System.out.println(reverseOnlyLetters(s1));
        System.out.println(reverseOnlyLetters(s2));
    }
}
