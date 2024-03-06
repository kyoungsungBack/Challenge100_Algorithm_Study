package BKS.복습;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_두큐합같게만들기 {
    // 20240306 14:26 ~ 14:48
    public static void main(String[] args) {
        int answer = -1;
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};

        // 1. 두 큐를 비교하기 위해 큐 2개와 각 합 변수를 생성한다.
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;

        // 2.1. que1에 원소를 넣고 합을 구한다.
        for (int num : queue1) {
            que1.offer(num);
            sum1 += num;
        }

        // 2.2. que2에 원소를 넣고 합을 구한다.
        for (int num : queue2) {
            que2.offer(num);
            sum2 += num;
        }


        int curCnt = 0;
        int num = 0;

        // 3. 최대로 확인해 볼 수 있는 횟수는 300000이다.
        while (curCnt <= 300000) {
            // 3.1. 두 큐 중의 하나라도 빈 값이면 두 큐를 같게 만들 수 없다.
            if (que1.isEmpty() || que2.isEmpty()) {
                break;
            }

            // 3.2. 두 큐의 합이 같으면 반복문 탈출한다.
            if (sum1 == sum2) {
                answer = curCnt;
                break;
            } // 3.3. 합이 큰 쪽의 원소를 빼고 다른 쪽으로 옮긴다.
            else if (sum1 > sum2) {
                num = que1.poll();
                que2.offer(num);
                sum1 -= num;
                sum2 += num;
            } else {
                num = que2.poll();
                que1.offer(num);
                sum2 -= num;
                sum1 += num;
            }

            curCnt++;
        }

        System.out.println(answer);
    }
}
