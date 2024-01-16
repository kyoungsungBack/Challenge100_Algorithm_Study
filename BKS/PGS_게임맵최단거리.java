package BKS;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_게임맵최단거리 {
    // 20240115 10:57 ~ 11:21
    static int[][] map;
    static int N, M;
    static int[] my = {0, 0, -1 ,1};
    static int[] mx = {-1, 1, 0, 0};
    static int answer;
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        answer = Integer.MAX_VALUE;
        N = maps.length;
        M = maps[0].length;

        map = new int[N][M];

        // 1. map을 행렬로 세팅한다.
        for (int i = 0 ; i < N ; i++) {
            map[i] = maps[i].clone();
        }

        sol(new boolean[N][M]);

        System.out.println(answer);
    }

    public static void sol(boolean[][] visited) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0, 1});

        visited[0][0] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == (N - 1) && cur[1] == (M - 1)) {
                answer = Math.min(answer, cur[2]);
            }

            for (int i = 0 ; i < 4 ; i++) {
                int py = cur[0] + my[i];
                int px = cur[1] + mx[i];

                if (0 <= py && py < N && 0 <= px && px < M) {
                    if (visited[py][px] == false && map[py][px] == 1) {
                        visited[py][px] = true;
                        que.offer(new int[]{py, px, cur[2] + 1});
                    }
                }
            }
        }

        if (answer == Integer.MAX_VALUE) answer = -1;

    }
}
