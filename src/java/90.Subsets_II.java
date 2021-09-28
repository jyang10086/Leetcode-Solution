class Solution {
  List<List<Integer>> result;
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    result = new ArrayList<>();
    if (nums.length == 0) return result;
    backtrack(0, nums, new ArrayList<>());
    return result;
  }
  private void backtrack(int idx, int[] nums, List<Integer> subset) {
    result.add(new ArrayList<>(subset));
    if (idx >= nums.length) {
      return;
    }
    for (int i = idx; i < nums.length; i++) {
      if (i > idx && nums[i] == nums[i - 1]) continue;
      subset.add(nums[i]);
      backtrack(i + 1, nums, subset);
      subset.remove(subset.size() - 1);
    }
  }
}