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
    public static void main(String[] args) throws FileNotFoundException
    {
    	System.out.println("hi");
	/*	double[] array = null;
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
				long startTime = System.nanoTime();
				SortComparison.selectionSort(currentArray);
				long endTime = System.nanoTime();
				long timeElapsed = endTime - startTime;
				System.out.println("Execution time in nanoseconds is:" + timeElapsed);
			}
			System.out.println("\nInsertion sort");
			for(int j=0;j<4;j++)
			{
				currentArray = array.clone();
				long startTime = System.nanoTime();
				SortComparison.insertionSort(currentArray);
				long endTime = System.nanoTime();
				long timeElapsed = endTime - startTime;
				System.out.println("Execution time in nanoseconds is:" + timeElapsed);
			}
			System.out.println("\nQuick sort"); 
			for(int j=0;j<4;j++)
			{
				currentArray = array.clone();
				long startTime = System.nanoTime();
				SortComparison.quickSort(currentArray);
				long endTime = System.nanoTime();
				long timeElapsed = endTime - startTime;
				System.out.println("Execution time in nanoseconds is:" + timeElapsed);
			}
			System.out.println("\nRecursive Merge sort");
			for(int j=0;j<4;j++)
			{
				currentArray = array.clone();
				long startTime = System.nanoTime();
				SortComparison.mergeSortRecursive(currentArray);
				long endTime = System.nanoTime();
				long timeElapsed = endTime - startTime;
				System.out.println("Execution time in nanoseconds is:" + timeElapsed);
			}
			System.out.println("\nIterative Merge sort");
			for(int j=0;j<4;j++)
			{
				currentArray = array.clone();
				long startTime = System.nanoTime();
				SortComparison.mergeSortIterative(currentArray);
				long endTime = System.nanoTime();
				long timeElapsed = endTime - startTime;
				System.out.println("Execution time in nanoseconds is:" + timeElapsed);
			}
		}
		inFile.close(); 
		*/
	}

}

