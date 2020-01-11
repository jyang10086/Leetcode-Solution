/*Excel(3,"C");
// construct a 3*3 2D array with all zero.
//   A B C
// 1 0 0 0
// 2 0 0 0
// 3 0 0 0

        Set(1, "A", 2);
// set C(1,"A") to be 2.
//   A B C
// 1 2 0 0
// 2 0 0 0
// 3 0 0 0

        Sum(3, "C", ["A1", "A1:B2"]);
// set C(3,"C") to be the sum of value at C(1,"A") and the values sum of the rectangle range
 whose top-left cell is C(1,"A") and bottom-right cell is C(2,"B"). Return 4.
//   A B C
// 1 2 0 0
// 2 0 0 0
// 3 0 0 4

        Set(2, "B", 2);
// set C(2,"B") to be 2. Note C(3, "C") should also be changed.
//   A B C
// 1 2 0 0
// 2 0 2 0
// 3 0 0 6*/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DesignExcelSumFormula {
    public static class Excel {
        /* H is a positive integer, range from 1 to 26.It represents the height.
        W is a character range from 'A' to 'Z'. It represents that the width is the number of characters.*/
        private int[][] m;
        private Map<String, String[]> map;

        public Excel(int H, char W) {
            map = new HashMap<>();
            m = new int[H][W - 'A' + 1];
        }

        public void set(int r, char c, int v) {
            String key = r + "#" + c;
            map.remove(key);
            m[r - 1][c - 'A'] = v;
        }

        public int get(int r, char c) {
            String key = r + "#" + c;
            return map.containsKey(r + "#" + c) ? sum(r, c, map.get(key)) : m[r - 1][c - 'A'];
        }

        // Sum(3, "C", ["A1", "A1:B2"]);
        public int sum(int r, char c, String[] strs) {
            int sum = 0;
            for (String str : strs) {
                String[] splits = str.split(":");
                System.out.println("str: " + Arrays.toString(splits));
                // A1
                if (splits.length <= 1) {
                    sum += get(Integer.parseInt(splits[0].substring(1)), splits[0].charAt(0));
                    //System.out.println(sum);
                } else {
                    //A1:B2
                    int x1 = Integer.parseInt(splits[0].substring(1)) - 1;
                    int x2 = Integer.parseInt(splits[1].substring(1)) - 1;
                    int y1 = splits[0].charAt(0) - 'A';
                    int y2 = splits[1].charAt(0) - 'A';
                    for (int i = x1; i <= x2; i++) {
                        for (int j = y1; j <= y2; j++) {
                            sum += get(i, (char) (j + 'A'));
                        }
                    }
                }
            }
            map.put(r + "#" + c, strs);
            m[r - 1][c - 'A'] = sum;
            return sum;
        }
    }

    public static void main(String[] args) {
//["Excel","set","set","set","sum","get","set","get","sum","set","get","get","sum","set","get","get","get","get","set","get","set","get","get","get"]
//[[5,"E"],
// [1,"A",5],
// [1,"B",3],
// [1,"C",2],
// [1,"C",["A1","A1:B1"]],
// [1,"C"],
// [1,"B",5],[1,"C"],
// [1,"B",["A1:A5"]],
// [5,"A",10],[1,"B"],[1,"C"],[3,"C",["A1:C1","A1:A5"]],
// [3,"A",3],[1,"B"],[1,"C"],[3,"C"],[5,"A"],[1,"C",-5],[3,"C"],[1,"A",6],[1,"C"],[3,"C"],[1,"B"]]
        Excel obj = new Excel(5, 'E');
        obj.set(1, 'A', 5);
        obj.set(1, 'B', 3);


        String[] arr1 = {"A1", "A1:B1"};
        int sum1 = obj.sum(1, 'C', arr1);

        String[] arr2 = {"A1:A5"};
        int sum2 = obj.sum(1, 'B', arr2);

        String[] arr3 = {"A1:C1", "A1:A5"};
        int sum3 = obj.sum(3, 'C', arr2);


        obj.set(1, 'A', 2);

        String[] arr6 = {"B2", "A1:B2"};
        System.out.println(obj.sum(3, 'C', arr6));
        System.out.println(Arrays.deepToString(obj.m));
        System.out.println();
    }
}
