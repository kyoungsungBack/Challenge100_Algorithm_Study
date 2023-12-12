package BKS.복습;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PGS_호텔대실 {
    // 20231212 09:19 ~ 09:45
    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"},{"18:20", "21:20"}};
        int answer = 0;

        // 1. 대실 시작시간 기준 오름차순 정렬
        Arrays.sort(book_time, new Comparator<String[]>(){
            int num1;
            int num2;

            @Override
            public int compare(String[] o1, String[] o2) {
                num1 = Integer.parseInt(o1[0].substring(0, 2))*60+Integer.parseInt(o1[0].substring(3, 5));
                num2 = Integer.parseInt(o2[0].substring(0, 2))*60+Integer.parseInt(o2[0].substring(3, 5));
                if (num1 > num2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        // 2. 사용중인 방들 종료시간 기준 오름차순 정렬
        //    int[] {start, end} 가 들어간다.
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        // 3. 현재 대실이 사용중인 방과 연이어 사용되거나
        //    일단 사용하고 큐에 들어간다.
        for (int i = 0 ; i < book_time.length ; i++) {
            int start = Integer.parseInt(book_time[i][0].substring(0, 2)) * 60 + Integer.parseInt(book_time[i][0].substring(3, 5));
            int end = Integer.parseInt(book_time[i][1].substring(0, 2)) * 60 + Integer.parseInt(book_time[i][1].substring(3, 5)) + 10;

            if (pq.isEmpty()) {
                pq.offer(new int[]{start, end});
                answer++;
                continue;
            }

            // 4. 사용가능 방인지 확인
            int[] prev = pq.poll();
            if (prev[1] <= start) {
                pq.offer(new int[]{start, end});
            } else {
                answer++;
                pq.offer(new int[]{start, end});
                pq.offer(prev);
            }
        }
        System.out.println(answer);
    }
}
