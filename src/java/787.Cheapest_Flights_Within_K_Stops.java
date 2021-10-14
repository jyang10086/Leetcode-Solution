class LC787 {
  // bfs
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int[][] graph = new int[n][n];
    for(int[] flight : flights){
      graph[flight[0]][flight[1]] = flight[2];
    }
    Queue<int[]> queue = new LinkedList<>();
    int[] dis = new int[n];
    Arrays.fill(dis, Integer.MAX_VALUE);
    queue.offer(new int[]{src, 0, k});
    while (!queue.isEmpty()) {
      int[] tmp = queue.poll();
      int cur = tmp[0], price = tmp[1], step = tmp[2];
      if (step < 0) {
        continue;
      }
      for (int i = 0; i < graph[cur].length; i++) {
        if (graph[cur][i] == 0) continue;
        int p = graph[cur][i] + price;
        if (p < dis[i]) {
          queue.offer(new int[]{i, p, step - 1});
          dis[i] = p;
        }
      }
    }
    return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];

  }
}