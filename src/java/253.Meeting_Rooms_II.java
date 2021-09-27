class LC253 {
  /**
   * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
   * return the minimum number of conference rooms required.
   *
   * Example 1:
   *
   * Input: intervals = [[0,30],[5,10],[15,20]]
   * Output: 2
   *
   * Example 2:
   *
   * Input: intervals = [[7,10],[2,4]]
   * Output: 1
   *  
   *
   * */
  public int minMeetingRooms(int[][] intervals) {
    /**
     1. sort arr by start time
     2. priority queue (minHeap, sort by end time)
     compare earliest ending time with cur meeting start time
     if  <= , pop heap
     O(nlogn + nlogk)
     18mins
     */
    if (intervals.length <= 1) return intervals.length;
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    PriorityQueue<int[]> currMeetings = new PriorityQueue<>(
        (a, b) -> a[1] - b[1]);
    int room = 0;
    for (int i = 0; i < intervals.length; i++) {
      int[] cur = intervals[i];
      if (!currMeetings.isEmpty()) {
        int[] earliestEnd =  currMeetings.peek();
        if (earliestEnd[1] <= cur[0]) {
          currMeetings.poll();
        }
      }
      currMeetings.offer(cur);
      room = Math.max(room, currMeetings.size());
    }
    return room;
  }
}