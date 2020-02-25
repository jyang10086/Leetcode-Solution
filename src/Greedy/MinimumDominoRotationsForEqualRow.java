package Greedy;

public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int result = check(A[0], A, B);
        return result != -1 ? result : check(B[0], A, B);
    }

    private int check(int key, int[] A, int[] B) {
        int rotationA = 0, rotationB = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != key && B[i] != key) {
                return -1;
            } else if (A[i] != key) {
                rotationA += 1;
            } else if (B[i] != key) {
                rotationB += 1;
            }
        }
        return Math.min(rotationA, rotationB);
    }


    public static void main(String[] args) {
        int[] A = {2, 1, 2, 4, 2, 2};
        int[] B = {5, 2, 6, 2, 3, 2};
        MinimumDominoRotationsForEqualRow mdrgger = new MinimumDominoRotationsForEqualRow();
        System.out.println(mdrgger.minDominoRotations(A, B));
    }
}
