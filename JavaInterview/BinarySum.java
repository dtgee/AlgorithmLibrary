package JavaInterview;

public class BinarySum {
    /*
     * Write a function that takes in two binary 
     * strings and returns their sum (also a binary string).
     * 
     * My first impression is to iterate both strings in 
     * parallel, backwards. At each turn add the digits together.
     * If the result goes over 1 (2), subtract 1 and carry a 1
     * to the next value. Do this be setting a variable for the carry.
     */
    
    static String add(String s1, String s2) {
        /* */
    }
    
    public static void main(String[] args) {
        String s1 = Integer.toBinaryString(10);
        String s2 = Integer.toBinaryString(15);
        System.out.println(s1+" + "+s2+" is");
        String ans = add(s1, s2);
        
        
        System.out.println(Integer.toBinaryString(123));
    }
}
