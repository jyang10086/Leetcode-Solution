import java.util.ArrayList;
import java.util.List;

class LC89 {
  public List<Integer> grayCode(int n) {
    /***
     000
     001
     ---
     011
     010
     -----
     110
     111
     101
     100
     */
    List<Integer> nums = new ArrayList<>();
    if (n < 0) return nums;
    nums.add(0);
    if (n == 0) return nums;
    nums.add(1);
    if (n == 1) return nums;
    for (int i = 1; i < n; i++) {
      int size = nums.size();
      for (int j = size - 1; j >= 0; j--) {
        nums.add(nums.get(j) + (1 << i));
      }
    }
    return nums;
  }
}