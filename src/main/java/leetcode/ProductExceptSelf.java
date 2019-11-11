package leetcode;

public class ProductExceptSelf {
  public static int[] productExceptSelf(int[] nums) {
    int[] left = new int[nums.length];
    int[] right = new int[nums.length];
    left[0] = 1;
    right[right.length - 1] = 1;

    for(int index=1; index < nums.length; index++) {
      left[index] = left[index-1] * nums[index - 1];
    }

    for(int index = nums.length - 2; index >= 0; index--) {
      right[index] = right[index + 1] * nums[index + 1];
    }

    int[] products = new int[nums.length];

    for(int index=0; index < nums.length; index++) {
      products[index] = left[index] * right[index];
    }
    return products;

  }
}
