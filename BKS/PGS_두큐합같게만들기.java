package BKS;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_두큐합같게만들기 {
    // 20240221 18:49 ~ 19:56
    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        int answer = 0;
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        int len = queue1.length;

        for (int num : queue1) {
            sum1 += num;
            que1.offer(num);
        }

        for (int num : queue2) {
            sum2 += num;
            que2.offer(num);
        }

        while (true) {
            if (sum1 > sum2) {
                int tmp = que1.poll();
                sum1 -= tmp;
                sum2 += tmp;
                que2.offer(tmp);
                answer++;
            } else if (sum1 < sum2) {
                int tmp = que2.poll();
                sum2 -= tmp;
                sum1 += tmp;
                que1.offer(tmp);
                answer++;
            } else {
                break;
            }

            if (answer >= len * 3) {
                break;
            }
        }

        if (answer >= len * 3) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }
}
