package BKS.복습;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGS_다리를지나는트럭 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        int answer = 0;
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0 ; i < bridge_length ; i++) {
            que.offer(0);
        }

        int curBridge = 0;
        int i = 0;
        while (!que.isEmpty()) {
            if (i == truck_weights.length) {
                break;
            }

            curBridge -= que.poll();
            if (curBridge + truck_weights[i] <= weight && que.size() <= bridge_length) {
                curBridge += truck_weights[i];
                que.offer(truck_weights[i]);
                i++;
            } else {
                que.offer(0);
            }
            answer++;
        }

        while (!que.isEmpty()) {
            que.poll();
            answer++;
        }
        System.out.println(answer);
    }
}
