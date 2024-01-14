package BKS;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PGS_숫자반환하기 {
    // 20240114 15:13 ~ 15:41
    public static void main(String[] args) {
        int answer = 0;
        int x = 10;
        int y = 40;
        int n = 5;
        // pq : [0]번째는 수, [1]번째는 횟수
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 0. y부터 x를 찾는 방식으로 진행한다.
        pq.offer(new int[] {y, 0});

        // 1. 횟수가 가장 적은 수부터 확인해 나간다.
        //    합, 곱(x -> y)으로 구하면 메모리 초과되므로
        //    차, 나누기(y -> x)으로 구하면 된다.
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            // 2. 0번째에 답이 나올 수 있으므로 return 한다.
            if (cur[0] == x) {
                answer = cur[1];
                break;
                //return cur[1]; 원래 문제에서 사용해야함
            }

            // 3.1. 현재 수의 차가 x보다 크거나 같다면 pq에 담는다.
            if ((cur[0] - n) >= x) {
                pq.offer(new int[] {cur[0] - n, cur[1] + 1});
            }

            // 3.2. 현재 수가 2로 나눠지고 x보다 크거나 같다면 pq에 담는다.
            if ((cur[0] % 2) == 0 && (cur[0] / 2) >= x) {
                pq.offer(new int[] {cur[0] / 2, cur[1] + 1});
            }

            // 3.3. 현재 수가 3으로 나눠지고 x보다 크거나 같다면 pq에 담는다.
            if ((cur[0] % 3) == 0 && (cur[0] / 3) >= x) {
                pq.offer(new int[] {cur[0] / 3, cur[1] + 1});
            }
        }

        // 4. 구할 수 없는 수 이면 -1을 반환한다.
        if (answer == 0) {
            answer = -1;
        }

        System.out.println(answer);
    }

}
