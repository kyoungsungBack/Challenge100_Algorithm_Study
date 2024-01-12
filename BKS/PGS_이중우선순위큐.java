package BKS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PGS_이중우선순위큐 {
    // 20240112 11:04 ~ 12:09
    public static void main(String[] args) {
        int[] answer;
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 1. operations 명령어에 따라 삽입, 삭제를 반복한다.
        for (int i = 0 ; i < operations.length ; i++) {
            String[] operation = operations[i].split(" ");

            if ("I".equals(operation[0])) {
                // 삽입
                pqMin.offer(Integer.parseInt(operation[1]));
                pqMax.offer(Integer.parseInt(operation[1]));
            } else if (!pqMax.isEmpty() && "1".equals(operation[1])) {
                // 최댓값 삭제
                int del = pqMax.poll();
                pqMin.remove(del);
            } else if (!pqMin.isEmpty() && "-1".equals(operation[1])) {
                // 최솟값 삭제
                int del = pqMin.poll();
                pqMax.remove(del);
            }
        }

        // 2. pqMax 와 pqMin 의 원소는 동일하므로 한가지로 판단이 가능하다.
        if (pqMax.isEmpty()) {
            answer = new int[]{0, 0};
        } else {
            answer = new int[]{pqMax.peek(), pqMin.peek()};
        }
        System.out.println(Arrays.toString(answer));
    }
}
