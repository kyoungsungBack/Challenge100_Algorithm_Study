package BKS;

public class PGS_순위 {
    // 20240821 21:35 ~ 22:35
    // 20240824 15:10 ~ 15:33 (복습)
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int answer = 0;

        int[][] map = new int[n + 1][n + 1];
        // 플로이드-워셜 알고리즘 적용
        // 이기면 1, 지면 2

        // 1. 먼저, 정확하게 순위를 매길 수 있는 선수의 수를 구하는 법을 찾는다.
        // -> n명이 참여할 때 (n - 1)의 경기 결과를 보유한 경우가 존재
        for (int[] result : results) {
            int a = result[0];
            int b = result[1];

            map[a][b] = 1;
            map[b][a] = 2;
        }

        // 2. 선수 A, B, C가 있을 때 A가 B를 이기고 B는 C를 이기면 A는 C를 이긴다
        // -> 플로이드-워셜 알고리즘 적용(이기고 지는 경우 동일)
        for (int k = 1 ; k <= n ; k++) {
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                        map[j][i] = 2;
                    }
                }
            }
        }


        // 3. 경기 결과를 바탕으로 (n-1)개의 결과를 보유한 선수의 수를 반환한다.
        for (int i = 1 ; i <= n ; i++) {
            int cnt = 0;
            for (int j = 1 ; j <= n ; j++) {
                if (i != j && map[i][j] != 0) cnt++;
            }

            if (cnt == (n - 1)) answer++;
        }

        System.out.println(answer);
    }
}
