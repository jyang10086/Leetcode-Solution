class LC41 {
  /**
   * 41. First Missing Positive
   * <p>
   * Given an unsorted integer array nums, return the smallest missing positive integer.
   * <p>
   * You must implement an algorithm that runs in O(n) time and uses constant extra space.
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [1,2,0]
   * Output: 3
   * Example 2:
   * <p>
   * Input: nums = [3,4,-1,1]
   * Output: 2
   * Example 3:
   * <p>
   * Input: nums = [7,8,9,11,12]
   * Output: 1
   */
  public int firstMissingPositive(int[] nums) {
    // i + 1 == nums[i]
    // for i in (0...len)
    //    swap(num, i, nums[i] - 1)
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] - 1 < nums.length && nums[i] > 0 && nums[i] != nums[nums[i] - 1]) {
        swap(nums, i, nums[i] - 1);
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (i + 1 != nums[i]) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }

  private void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }

  public static void main(String[] args) {
    LC41 l = new LC41();
    int[] l1 = {1, 2, 0};
    int[] l2 = {3, 4, -1, 1};
    int s = l.firstMissingPositive(l2);
    System.out.println(s);
  }
}