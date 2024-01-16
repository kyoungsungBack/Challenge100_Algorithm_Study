package BKS;

import java.util.Collections;
import java.util.PriorityQueue;

public class PGS_프로세스 {
    // 20240116 09:32 ~ 09:39 (복습)
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = 0;

        // 1. 우선순위가 높은 순으로 내림차순 정렬한다.
        for (int priority : priorities) {
            pq.offer(priority);
        }

        // 2. 높은 우선순위부터 하나씩 제거하며 실행횟수를 증가시킨다.
        while (!pq.isEmpty()) {
            for (int i = 0 ; i < priorities.length ; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    // 3. 찾으려는 알파벳의 위치일 경우 실행횟수를 반환한다.
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }
    }
}
