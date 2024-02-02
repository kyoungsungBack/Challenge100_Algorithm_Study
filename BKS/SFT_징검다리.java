package BKS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SFT_징검다리 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        int[] bridge = new int[N];
        int[] dp = new int[N];
        int res = 1;
        Arrays.fill(dp, 1);

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            bridge[i]  = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j <= i ; j++) {
                if (bridge[i] > bridge[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0 ; i < N ; i++) {
            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
    }
}
