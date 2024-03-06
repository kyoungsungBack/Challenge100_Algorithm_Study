package BKS.복습;

public class PGS_도둑질 {
    // 20240306 09:12 ~ 09:25
    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};
        int answer = 0;

        // 1. 원형으로 이어져 있으므로 첫번째 집을 훔치냐 안훔치냐로 DP를 구한다.
        int N = money.length;
        int[] dp = new int[N];

        // 2.1. 첫번째 집을 훔칠 때의 DP를 작성한다.
        dp[0] = money[0];
        dp[1] = dp[0];
        for (int i = 2 ; i < N - 1 ; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        answer = dp[N - 2];

        // 2.2. 첫번째 집을 안훔칠 때의 DP를 작성한다.
        dp[0] = 0;
        dp[1] = money[1];
        for (int i = 2 ; i < N ; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }

        // 3. N-1 와 N-2 인덱스를 가진 DP의 값을 비교하여 최댓값을 반환한다.
        answer = Math.max(answer, dp[N - 1]);
        System.out.println(answer);
    }
}
