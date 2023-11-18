package BKS;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_네트워크 {
    static boolean[] visited;

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer = 0;
        visited = new boolean[n]; // 0으로 세팅

        for (int i = 0; i < n; i++) { // 시작점 n만큼 확인 -> 네트워크 개수
            if (visited[i] == false) {
                bfs(i, computers, n);
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void bfs(int i, int[][] computers, int n) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(i); // 1. 시작점
        visited[i] = true;

        while (!que.isEmpty()) {
            int value = que.poll(); // 그 다음 연결의 시작점

            for (int j = 0; j < n; j++) { // 2. 모든점을 방문
                if (visited[j] == false && computers[value][j] == 1) { // 3. 연결되있으면 간다
                    visited[j] = true; // 4. 방문표시
                    que.offer(j); // 5. 큐에 넣는다.
                }
            }
        }
    }
}
