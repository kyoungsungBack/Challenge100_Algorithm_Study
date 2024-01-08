package BKS.복습;

public class PGS_스티커모으기 {
    // 20240108 15:35 ~ 16:16
    public static void main(String[] args) {
        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        int answer = 0;
        int len = sticker.length;

        // 1. dp배열에는 해당 idx까지의 스티커 최대합을 저장한다.
        int[] dp = new int[len];

        // 2. 스티커의 길이가 1이면 종료한다.
        if (sticker.length == 1) {
            System.out.println(sticker[0]);
        }

        // 3. 첫번째 스티커를 뽑은 경우
        dp[0] = sticker[0];
        dp[1] = dp[0];


        for (int i = 2 ; i < sticker.length - 1 ; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }

        answer = dp[len - 2];

        // 4. 첫번째 스티커를 뽑지 않은 경우
        dp[0] = 0;
        dp[1] = sticker[1];

        for (int i =  2; i < sticker.length ; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }

        answer = Math.max(answer, dp[len - 1]);
        System.out.println(answer);
    }
}
