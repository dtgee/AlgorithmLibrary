package JavaAlgo;
public class JacobSorts {

	public static void main(String[] args) {

		int[] arr = { 5, 2, 3, 10, 2 };
		quicksort(arr, 0, arr.length - 1);

		for (int a : arr)
			System.out.println(a);

	}

	public static void quicksort(int[] arr, int a, int b) {

		if (b < a)
			return;

		int piv = arr[(a + b) / 2];
		int start = a;
		int end = b;

		while (start <= end) {

			while (arr[start] < piv)
				start++;

			while (arr[end] > piv)
				end--;

			if (start <= end) {
				int tmp = arr[start];
				arr[start] = arr[end];
				arr[end] = tmp;
				start++;
				end--;
			}
		}

		quicksort(arr, a, end);
		quicksort(arr, start, b);
	}
}
