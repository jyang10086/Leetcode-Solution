import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountRangeSum {
    class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int count;
        long min;
        long max;

        public SegmentTreeNode(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }

    private SegmentTreeNode buildSegmentTree(Long[] valArr, int low, int high) {
        if (low > high) return null;
        SegmentTreeNode stn = new SegmentTreeNode(valArr[low], valArr[high]);
        System.out.println("[" + valArr[low] + ", " + valArr[high] + "]");
        if (low == high) return stn;
        int mid = (low + high) / 2;
        stn.left = buildSegmentTree(valArr, low, mid);
        stn.right = buildSegmentTree(valArr, mid + 1, high);
        return stn;
    }

    private void updateSegmentTree(SegmentTreeNode stn, Long val) {
        if (stn == null) return;
        if (val >= stn.min && val <= stn.max) {
            stn.count++;
            updateSegmentTree(stn.left, val);
            updateSegmentTree(stn.right, val);
        }
    }

    private int getCount(SegmentTreeNode stn, long min, long max) {
        System.out.println("getCount:[" + min + ", " + max + "]");
        if (stn == null) return 0;
        if (min > stn.max || max < stn.min) return 0;
        if (min <= stn.min && max >= stn.max) return stn.count;
        return getCount(stn.left, min, max) + getCount(stn.right, min, max);
    }


    public int countRangeSumOne(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + nums[i];
        System.out.println(Arrays.toString(sums));
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                System.out.println("d:" + (sums[j] - sums[i]));
                if (sums[j] - sums[i] >= lower && sums[j] - sums[i] <= upper)
                    ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountRangeSum cts = new CountRangeSum();
        int[] nums = {-2, 5, -1};
        Set<Long> valSet = new HashSet<Long>();
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (long) nums[i];
            valSet.add(sum);
        }
        int ans = 0;
        int lower = -2;
        int upper = 2;
        Long[] valArr = valSet.toArray(new Long[0]);
        Arrays.sort(valArr);
        SegmentTreeNode root = cts.buildSegmentTree(valArr, 0, valArr.length - 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.println("sum: " + sum);
            cts.updateSegmentTree(root, sum);
            sum -= (long) nums[i];
            ans += cts.getCount(root, (long) lower + sum, (long) upper + sum);
        }
        System.out.println(ans);
        // System.out.println(cts.countRangeSum(nums, -2, 2));
    }

}
