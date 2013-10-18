package JavaInterview;

import java.util.Arrays;

public class BinarySum {
    /*
     * Write a function that takes in two binary 
     * strings and returns their sum (also a binary string).
     * 
     * My first impression is to iterate both strings in 
     * parallel, backwards. At each turn add the digits together.
     * If the result goes over 1 (2), subtract 1 and carry a 1
     * to the next value. Do this be setting a variable for the carry.
     * 
     * Complexity in time is O(m+n)
     */
    
    static int[] tointarr(String s) {
        int[] res = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            int e = Integer.parseInt(s.substring(i,i+1));
            res[i] = e;
        }
        return res;
    }
    
    static String add(String s1, String s2) {
        int[] a1 = tointarr(s1);
        int[] a2 = tointarr(s2);
        int[] result = new int[a1.length+a2.length];
        int carry = 0;
        int count = result.length-1;
        for (int i=a1.length-1; i>=0; i--) {
            result[count--] = a1[i];    
        }
        count = result.length-1;
        for (int j=a2.length-1; j>=0; j--) {
            int base = result[count];
            base += a2[j];
            base += carry;
            carry = base >> 1;
            base = base & 1;
            result[count--] = base;
        }
        if (carry == 1) {
            result[count] = 1;
        }
        return Arrays.toString(result);
    }
    
    public static void main(String[] args) {
        String s1 = Integer.toBinaryString(10);
        String s2 = Integer.toBinaryString(15);
        System.out.println(s1+" + "+s2+" is");
        String ans = add(s1, s2);
        System.out.println(ans);
    }
}

