public class TrappingRainWater {
    public int trap(int[] height) {

        int l = 0, r = height.length - 1;
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        int res = 0;
        while (l < r) {
            maxLeft = Math.max(maxLeft, height[l]);
            maxRight = Math.max(maxRight, height[r]);
            if (maxLeft <= maxRight) {
                res += maxLeft - height[l];
                l++;
            } else {
                res += (maxRight - height[r]);
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        TrappingRainWater t = new TrappingRainWater();
        int[] h = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(t.trap(h));
    }
}
