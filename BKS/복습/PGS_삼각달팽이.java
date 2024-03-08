package BKS.복습;

import java.util.Arrays;

public class PGS_삼각달팽이 {
    // 20240308 18:09 ~ 18:38
    public static void main(String[] args) {
        int n = 6;
        int[] answer = new int[(n * (n + 1)) / 2];

        int[][] map = new int[n][n];
        // 1   0   0   0
        // 2   9   0   0
        // 3  10   8   0
        // 4   5   6   7

        // 0. 3가지로 방향을 전환하며 숫자를 채워 나간다.
        int num = 1;
        int row = -1;
        int col = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = i ; j < n ; j++) {
                // 1. 현재 배열에 num을 대입한다.

                // 2. 3가지 방향에 대해 각각 row, col을 수정한다.
                // 2.1. 아래로 채울 때
                if (i % 3 == 0) {
                    row++;
                } // 2.2. 오른쪽으로 채울 때
                else if (i % 3 == 1) {
                    col++;
                } // 2.3. 대각선으로 채울 때
                else if (i % 3 == 2) {
                    row--;
                    col--;
                }
                map[row][col] = num++;
            }
        }

        int idx = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (map[i][j] == 0) continue;
                answer[idx++] = map[i][j];
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
