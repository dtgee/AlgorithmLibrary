package JavaAlgo;

import java.util.Random;

// Sorts an array of integers in descending order.
public class MergeSort {
    static Random r = new Random();
    static int listSize = r.nextInt(10) + 5;
    static int[] testArr = new int[listSize];
    static int[] helper = new int[listSize];

    public static void generateTests() {
        for (int i = 0; i < listSize; i++) {
            int randomFact = r.nextInt(41) - 20; // Random integers from -20 to
                                                 // 20
            testArr[i] = randomFact;
        }

        String stringList = "";
        for (int i = 0; i < testArr.length; i++)
            stringList += testArr[i] + " ";
        System.out.println("The unsorted list is: " + stringList);

        long startTime = System.nanoTime();

        // int[] sortedArr = mergeSort(testArr, 0, testArr.length - 1);
        // Uncomment for legacy sort
        mergeSort(0, testArr.length - 1);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        double seconds = (double) (duration / 1000000000.0);

        stringList = "";
        for (int i = 0; i < testArr.length; i++)
            stringList += testArr[i] + " ";
        String output = "The sorted list is " + stringList
                + "\r\nThis was computed in " + seconds + " seconds. \r\n";

        System.out.println(output);
    }

    public static void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    public static void merge(int low, int mid, int high) {

        int[] helper = new int[testArr.length];
        for (int i = 0; i < helper.length; i++)
            helper[i] = testArr[i];

        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (helper[i] > helper[j])
                testArr[k++] = helper[i++];
            else
                testArr[k++] = helper[j++];
        }

        while (i <= mid)
            testArr[k++] = helper[i++];
        while (j <= high)
            testArr[k++] = helper[j++];
    }

    /*
     * LEGACY SORT - IT ACTUALLY RETURNS AN ARRAY public static int[]
     * mergeSort(int[] array, int low, int high) { if (low < high) { int middle
     * = (low + high) / 2; int[] leftSide = mergeSort(array, low, middle); int[]
     * rightSide = mergeSort(array, middle + 1, high); return merge(leftSide,
     * rightSide); } return Arrays.copyOfRange(array, low, low + 1); }
     * 
     * public static int[] merge(int[] leftSide, int[] rightSide) { int
     * firstPointer = 0; int secondPointer = 0; int[] returnArr = new
     * int[leftSide.length + rightSide.length]; int position = 0;
     * 
     * while (firstPointer < leftSide.length && secondPointer <
     * rightSide.length) { if (leftSide[firstPointer] >
     * rightSide[secondPointer]) { returnArr[position] = leftSide[firstPointer];
     * firstPointer++; } else { returnArr[position] = rightSide[secondPointer];
     * secondPointer++; } position++; } while (firstPointer < leftSide.length) {
     * returnArr[position] = leftSide[firstPointer]; firstPointer++; position++;
     * } while (secondPointer < rightSide.length) { returnArr[position] =
     * rightSide[secondPointer]; secondPointer++; position++; } return
     * returnArr; }
     */
}
