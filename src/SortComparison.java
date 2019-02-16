import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2019
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	double temp;
    	for(int i=1; i < a.length; i++)
    	{
    		for(int j = i;j>0;j--)
    		{
        		if(a[j] < a[j-1])
        		{
        			temp = a[j-1];
        			a[j-1]=a[j];
        			a[j]=temp;
        		}
    		}
    		
    	}
		return a;
    }
    //end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
    	if(a.length <=1)
    	{
    		return a;
    	}
    	else
    	{
        	//Randomising array first
        	Random num = ThreadLocalRandom.current();
            for (int i = a.length - 1; i > 0; i--)
            {
              int index = num.nextInt(i + 1);
              double current = a[index];
              a[index] = a[i];
              a[i] = current;
            }
            //now the actual sorting
            a = quicksort(a, a[0], a[a.length-1]);
    		return a;
    	}
    }
    
    
    private static double[] quicksort(double[] a, double low, double high) {
    	if(low < high)
    	{
    		
    	}
		return a;
	}
	//end quicksort

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
		return a;

		 //todo: implement the sort
	
    }
    //end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
		return a;
    	

    	//todo: implement the sort
	
   }
    //end mergeSortRecursive
    	
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	for(int i=0;i<a.length-1;i++)
    	{
    		int temp = i ;
    		for(int j=i+1;j<a.length;j++)
    		{
    			if(a[j] < a[temp])
    			{
    				temp = j;
    			}
    		}
    		double temporary = a[temp];
    		a[temp] = a[i];
    		a[i] = temporary;
    	}
		return a;
    }
    //end selectionsort

   


    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

 }
 //end class

