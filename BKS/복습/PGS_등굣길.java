package BKS.복습;

public class PGS_등굣길 {
    public static void main(String[] args) {
        int answer = 0;
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        int mod = 1000000007;
        // m : x좌표
        // n : y좌표
        // 즉, (m, n)
        int[][] map = new int[n][m];

        // 물웅덩이 위치 -1로 세팅
        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0] - 1;
            int y = puddles[i][1] - 1;
            map[y][x] = -1;
        }

        map[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }

                if (j != 0) {
                    map[i][j] += map[i][j - 1] % mod;
                }

                if (i != 0) {
                    map[i][j] += map[i - 1][j] % mod;
                }
            }
        }
        answer = map[n - 1][m - 1];
        System.out.println(answer);
    }
}
