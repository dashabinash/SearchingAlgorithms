package com.dash.abinash.LinearSearch;

/*
 * The following code snippet will demonstrate about the Linear searching .
 */
public class LinearSearchAlgorithm {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Enter size of array :");
		int size = sc.nextInt();
		int[] numarr = new int[size];

		System.out.println("Entering array elements ...");
		for (int i = 0; i < numarr.length; i++) {
			numarr[i] = sc.nextInt();
		}

		System.out.println("Enter item to search :");
		int item = sc.nextInt();
		LinearSearchAlgorithm obj = new LinearSearchAlgorithm();
		int result = obj.searchLineralyOverArray(numarr, item);
		if (result == 1) {
			System.out.println("Element has been found.");
		} else {
			System.out.println("Element has not been found.");
		}

	}

	public int searchLineralyOverArray(int[] arr, int item) {

		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == item) {
					return 1;
				}
			}
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
