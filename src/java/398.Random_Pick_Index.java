import java.util.Random;

/***
 *
 *
 * Given an integer array nums with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 *
 * Implement the Solution class:
 *
 * Solution(int[] nums) Initializes the object with the array nums.
 *
 * int pick(int target) Picks a random index i from nums where nums[i] == target.
 *
 * If there are multiple valid i's, then each index should have an equal probability of returning.
 *  
 *
 * Example 1:
 *
 * Input
 * ["Solution", "pick", "pick", "pick"]
 * [[[1, 2, 3, 3, 3]], [3], [1], [3]]
 * Output
 * [null, 4, 0, 2]
 *
 * **/
class LC398 {
  // hashmap
  // Map<Integer, List<Integer>> map;
  // public Solution(int[] nums) {
  //   map = new HashMap<>();
  //   for (int i = 0; i < nums.length; i++) {
  //     map.putIfAbsent(nums[i], new ArrayList());
  //     map.get(nums[i]).add(i);
  //   }
  // }

  // public int pick(int target) {
  //   Random r = new Random();
  //   int i = r.nextInt(map.get(target).size());
  //   return map.get(target).get(i);
  // }


  /***
   蓄水池抽样
   */
  int[] nums;

  public LC398(int[] nums) {
    this.nums = nums;
  }

  public int pick(int target) {
    Random r = new Random();
    int idx = 0, cnt = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        cnt++;
        // 第一次选取时的概率与之后选取时概率相同
        if (r.nextInt(cnt) == 0) {
          idx = i;
        }
      }
    }
    return idx;
  }
}
