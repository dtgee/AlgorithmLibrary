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
        /* This solution is naive. We iterate the radix sizes
         * for the fibonacci numbers. A radix=1 means we
         * are checking if 1+1=2 in 112, a radix=2 means
         * we are checking if 12+12=13 in 121213.  */
        String numstr = Integer.toString(num);
        
        if (numstr.length() < 3)
            return false;
        
        for (int radix=1; radix<=(numstr.length()/3); radix++) {
            
            String third = numstr.substring(0, 0+radix);
            String second = numstr.substring(0+(radix), radix*2);
            String current = "";
            boolean passed = true;
            
            for (int i=(radix*2); (i+radix-1) < numstr.length(); i++) { 
                String chunk = numstr.substring(i, i+radix);
                current = chunk;
                System.out.println("cur, second, third, radix "+
                        current+" "+second+" "+third+" "+radix);
                if ((Integer.parseInt(third) + Integer.parseInt(second)) 
                        != Integer.parseInt(current)) {
                    passed = false;
                    break;
                }
                third = second;
                second = current;
            }
            if (passed) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(isfib(91019));
    }
}
