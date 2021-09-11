class MyHashSet {
  class Node {
    int val;
    Node next;
    public Node(int val) {
      this.val = val;
    }
  }
  Node[] map;
  int N = 16;
  /** Initialize your data structure here. */
  public MyHashSet() {
    this.map = new Node[N];
  }


  // O(k) 链表长度
  public void add(int key) {
    int hash = getHashIdx(key);
    Node node = map[hash];
    if (node == null) {
      map[hash] = new Node(key);
    } else {
      Node prev = node;
      while (node != null) {
        // already exist
        if (node.val == key) {
          return;
        }
        prev = node;
        node = node.next;
      }
      prev.next = new Node(key);
    }
  }

  // O(k) 链表长度
  public void remove(int key) {
    int hash = getHashIdx(key);
    Node node = map[hash];
    if (node == null) {
      return;
    }
    if (node.val == key) {
      map[hash] = node.next;
      return;
    }
    Node prev = node;
    node = node.next;
    while (node != null) {
      if (node.val == key) {
        prev.next = node.next; // delete
        return;
      }
      prev = node;
      node = node.next;
    }
  }

  /** Returns true if this set contains the specified element */
  // O(k) 链表长度
  public boolean contains(int key) {
    int hash = getHashIdx(key);
    Node node = map[hash];
    while (node != null) {
      if (node.val == key) {
        return true;
      }
      node = node.next;
    }
    return false;
  }

  private int getHashIdx(int key) {
    int h = Objects.hashCode(key);
    int hash = h ^ (h >>> 16);
    return (N - 1) & hash;
  }
}