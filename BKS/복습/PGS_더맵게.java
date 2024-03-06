package BKS.복습;

import java.util.PriorityQueue;

public class PGS_더맵게 {
    // 20240306 13:55 ~ 14:06
    public static void main(String[] args) {
        int answer = 0;
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        // 1. 스코빌 지수를 오름차순으로 관리할 pq를 선언한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : scoville) {
            pq.offer(num);
        }

        // 2. pq.size()가 1이하 일 때 까지 스코빌 지수를 찾는다.
        while (pq.size() > 1) {
            int cur = pq.peek();

            // 2.1. pq.peek()가 K이상 이면 반복문 탈출한다.
            if (cur >= K) {
                break;
            }

            // 2.2. 새로 계산된 스코빌 지수를 pq에 넣는다.
            cur = pq.poll();
            cur += pq.poll() * 2;
            pq.offer(cur);

            // 2.3. 섞은 횟수를 증가한다.
            answer++;
        }

        // 3. 만약 pq에 남은 원소가 K보다 작으면 -1을 반환한다.
        if (pq.peek() < K) {
            answer = -1;
        }

        System.out.println(answer);
    }
}
