package BKS.복습;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PGS_야근지수 {
    // 20240109 17:06 ~ 17:18
    public static void main(String[] args) {
        long answer = 0;
        int[] works = {4, 3, 3};
        int n = 4;

        // 1. 내림차순 기준으로 pq를 생성한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 2. 일의 양을 내림차순으로 pq에 적재한다.
        for (int work : works) {
            pq.offer(work);
        }

        // 3. n시간 만큼 매번 가장 일을 1씩 감소한다.
        while (!pq.isEmpty()) {
            if (n == 0) {
                break;
            }

            int work = pq.poll();

            if (work != 0) {
                pq.offer(work - 1);
                n--;
            }
        }

        // 4. 남은 일들은 제곱하여 더한 뒤 반환한다.
        for (int work : pq) {
            answer += Math.pow(work, 2);
        }
        System.out.println(answer);
    }
}
