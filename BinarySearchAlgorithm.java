package com.dash.abinash.BinarySearch;

/*
 *Below code snippet will demonstrate about the Binary searching technique. 
 */
/*
 * Need to check how to do binary search implementation by recursion .(important part is recursion)
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchAlgorithm {
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws Exception {

		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Enter the size of the Array :");
		int size = sc.nextInt();
		Integer[] arr = new Integer[size];
		System.out.println("Entering Array elements..");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter " + i + " item :");
			arr[i] = sc.nextInt();
		}

		List<Integer> list = Arrays.asList(arr);
		Collections.sort(list);

		Integer[] inputarr = new Integer[list.size()];
		inputarr = (Integer[]) list.toArray();

		System.out.println("Size of list :" + " " + list.size());

		System.out.println("Display of elements after sorting..");
		for (int i = 0; i < inputarr.length; i++) {
			System.out.print(inputarr[i] + " ");
		}
		System.out.println();
		System.out.println("Enter the item to search :");
		int searchitem = sc.nextInt();
		BinarySearchAlgorithm obj = new BinarySearchAlgorithm();
		int result = obj.searchBinarylyOverArray(inputarr, searchitem,
				inputarr.length);
		if (result == 1) {
			System.out.println("Searching successful.");
		} else {
			System.out.println("Searching unsuccessful.");
		}

	}

	public int searchBinarylyOverArray(Integer[] inputarr, int searchitem,
			int length) throws Exception {

		int lowerlimit = 0;
		int upperlimit = length - 1;
		int middle;

		if (inputarr != null) {
			while (upperlimit >= lowerlimit) {
				middle = (lowerlimit + upperlimit) / 2;

				if (inputarr[middle] == searchitem) {
					System.out.println("Item found at position " + middle);
					return 1;
				} else if (searchitem > inputarr[middle]) {
					lowerlimit = middle + 1;
				} else {
					upperlimit = middle - 1;
				}
			}
		} else {
			throw new Exception("Passed Array is of null .");
		}

		return -1;

	}
}

/*
 * Advantages :
 * 
 * 
 * Disadvantages :
 */
