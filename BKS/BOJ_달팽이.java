package BKS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_달팽이 {
    // 20240921 23:26 ~ 12:40
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine()); // target

        int[][] map = new int[N + 2][N + 2];
        int v = 1;
        int h = 1;
        int num = N * N;
        String cur = "D";

        for (int idx = 0 ; idx <= N + 1 ; idx++) {
            map[N + 1][idx] = -1;
            map[idx][N + 1] = -1;
            map[0][idx] = -1;
            map[idx][0] = -1;
        }

        // DRUL
        while (num > 0) {
            map[v][h] = num--;

            // 아래
            if ("D".equals(cur)) {
                v++;
            } // 우
            else if ("R".equals(cur)) {
                h++;
            } // 위
            else if ("U".equals(cur)) {
                v--;
            } // 좌
            else if ("L".equals(cur)) {
                h--;
            }

            // 각 모서리에서 방향전환
            if (cur.equals("D") && map[v][h] != 0) {
                v--;
                h++;
                cur = "R";
            } else if (cur.equals("R") && map[v][h] != 0) {
                h--;
                v--;
                cur = "U";
            } else if (cur.equals("U") && map[v][h] != 0) {
                v++;
                h--;
                cur = "L";
            } else if (cur.equals("L") && map[v][h] != 0) {
                h++;
                v++;
                cur = "D";
            }
        }

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                if (map[i][j] == M) {
                    sb.append(i + " " + j);
                }
            }
        }

        System.out.println(sb);

    }
}
