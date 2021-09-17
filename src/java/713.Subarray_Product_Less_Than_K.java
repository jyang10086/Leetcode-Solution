class LC713 {
  /**
   *Given an array of integers nums and an integer k,
   * return the number of contiguous subarrays where
   * the product of all the elements in the subarray is strictly less than k.

   *
   * Input: nums = [10,5,2,6], k = 100
   * Output: 8
   * Explanation: The 8 subarrays that have product less than 100 are:
   * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
   * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
   *
   *
   *
   * */
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k <= 1) return 0;
    // 滑动窗口
    int product = 1;
    int i = 0;
    int num = 0;
    for (int j = 0; j < nums.length; j++) {
      product *= nums[j];
      while (i < nums.length && product >= k) { // 缩短窗口
        product /= nums[i++];
      }
      //[1, 2, 3, 4]满足, 则[1,2,3,4],[2,3,4], [3,4],[4]四个满足
      //[1, 2, 3]满足, 则[1,2,3],[2,3], [3], 三个满足
      num += j - i + 1;
    }
    return num;
  }
}