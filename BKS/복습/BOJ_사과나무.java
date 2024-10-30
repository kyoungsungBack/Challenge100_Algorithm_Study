package BKS.복습;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_사과나무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];
        long answer = -1001;

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= N ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1. 현재 농장의 누적합을 구한다.
        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + board[i][j];
            }
        }

        // 2. 누적합에서 1 ~ K 길이인 정사각형 합 중에 최대를 구한다.
        for (int k = 1 ; k <= N ; k++) {
            for (int i = k ; i <= N ; i++) {
                for (int j = k ; j <= N ; j++) {
                    int cal = dp[i][j] - dp[i - k][j] - dp[i][j - k] + dp[i - k][j - k];
                    answer = Math.max(answer, cal);
                }
            }
        }

        bw.append(String.valueOf(answer));
        bw.flush();

    }
}
