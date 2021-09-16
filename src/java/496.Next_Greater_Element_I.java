class LC496 {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    /***
     单调栈: O(n)
     */
    int[] res = new int[nums1.length];
    Stack<Integer> stack = new Stack();
    HashMap<Integer, Integer> hasMap = new HashMap<>();
    for (int num : nums2) {
      // 从前往后遍历，栈顶元素找到比自己大的元素则记录到map
      while (!stack.isEmpty() && stack.peek() < num) {
        hasMap.put(stack.pop(), num);
      }
      stack.push(num);
    }
    for (int i = 0; i < nums1.length; i++) {
      res[i] = hasMap.getOrDefault(nums1[i], -1);
    }
    return res;

  }
}