package BKS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PGS_호텔대실 {
    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        //String[][] book_time = {{"09:10", "10:10"}, {"10:20", "12:20"}};
        int answer = 0;

        // 2 현재 사용중인 방, 종료시간 기준으로 오름차순
        //  (다른 예약의 시작시간과 비교하여 같은 객실이용이 가능한지 판단의 근거)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] == o2[1]) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        // 1 시작시간을 기준으로 오름차순 정렬
        Arrays.sort(book_time, new Comparator<String[]>() {
            public int compare(String[] o1, String[] o2) {
                if (o1[0].contentEquals(o2[0])) { // 시작시간이 같은 경우 종료시간 으로 오름차순
                    return o1[1].compareTo(o2[1]);
                } else {
                    return o1[0].compareTo(o2[0]);
                }
            }
        });

        // 3 대실가능한 방을 pq에 넣고 하나씩 꺼내서 현재 방이 들어갈 수 있는지 확인하는 반복문
        for (int i = 0; i < book_time.length; i++) {
            // 4 대실시간에 대해 분으로 변경(계산의 용이를 위해)
            int start = Integer.parseInt(book_time[i][0].substring(0, 2)) * 60 + Integer.parseInt(book_time[i][0].substring(3, 5));
            int end = Integer.parseInt(book_time[i][1].substring(0, 2)) * 60 + Integer.parseInt(book_time[i][1].substring(3, 5)) + 10;

            // 5 처음 예약은 무조건 사용됨
            if (pq.isEmpty()) {
                pq.offer(new int[]{start, end});
                answer++;
                continue;
            }

            // 6 이전 예약과 현재 예약에 같은 방 사용가능한지 확인
            int[] prev = pq.poll();
            if (start >= prev[1]) { // 같은 방 대실이 가능한 경우
                pq.offer(new int[]{start, end});
            } else { // 같은 방 대실이 불가능한 경우
                answer++;
                pq.offer(new int[]{start, end});
                pq.offer(prev); // 현재 대실된 방을 위에서 뺐지만 계속 사용되야 하므로
            }
        }

        System.out.println(answer);
        //return answer;
    }
}
