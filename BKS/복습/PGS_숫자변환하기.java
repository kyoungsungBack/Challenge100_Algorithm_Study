package BKS.복습;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PGS_숫자변환하기 {
    // 20240303 15:46 ~ 16:06
    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 5;

        int answer = -1;
        // 0. y -> x로 변환됨을 찾아서 간다.
        // 1. 연산횟수를 오름차순으로 정렬하여 관리한다.
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 2. y와 연산횟수를 pq에 넣는다.
        pq.offer(new int[]{y, 0});

        // 3. x가 y로 변환되는 최소 연산을 찾는다.
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (x == cur[0]) {
                answer = cur[1];
                break;
            }

            if (cur[0] - n >= x) {
                pq.offer(new int[]{cur[0] - n, cur[1] + 1});
            }

            if (cur[0] / 2 >= x && cur[0] % 2 == 0) {
                pq.offer(new int[]{cur[0] / 2, cur[1] + 1});
            }

            if (cur[0] / 3 >= x && cur[0] % 3 == 0) {
                pq.offer(new int[]{cur[0] / 3, cur[1] + 1});
            }
        }

        System.out.println(answer);
    }
}
