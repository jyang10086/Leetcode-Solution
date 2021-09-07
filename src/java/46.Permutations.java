class LC46 {
  /***
   * Given an array nums of distinct integers, return all the possible permutations.
   * You can return the answer in any order.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [1,2,3]
   * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
   * Example 2:
   *
   * Input: nums = [0,1]
   * Output: [[0,1],[1,0]]
   * Example 3:
   *
   * Input: nums = [1]
   * Output: [[1]]]
   *
   * */
  List<List<Integer>> result;
  // time O(n!)
  public List<List<Integer>> permute(int[] nums) {
    result = new ArrayList<>();
    boolean[] visited = new boolean[nums.length];
    backtrack(nums, new ArrayList(), visited);
    return result;
  }
  private void backtrack(int[] nums, List<Integer> path, boolean[] visited) {
    if (path.size() == nums.length) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) continue;
      visited[i] = true;
      path.add(nums[i]);
      backtrack(nums, path, visited);
      visited[i] = false;
      path.remove(path.size() - 1);
    }
  }
}