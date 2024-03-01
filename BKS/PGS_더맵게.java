package BKS;

import java.util.PriorityQueue;

public class PGS_더맵게 {
    // 20240301 20:45 ~ 21:20
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 1. pq에 scoville을 오름차순으로 담는다.
        for (int num : scoville) {
            pq.offer(num);
        }

        while (true) {
            int num = pq.peek();

            // 2. 반복문 탈출 조건
            //    -> 크기 1이이거나 pq의 제일 작은 수가 스코빌지수와 같거나 클 때
            if (pq.size() == 1 || num >= K) {
                break;
            }

            // 3. K보다 작은 수가 있으면 섞고 pq에 다시 더 한다.
            int sum = 0;
            sum += pq.poll();
            sum += pq.poll() * 2;

            answer++;
            pq.offer(sum);

        }

        // 4. 반복문 탈출 후 pq의 젤 작은 수가 K보다 작으면
        //    스코빌 지수를 K 이상으로 만들 수 없는 경우이다.
        if (pq.peek() < K) {
            answer = -1;
        }

        System.out.println(answer);
    }
}
