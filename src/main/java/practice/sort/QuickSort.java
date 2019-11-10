package practice.sort;

public class QuickSort {

	public void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int divideIndex = partition(arr, low, high);
			partition(arr, low, divideIndex - 1);
			partition(arr, divideIndex + 1, high);
		}
	}

	private int partition(int[] arr, int low, int high) {
		int indexAfterLastSwitched = low;
		int pivot = arr[high];

		for (int i = low; i < high; i++) {
			if (arr[i] <= pivot) {
				int temp = arr[indexAfterLastSwitched];
				arr[indexAfterLastSwitched] = arr[i];
				arr[i] = temp;
				indexAfterLastSwitched++;
			}
		}

		int temp = arr[indexAfterLastSwitched];
		arr[indexAfterLastSwitched] = pivot;
		arr[high] = temp;

		return indexAfterLastSwitched;
	}
}
