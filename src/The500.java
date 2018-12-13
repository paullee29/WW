import java.util.Random;

//WW - Question 3
import java.util.Scanner;

/**
 * This class will prompt the user whether or not they would like to automatically generate 500 random numbers
 * or customize the amount of numbers and the highest random number that can be generated
 * @author Paul Lee
 * @since 12.13.2018
 */

public class The500 {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		The500 randgen = new The500();
		boolean keepgoing = true;
		int custom=1;
		while (keepgoing) {
			System.out.println("Automatically generate 500 random numbers (up to 1000), enter 1: ");
			System.out.println("To customize the array length and highest number, enter 2: ");
			custom = sc.nextInt();
			if (custom == 1 || custom ==2) {
				keepgoing = false;
			} else {
				System.out.println("Invalid choice, please select 1 or 2");
			}
		}
		int [] n = {500,1000};
		if (custom ==2) {
			n = randgen.numberPrompter();
		} 

		int [] A = randgen.generateRandom(n);

		System.out.println("Randomly generated array: ");
		randgen.printArray(A);
		A = randgen.insertionSort(A);
		System.out.println("Sorted array: ");
		randgen.printArray(A);
		randgen.nthSmallest(A);

	}
	
	/**
	 * if #2 is selected it will run the numberPrompter to customize the array
	 * @return returns the customized array
	 */
	public int[] numberPrompter () {
		int [] n = new int[2];
		System.out.println("Please input how many random numbers you would like: "); 
		n[0] = sc.nextInt();
		System.out.println("What is the max random number integer?: ");
		n[1] = sc.nextInt();

		return n;
	}
	
/**	
 * nthSmallest will generate the nth smallest number 
 * @param A the array that will be parsed for nth smallest number
 */
	public void nthSmallest (int[] A) {
		System.out.println("What n smallest number would you like to print?: ");

		int smallest = sc.nextInt();
		Boolean keepgoing = true;
		while (keepgoing) {
			try {
				System.out.println("Here is the nth smallest number (starting from 1) : " + A[smallest-1]);
				keepgoing = false;
			} catch (ArrayIndexOutOfBoundsException exception) {
				System.out.println("Please select a number within under the number of random numbers you requested, try again: ");
				keepgoing = true;
				smallest = sc.nextInt();
				
			}
		}
		sc.close();

	}
	
/**	
 *  insertion sorter
 * 	@param A the array to be sorted in ascending order
 * 	@return returns the sorted array
*/	
	public int[] insertionSort (int[] A) {
		int key, j;
		int length = A.length;
		for (int i = 1; i<length; i++) {
			key = A[i];
			j = i-1;
			while (j>=0 && A[j]>key) {
				A[j+1]=A[j];
				j-=1;
			}
			A[j+1] = key;
		}

		return A;
	}
	
/**	
 * generates the random array
 * 	@param n generates a random array of n[0] length and n[1] highest number
 * 	@return returns the randomly generated array
 */
	public int [] generateRandom (int[] n) {
		Random rand = new Random();
		
		int[] A = new int [n[0]];
		for (int i = 0; i < n[0]; i++) {
			A[i] = rand.nextInt(n[1]);
		}
		return A;
	}
	
/**	
 * prints the array
 * @param A the array to be printed
 */
	public void printArray (int[] A) {
		System.out.print("{");
		for (int i=0;i<A.length;i++) {
			if (i==A.length-1) {
				System.out.print(A[i]);
			} else {
			System.out.print(A[i] + ",");
			}
		}
		System.out.println("}");
	}

}
