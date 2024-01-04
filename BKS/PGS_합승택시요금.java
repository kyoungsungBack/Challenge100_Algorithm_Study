package BKS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PGS_합승택시요금 {
    // 20230104 11:18 ~ 11:44 (복습)
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

        /* (1) 다익스트라 풀이 */
        // 0. 간선에 대한 인접행렬을 생성하고 세팅한다.
        map = new int[N + 1][N + 1];

        for (int i = 0 ; i < fares.length ; i++) {
            int u = fares[i][0];
            int v = fares[i][1];
            // 양방향 그래프 이므로
            map[u][v] = fares[i][2];
            map[v][u] = fares[i][2];
        }

        // 1. 시작점에 대해서 모든 최단거리 배열을 생성한다.
        int[] tog = sol(s);
        int minDistance = Integer.MAX_VALUE;

        // 8. 합승배열 ind를 만든 뒤 최단합승 + 개인의 최소를 찾는다.
        for (int i = 1 ; i <= N ; i++) {
            int[] ind = sol(i);
            if (minDistance > tog[i] + ind[a] + ind[b]) {
                minDistance = tog[i] + ind[a] + ind[b];
            }
        }
        System.out.println(minDistance);

        /* (2) 플로이드 워셜 풀이 */

        /*

        int answer = Integer.MAX_VALUE;
        int[][] map = new int[n + 1][n + 1];

        // 1. 인접행렬에 대해 임의의 최대값을 세팅한다.
        for (int i = 0 ; i <= n ; i++) {
            Arrays.fill(map[i], 20000001);
        }

        // 2. 자기 자신에 대해서 0으로 세팅한다.
        for (int i = 1 ; i <= n ; i++) {
            map[i][i] = 0;
        }

        // 3. 인접행렬에 가중치를 세팅한다.
        for (int i = 0 ; i < fares.length ; i++) {
            int u = fares[i][0];
            int v = fares[i][1];
            map[u][v] = fares[i][2];
            map[v][u] = fares[i][2];
        }

        // 4. 연결된 점들에 대해 거쳐가는 점을 만들어 최단거리를 세팅한다.
        for (int k = 1 ; k <= n ; k++) {
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        // 5. 거쳐가는 지점 s를 기준으로 최단거리를 찾는다.
        for (int i = 1 ; i <= n ; i++) {
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
         */
    }
    public static int[] sol(int start) {
        // 2. pq에 최단거리 기준 오름차순으로 정렬한다.
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 3. 방문배열 생성한다.
        boolean[] visited = new boolean[N + 1];

        // 4. 최단거리 배열 생성한다.
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 5. 시작점에 대해서 방문한다.
        distance[start] = 0;

        pq.offer(new int[] {0, start});

        // 6. 시작점과 연결된 모든 점에 대해 최단거리 배열을 채워나간다.
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[1]]) {
                continue;
            }

            visited[cur[1]] = true;

            // 6.1 연결된 점들을 탐색한다.
            for (int i = 1 ; i <= N ; i++) {
                // 6.2 연결되지 않은 점은 씹는다.
                if (map[cur[1]][i] == 0) {
                    continue;
                }

                // 7. 연결되고 최단거리가 될 가능성이 있으면 pq에 담는다.
                if (distance[i] > distance[cur[1]] + map[cur[1]][i]) {
                    distance[i] = distance[cur[1]] + map[cur[1]][i];
                    pq.offer(new int[] {distance[i], i});
                }
            }
        }
        return distance;
    }
}
