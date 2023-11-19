package BKS;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_네트워크 {
    static boolean[] visited;

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer = 0;
        visited = new boolean[n];

        // 모든 점들에 대해 네트워크 확인
        for (int i = 0 ; i < n ; i++) {
            if (visited[i] == false) { // 아직 방문을 안했으면 네트워크 이다.
                bfs(i, n, computers);
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void bfs(int i, int n, int[][] computers) {
        Queue<Integer> que = new LinkedList<>(); // que를 통해 연결된 점 확인
        que.offer(i);
        visited[i] = true;

        while (!que.isEmpty()) { // 연결된 모든 점의 확인이 끝날 때 까지
            int cur = que.poll();

            // 현재 점에서 모든 점들에 대한 연결 확인
            for (int j = 0 ; j < n ; j++) {
                if (visited[j] == false && computers[cur][j] == 1) {
                    visited[j] = true;
                    que.offer(j);
                }
            }
        }
    }
    public static void dfs(int i, int n, int[][] computers) {
        // 현재 점에서 모든 점들에 대한 연결 확인
        for (int j = 0 ; j < n ; j++) {
            if (visited[j] == false && computers[i][j] == 1) {
                visited[j] = true;
                dfs(j, n, computers);
            }
        }
    }
}
