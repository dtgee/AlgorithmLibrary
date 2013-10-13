package JavaInterview;

public class FibonacciRange {
    /*
     * Fibonacci Numbers: A number is said to be Fibonacci number if it follows
     * the fibonacci property. (Ex: 112, 1123, etc). But additionally, it need
     * not necessarily start with 1, as with the normal fibonacci series. So, in
     * this new definition, 112(1,1,2) is a fibonacci number and so is
     * 121224(12,12,24), and so is 252550(25,25,50). So, given any two numbers
     * as input, print out all the Fibonacci Numbers within that range..
     * 
     */
    
    static boolean isfib(int num) {
        /*  */
        String numstr = Integer.toString(num);
        
        if (numstr.length() < 3)
            return false;
        
        char[] arr = numstr.toCharArray();
        for (int radix=1; radix<(numstr.length()/3); radix++) {
            String third = null;
            String second = null;
            String current;
            for (int i=0; (i+radix-1) < numstr.length(); i++) {
                String chunk = numstr.substring(i, i+radix);
                if (i == 0) {
                    third = chunk;
                    continue;
                }
                else if (i == 1) {
                    second = chunk;
                    continue;
                }
                    
            }
        }
        
    }
    
    public static void main(String[] args) {
        
    }
}
