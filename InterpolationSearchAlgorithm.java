package com.dash.abinash.InterpolationSearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * The below code snippet will demonstrate about the technique of Interpolation searching technique .
 */
public class InterpolationSearchAlgorithm {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Enter the size of the Array :");
		int size = sc.nextInt();
		Integer[] arr = new Integer[size];
		System.out.println("Enter Array elements..");
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter item at " + i + ": ");
			arr[i] = sc.nextInt();
		}

		List<Integer> list = Arrays.asList(arr);
		Integer[] inputarr = new Integer[list.size()];
		Collections.sort(list);
		inputarr = (Integer[]) list.toArray();

		System.out.println("Display of Array elements..");
		for (int i = 0; i < inputarr.length; i++) {
			System.out.print(inputarr[i] + " ");
		}
		System.out.println();
		System.out.println("Enter the item to search :");
		int item = sc.nextInt();

		InterpolationSearchAlgorithm obj = new InterpolationSearchAlgorithm();
		int result = obj.searchByInterpolatingOverArray(inputarr,
				inputarr.length, item);
		if (result == 1) {
			System.out.println("Searching successful.");
		} else {
			System.out.println("Searching umsuccessful.");
		}
	}

	public int searchByInterpolatingOverArray(Integer[] inputarr, int length,
			int searchitem) throws Exception {

		int upperlimit = length - 1;
		int lowerlimit = 0;
		int position;

		if (inputarr != null) {
			while (lowerlimit <= upperlimit
					&& inputarr[lowerlimit] <= searchitem
					&& inputarr[upperlimit] >= searchitem) {
				position = (int) (lowerlimit + (((double) (upperlimit - lowerlimit) / (inputarr[upperlimit] - inputarr[lowerlimit])) * (searchitem - inputarr[lowerlimit])));

				if (searchitem == inputarr[position]) {
					System.out.println("Item found at " + position);
					return 1;
				} else if (searchitem > inputarr[position]) {
					lowerlimit = position + 1;
				} else {
					upperlimit = position - 1;
				}
			}
		} else {
			throw new Exception("Passed array is null .");
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