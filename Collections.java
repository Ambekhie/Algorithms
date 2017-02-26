import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
/**
 *	Collections Utility (searching and Sorting) Class
 * 	Comparison Based Algorithms 
 *	@author		Amr Mahmoud Ahmed Bekhiet Aly
 *	@version	0.1
*/
public class Collections {
	/**
	 *	swaps to Elements (i and j) in a List
	 *	Complexity O(1)~time
	 *	Complexity O(1)~space
	 *	@param collection 	elements modify
	 *	@param i 		  	first element to swap
	 *	@param j 		  	second element to swap
	 *	@return 		  	void
	*/
	private static <T> void swap(List<T> collection, int i, int j) {
		T temp = collection.get(i);
		collection.set(i, collection.get(j));
		collection.set(j, temp);				
	}
	/**
	 *	provides Binary Search algorithm 
	 *	Complexity O(log(size))~time
	 *	Complexity O(1)~space
	 *	Behaviour is undefined for unsorted elements
	 *	@param collection 	elements to be searched
	 *	@param item		 	element to lookup
	 *	@return 		  	int index of item in collection if exist, -1 otherwise
	*/
	public static <T extends Comparable<? super T>> int binarySearch(List<T> collection, T item) {
		int low = 0;
		int high = collection.size() - 1;
		while (low <= high) {
			int mid = low + (high - low)/2;
			if (collection.get(mid).compareTo(item) == 0) {
				return mid;
			}else if (collection.get(mid).compareTo(item) < 0) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		return -1;	
	}
	/**
	 *	provides Binary Search floor algorithm 
	 *	Complexity O(log(size))~time
	 *	Complexity O(1)~space
	 *	Behaviour is undefined for unsorted elements
	 *	@param collection 	elements to be searched
	 *	@param item		 	element to lookup its floor
	 *	@return 		  	int index of floor to item in collection if exist, -1 otherwise
	*/
	public static <T extends Comparable<? super T>> int floor(List<T> collection, T item) {
		int low = 0;
		int high = collection.size() - 1;
		int floor = -1;
		while (low <= high) {
			int mid = low + (high - low)/2;
			if (collection.get(mid).compareTo(item) == 0) {
				return mid;
			}else if (collection.get(mid).compareTo(item) < 0) {
				floor = mid;
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		return floor;	
	}
	/**
	 *	provides Binary Search ceil algorithm 
	 *	Complexity O(log(size))~time
	 *	Complexity O(1)~space
	 *	Behaviour is undefined for unsorted elements
	 *	@param collection 	elements to be searched
	 *	@param item		 	element to lookup its ceil
	 *	@return 		  	int index of ceil to item in collection if exist, -1 otherwise
	*/
	public static <T extends Comparable<? super T>> int ceil(List<T> collection, T item) {
		int low = 0;
		int high = collection.size() - 1;
		int ceil = -1;
		while (low <= high) {
			int mid = low + (high - low)/2;
			if (collection.get(mid).compareTo(item) == 0) {
				return mid;
			}else if (collection.get(mid).compareTo(item) < 0) {
				low = mid + 1;
			}else {
				ceil = mid;
				high = mid - 1;
			}
		}
		return ceil;	
	}
	/**
	 *	provides Selection sort algorithm (Increasing Order)
	 *	Complexity O(size * size)~time
	 *	Complexity O(1)~space
	 *	@param collection 	elements to be sorted
	 *	@return 		  	void
	*/
	public static <T extends Comparable<? super T>> void selectionSort(List<T> collection) {
		int size = collection.size() - 1;
		T max = null;
		int maxIndex = -1;
		for (int i = 0; i <= size; i++) {
			for (int j = 0; j <= (size - i); j++) {
				if (max == null || collection.get(j).compareTo(max) > 0) {
					max = collection.get(j);
					maxIndex = j;
				}
			}
			swap(collection, maxIndex, size - i);
			max = null;
			maxIndex = -1;
		}
	}
	/**
	 *	provides Bubble sort algorithm (Increasing Order)
	 *	Complexity O(size * size)~time
	 *	Complexity O(1)~space
	 *	@param collection 	elements to be sorted
	 *	@return 		  	void
	*/
	public static <T extends Comparable<? super T>> void bubbleSort(List<T> collection) {
		int size = collection.size() - 1;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < (size - i); j++) {
				if (collection.get(j).compareTo(collection.get(j + 1)) > 0) {
					swap(collection, j, j + 1);
				}
			}
		}
	}
	/**
	 *	Merge sort Helper method to merge Two halves
	 *	Complexity O(size)~time
	 *	Complexity O(size)~space
	 *	@param collection 	elements to be sorted
	 *	@param start 		index of first element in first part
	 *	@param mid  		index of first element in second part 
	 *	@param end 		 	index of last element in second part
	 *	@param aux 			auxilary collection 
	 *	@return 		  	void
	*/
	private static <T extends Comparable<? super T>> void mergeHelper(List<T> collection,
													 			int start, 
													 			int mid, 
													 			int end, 
													 			List<T> aux) {
		for (int i = start; i <= end; i++) {
			aux.set(i, collection.get(i));
		}
		int ptrA = start;
		int ptrB = mid;
		int index = start;
		while (ptrA < mid && ptrB <= end) {
			if (aux.get(ptrA).compareTo(aux.get(ptrB)) < 0) {
				collection.set(index++, aux.get(ptrA++));
			}else {
				collection.set(index++, aux.get(ptrB++));
			}
		}
		while (ptrA < mid) {
			collection.set(index++, aux.get(ptrA++));
		}
	}
	/**
	 *	Merge sort recursive method (Increasing Order)
	 *	Complexity O(size * log(size))~time
	 *	Complexity O(size)~space
	 *	@param collection 	elements to be sorted
	 *	@param start 		index of first element 
	 *	@param end 		 	index of last element
	 *	@param aux 			auxilary collection 
	 *	@return 		  	void
	*/
	private static <T extends Comparable<? super T>> void merge(List<T> collection,
													 			int start, 
													 			int end, 
													 			List<T> aux) {
		if (start >= end)
			return;
		int mid = start + (end - start)/2;
		merge(collection, start, mid, aux);
		merge(collection, mid + 1, end, aux);
		mergeHelper(collection, start, mid + 1, end, aux);
	}
	/**
	 *	provides Merge sort algorithm (Increasing Order)
	 *	Complexity O(size * log(size))~time
	 *	Complexity O(size)~space
	 *	@param collection 	elements to be sorted
	 *	@return 		  	void
	*/
	public static <T extends Comparable<? super T>> void mergeSort(List<T> collection) {
		List<T> aux = new ArrayList<>(collection);
		merge(collection, 0, collection.size() - 1, aux);
	}
	/**
	 *	Quick sort Helper method to partition elements around pivot 
	 *	Complexity O(size) ~ time 
	 *	Complexity O(1) ~ Additional space
	 *	@param collection 	elements to be sorted
 	 *	@param start 		index of first element 
	 *	@param end 		 	index of last element
	 *	@return 		  	int pivot index
	*/
	private static <T extends Comparable<? super T>> int partition(List<T> collection,
															   int start,
															   int end) {
		int index = start + (int) Math.random() * (end - start + 1);
		T pivot = collection.get(index);
		int first = start;
		swap(collection, start++, index);
		while (start <= end) {
			if (collection.get(start).compareTo(pivot) <= 0) {
				start++;
			}else if (collection.get(end).compareTo(pivot) >= 0) {
				end--;
			}else {
				swap(collection, start++, end--);
			}
		}
		swap(collection, first, start - 1);
		return start - 1;
	}
	/**
	 *	Quick sort recursive algorithm (Increasing Order)
	 *	Complexity O(size * log(size)) ~ time on Average
	 *	Complexity O(log(size)) ~ Additional space
	 *	@param collection 	elements to be sorted
 	 *	@param start 		index of first element 
	 *	@param end 		 	index of last element
	 *	@return 		  	void
	*/
	private static <T extends Comparable<? super T>> void quick(List<T> collection,
															   int start,
															   int end) {
		if (start >= end)
			return;
		int index = partition(collection, start, end);
		quick(collection, start, index - 1);
		quick(collection, index + 1, end);
	}
	/**
	 *	provides Quick sort algorithm (Increasing Order)
	 *	Complexity O(size * log(size)) ~ time on Average
	 *	Complexity O(log(size)) ~ Additional space
	 *	@param collection 	elements to be sorted
	 *	@return 		  	void
	*/
	public static <T extends Comparable<? super T>> void quickSort(List<T> collection) {
		quick(collection, 0, collection.size() - 1);
	}
}