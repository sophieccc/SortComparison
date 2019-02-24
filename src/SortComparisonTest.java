/* COMMENTS
 * 
a. Which of the sorting algorithms does the order of input have an impact on? Why?
	1.Insertion sort, as the closer to it being ordered already, the less it has to do and therefore the quicker it will be.
		If it is very out of order, or opposite, etc. insertion sort has to do a lot of swaps.
	2. Quick sort would be affected by order if I had not randomised the array in the function.
		If it had not been randomised and I had still picked the first/last number as a pivot,
		it could have taken a lot longer if the array has been sorted in ascending/descending order.
		This would cause everything to go to one side of the pivot, so a lot of work would have to be done.
	3. Selection sort. While it will pass through the entire array every time, if the array is already ordered,
	then there will be a lesser amount of swaps, making it faster. Otherwise, there will be more swaps, 
	making it slower.

b. Which algorithm has the biggest difference between the best and worst performance, based
on the type of input, for the input of size 1000? Why?
	: Selection sort. This is due to when it being a random 100, it probably has to make many swaps, which
	gave it a time of 8 milliseconds. Contrastingly, when it was nearly sorted, and only had to make a few swaps,
	it only had a time of 1ms.

c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
based on the input size? Please consider only input files with random order for this answer.
	: Selection sort. It has a worst case run time of n^2 so is very affected by the size.

d. Did you observe any difference between iterative and recursive implementations of merge
sort?
	: Yes. Recursive merge sort seemed to be slightly slower for the random inputs. While, when there
		was an order (of any kind, or almost an order) to the array, recursive sort seemed slightly faster.

e. Which algorithm is the fastest for each of the 7 input files? 
	: Quicksort was overall fastest.
	10 random: equal
	100 random: Merge Iterative
	1000 random: Quick & Merge Iterative
	1000 few unique: Merge Recursive
	1000 nearly ordered: all equal (except selection sort)
	1000 reverse order: quick sort & the merge sorts
	1000 sorted: quicksort & merge recursive
 *
 * RESULTS: (all times are in milliseconds)
                    | Insert  |  Quick  |  Merge Recursive  |  Merge Iterative  |  Selection  |
          10 random |	0			0		  	 0					0					0
         100 random |	0.33		0.33		 0.33				0					0.33
        1000 random |	2			0			 1					0					8	
    1000 few unique |   0.66		0.33		 0					1					3.33
1000 nearly ordered |	0			0			 0					0					1
 1000 reverse order |	2.67		0.33		 0.33				0.33				4												
        1000 sorted |	0.66		0.33		 0.33				0.66				3.67
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Sophie Crowley
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
	//~ Constructor ........................................................
	@Test
	public void testConstructor()
	{
		new SortComparison();
	}

	//~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the methods work for empty arrays
	 */
	@Test
	public void testEmpty()
	{
		double[] array = null;
		SortComparison.insertionSort(array);
		assertEquals(SortComparison.insertionSort(array),null);
		array = null;
		SortComparison.selectionSort(array);
		assertEquals(SortComparison.insertionSort(array),null);
		array = null;
		SortComparison.quickSort(array);
		assertEquals(SortComparison.insertionSort(array),null);
		array = null;
		SortComparison.mergeSortRecursive(array);
		assertEquals(SortComparison.insertionSort(array),null);
		array = null;
		SortComparison.mergeSortIterative(array);
		assertEquals(SortComparison.insertionSort(array),null);
	}


	@Test
	public void testInsertion()
	{
		double[] array = {1};
		assertEquals(SortComparison.insertionSort(array),array);
		double[] array2 = {};
		assertEquals(SortComparison.insertionSort(array2),array2);
		double[] array3 = {1,2};
		assertEquals(SortComparison.insertionSort(array3),array3);
		double[] array4 = {2,1};
		SortComparison.insertionSort(array4);
		assertTrue(Arrays.equals(array4,array3));
	}

	@Test
	public void testSelection()
	{
		double[] array = {1};
		assertEquals(SortComparison.selectionSort(array),array);
		double[] array2 = {};
		assertEquals(SortComparison.selectionSort(array2),array2);
		double[] array3 = {1,2};
		assertEquals(SortComparison.selectionSort(array3),array3);
		double[] array4 = {2,1};
		SortComparison.selectionSort(array4);
		assertTrue(Arrays.equals(array4,array3));

	}

	@Test
	public void testQuick()
	{
		double[] array = {1};
		assertEquals(SortComparison.quickSort(array),array);
		double[] array2 = {};
		assertEquals(SortComparison.quickSort(array2),array2);
		double[] array3 = {1,2};
		assertEquals(SortComparison.quickSort(array3),array3);
		double[] array4 = {2,1};
		SortComparison.quickSort(array4);
		assertTrue(Arrays.equals(array4,array3));
		double[] array5 = {2,1,3};
		double[] array6 = {1,2,3};
		SortComparison.quickSort(array5);
		assertTrue(Arrays.equals(array5,array6));
		double[] array7 = {3,3,3};
		SortComparison.quickSort(array7);
		assertTrue(Arrays.equals(array7,array7));
		double[] array8 = {2,3,3};
		SortComparison.quickSort(array8);
		assertTrue(Arrays.equals(array8,array8));

	}

	@Test
	public void testMergeRec()
	{
		double[] array = {1};
		assertEquals(SortComparison.mergeSortRecursive(array),array);
		double[] array2 = {};
		assertEquals(SortComparison.mergeSortRecursive(array2),array2);
		double[] array3 = {1,2};
		assertEquals(SortComparison.mergeSortRecursive(array3),array3);
		double[] array4 = {2,1};
		SortComparison.mergeSortRecursive(array4);
		assertTrue(Arrays.equals(array4,array3));
		double[] array5 = {2,1,3};
		double[] array6 = {1,2,3};
		SortComparison.mergeSortRecursive(array5);
		assertTrue(Arrays.equals(array5,array6));
		double[] array7 = {3,3,3};
		SortComparison.mergeSortRecursive(array7);
		assertTrue(Arrays.equals(array7,array7));
		double[] array8 = {2,3,3};
		SortComparison.mergeSortRecursive(array8);
		assertTrue(Arrays.equals(array8,array8));

	}

	@Test
	public void testMergeIt()
	{
		double[] array = {1};
		assertEquals(SortComparison.mergeSortIterative(array),array);
		double[] array2 = {};
		assertEquals(SortComparison.mergeSortIterative(array2),array2);
		double[] array3 = {1,2};
		assertEquals(SortComparison.mergeSortIterative(array3),array3);
		double[] array4 = {2,1};
		SortComparison.mergeSortIterative(array4);
		assertTrue(Arrays.equals(array4,array3));
		double[] array5 = {2,1,3};
		double[] array6 = {1,2,3};
		SortComparison.mergeSortIterative(array5);
		assertTrue(Arrays.equals(array5,array6));
		double[] array7 = {3,3,3};
		SortComparison.mergeSortIterative(array7);
		assertTrue(Arrays.equals(array7,array7));
		double[] array8 = {2,3,3};
		SortComparison.mergeSortIterative(array8);
		assertTrue(Arrays.equals(array8,array8));

	}

	// ----------------------------------------------------------
	/**
	 *  Main Method.
	 *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
	 * @throws FileNotFoundException 
	 *
	 *
	 */
	/*
	public static void main(String[] args) throws FileNotFoundException
	{ 
		double[] array = null;
		Scanner inFile = null;
		for(int y=0; y<7;y++)
		{ 
			if(y==0)
			{
				inFile = new Scanner(new File("numbers10.txt"));
				array = new double[10];
			}
			else if(y==1)
			{
				inFile = new Scanner(new File("numbers100.txt"));
				array = new double[100];
			}
			else if(y==2)
			{
				inFile = new Scanner(new File("numbers1000.txt"));
				array = new double[1000];
			}
			else if(y==3)
			{
				inFile = new Scanner(new File("numbers1000Duplicates.txt"));
				array = new double[1000];
			}
			else if(y==4)
			{
				inFile = new Scanner(new File("numbersNearlyOrdered1000.txt"));
				array = new double[1000];
			}
			else if(y==5)
			{
				inFile = new Scanner(new File("numbersReverse1000.txt"));
				array = new double[1000];
			}
			else if(y==6)
			{
				inFile = new Scanner(new File("numbersSorted1000.txt"));
				array = new double[1000];
			}
			int x=0;
			while(inFile.hasNextDouble())
			{
				array[x] = inFile.nextDouble();
				x++;
			}
			double currentArray[] = null;
			System.out.println("\nUsing test case " + (y+1) + "\n");
			System.out.println("Selection sort");
			for(int j=0;j<4;j++)
			{
				currentArray = array.clone();
				long startTime = System.currentTimeMillis();
				SortComparison.selectionSort(currentArray);
				long endTime = System.currentTimeMillis();
				long timeElapsed = endTime - startTime;
				System.out.println("Execution time in nanoseconds is:" + timeElapsed);
			}
			System.out.println("\nInsertion sort");
			for(int j=0;j<4;j++)
			{
				currentArray = array.clone();
				long startTime = System.currentTimeMillis();
				SortComparison.insertionSort(currentArray);
				long endTime = System.currentTimeMillis();
				long timeElapsed = endTime - startTime;
				System.out.println("Execution time in nanoseconds is:" + timeElapsed);
			}
			System.out.println("\nQuick sort"); 
			for(int j=0;j<4;j++)
			{
				currentArray = array.clone();
				long startTime = System.currentTimeMillis();
				SortComparison.quickSort(currentArray);
				long endTime = System.currentTimeMillis();
				long timeElapsed = endTime - startTime;
				System.out.println("Execution time in nanoseconds is:" + timeElapsed);
			}
			System.out.println("\nRecursive Merge sort");
			for(int j=0;j<4;j++)
			{
				currentArray = array.clone();
				long startTime = System.currentTimeMillis();
				SortComparison.mergeSortRecursive(currentArray);
				long endTime = System.currentTimeMillis();
				long timeElapsed = endTime - startTime;
				System.out.println("Execution time in nanoseconds is:" + timeElapsed);
			}
			System.out.println("\nIterative Merge sort");
			for(int j=0;j<4;j++)
			{
				currentArray = array.clone();
				long startTime = System.currentTimeMillis();
				SortComparison.mergeSortIterative(currentArray);
				long endTime = System.currentTimeMillis();
				long timeElapsed = endTime - startTime;
				System.out.println("Execution time in nanoseconds is:" + timeElapsed);
			}
		}
		inFile.close(); 
	}
*/

}

