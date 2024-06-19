package BKS.복습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGS_기능개발 {
    // 20231203 21:13 ~ 21:34
    // 20240619 22:18 ~ 22:52
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0 ; i < progresses.length ; i++) {
            int num1 = 100 - progresses[i];
            int num2 = num1 % speeds[i] == 0 ? num1 / speeds[i] : (num1 / speeds[i]) + 1;
            que.offer(num2);
        }

        int temp = que.peek();
        int cnt = 0;
        while (!que.isEmpty()) {
            int cur = que.peek();

            if (temp >= cur) {
                cnt++;
                que.poll();
            } else {
                list.add(cnt);
                cnt = 0;
                temp = que.peek();
            }
        }
        list.add(cnt);

        int[] answer = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++) {
            answer[i] = list.get(i);
        }
        System.out.println(Arrays.toString(answer));
    }
}
