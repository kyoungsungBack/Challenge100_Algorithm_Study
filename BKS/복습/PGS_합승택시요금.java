package BKS.복습;

import java.util.Arrays;

public class PGS_합승택시요금 {
    // 20240108 16:25 ~ 16:39
    public static void main(String[] args) {
        int answer = 20000001;
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        int[][] map = new int[n + 1][n + 1];
        for (int i = 1 ; i <= n ; i++) {
            Arrays.fill(map[i], 20000001);
        }

        for (int i = 0 ; i < fares.length ; i++) {
            int u = fares[i][0];
            int v = fares[i][1];
            map[u][v] = fares[i][2];
            map[v][u] = fares[i][2];
        }

        for (int i = 1 ; i <= n ; i++) {
            map[i][i] = 0;
        }

        for (int k = 1 ; k <= n ; k++) {
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        for (int i = 1 ; i <= n ; i++) {
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
        }
        System.out.println(answer);
    }
}
