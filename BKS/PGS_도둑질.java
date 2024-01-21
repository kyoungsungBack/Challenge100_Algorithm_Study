package BKS;

public class PGS_도둑질 {
    // 20240121 13:15 ~ 13:25
    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};
        int answer = 0;
        int len = money.length;
        int[] dp = new int[money.length];

        // 인접한 경우의 dp 풀이는는 처음 값을 훔칠지 말지 두 번으로 계산한다.
        // 점화식은 dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[1]) 이다.

        // 1. 첫번째 집을 훔쳤을 때,
        dp[0] = money[0];
        dp[1] = dp[0];
        for (int i = 2 ; i < len - 1 ; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        answer = dp[len - 2];

        // 2. 첫번째 집을 훔치지 않았을 때,
        dp[0] = 0;
        dp[1] = money[1];
        for (int i = 2 ; i < len ; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }

        answer = Math.max(answer, dp[len - 1]);
        System.out.println(answer);
    }
}
