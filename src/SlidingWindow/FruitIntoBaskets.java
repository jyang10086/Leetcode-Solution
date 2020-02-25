package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public int totalFruit(int[] tree) {
        Map<Integer, Integer> baskets = new HashMap<>();
        int start = 0, end;
        int res = 0;
        for (end = 0; end < tree.length; ++end) {
            int fruit = tree[end];
            baskets.put(fruit, baskets.getOrDefault(fruit, 0) + 1);
            while (baskets.size() > 2) {
                //remove old fruit
                int outFruit = tree[start++];
                baskets.put(outFruit, baskets.get(outFruit) - 1);
                baskets.remove(outFruit, 0);
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    //brute force (out of time)
    public int totalFruitTwo(int[] tree) {
        int len = tree.length;
        int res = 0;
        for (int start = 0; start < len; start++) {
            Map<Integer, Integer> baskets = new HashMap<>();
            //System.out.print("start:"+ start + "   ");
            baskets.put(tree[start], 1); // fruit number
            for (int end = start + 1; end < len; end++) {
                if (baskets.size() >= 2 && !baskets.containsKey(tree[end])) {
                    break;
                }
                baskets.put(tree[end], baskets.getOrDefault(tree[end], 0) + 1);
            }
            int cnt = 0;
            for (Map.Entry<Integer, Integer> entry : baskets.entrySet()) {
                //System.out.print(entry.getValue() + " ");
                cnt += entry.getValue();
            }
            res = Math.max(res, cnt);
            //System.out.println();
        }

        return res;
    }

    public static void main(String[] args) {
        FruitIntoBaskets fib = new FruitIntoBaskets();
        int[] arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int res = fib.totalFruit(arr);
        System.out.println(res);


    }


}