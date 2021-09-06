class LC621 {
  /***
   * Example 1:
   *
   * Input: tasks = ["A","A","A","B","B","B"], n = 2
   * Output: 8
   * Explanation:
   * A -> B -> idle -> A -> B -> idle -> A -> B
   * There is at least 2 units of time between any two same tasks.
   *
   *Example 2:
   *
   * Input: tasks = ["A","A","A","B","B","B"], n = 0
   * Output: 6
   * Explanation: On this case any permutation of size 6 would work since n = 0.
   * ["A","A","A","B","B","B"]
   * ["A","B","A","B","A","B"]
   * ["B","B","B","A","A","A"]
   * ...
   * And so on.
   *
   * Example 3:
   *
   * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
   * Output: 16
   * Explanation:
   * One possible solution is
   * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
   *
   *
   * */
  public int leastInterval(char[] tasks, int n) {
    /***
     greedy + heap: 每次执行次数最多的task
     O(N*logK): K为task的种类
     */
    Map<Character, Integer> taskCntMap = new HashMap<>();
    for (char task : tasks) {
      taskCntMap.put(task, taskCntMap.getOrDefault(task, 0) + 1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> pq =
        new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    for (Map.Entry<Character, Integer> task :  taskCntMap.entrySet()) {
      pq.offer(task);
    }
    int totalTimes = 0;
    while (!pq.isEmpty()) {
      int interval = n + 1;
      List<Map.Entry<Character, Integer>> curExec = new ArrayList<>();
      while (interval > 0 && !pq.isEmpty()) {
        Map.Entry<Character, Integer> cur = pq.poll();
        cur.setValue(cur.getValue() - 1);
        curExec.add(cur);
        totalTimes++;
        interval--;
      }
      // 重新入队
      for (Map.Entry<Character, Integer> task : curExec) {
        if (task.getValue() > 0) {
          pq.offer(task);
        }
      }
      if (pq.isEmpty()) break;
      // 剩余idle
      totalTimes += interval;
    }
    return totalTimes;
  }
}