package BKS.복습;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PGS_프로세스 {
    // 20240304 17:25 ~ 18:01 21:00 ~ 21:17 (36분 + 17분 = 53분)
    // 20240620 22:25 ~ 22:50
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = 0;

        Queue<int[]> que = new LinkedList<>();
        int cnt = 0;

        for (int i = 0 ; i < priorities.length ; i++) {
            que.offer(new int[]{i, priorities[i]});
        }

        while (true) {
            int[] cur = que.poll();
            boolean isOut = true;

            // 현재 본인보다 큰 수가 있으면 다시 들어간다.
            for (int[] temp : que) {
                if (cur[1] < temp[1]) {
                    isOut = false;
                    break;
                }
            }

            // 현재 빠져나갈 차례고 찾으려는 순번이면 종료한다.
            if (isOut) {
                cnt++;
                if (cur[0] == location) {
                    answer = cnt;
                    break;
                }
            } else {
                que.offer(cur);
            }
        }

        System.out.println(answer);
    }
}
