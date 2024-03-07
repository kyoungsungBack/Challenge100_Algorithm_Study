package BKS.복습;

public class PGS_땅따먹기 {
    // 20240307 19:52 ~ 20:08
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int answer = 0;
        int n = land.length;
        int[][] dp = new int[n][4];
        dp[0] = land[0].clone();

        // 1. 플로이드-워셜 알고리즘 방식에서 같은 열이 아닐 조건을 추가한다.
        for (int i = 1 ; i < n ; i++) {
            for (int j = 0 ; j < 4 ; j++) {
                for (int k = 0 ; k < 4 ; k++) {
                    if (j == k) {
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i - 1][k]);
                }
            }
        }

        // 2. dp의 마지막 행에서 최댓값을 반환한다.
        for (int i = 0 ; i < 4 ; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }
        System.out.println(answer);
    }
}
