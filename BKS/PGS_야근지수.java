package BKS;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PGS_야근지수 {
    // 20230103
    public static void main(String[] args) {
        int[] works = {4, 3, 3};
        int n = 4;

        long answer = 0;
        // pq에 대해 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : works) {
            pq.offer(num);
        }

        for (int i = 0 ; i < n ; i++) {
            int cur = pq.poll();

            // 제일 적은 수인 0이 빠졌으면 반복문 종료
            if (cur == 0) break;

            pq.offer(cur - 1);
        }

        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }

        System.out.println(answer);
    }
}
