package BKS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGS_거리두기확인하기 {
    // 20230102 18:57 ~

    static int[] mx = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] my = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] answer;

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        answer = new int[places.length];

        // Queue에 P를 담아서 함수 실행
        for (int k = 0; k < places.length; k++) {
            sol(places[k], k);
        }

        System.out.println(Arrays.toString(answer));
    }

    public static void sol(String[] place, int len) {
        int res = 1;
        Queue<int[]> que = new LinkedList<>();

        // 1. que에 모든 P를 담는다.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    que.add(new int[]{i, j});
                }
            }
        }

        // 2. 맨허튼 거리 안에 P가 있는 경우
        // 2.1 P와 P 사이에 파티션이 있는지 없는지 확인
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int k = 0; k < 8; k++) {
                int py = cur[0] + my[k];
                int px = cur[1] + mx[k];

                // 범위 안에만 확인
                // cur[0], px 와 py, cur[1] 이 둘 다 파티션이면 true
                if (0 <= py && py < 5 && 0 <= px && px < 5) {
                    if (place[py].charAt(px) == 'P' && (place[cur[0]].charAt(px) != 'X' || place[py].charAt(cur[1]) != 'X')) {
                        res = 0;
                        break;
                    }
                }
            }
        }

        answer[len] = res;
    }
}

