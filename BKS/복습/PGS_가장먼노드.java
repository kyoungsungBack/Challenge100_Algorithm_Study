package BKS.복습;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PGS_가장먼노드 {
    // 20240306 11:23 ~ 50 12:10 ~ 12:33 (37 + 23 = 60분)
    // 20240307 19:27 ~ 19:48
    static ArrayList<Integer>[] map;
    static int N;
    static int answer;
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        answer = 0;

        // 0. 그래프를 구현할 수 있는 법 -> 인접행렬, 간선리스트
        map = new ArrayList[n + 1];

        for (int i = 0 ; i <= n ; i++) {
            map[i] = new ArrayList<>();
        }

        // 1. 그래프 정보를 간선리스트에 담는다.
        for (int[] node : edge) {
            int start = node[0];
            int end = node[1];

            map[start].add(end);
            map[end].add(start);
        }

        // 2. 노드를 bfs로 탐색한다.
        sol(1, new boolean[n + 1]);

        System.out.println(answer);
    }

    public static void sol(int start, boolean[] visited) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{start, 0}); // 연결된 점, Depth를 담는다.
        visited[start] = true;
        int prev = 0; // 가장 먼 노드를 확인하기 위해 선언한다.

        // 3. que에 원소가 없을 때 까지 연결된 가장 먼 노드를 탐색한다.
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            // 3.1. Depth가 같다면 answer를 증가한다.
            if (cur[1] == prev) {
                answer++;
            } // 3.2. Depth가 커졌다면 prev를 갱싱 및 answer를 1로 정의한다.
            else if (cur[1] > prev){
                prev = cur[1];
                answer = 1;
            }

            // 4. 간선리스트에서 현재 점과 연결된 점을 확인 후 방문하지 않았으면
            //    que에 다시 넣어 가장 먼 노드를 찾는다.
            //    BFS의 특성상 해당 반복문 한 턴의 노드들은 다 같은 Depth이다.
            for (int end : map[cur[0]]) {
                if (visited[end] == false) {
                    que.offer(new int[]{end, cur[1] + 1});
                    visited[end] = true;
                }
            }
        }
    }
}
