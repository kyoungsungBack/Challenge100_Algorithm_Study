package BKS;

public class PGS_등굣길 {
    static int[][] map;
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        int answer = 0;
        int mod = 1000000007;
        map = new int[n][m];
        // 집에서 학교까지 갈 수 있는 최단경로의 개수를 구하시오.

        // 지도에 물덩이 세팅
        for (int i = 0 ; i < puddles.length ; i++) {
            for (int j = 0 ; j < puddles[0].length ; j++) {
                int x = puddles[i][0] - 1;
                int y = puddles[i][1] - 1;
                map[y][x] = -1;
            }
        }

        map[0][0] = 1;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                // map의 값이 int범위를 넘을 수 있다
                // 효율성에서만 오류날 때는 자료형의 크기를 고려하자.
                if (i != 0) map[i][j] += map[i - 1][j] % mod;
                if (j != 0) map[i][j] += map[i][j - 1] % mod;
            }
        }

        answer = map[n - 1][m - 1] % mod;

        System.out.println(answer);
    }
}
