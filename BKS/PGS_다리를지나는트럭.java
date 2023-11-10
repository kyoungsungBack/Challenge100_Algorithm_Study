package BKS;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_다리를지나는트럭 {
    public static void main(String[] args) {
        int[] truck_weights = {7,4,5,6};
        int bridge_length = 2;
        int weight = 10;
        Queue<Integer> queue = new LinkedList<>();
        int weightSum = 0;
        int answer = 0, index = 0;

        for (int i = 0; i < bridge_length; i++) queue.offer(0);

        while (index < truck_weights.length) {
            int n = queue.poll();
            weightSum = weightSum - n;
            if (weightSum + truck_weights[index] <= weight) {
                weightSum += truck_weights[index];
                queue.offer(truck_weights[index++]);
            } else {
                queue.offer(0);
            }
            answer += 1;
        }

        while (!queue.isEmpty()) {
            answer += 1;
            queue.poll();
        }

        System.out.println(answer);
    }
}
