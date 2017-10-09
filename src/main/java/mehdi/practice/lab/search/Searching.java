package mehdi.practice.lab.search;

import java.util.Arrays;

public class Searching {

	public static int binarySerach(int[] arr, int element) {

		int length = arr.length;
		int mid = (length / 2);

		if (element == arr[mid])
			return mid + 1;
		else if (element > arr[mid])
			return binarySerach(Arrays.copyOfRange(arr, mid + 1, length), element) + mid + 1;
		else
			return binarySerach(Arrays.copyOfRange(arr, 0, mid), element);

	}
}
