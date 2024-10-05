package BKS;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_테트로미노 {
    // 20241005 18:01 ~ 18:18 (BFS 시간초과)
    // 20241005 21:13 ~ 22:12 (백트래킹 O)
    static int[] my = {-1, 1, 0, 0};
    static int[] mx = {0, 0, -1, 1};
    static int[][] map;
    static int N, M;
    static int answer;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = 0;
        map = new int[N][M];
        visited = new boolean[N][M];
        // 1. 종이 세팅
        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

		for (int i = 0 ; i < N ; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                sol(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }
        bw.append(String.valueOf(answer));
        bw.flush();
    }

    public static void sol(int r, int c, int depth, int sum) {
        // 1. dapth가 4이면 종료
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0 ; i < 4 ; i++) {
            int ny = r + my[i];
            int nx = c + mx[i];

            if (!isValid(ny, nx)) continue;
            if (visited[ny][nx]) continue;

            if (depth == 2) { // ㅗ인 경우 처리
                visited[ny][nx] = true;
                sol(r, c, depth + 1, sum + map[ny][nx]);
                visited[ny][nx] = false;
            }

            visited[ny][nx] = true;
            sol(ny, nx, depth + 1, sum + map[ny][nx]);
            visited[ny][nx] = false;
        }
    }

    public static boolean isValid(int r, int c) {
        if (r < 0 || N <= r || c < 0 || c >= M) return false;
        else return true;
    }
}