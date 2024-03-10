package BKS.복습;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGS_주식가격 {
    // 20240110 12:17 ~ 12:45
    // 20240308 22:00 ~ 10:49 (다시)
    // 20240310 21:28 ~ 21:34
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = new int[prices.length];
        Queue<Integer> que = new LinkedList<>();

        // 1. 나열된 주식가격을 que에 적재한다.
        for (int price : prices) {
            que.offer(price);
        }

        int idx = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();

            // 2. 현재 가격과 que에 남아있는 가격들을 비교한다.
            for (int price : que) {
                answer[idx]++;
                if (cur > price) {
                    break;
                }
            }
            idx++;
        }

        System.out.println(Arrays.toString(answer));
    }
}
