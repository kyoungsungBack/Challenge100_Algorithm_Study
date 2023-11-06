package BKS;

import java.util.*;

public class PGS_기능개발 {
    public static void main(String[] args) {
        //int[] progresses = {93, 30, 55};
        //int[] speeds = {1, 30, 5};
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        // 남은 시간을 큐에 담는다
        Queue<Integer> que = new LinkedList<>();
        Map<Integer, Integer> list = new HashMap<>();

        for (int i = 0; i < progresses.length; i++) {
            int num = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            que.offer(num); // 필요한 시간
        }

        int cnt = 0;
        int idx = 0;
        int prev = que.peek();

        while (!que.isEmpty()) {
            int cur = que.poll();

            if (cur <= prev) { // 현재가 이전보다 작으면 cnt 증가
                prev = Math.max(prev, cur);
                cnt++;
                list.put(idx, cnt);
            } else {
                prev = cur;
                idx++;
                cnt = 1;
                list.put(idx, cnt);
            }
        }

        System.out.println(list.values());
    }
}
