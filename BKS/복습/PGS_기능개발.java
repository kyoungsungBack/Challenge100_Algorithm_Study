package BKS.복습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGS_기능개발 {
    // 20231203 21:13 ~ 21:34
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();

        int day = 0;
        for (int i = 0; i < progresses.length; i++) {
            day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] == 0) {
                que.add(day);
            } else {
                que.add(day + 1);
            }

        }

        // 남은시간이 100이 넘어가면 계속 poll해주고 그만큼 개수를 answer에 담는다.
        while (!que.isEmpty()) {
            int cnt = 1;
            int cur = que.poll();

            while (!que.isEmpty() && cur >= que.peek()) {
                que.poll();
                cnt++;
            }

            list.add(cnt);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }
}
