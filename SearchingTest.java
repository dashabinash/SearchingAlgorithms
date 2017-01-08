import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchingTest {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception {

		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Enter the size of the Array :");
		int size = sc.nextInt();

		System.out.println("Processing LinearSearch algorithm...");
		int[] arr = new int[size];
		System.out.println("Entering array elements..");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter item for position :" + " " + i);
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter the item you want to search :");
		int item = sc.nextInt();

		SearchingTest obj = new SearchingTest();
		boolean linearflag = obj.linearSearch(arr, item);
		if (linearflag) {
			System.out.println("Searching successful.");
		} else {
			System.out.println("Searching unsuccessful");
		}

		System.out
				.println("Now going to execute all other searching techniques one by one ...");

		Integer[] genericarr = new Integer[size];
		System.out.println("Entering Array elements..");
		for (int i = 0; i < genericarr.length; i++) {
			System.out.println("Enter item for position :" + " " + i);
			genericarr[i] = sc.nextInt();
		}
		System.out.println("Enter the item you want to search");
		int item1 = sc.nextInt();
		List<Integer> list = Arrays.asList(genericarr);
		Collections.sort(list);
		Integer[] binaryarr = new Integer[list.size()];
		binaryarr = (Integer[]) list.toArray();

		System.out.println("Processing BinarySearch algorithm...");
		SearchingTest obj1 = new SearchingTest();
		int binaryresult = obj1
				.binarySearch(binaryarr, item1, binaryarr.length);
		if (binaryresult == 1) {
			System.out.println("searching successful.");
		} else {
			System.out.println("Searching Unsuccessful.");
		}

		System.out.println("Processing JumpSearch algorithm..");
		SearchingTest obj2 = new SearchingTest();
		int jumpresult = obj2.jumpSearch(binaryarr, item1, binaryarr.length);
		if (jumpresult == 1) {
			System.out.println("Searching successful.");
		} else {
			System.out.println("Searching Unsuccessfull.");
		}

		System.out.println("Processing InterpolatingSearch algorithm..");
		SearchingTest obj3 = new SearchingTest();
		int interpolateresult = obj3.interpolationSearch(binaryarr, item1,
				binaryarr.length);
		if (interpolateresult == 1) {
			System.out.println("Searching successful.");
		} else {
			System.out.println("Searching Unsuccessfull.");
		}

	}

	public boolean linearSearch(int[] inputarr, int item) throws Exception {
		boolean flag = false;

		SearchingTest.displayArrayElements(inputarr);
		System.out.println("Starting of LinearSearching process.");
		if (inputarr != null) {
			for (int i : inputarr) {
				if (i == item) {
					System.out.println("Item has been found successfully .");
					flag = true;
					break;
				}
			}
		} else {
			throw new Exception("Passed array is null.");
		}
		return flag;
	}

	public int binarySearch(Integer[] inputarr, int item, int length)
			throws Exception {

		SearchingTest.displayArrayElements(inputarr);
		System.out.println("Starting of BinarySearch process..");
		if (inputarr != null) {
			int middle;
			int upperlimit = length - 1;
			int lowerlimit = 0;

			while (lowerlimit <= upperlimit) {
				middle = (lowerlimit + upperlimit) / 2;

				if (inputarr[middle] == item) {
					System.out
							.println("Element found successfully at position "
									+ middle);
					return 1;
				} else if (item > inputarr[middle]) {
					lowerlimit = middle + 1;
				} else {
					upperlimit = middle - 1;
				}
			}
		} else {
			throw new Exception("Passed Array is null.");
		}
		return -1;
	}

	public int jumpSearch(Integer[] inputarr, int item, int length)
			throws Exception {

		int left = 0;
		int right = 0;
		int root;

		SearchingTest.displayArrayElements(inputarr);
		System.out.println("Starting of JumpSearh Process..");
		if (inputarr != null) {
			root = (int) Math.sqrt(length);
			while (left <= length && inputarr[left] <= item) {

				right = Math.min(length - 1, left + root);
				if (inputarr[root] >= inputarr[left]
						&& inputarr[root] <= inputarr[right]) {
					break;
				}
				left = left + root;
			}

			if (left >= length - 1 && inputarr[left] > item) {
				return -1;
			}

			right = Math.min(length - 1, right);
			for (int i = left; i <= right && inputarr[i] <= item; i++) {
				if (inputarr[i] == item) {
					return 1;
				}
			}

		} else {
			throw new Exception("Passed array is null.");
		}
		return -1;
	}

	public int interpolationSearch(Integer[] inputarr, int item, int length)
			throws Exception {

		int upperlimit = length - 1;
		int lowerlimit = 0;
		System.out.println("Starting of Interpolation search process..");
		if (inputarr != null) {
			int pos;
			while (lowerlimit <= upperlimit) {
				pos = (int) (lowerlimit + (((double) (upperlimit - lowerlimit) / (inputarr[upperlimit] - inputarr[lowerlimit])) * (item - inputarr[lowerlimit])));

				if (inputarr[pos] == item) {
					System.out.println("Item found successfully at position :"
							+ " " + pos);
					return 1;
				} else if (inputarr[pos] < item) {
					lowerlimit = pos + 1;
				} else {
					upperlimit = pos - 1;
				}
			}

		} else {
			throw new Exception("Passed array is null.");
		}
		return -1;
	}

	private static void displayArrayElements(Integer[] inputarr) {
		for (int i = 0; i < inputarr.length; i++) {
			System.out.print(inputarr[i] + " ");
		}
		System.out.println();

	}

	public static void displayArrayElements(int[] inputarr) {
		for (int i = 0; i < inputarr.length; i++) {
			System.out.print(inputarr[i] + " ");
		}
		System.out.println();
	}
}
