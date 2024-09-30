package BKS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_빙고 {
    // 20240930 22:39 ~ 23:59
    static int[][] map;
    static boolean[][] bingo;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[5][5];
        bingo = new boolean[5][5];
        nums = new int[25];
        int answer = 0;

        for (int i = 0 ; i < 5 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 5 ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        for (int i = 0 ; i < 5 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 5 ; j++) {
                nums[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < 25 ; i++) {
            if (sol(nums[i])) {
                answer = i + 1;
                break;
            }
        }

        System.out.println(answer);
    }
    public static boolean sol(int target) {
        boolean isBingo = false;

        // 1. 빙고판에 현재 불린 숫자를 표시한다.
        for (int i = 0 ; i < 5 ; i++) {
            for (int j = 0 ; j < 5 ; j++) {
                if (map[i][j] == target) {
                    bingo[i][j] = true;
                    break;
                }
            }
        }

        int cnt = 0;
        // 2. 빙고판에 채워진 라인 수를 확인한다.
        // 가로
        for (int i = 0 ; i < 5 ; i++) {
            boolean h = true;
            for (int j = 0 ; j < 5 ; j++) {
                if (bingo[i][j] == false) {
                    h = false;
                    break;
                }
            }
            if (h) cnt++;
        }

        // 세로
        for (int i = 0 ; i < 5 ; i++) {
            boolean v = true;
            for (int j = 0 ; j < 5 ; j++) {
                if (bingo[j][i] == false) {
                    v = false;
                    break;
                }
            }
            if(v) cnt++;
        }
        // 좌 대각선
        boolean right = true;
        for (int i = 0 ; i < 5 ; i++) {
            if (bingo[i][i] == false) {
                right = false;
                break;
            }
        }
        if (right) cnt++;

        // 우 대각선
        boolean left = true;
        int idx = 0;
        for (int i = 4 ; i >= 0 ; i--) {
            if (bingo[idx++][i] == false) {
                left = false;
                break;
            }
        }
        if (left) cnt++;

        if (cnt >= 3) {
            isBingo = true;
        }

        return isBingo;
    }
}
