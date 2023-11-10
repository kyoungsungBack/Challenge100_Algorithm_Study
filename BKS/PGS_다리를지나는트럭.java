package BKS;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_다리를지나는트럭 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        Queue<Integer> que = new LinkedList<>();
        int answer = 0;
        int boardTruckSum = 0;
        int idx = 0;

        for (int i = 0 ; i < bridge_length ; i++) {
            que.offer(0); // que에 다리 길이만큼 0을 세팅해준다.
        }

        while (idx < truck_weights.length) {
            int curTruck = que.poll(); // 하차 트럭
            boardTruckSum -= curTruck; // 현재 다리에 있는 트럭들 무게

            // 대기 트럭의 탑승여부(다리를 한 칸씩 밀어준다고 생각)
            if (boardTruckSum + truck_weights[idx] <= weight) { // 승차 가능
                boardTruckSum += truck_weights[idx];
                que.offer(truck_weights[idx++]);
            } else { // 승차 불가능
                que.offer(0);
            }
            answer++;
        }

        while (!que.isEmpty()) {
            answer++;
            que.poll();
        }

        System.out.println(answer);
    }
}
