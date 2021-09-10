class MinStack {

  Deque<Integer> stack;
  private int min = Integer.MAX_VALUE;
  public MinStack() {
    stack = new LinkedList<>();
  }

  public void push(int x) {
    if (x <= min) {
      // 存储上一次的最小值
      stack.push(min);
      min = x;
    }
    stack.push(x);
  }

  public void pop() {
    if (stack.pop() == min) {
      min = stack.pop();
    };
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min;
  }
}