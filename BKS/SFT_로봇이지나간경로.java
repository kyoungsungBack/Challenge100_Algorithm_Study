package BKS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SFT_로봇이지나간경로 {
    static char[][] map;
    static int H, W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        H = Integer.parseInt(st.nextToken()); // 세로
        W = Integer.parseInt(st.nextToken()); // 가로

        map = new char[H + 1][W + 1];

        for (int i = 1; i <= H; i++) {
            String str = br.readLine();
            for (int j = 1; j <= W; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }

    }
}
