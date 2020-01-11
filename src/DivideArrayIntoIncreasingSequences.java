public class DivideArrayIntoIncreasingSequences {
    /*
    Given a non-decreasing array of positive integers nums and an integer K,
    find out if this array can be divided into one or more disjoint increasing subsequences of length at least K.
    * */
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        //将出现次数最多的数字，全部拆开到不同子序列。其它重复的数字也用同样的思路分配。
        // 剩余的不重复的数字均匀分配到这些子序列中。这些子序列一定是严格递增子序列。
        // 例如：nums = [1,2,2,3,3,4,4], K = 3
        //
        //        最大出现的次数是2, 将序列至少分成2个。
        //
        //        2，3，4都出现2次。分配在两个子序列中。[2,3,4]和[2,3,4]。
        //
        //        1随机分配到其中一个序列。[1,2,3,4]和[2,3,4]。
        int maxFreq = 1;
        int freq = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                freq = 1;
            } else {
                freq++;
            }
            if (freq > maxFreq) {
                maxFreq = freq;
            }
        }
        return nums.length >= maxFreq * K;
    }
}
