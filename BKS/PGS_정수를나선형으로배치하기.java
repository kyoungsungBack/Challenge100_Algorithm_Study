package BKS;

import java.util.Arrays;

public class PGS_정수를나선형으로배치하기 {
    // 20241005 22:42 ~ 23:25
    public static void main(String[] args) {
        int n = 5;
        int[][] answer = new int[n][n];
        int num = 1;
        int r = 0;
        int c = 0;
        char dir = 'R';

        while (num <= n * n) {
            answer[r][c] = num++;
            // 조건문 안에 조건이 여러개일 때 앞에부터 실행됨
            // -> 그래서, 현재 배열의 범위 밖의 인덱스를 확인한다 해도 조건이 안타서 에러 안남
            // -> 즉, 조건문 안에 다중 조건의 순서 주의

            // 우 -> 아래
            if (dir == 'R') {
                if (c == n - 1 || answer[r][c + 1] != 0) {
                    dir = 'D';
                    r++;
                } else {
                    c++;
                }
            } else if (dir == 'D') {
                // 아래 -> 왼
                if (r == n - 1 || answer[r + 1][c] != 0) {
                    dir = 'L';
                    c--;
                } else {
                    r++;
                }
            } else if (dir == 'L') {
                // 왼 -> 위
                if (c == 0 || answer[r][c - 1] != 0) {
                    dir = 'U';
                    r--;
                } else {
                    c--;
                }
            } else if (dir == 'U') {
                // 위 -> 우
                if (r == 0 || answer[r - 1][c] != 0) {
                    dir = 'R';
                    c++;
                } else {
                    r--;
                }
            }
        }
        for (int i = 0 ; i < n ; i++) {
            System.out.println(Arrays.toString(answer[i]));
        }
    }
}
