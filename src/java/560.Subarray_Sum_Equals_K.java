import java.util.HashMap;
import java.util.Map;

class LC560 {
  /**
   * Given an array of integers nums and an integer k,
   * return the total number of continuous subarrays whose sum equals to k.
   * <p>
   *  
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [1,1,1], k = 2
   * Output: 2
   * Example 2:
   * <p>
   * Input: nums = [1,2,3], k = 3
   * Output: 2
   *  
   */
  public int subarraySum(int[] nums, int k) {
    /***
     s[i] - s[j] = k
     */
    Map<Integer, Integer> map = new HashMap<>(); // <sum, cnt>
    int sum = 0;
    int cnt = 0;
    map.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (map.containsKey(sum - k)) {
        cnt += map.get(sum - k);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return cnt;
  }
}