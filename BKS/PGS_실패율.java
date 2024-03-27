package BKS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PGS_실패율 {
    // 20240327 18:56 ~ 19:20 19:30 ~ 20:10 21:40 ~ 21:55 (119분)
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int[] answer = new int[N];
        // 1. 우선순위 큐에 2차원 배열을 담고 실패율로 내림차순하고 같으면 작은번호로 정렬한다.
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>(){
            @Override
            public int compare(double[] o1, double[] o2) {
                // 이때, 0번째는 stage, 1번째는 실패율이다.
                if (o1[1] == o2[1]) {
                    return (int)(o1[0] - o2[0]);
                } else {
                    if (o2[1] > o1[1]) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });

        HashMap<Integer, Integer> map = new HashMap<>();

        // 2. 각 스테이지 단계에 있는 인원을 센다.
        for (int stage : stages) {
            if (map.get(stage) == null) {
                map.put(stage, 1);
            } else {
                map.put(stage, map.get(stage) + 1);
            }
        }

        int mok = stages.length;
        // 3. pq에 스테이지별 실패율을 담는다.
        for (int i = 1 ; i <= N ; i++) {
            // 4.1. 스테이지에 머무른 인원 없으면 실패율 0이다.
            if (map.get(i) == null) {
                pq.offer(new double[]{(double)i, 0});
            } // 4.2. 스테이지가 증가할수록 도달한 플레이어는 줄어드므로 이전 단계에 머무른 인원 뺀다.
            else {
                pq.offer(new double[]{(double)i, map.get(i) / (double)mok});
                mok -= map.get(i);
            }
        }

        int idx = 0;
        // 5. 실패율로 정렬된 스테이지를 배열에 담고 반환한다.
        while (!pq.isEmpty()) {
            answer[idx++] = (int)pq.poll()[0];
        }
        System.out.println(Arrays.toString(answer));
    }
}
