package BKS.복습;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PGS_이중우선순위큐 {
    // 20240301 23:00 ~ 23:26 복습
    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] answer = {};
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }); // 내림차순

        for (int i = 0 ; i < operations.length ; i++) {
            String[] str = operations[i].split(" ");
            // 1. 삽입(I)이면 pq1, pq2 둘 다 넣는다.
            if ("I".equals(str[0])) {
                pq1.offer(Integer.parseInt(str[1]));
                pq2.offer(Integer.parseInt(str[1]));
            } // 2. 삭제(D)이면 최대와 최소를 구분한다.
            else {
                // 2.0. pq가 비었으면 무시한다.
                if (pq2.isEmpty() || pq1.isEmpty() ) {
                    continue;
                }

                // 2.1. 큐에서 최댓값을 삭제한다.
                if ("1".equals(str[1])) {
                    int num = pq2.poll();
                    pq1.remove(num);
                } // 2.2. 큐에서 최솟값을 삭제한다.
                else {
                    int num = pq1.poll();
                    pq2.remove(num);
                }
            }
        }

        if (pq1.isEmpty()) {
            answer = new int[]{0, 0};
        } else {
            answer = new int[]{pq2.peek(), pq1.peek()};
        }

        System.out.println(Arrays.toString(answer));
    }
}
