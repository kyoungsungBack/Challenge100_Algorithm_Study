package BKS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PGS_합승택시요금 {
    // 다익스트라 또는 플로이드워셜 풀이
    static int N, E;
    static int[][] map;

    public static void main(String[] args) {
        int answer = 0;
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        N = n;
        E = fares.length;

        map = new int[n][n];

        // 간선리스트 정보 저장
        for (int i = 0; i < E; i++) {
            int u = fares[i][0] - 1;
            int v = fares[i][1] - 1;
            map[u][v] = fares[i][2];
            map[v][u] = fares[i][2];
        }

        int[] together = dijkstra(s - 1);
        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int[] alone = dijkstra(i);
            int cost = together[i] + alone[a - 1] + alone[b - 1];
            if (cost < minCost) {
                minCost = cost;
            }
        }
        System.out.println(minCost);
    }

    public static int[] dijkstra(int start) {
        // 가중치 기준으로 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        boolean[] visited = new boolean[N];
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int u = cur[1];
            if (visited[u]) {
                continue;
            }

            visited[u] = true;
            for (int v = 0; v < N; v++) {
                if (map[u][v] == 0) {
                    continue;
                }
                if (distance[u] + map[u][v] < distance[v]) {
                    distance[v] = distance[u] + map[u][v];
                    pq.add(new int[]{distance[v], v});
                }
            }
        }

        return distance;
    }

}
