import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> records = new HashMap<>();
        for (int[] trans : transactions) {
            records.put(trans[0], records.getOrDefault(trans[0], 0) + trans[2]);
            records.put(trans[1], records.getOrDefault(trans[1], 0) - trans[2]);
        }

        List<Integer> balance = new ArrayList<>();
        for (int value : records.values()) {
            if (value != 0) {
                balance.add(value);
            }
        }

        return dfs(0, 0, balance);
    }

    public int dfs(int idx, int num, List<Integer> balance) {
        System.out.println("idx:" + idx + "   " + balance.toString());
        int n = balance.size();
        while (idx < n && balance.get(idx) == 0) {
            idx++;
        }
        int res = Integer.MAX_VALUE;
        if (idx == n) {
            // account doesn`t change, return num
            return Math.min(res, num);
        }

        //jump already changed balance records
        int cur = balance.get(idx);
        for (int i = idx + 1; i < n; i++) {
            int next = balance.get(i);
            if (next * cur < 0) {
                balance.set(i, next + cur);
                res = Math.min(res, dfs(idx + 1, num + 1, balance));
                balance.set(i, next);
                if (next + cur == 0) {
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        OptimalAccountBalancing oab = new OptimalAccountBalancing();
        int[][] arrays = {{0, 1, 2}, {1, 2, 4}, {4, 2, 1}, {2, 3, 2}};
        int[][] arrays2 = {{2, 0, 5}, {3, 4, 4}};
        int ans = oab.minTransfers(arrays);
        System.out.println(ans);
    }
}
