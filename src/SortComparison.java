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
		if(a!=null)
		{
			if(a.length <=1)
			{
				return a;
			}
			else
			{
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
		}
		else
		{
			return null;
		}
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
		if(a!=null)
		{
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

				quickSort(a, 0, a.length-1);
				return a;
			}
		}
		else
		{
			return null;
		}
	}


	private static void quickSort(double[] a, int low, int high) {
		if(high <= low) {
			return;
		}
		int pivot = partition(a, low, high);
		quickSort(a, low, pivot-1);
		quickSort(a, pivot+1, high);
	}

	private static int partition(double[] array, int low, int high) {
		int i = low;
		int j = (high+1);
		double pivot = array[low];
		boolean go = true;
		while(go) {
			while((array[++i]< pivot)) {
				if(i == high) break;
			}
			while(pivot < array[--j]) {
				if(j == low) break;
			}
			if(i >= j) break;
			else
			{
				double temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		array[low] = array[j];
		array[j] = pivot;
		return j;
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
		if(a!=null)
		{
			if(a.length <=1)
			{
				return a;
			}
			else
			{
				double aux[] = new double[a.length];
				for(int i=1; i < a.length;i+=i)
				{
					for(int low = 0; low < a.length-i; low +=i+i)
					{
						merge(a,aux,low,(low+i)-1,Math.min(low+i+i-1, a.length-1));
					}
				}
				return a;
			}
		}
		else
		{
			return null;
		}

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
		if(a!=null)
		{
			if(a.length <=1)
			{
				return a;
			}
			else
			{
				double[] aux = new double[a.length];
				mergeSort(a,aux,0,a.length-1);
				return a;
			}
		}
		else
		{
			return null;
		}


	}

	private static void mergeSort (double[] a, double[] aux, int low, int high)
	{
		if(high <= low)
		{
			return;
		}
		int mid = low + ((high-low) /2);
		mergeSort(a,aux,low,mid);
		mergeSort(a,aux,mid+1,high);
		merge(a,aux,low,mid,high);
	}

	private static void merge (double[] a, double[] aux, int low, int mid, int high)
	{
		for(int i= low;i<=high; i++)
		{
			aux[i] = a[i];
		}
		int j = low;
		int k = mid+1;
		for(int n = low; n <=high;n++)
		{
			if(j > mid)
			{
				a[n] = aux[k++];
			}
			else if(k > high)
			{
				a[n] = aux[j++];
			}
			else if(aux[k] < aux[j])
			{
				a[n] = aux[k++];
			}
			else
			{
				a[n] = aux[j++];
			}
		}
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
		if(a!=null)
		{
			if(a.length <=1)
			{
				return a;
			}
			else
			{
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
		}
		else
		{
			return null;
		}
	}
	//end selectionsort



	/*
	public static void main(String[] args){

	}
	 */
}

//end class

