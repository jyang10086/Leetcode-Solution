import java.util.*;

class LC743 {
  /**
   * BFS:
   * time: O(Nlog(N) + E)
   * space: O(N + E)
   */
  public int networkDelayTime(int[][] times, int n, int k) {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] edge : times) {
      if (!graph.containsKey(edge[0] - 1)) {
        graph.put(edge[0] - 1, new ArrayList<int[]>());
      }
      graph.get(edge[0] - 1).add(new int[]{edge[1] - 1, edge[2]});
    }

    // sort by distance
    // <node, distance>
    Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.add(new int[]{k - 1, 0});
    int res = 0;
    boolean[] visited = new boolean[n];
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int node = cur[0], step = cur[1];
      if (visited[node]) continue;
      visited[node] = true;
      res = step;
      n--;
      if (!graph.containsKey(node)) continue;
      for (int[] next : graph.get(node)) {
        pq.offer(new int[]{next[0], step + next[1]});
      }
    }
    return n == 0 ? res : -1;
  }
}