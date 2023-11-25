package BKS;

import java.util.Arrays;

public class COS_1차1급문제2 {
    public static void main(String[] args) {
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        int n = 4;

        // Write code here.
        int answer = 0;
        int[][] pane = new int[n][n];

        int ci = 0;
        int cj = 0;
        int num = 1;

        while (inRange(ci, cj, n) && pane[ci][cj] == 0) {
            for (int k = 0; k < 4; k++) {
                // 범위를 벗어낫거나 이미 채워져 있으면 반복문 종료
                if (!inRange(ci, cj, n) || pane[ci][cj] != 0) break;
                while (true) {
                    pane[ci][cj] = num++; // 먼저, 자신을 채움
                    for (int i = 0; i < pane.length; i++) {
                        System.out.println(Arrays.toString(pane[i]));
                    }
                    System.out.println();
                    int ni = ci + dy[k]; // 이동된 y좌표
                    int nj = cj + dx[k]; // 이동된 x좌표

                    // 이동된 좌표가 범위를 벗어낫거나 이미 채워져 있으면
                    // 둘레이므로 값 대입 후 반복문 종료
                    // 좌표회전 방식은 우 -> 아래 -> 좌 -> 위
                    if (!inRange(ni, nj, n) || pane[ni][nj] != 0) {
                        ci += dy[(k + 1) % 4];
                        cj += dx[(k + 1) % 4];
                        System.out.println(ni + " " + nj + " " + ci + " " + cj);
                        break;
                    }
                    ci = ni;
                    cj = nj;
                }
            }
        }
    }

    static boolean inRange(int i, int j, int n) {
        return 0 <= i && i < n && 0 <= j && j < n;
    }
}
