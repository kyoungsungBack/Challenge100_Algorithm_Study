package BKS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGS_전력망을둘로나누기 {
    public static ArrayList<Integer>[] list;
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        int answer = 99;
        list = new ArrayList[n + 1];

        for (int i = 0 ; i < list.length ; i ++) {
            list[i] = new ArrayList<>();
        }

        // 1. 인접리스트에 간선정보를 담는다.
        for (int i = 0 ; i < wires.length ; i++) {
            int start = wires[i][0]; // 시작점
            int end = wires[i][1]; // 도착점
            list[start].add(end);
            list[end].add(start);
        }

        // 2. 간선을 하나씩 끊으며 두 전력망 개수를 비교한다.
        for (int i = 0 ; i < wires.length ; i++) {
            // 3, 4. 두 전력망 개수의 차이가 최소가 되는 경우를 찾는다.
            answer = Math.min(answer, sol(n, wires[i][0], wires[i][1]));
        }
        System.out.println(answer);
    }

    public static int sol(int n, int start, int end) {
        // 3.1. 시작점에 대한 노드 개수를 센다.
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int startCnt = 0;

        que.offer(start);
        visited[start] = true;

        // 3.2. 연결된 노드를 탐색하며 노드 개수 센다.
        while (!que.isEmpty()) {
            int cur = que.poll();
            startCnt++;

            for (int conn : list[cur]) {
                if (visited[conn] == false && conn != end) {
                    visited[conn] = true;
                    que.offer(conn);
                }
            }
        }

        // 3.3. 도착점에 대한 노드 개수를 센다.
        int endCnt = 0;
        Arrays.fill(visited, false);
        que.offer(end);
        visited[end] = true;

        // 3.4. 연결된 노드를 탐색하며 노드 개수 센다.
        while (!que.isEmpty()) {
            int cur = que.poll();
            endCnt++;

            for (int conn : list[cur]) {
                if (visited[conn] == false && conn != start) {
                    visited[conn] = true;
                    que.offer(conn);
                }
            }
        }

        // 3.5. 각 전력망의 개수의 차를 반환한다.
        return Math.abs(startCnt - endCnt);
    }
}
