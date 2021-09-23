class LC53 {
    /*
      * A subarray is a contiguous part of an array.
      * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
      * Output: 6
      * Explanation: [4,-1,2,1] has the largest sum = 6.
     */
  public int maxSubArray(int[] nums) {
    /**
     dp[i] :  max
     (dp[i - 1] + num,  num)
     */
    int result = nums[0];
    int pre = 0;
    for (int num : nums) {
      pre = Math.max(pre + num, num);
      result = Math.max(pre, result);
    }
    return result;
  }
}