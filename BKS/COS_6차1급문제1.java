package BKS;

import java.util.LinkedList;
import java.util.Queue;

public class COS_6차1급문제1 {
    static boolean[][] visited;
    static int[][] map;
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) {
        int n = 3;
        int[][] garden = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        answer = 0;
        visited = new boolean[n][n];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (garden[i][j] == 1) {
                    bfs(i, j, n, garden);
                }
            }
        }

        System.out.println(answer);
    }

    static public void bfs(int y, int x, int n, int[][] garden) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{y, x, 0});
        visited[y][x] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int py = cur[0] + my[i];
                int px = cur[1] + mx[i];

                if (0 <= py && py < n && 0 <= px && px < n) {
                    if (garden[py][px] == 0 && visited[py][px] == false) {
                        visited[py][px] = true;
                        garden[py][px] = 1;
                        que.offer(new int[]{py, px, cur[2] + 1});
                    }
                }
            }
            if (cur[2] > answer) {
                answer++;
            }
        }
    }
}
