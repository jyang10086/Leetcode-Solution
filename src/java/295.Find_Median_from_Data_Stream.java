import java.util.PriorityQueue;

// LC295
class MedianFinder {
  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;

  /**
   * initialize your data structure here.
   */
  public MedianFinder() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>((a, b) -> {
      return b - a;
    });
  }

  public void addNum(int num) {
    // all the elements of minHeap are greater than or equal to the peek of maxHeap
    if (minHeap.isEmpty() || num >= minHeap.peek()) {
      minHeap.add(num);
    } else {
      maxHeap.add(num);
    }
    // make sure minHeap has one more element than or equal to maxHeap
    if (minHeap.size() == maxHeap.size() + 2) {
      maxHeap.offer(minHeap.remove());
    } else if (minHeap.size() + 1 == maxHeap.size()) {
      minHeap.offer(maxHeap.remove());
    }
  }

  public double findMedian() {
    if (minHeap.size() == maxHeap.size()) {
      return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
    return minHeap.peek();
  }
}