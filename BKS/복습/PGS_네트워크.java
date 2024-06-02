package BKS.복습;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_네트워크 {
    // 20231207 09:13 ~ 09:29 -> sol1(dfs)
    // 20240602 21:15 ~ 21:41 -> sol2(bfs)
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0},{1, 1, 0},{0, 0, 1}};
        int answer = 0;
        boolean[] visited = new boolean[n];

        // 1. n개의 노드만큼 네트워크를 확인한다.
        for (int i = 0 ; i < n ; i++) {
            // 2. 아직 방문하기 전이면 탐색한다.
            if (!visited[i]) {
                //sol1(i, computers, n, visited);
                sol2(i, computers, visited);
                answer++;
            }
        }

        System.out.println(answer);
    }
    // 모든 정점에 대해 연결된 점을 탐색
    public static void sol1(int start, int[][] computers, int nodeCnt, boolean[] visited) {
        for (int i = 0 ; i < nodeCnt ; i++) {
            if (visited[i] == false && computers[start][i] == 1) {
                visited[i] = true;
                sol1(i, computers, nodeCnt, visited);
            }
        }
    }

    public static void sol2(int start, int[][] computers, boolean[] visited) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            // 3. 도착점을 확인하며 연결된 네트워크를 찾는다.
            for (int i = 0 ; i < visited.length ; i++) {
                if (cur == i) continue;

                if (!visited[i] && computers[cur][i] == 1) {
                    visited[i] = true;
                    que.offer(i);
                }
            }
        }
    }
}
