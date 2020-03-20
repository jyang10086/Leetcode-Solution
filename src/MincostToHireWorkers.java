import javafx.util.Pair;

import java.util.*;

public class MincostToHireWorkers {
    // track minimum MAX RATIO -> keep current ratio -> increse order workers list
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            workers.add(new Worker(quality[i], wage[i]));
        }
        // Sort by ratio increasingly
        //O(nlogn)
        Collections.sort(workers, (a, b) -> Double.compare(a.paidRatio, b.paidRatio));

        // Maxheap always pop highest quality
        //O(nlogk)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (int) (b - a));
        int totalQuality = 0;
        double minCost = Double.MAX_VALUE;
        for (Worker worker : workers) {
            maxHeap.offer(worker.quality);
            totalQuality += worker.quality;
            if (maxHeap.size() > K) {
                int popWorkerValue = maxHeap.poll();
                totalQuality -= popWorkerValue;
            }
            if (maxHeap.size() == K) {
                minCost = Math.min(minCost, totalQuality * worker.paidRatio);
            }
        }
        return minCost;
    }

    public class Worker {
        int quality;
        int wage;
        double paidRatio;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            // be careful about int = int / int, double = double / int
            this.paidRatio = wage * 1.0 / quality;
        }
    }
}

