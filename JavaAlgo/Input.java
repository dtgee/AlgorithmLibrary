package JavaAlgo;
import java.util.Scanner;


// Main entry class where lists and what not can be inputted
// for algorithm analysis, this is just a wrapper to make life
// easier.
public class Input 
{
	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		Asker asker = new Asker();
		asker.recursiveAsk(reader);
	}
}

class Asker 
{
	public void recursiveAsk(Scanner reader)
	{
		System.out.println("Please enter in this format: [algorithm-name]");

		String alg = reader.next(); 

		if (alg.equals("binary_search"))
			BinarySearch.generateTests();
		
		if (alg.equals("rotated_binary_search"))
			RotatedBinarySearch.generateTests();
		
		if (alg.equals("insertion_sort"))
			InsertionSort.generateTests();
		
		if (alg.equals("merge_sort"))
			MergeSort.generateTests();
		
		if (alg.equals("quick_sort"))
			QuickSort.generateTests();
		
		if (alg.equals("reverse_list"))
			ReverseList.generateTests();
		
		recursiveAsk(reader);
	}
}
