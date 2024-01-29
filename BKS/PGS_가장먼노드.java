package BKS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PGS_가장먼노드 {
    // 20240129 14:37 ~ 15:49
    static ArrayList<Integer>[] map;
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int answer = 0;

        map = new ArrayList[n + 1];

        for (int i = 0 ; i <= n ; i++) {
            map[i] = new ArrayList<>();
        }

        // 1. 인접리스트를 세팅한다.
        for (int[] edg : edge) {
            int start = edg[0];
            int end = edg[1];
            map[start].add(end);
            map[end].add(start);
        }

        /* 인접행렬 풀이 방법(세팅) */
        /*
        static int[][] map; // 해당 코드는 전역변수에 선언

        map = new int[n + 1][n + 1];
        for (int i = 0 ; i < edge.length ; i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            map[start][end] = 1;
            map[end][start] = 1;
        }
        */

        answer = bfs(1, n);
        System.out.println(answer);
    }
    static public int bfs(int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[]{start, 0});
        visited[start] = true;
        int prev = 0; // 이전 노드의 깊이
        int cnt = 0; // 같은 깊이의 노드 개수

        // 1. 시작점 부터 연결된 노드를 탐색하며 가장 먼 노드의 개수를 센다.
        while (!que.isEmpty()) {
            int[] cur = que.poll(); // 1. cur[0] : 현재노드 , cur[1] : 현재 깊이

            // 2. 현재 깊이가 바뀌었으면 다시 개수를 센다.
            if (cur[1] > prev) {
                cnt = 1;
                prev = cur[1];
            } else {
                cnt++;
            }

            // 3. 현재 노드와 연결된 모든 노드를 하나씩 받는다.
            for (int end : map[cur[0]]) {
                // 4. 연결된 노드 중에 아직 방문 안했으면 간다.
                if (visited[end] == false) {
                    visited[end] = true;
                    que.offer(new int[]{end, cur[1] + 1});
                }
            }
        }

        /* 인접행렬 풀이 방법(찾기) */
        /*
        while (!que.isEmpty()) {
            int[] cur = que.poll(); // 1. cur[0] : 현재노드 , cur[1] : 현재 깊이

            // 1. 현재 깊이가 바뀌었으면 다시 개수를 센다.
            if (cur[1] > prev) {
                cnt = 1;
                prev = cur[1];
            } else {
                cnt++;
            }

            // 2. 현재 노드와 연결된 모든 점을 확인한다.(인접행렬 방식)
            for (int i = 1 ; i <= n ; i++) {
                // 3. 다음 노드를 아직 방문 안하고 연결된 노드이면 간다.
                if (visited[i] == false && map[start].get == 1) {
                    visited[i] = true;
                    que.offer(new Integer[]{i, cur[1] + 1});
                }
            }
        }
        */

        return cnt;
    }
}
