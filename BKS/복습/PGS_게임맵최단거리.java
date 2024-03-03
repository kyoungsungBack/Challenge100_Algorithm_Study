package BKS.복습;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_게임맵최단거리 {
    // 20240303 16:12 ~ 16:33
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};
    static int[][] map;
    static int m, n;
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        int answer = -1;
        m = maps.length;
        n = maps[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> que = new LinkedList<>();

        // 0. 시작점을 세팅한다.
        que.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        // 1. 가장 최소의 거리로 상대진영을 가는 길을 찾는다.
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            // 2. 상대팀 진영에 도착한 경우 현재까지의 거리를 반환한다.
            if (cur[0] == m - 1 && cur[1] == n - 1) {
                answer = cur[2];
                break;
            }

            // 3. 상,하,좌,우 방향으로 갈 수 있는 곳을 탐색한다.
            for (int i = 0 ; i < 4 ; i++) {
                int py = cur[0] + my[i];
                int px = cur[1] + mx[i];

                // 3.1. 범위 안에 있고
                if (0 <= py && py < m && 0 <= px && px < n) {
                    // 3.2. 방문 전이면서 갈 수 있으면 간다.
                    if (!visited[py][px] && maps[py][px] == 1) {
                        visited[py][px] = true;
                        que.offer(new int[]{py, px, cur[2] + 1});
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
