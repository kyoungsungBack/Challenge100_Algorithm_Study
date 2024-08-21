package BKS;

public class PGS_순위 {
    // 20240821 21:35 ~ 22:35
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int answer = 0;

        int[][] map = new int[n + 1][n + 1];
        // 플로이드-워셜 알고리즘 적용
        // 이기면 1, 지면 2

        // 1. 배열에 각 번호들의 승패를 기록한다.
        for (int[] result : results) {
            int w = result[0];
            int l = result[1];
            map[w][l] = 1;
            map[l][w] = 2;
        }

        // 2. 세 점에 대해 항상 이기는 경우와 지는 경우를 기록한다.
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                for (int k = 1 ; k <= n ; k++) {
                    if (map[i][j] == 1 && map[j][k] == 1) {
                        map[i][k] = 1;
                        map[k][i] = 2;
                    }

                    if (map[i][j] == 2 && map[j][k] == 2) {
                        map[i][k] = 2;
                        map[k][i] = 1;
                    }
                }
            }
        }

        // 3. 각 번호의 모든 경기 결과를 알 수 있는 경우만 등수를 알 수 있다.
        for (int i = 1 ; i <= n ; i++) {
            int cnt = 0;
            for (int j = 1 ; j <= n ;j++) {
                if (map[i][j] == 1 || map[i][j] == 2) {
                    cnt++;
                }
            }

            if (cnt == n - 1) answer++;
        }

        System.out.println(answer);
    }
}
