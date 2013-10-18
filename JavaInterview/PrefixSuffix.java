package JavaInterview;

public class PrefixSuffix {
    /*
     * Given two String, s1 and s2. to find the longest 
     * substring which is prefix of s1, as well as 
     * suffix of s2.
     */
    
    static int[] presuf(String s1, String s2) {
        for (int i=0; i<s1.length(); i++) {
            for (int j=s2.length()-1; j>-0; j--) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    return new int[] {i, j};
                   
                }
            }
        }
        // Entire words match..
        return new int[] {s1.length()-1, s2.length()-1};
    }
    
    public static void main(String[] args) {
        String s1 = "lucas ou-yang";
        String s2 = "kdsfjlu";
        int[] res = presuf(s1, s2);

        System.out.println(s1.substring(0, res[0]-1));
    }
}
