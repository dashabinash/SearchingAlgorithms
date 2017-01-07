package com.dash.abinash.JumpSearch;

/*
 * The below code snippet will demonstrate about the Jump search algorithm technique .
 */

/*
 * Reference :-https://dzone.com/articles/algorithm-week-jump-search
 *             https://www.2braces.com/data-structures/jump-search
 *             http://theoryofprogramming.com/2016/11/10/jump-search-algorithm/
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JumpSearchAlgorithm {
	@SuppressWarnings("resource")
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

		JumpSearchAlgorithm obj = new JumpSearchAlgorithm();
		int result = obj.searchByJumpingOverArray(inputarr, inputarr.length,
				searchitem);
		if (result == 1) {
			System.out.println("Item found successfully.");
		} else {
			System.out.println("Not found successfully.");
		}
	}

	public int searchByJumpingOverArray(Integer[] inputarr, int length,
			int searchitem) throws Exception {

		int root = (int) Math.sqrt(length);
		int right = 0;
		int left = 0;

		if (inputarr != null) {
			while (left < length - 1 && inputarr[left] <= searchitem) {
				right = Math.min(length - 1, left + root);
				if (inputarr[left] <= searchitem
						&& inputarr[right] >= searchitem) {
					break;
				}
				left = left + root;
			}
			if (left >= length - 1 || inputarr[left] > searchitem) {
				return -1;
			}
			right = Math.min(length - 1, right);
			for (int i = left; i <= right && inputarr[i] <= searchitem; i++) {
				if (inputarr[i] == searchitem) {
					System.out.println("Item found at index " + " " + i);
					return 1;
				}
			}
		}
		else{
			throw new Exception("Passed Array is null.");
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
