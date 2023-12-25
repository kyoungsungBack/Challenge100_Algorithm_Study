package BKS;

public class PGS_스티커모으기2 {
    // 20231225 17:31 ~ 17:42
    public static void main(String[] args) {
        int answer = 0;
        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};

        int n = sticker.length;
        if (n == 1) {
            System.out.println(sticker[0]);
            return;
        }

        int[] dp = new int[n];

        // 1. 첫번째 스티커를 뗄 때의 dp를 작성한다. (원형을 이루므로 마지막은 필요없다.)
        dp[0] = sticker[0];
        dp[1] = dp[0];
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], sticker[i] + dp[i - 2]);
        }
        answer = dp[n - 2];

        // 2. 두번째 스티커를 뗄 때의 dp를 작성한다.
        dp[0] = 0;
        dp[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], sticker[i] + dp[i - 2]);
        }

        // 3. 첫, 두 번째의 스티커를 뗄 때의 dp값 중에 최대를 골라 반환한다.
        System.out.println(Math.max(dp[n - 1], answer));
    }
}
