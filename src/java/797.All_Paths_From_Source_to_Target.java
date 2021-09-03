import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
 * find all possible paths from node 0 to node n - 1 and return them in any order.
 * <p>
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i
 * (i.e., there is a directed edge from node i to node graph[i][j]).
 * <p>
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */
class Solution {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> allPaths = new ArrayList<>();
    dfs(graph, new ArrayList<>(), allPaths, 0);
    return allPaths;
  }

  private void dfs(int[][] graph, List<Integer> path, List<List<Integer>> allPaths, int cur) {
    if (cur == 0) {
      path.add(cur);
    }
    if (cur == graph.length - 1) {
      allPaths.add(new ArrayList<>(path));
      return;
    }
    for (int nextNode : graph[cur]) {
      path.add(nextNode);
      dfs(graph, path, allPaths, nextNode);
      path.remove(path.size() - 1);
    }
  }
}