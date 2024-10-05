package BKS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_방탈출 {
    // 20241005 16:27 ~ 17:25
    static int N, M;
    static int[][] map;
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};
    static int resLen;
    static int resSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 길이가 가장 긴 경로일 때 시작, 끝 수의 합

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        resLen = 0;
        resSum = 0;
        map = new int[N][M];

        // 1. 지도 정보 세팅
        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 모든 점에 대해 O이 아닐 때 탐색한다.
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                // 현재 점이 0이 아닐 때 비밀번호 확인한다.
                if (map[i][j] != 0) {
                    sol(i, j);
                }
            }
        }

        System.out.println(resSum);
    }

    public static void sol(int start, int end) {
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        que.offer(new int[]{start, end, 1, map[start][end]});
        visited[start][end] = true;
        int curLen = 1; // 현재 턴의 최대 길이 경로
        int curSum = map[start][end]; // 현재 턴 최대 경로일 때 합

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (curLen < cur[2]) {
                curLen = cur[2];
                curSum = map[start][end] + map[cur[0]][cur[1]];
            }

            for (int i = 0 ; i < 4 ; i++) {
                int ny = cur[0] + my[i];
                int nx = cur[1] + mx[i];


                // 범위 안에 있으면,
                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    // 아직 방문 전이면,
                    if (!visited[ny][nx] && map[ny][nx] != 0) {
                        visited[ny][nx] = true;
                        que.offer(new int[]{ny, nx, cur[2] + 1, cur[3]});
                    }
                }
            }
        }

        // 현재 턴의 경로가 더 길다면 갱신
        if (resLen < curLen) {
            resLen = curLen;
            resSum = curSum;
        } // 현재 턴의 경로가 같은데 시작, 끝 합이 크다면 갱신
        else if (resLen == curLen && resSum < curSum) {
            resSum = curSum;
        }
    }
}
