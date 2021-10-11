/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class LC690 {
  // bfs O(n)
  public int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> map = new HashMap<>();
    for (Employee employee : employees) {
      map.put(employee.id, employee);
    }
    Queue<Employee> queue = new LinkedList<>();
    queue.offer(map.get(id));
    int sum = 0;
    while (!queue.isEmpty()) {
      Employee cur = queue.poll();
      sum += cur.importance;
      for (int subId : cur.subordinates) {
        queue.offer(map.get(subId));
      }
    }
    return sum;
  }
  // dfs O(n)
  public int getImportance2(List<Employee> employees, int id) {
    Map<Integer, Employee> map = new HashMap<>();
    for (Employee employee : employees) {
      map.put(employee.id, employee);
    }
    return dfs(map, id);
  }

  private int dfs(Map<Integer, Employee> map, int id) {
    Employee cur = map.get(id);
    int sum = cur.importance;
    for (int subId : cur.subordinates) {
      sum += dfs(map, subId);
    }
    return sum;
  }

}