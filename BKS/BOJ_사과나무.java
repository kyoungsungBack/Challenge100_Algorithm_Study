package BKS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_사과나무 {
    // 20241028 23:27 ~
    static int N;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = -1001;
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= N ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 누적합을 세팅한다.
        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + board[i][j];
            }
        }

        // 2. 바깥 2중 반복문은 2차원 배열의 시작점을 의미한다.
        for (int y1 = 1 ; y1 <= N ; y1++) {
            for (int x1 = 1 ; x1 <= N ; x1++) {

                // 3. 안쪽 2중 반복문은 시작점 기준으로 1 ~ N 크기의 정사각형 합을 의미한다.
                for (int y2 = y1 ; y2 <= N ; y2++) {
                    for (int x2 = x1 ; x2 <= N ; x2++) {
                        // 3.1. 정사각형이 아닌 경우
                        if (y2 - y1 != x2 - x1) continue;
                        int res = dp[y2][x2] - dp[y1 - 1][x2] - dp[y2][x1 - 1] + dp[y1 - 1][x1 - 1];

                        answer = Math.max(answer, res);
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
