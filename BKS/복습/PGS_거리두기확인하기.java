package BKS.복습;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGS_거리두기확인하기 {
    // 20240110 15:14 ~ 15:41
    static int[] my = {0, 0, -1, 1, 1, 1, -1, -1, 0, 0, -2, 2};
    static int[] mx = {-1, 1, 0, 0, 1, -1, -1, 1, 2, -2, 0, 0};
    static char[][] map;
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] answer = new int[places.length];

        for (int i = 0 ; i < places.length ; i++) {
            answer[i] = sol(places[i]);
        }

        System.out.println(Arrays.toString(answer));
    }

    public static int sol(String[] place) {
        map = new char[5][5];
        Queue<int[]> que = new LinkedList<>();

        // 1. 강의실 및 사람위치를 세팅한다.
        for (int i = 0 ; i < 5 ; i++) {
            for (int j = 0 ; j < 5 ; j++) {
                if (place[i].charAt(j) == 'P') {
                    que.offer(new int[]{i, j});
                }
                map[i][j] = place[i].charAt(j);
            }
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            // 2. 상하좌우 대각선을 확인한다.
            for (int i = 0 ; i < 8 ; i++) {
                int py = cur[0] + my[i];
                int px = cur[1] + mx[i];
                if (0 <= py && py < 5 && 0 <= px && px < 5) {
                    // map[py][cur[1]] == 'O' || map[cur[0]][px] == 'O' 로 하면 상하좌우일 때 조건성립이 안된다.
                    if (map[py][px] == 'P' && (map[py][cur[1]] != 'X' || map[cur[0]][px] != 'X')) {
                        return 0;
                    }
                }
            }
            // 3. 상하좌우 두 칸을 확인한다.
            for (int i = 8 ; i < 12 ; i++) {
                int py = cur[0] + my[i];
                int px = cur[1] + mx[i];
                if (0 <= py && py < 5 && 0 <= px && px < 5) {
                    int y = (cur[0] + py) / 2;
                    int x = (cur[1] + px) / 2;

                    if (map[py][px] == 'P' && map[y][x] == 'O') {
                        return 0;
                    }
                }
            }
        }

        return 1;
    }
}
