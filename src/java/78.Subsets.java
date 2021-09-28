class LC78 {
  List<List<Integer>> result;
  public List<List<Integer>> subsets(int[] nums) {
    result = new ArrayList<>();
    backtrack(0, nums, new ArrayList<>());
    return result;
  }
  private void backtrack(int idx, int[] nums, List<Integer> subset) {
    result.add(new ArrayList<>(subset));
    if (idx >= nums.length) {
      return;
    }
    for (int i = idx; i < nums.length; i++) {
      subset.add(nums[i]);
      backtrack(i + 1, nums, subset);
      subset.remove(subset.size() - 1);
    }
  }
}