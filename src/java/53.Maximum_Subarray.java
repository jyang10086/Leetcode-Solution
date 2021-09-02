class LC53 {
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