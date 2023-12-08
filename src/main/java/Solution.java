import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(
                point -> -distance(point)
        ));
        for (int[] point : points){
            if(pq.size() == k){
                if(distance(pq.peek()) > distance(point)){
                    pq.poll();
                    pq.offer(point);
                }
            }else pq.offer(point);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
    private double distance(int[] point){
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }
}
