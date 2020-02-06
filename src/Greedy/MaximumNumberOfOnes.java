package Greedy;

import java.util.PriorityQueue;

/***
 * 1183. Maximum Number of Ones
 * Input: width = 3, height = 3, sideLength = 2, maxOnes = 1
 * Output: 4
 * Explanation:
 * In a 3*3 matrix, no 2*2 sub-matrix can have more than 1 one.
 * The best solution that has 4 ones is:
 * [1,0,1]
 * [0,0,0]
 * [1,0,1]
 */
public class MaximumNumberOfOnes {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        int[][] sm = new int[sideLength][sideLength];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sm[i % sideLength][j % sideLength]++;
            }
        }

        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                pq.add(sm[i][j]);
            }
        }
        int ans = 0, i = 0;
        while (i++ < maxOnes) {
            ans += pq.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumNumberOfOnes mno = new MaximumNumberOfOnes();
        int res = mno.maximumNumberOfOnes(3, 3, 2, 1);
        System.out.println(res);
    }
}

// Solution2
//public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
//    int ans = 0;
//    PriorityQueue<Integer> pq = new PriorityQueue<>();
//    for(int i = 0; i < sideLength; ++i)
//        for(int j = 0; j < sideLength; ++j) {
//            pq.add(((width - 1 - i) / sideLength + 1) * ((height - 1 - j) / sideLength + 1));
//            if(pq.size() > maxOnes)
//                pq.poll();
//        }
//    while(!pq.isEmpty())
//        ans += pq.poll();
//    return ans;
//}
