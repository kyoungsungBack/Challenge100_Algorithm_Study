package BKS;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class PGS_삼각달팽이 {
    // 20240226 22:04 ~ 22:12 (복습 할 것)
    public static void main(String[] args) {
        int n = 6;
        int[] answer = new int[(n * (n + 1)) / 2]; // 등차수열일 때 1~n까지의 합공식
        int[][] map = new int[n][n];

        int x = 0;
        int y = -1;
        int num = 1;
        // 0. 삼각형은 세 가지 방향으로 밖 -> 안으로 수를 채워나간다.
        for (int i = 0 ; i < n ; i++) {
            for (int j = i ; j < n ; j++) {
                // 1. 밑으로 채울 때
                if (i % 3 == 0) {
                    y++;
                } // 2. 옆으로 채울 때
                else if (i % 3 == 1) {
                    x++;
                } // 3. 대각선으로 채울 때
                else if (i % 3 == 2) {
                    y--;
                    x--;
                }
                map[y][x] = num++;
            }
        }

        int idx = 0;
        // 4. map배열에 담긴 수를 answer배열에 넣는다.
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (map[i][j] == 0) {
                    break;
                }
                answer[idx++] = map[i][j];
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
