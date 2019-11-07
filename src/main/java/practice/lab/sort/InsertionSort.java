package practice.lab.sort;

public class InsertionSort {

  public static void main(String[] args) {
    insertionSort(new int[] {12, 2, 1, 6, 14});
  }

  public static void insertionSort(int[] arrayToSort) {
    for (int index = 1; index < arrayToSort.length; index++) {
      for(int backIndex = index - 1; backIndex > 0; backIndex --) {
        if(arrayToSort[backIndex] < arrayToSort[backIndex - 1]) {
          arrayToSort[backIndex] += arrayToSort[backIndex - 1];
          arrayToSort[backIndex - 1] = arrayToSort[backIndex] - arrayToSort[backIndex - 1];
          arrayToSort[backIndex] -= arrayToSort[backIndex - 1];
        }
      }
    }
  }

  public static int fibonacci(int number) {
    return number == 0 ? 0 : number == 1 ? 1 : fibonacci(number - 1) + fibonacci(number -2);
  }

}
