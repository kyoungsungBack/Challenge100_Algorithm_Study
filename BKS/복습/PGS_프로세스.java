package BKS.복습;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PGS_프로세스 {
    // 20240304 17:25 ~ 18:01 21:00 ~ 21:17 (36분 + 17분 = 53분)
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = 1;
        Queue<int[]> que = new LinkedList<>();

        // 1.1. priorities를 내림차순으로 정렬한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 1.2. int[] 에는 int[0] 인덱스, int[1] 우선순위 를 세팅한다.
        int idx = 0;
        for (int priority : priorities) {
            pq.offer(priority);
            que.offer(new int[]{idx++, priority});
        }

        // 2. que가 빌 때 까지 프로세스를 실행하고 원하는 위치의 프로세스 발견하면 종료한다.
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            // 3.1. 현재 가장 큰 수이며, 원하는 위치이면 반복문 탈출한다.
            if (cur[1] == pq.peek() && cur[0] == location) {
                break;
            } // 3.2. 현재 que 중에 가장 큰 수 이면 answer 1증가, pq poll한다.
            else if (cur[1] ==  pq.peek() && cur[0] != location) {
                answer++;
                pq.poll();
            } // 3.3. 나갈 순서도 아니도 작은 수이면 다시 que에 담는다.
            else {
                que.offer(cur);
            }
        }
        System.out.println(answer);
    }
}
