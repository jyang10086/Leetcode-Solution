class LC207 {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> edges = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      edges.add(new ArrayList<Integer>());
    }
    int N = prerequisites.length;
    int[] inDegree = new int[numCourses];
    for (int[] pre : prerequisites) {
      edges.get(pre[1]).add(pre[0]);
      inDegree[pre[0]]++;
    }
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        q.offer(i);
      }
    }
    int idx = 0;
    while (!q.isEmpty()) {
      int pre = q.poll();
      idx++;
      for (int cur : edges.get(pre)) {
        if (--inDegree[cur] == 0) {
          q.offer(cur);
        }
      }
    }
    return idx == numCourses;
  }
}