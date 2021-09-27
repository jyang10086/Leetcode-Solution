/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
/**
 *
 * The definition of a celebrity is that all the other n - 1 people know him/her,
 * but he/she does not know any of them.
 *
 *
 *
 * Input: graph = [[1,1,0],[0,1,0],[1,1,1]]
 * Output: 1
 * Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.
 *
 * */
class LC277 extends Relation {
  /***
   O(n) greedy
   */
  public int findCelebrity(int n) {
    int i = 0;
    for (int j = 1; j < n; j++) {
      if (knows(i, j)) {
        i = j;
      }
    }
    for (int k = 0; k < n; k++) {
      if (k == i) {
        continue;
      }
      if (knows(i, k) || !knows(k, i)) {
        return -1;
      }
    }
    return i;
  }
}