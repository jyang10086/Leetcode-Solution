class LC47 {
  /*
  *
  * Given a collection of numbers, nums, that might contain duplicates,
  * return all possible unique permutations in any order.
  Example 1:
  Input: nums = [1,1,2]
  Output:
  [[1,1,2],
   [1,2,1],
   [2,1,1]]
   *
  Example 2:
  Input: nums = [1,2,3]
  Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  **/
  List<List<Integer>> result = new ArrayList<>();

  // time O(n!)
  public List<List<Integer>> permuteUnique(int[] nums) {
    if (nums.length == 0) return result;
    Arrays.sort(nums);
    boolean[] visited = new boolean[nums.length];
    backtrack(nums, new ArrayList(), visited);
    return result;
  }

  private void backtrack(int[] nums, List<Integer> path, boolean[] visited) {
    if (path.size() == nums.length) {
      result.add(new ArrayList(path));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) continue;
      if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;
      path.add(nums[i]);
      visited[i] = true;
      backtrack(nums, path, visited);
      path.remove(path.size() - 1);
      visited[i] = false;
    }
  }
}