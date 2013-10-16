package JavaInterview;

public class TwoSortedMedians {
    /*
     * You have two sorted arrays. Different lengths.
     * Find the median of both arrays.
     * 
     * 1. We know median of a sorted arr is just index=floor(arr.length/2)
     * 
     * Potentially allocate a new list M+N, merge the two lists in
     * sorted and run the median on it? O(n) space and time.
     * 
     * Or.. Instead of merging two lists, we can just run counters on
     * the two lists in merge-sort fashion, then retrieve the median.
     * Still O(n) time but O(1) space now.
     * 
     */
    
    static int naivemedian(int[] arr1, int[] arr2) {
        int m = 0;
        int n = 0;
        int med_index = (arr1.length+arr2.length)/2;
        while (m < arr1.length && n < arr2.length) {
            if (arr1[m] <= arr2[n]) {
                m++;
                if (m+n==med_index) {
                    return arr1[m];
                }
            } else if (arr2[n] < arr1[m]) {
                n++;
                if (m+n==med_index) {
                    return arr2[n];
                }
            }
        }
        while (m < arr1.length) {
            m++;
            if (m+n==med_index) {
                return arr1[m];
            }
        }
        while (n < arr2.length) {
            n++;
            if (m+n==med_index) {
                return arr2[n];
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 4, 10, 100, 200};
        int[] arr2= {8, 20, 40, 80, 160, 1000, 2000};
        int median = naivemedian(arr1, arr2);
        System.out.println(median);
    }
}
