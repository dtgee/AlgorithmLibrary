package JavaInterview;

public class SortedMatrix {
    /*
     * Given an MxN matrix in which each row and each 
     * column is sorted in ascending order, write a method
     * to find an element.
     * 
     * A naive solution is to perform binary search row by
     * row until something has been found. Time: O(M*log(N))
     * 
     * We can also perform somewhat of an informed depth  first
     * traversal starting from one of the corners.
     * 
     */
    
    static int binarys(int[] row, int k, int a, int b) {
        while (a<=b) {
            int m = (a+b)/2;
            if (k < m) b = m-1;
            else if (k > m) a = m+1;
            else return m;
        }
        return -1;
    }
    
    static int[] naivematrixsearch(int[][] matrix, int k) {
        int rows = matrix.length;
        for (int i=0; i<rows; i++) {
            int[] col = matrix[i];
            int result = binarys(col, k, 0, col.length-1);
            System.out.println(result);
            if (matrix[i][result] == k)
                return new int[] {i,result}; // row, column
        }
        return new int[] {-1, -1};
    }
    
    //static int matrixsearch(int[][] matrix) {
        
    //}
    
    public static void main(String[] args) {
        // 15 20 40  85
        // 20 35 80  95
        // 30 35 95  105
        // 40 80 100 120
        int[][] matrix = new int[][] {
                new int[] {15, 20, 40, 85},
                new int[] {20, 35, 80, 95},
                new int[] {30, 35, 95, 105},
                new int[] {40, 80, 100, 120},
        };
        int lookingfor = 80;
        System.out.println(naivematrixsearch(matrix, lookingfor));
    }
}
