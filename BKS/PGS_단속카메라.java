package BKS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class PGS_단속카메라 {
    // 20231216 14:41 ~ 15:41
    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        int answer = 0;

        // 1. 도로진입 시작이 빠른 순서로 오름차순 정렬
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        // 2. 현재 도로에 진입한 차를 Queue에 저장
        Queue<int[]> que = new LinkedList<>();

        for (int i = 0 ; i < routes.length ; i++) {
            // 3.0 차가 도로에 처음 진입할 때
            if (que.isEmpty()) {
                que.offer(routes[0]);
                answer++;
                continue;
            }
            int[] prev = que.peek();
            // 3.1 이전 차가 도로를 빠져나가는 거리를 앞 뒤로 현재 차가 걸쳐있는지 확인
            if (routes[i][0] <= prev[1] && prev[1] <= routes[i][1]) {
                continue;
            } // 3.2 현재 차의 시작 끝 거리가 이전 차가 도로를 빠져나가는 거리보다 작은 경우
            else if (routes[i][0] <= prev[1] && routes[i][1] <= prev[1]) {
                que.poll();
                que.offer(routes[i]);
            } // 3.3 둘 다 아니면 새로운 카메라가 필요
            else {
                que.poll();
                que.offer(routes[i]);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
