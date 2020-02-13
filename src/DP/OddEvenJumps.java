package DP;

import com.sun.codemodel.internal.JForEach;

import java.util.Arrays;
import java.util.TreeMap;

public class OddEvenJumps {
    /***
     * [10,13,12,14,15]
     *
     * odd numbered jumps   A[i] <= A[j] and A[j] is the smallest possible value greater ceiling
     * even numbered jumps  A[i] >= A[j] and A[j] is the largest possible value  less   floor
     ***/
    public int oddEvenJumps(int[] A) {
        int len = A.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                result++;
                break;
            }
            int idx = i;
            System.out.println("i:" + idx);
            while (idx < len) {
                // odd jump
                idx = getCeiling(A, idx);
                System.out.println("odd:" + idx);
                if (idx == len - 1) {
                    result++;
                    break;
                } else if (idx == -1) {
                    break;
                }

                //even jump
                idx = getFloor(A, idx);
                System.out.println("even:" + idx);
                if (idx == len - 1) {
                    result++;
                    break;
                } else if (idx == -1) {
                    break;
                }
            }
        }
        return result;
    }

    private int getFloor(int[] a, int i) {
        int max = a[i];
        int min = Integer.MIN_VALUE;
        int minIdx = -1;
        while (++i < a.length) {
            if (a[i] == max) {
                return i;
            }
            if (max > a[i] && a[i] > min) {
                min = a[i];
                minIdx = i;
            }
        }
        return minIdx;

    }

    private int getCeiling(int[] a, int i) {
        int min = a[i];
        int max = Integer.MAX_VALUE;
        int minIdx = -1;
        while (++i < a.length) {
            if (a[i] == min) {
                return i;
            }
            if (min < a[i] && a[i] < max) {
                max = a[i];
                minIdx = i;
            }
        }
        return minIdx;
    }


    //Solution :treeMap
    // ceiling least  >= key   odd
    // floor   greatest <= key  even
    public int oddEvenJumpsTwo(int[] A) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int len = A.length;
        boolean[] odd = new boolean[A.length];
        boolean[] even = new boolean[A.length];
        int i = len - 1;
        odd[i] = true;
        even[i] = true;
        treeMap.put(A[i], i);
        int result = 0;
        while (i >= 0) {
            //odd step
            Integer ceiling = treeMap.ceilingKey(A[i]);
            if (ceiling != null) {
                odd[i] = even[treeMap.get(ceiling)];
            }
            //even step
            Integer floor = treeMap.floorKey(A[i]);
            if (floor != null) {
                even[i] = odd[treeMap.get(floor)];
            }
            if (odd[i]) {
                result++;
            }
            treeMap.put(A[i], i);
            i--;
        }

        return result;

    }

    public static void main(String[] args) {
        int[] arr = {10, 13, 12, 14, 15};
        OddEvenJumps oej = new OddEvenJumps();
        int res1 = oej.oddEvenJumps(arr);
        System.out.println(res1);
        int res2 = oej.oddEvenJumpsTwo(arr);
        System.out.println(res2);
    }

}
