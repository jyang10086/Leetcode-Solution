import java.util.Arrays;

public class KEmptySlots {

    public int kEmptySlots(int[] bulbs, int K) {
        int[] slots = new int[bulbs.length];
        for (int i = 0; i < bulbs.length; i++) {
            //day
            int curPos = bulbs[i] - 1;
            slots[curPos] = 1;
            Arrays.stream(slots).forEach(num -> System.out.print(num + " "));
            System.out.println("cur:" + curPos);

            //check k position before cur
            if (curPos - K - 1 >= 0) {
                if (slots[curPos - K - 1] == 1) {
                    int j;
                    for (j = 1; j <= K; j++) {
                        if (slots[curPos - j] == 1) {
                            break;
                        }
                    }
                    if (j - 1 == K) {
                        return i + 1;
                    }
                }
            }

            //check k position after cur
            if (curPos + K + 1 < slots.length) {
                if (slots[curPos + K + 1] == 1) {
                    int k;
                    for (k = 1; k <= K; k++) {
                        if (slots[curPos + k] == 1) {
                            break;
                        }
                    }
                    if (k - 1 == K) {
                        return i + 1;
                    }
                }
            }


        }
        return -1;
    }

    //[6,5,8,9,7,1,10,2,3,4]
    public static void main(String[] args) {
        KEmptySlots kes = new KEmptySlots();
        int res = kes.kEmptySlots(new int[]{6, 5, 8, 9, 7, 1, 10, 2, 3, 4}, 2);
        System.out.println(res);
    }

}
