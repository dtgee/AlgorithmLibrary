package JavaInterview;


public class DutchNationalFlag {
	/*
	 * Given a list of 1's, 2's, and 3's,
	 * sort them so the 1's come first, 2's
	 * second and the 3's come third. Don't
	 * allocate new lists, and it must be in one pass.
	 * 
	 */
	public static void main(String[] args) {
		
		int[] list = { 1, 2, 2, 1, 3, 2, 3, 1, 2 };

		int lo = 0;
		int hi = list.length-1;
		int counter = 0;
		
		// only need to go up to high
		while (counter <= hi) {
			int e = list[counter];
			if (e == 1) {
				// if it's 1, swap and increment both counters
				int tmp = list[lo];
				list[lo++] = e;
				list[counter++] = tmp;
			} 
			else if (e == 3) {
				// don't decrement counter
				int tmp = list[hi];
				list[hi--] = e;
				list[counter] = tmp;
			} 
			else {
				// if it's 2, just keep going
				counter++;
			}
		}
		
		String str = "";
		for (int i : list)
			str += i + " ";
		System.out.println(str);
	}
}