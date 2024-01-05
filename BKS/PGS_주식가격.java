package BKS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGS_주식가격 {
    // 20240105 16:07 ~ 16:15 (복습)
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = new int[prices.length];
        Queue<Integer> que = new LinkedList<>();

        // 1. que에 현재 주식변동 정보를 넣는다.
        for (int price : prices) {
            que.offer(price);
        }

        // 2. 시간유지 배열의 idx를 설정한다.
        int idx = 0;

        // 3. 큐에서 하나씩 값을 빼내어 몇초간 유지되었는지 확인한다.
        while (!que.isEmpty()) {
            // 4. 큐에서 현재 확인할 값을 뺀다.
            int cnt = que.poll();

            // 5. 먼저, 현재 idx의 answer를 0으로 세팅한다.
            answer[idx] = 0;

            // 6. 큐에 담은 주식변동 정보를 확인한다.
            for (Integer integer : que) {
                answer[idx]++;
                // 7. 값이 유지가 안되면(주식이 떨어진 경우) 반복문 탈출한다.
                if (cnt > integer) {
                    break;
                }
            }
            idx++;
        }
        System.out.println(Arrays.toString(answer));
    }
}
