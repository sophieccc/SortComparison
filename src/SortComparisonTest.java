import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
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
    }


    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     * @throws FileNotFoundException 
     *
     */
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
	}

}

