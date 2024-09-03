package BKS.복습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PGS_배달 {
    // 20240824 15:56 ~ 16:30 16:37 ~ 16:53 -> dfs풀이
    // 20240824 17:36 ~ 18:05 -> 플로이드-워셜
    // 20240903 19:14 ~ 19:40
    public static ArrayList<int[]>[] map;
    public static HashSet<Integer> isOk;
    /*public static void main(String[] args) {
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;

        int answer = 0;
        map = new ArrayList[N + 1];
        isOk = new HashSet<>();

        for (int i = 0 ; i <= N ; i++) {
            map[i] = new ArrayList<>();
        }
        // 1번 마을이 배달할 수 있는 마을의 수를 구한다.

        // 1. 간선 정보를 저장한다.
        for (int[] r : road) {
            int start = r[0];
            int end = r[1];
            int value = r[2];

            map[start].add(new int[]{end, value});
            map[end].add(new int[]{start, value});
        }
        isOk.add(1);
        sol(K, 1, 0, new boolean[N + 1]);

        answer = isOk.size();
        System.out.println(answer);
    }*/
    public static void main(String[] args) {
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;

        int answer = 0;
        int[][] map = new int[N + 1][N + 1];

        // 0. 출발, 도착점의 거리를 최대값으로 초기화
        for (int i = 0 ; i <= N ; i++) {
            Arrays.fill(map[i], 2000001);
        }

        // 1. 출발과 도착이 같은 경우 count를 위해 0으로 초기화
        for(int i = 1; i <= N; i++) {
            map[i][i] = 0;
        }

        // 2. 인접행렬에 현재 노드정보를 담는다.
        for (int[] node : road) {
            int start = node[0];
            int end = node[1];
            int value = node[2];

            map[start][end] = Math.min(map[start][end], value);
            map[end][start] = Math.min(map[end][start], value);
        }

        // 3. 바로 가는 경우와 중간에 거쳐는 경우를 비교하여 최단거리를 적용한다.
        // -> 플로이드-워셜
        for (int k = 1 ; k <= N ; k++)  {
            for (int i = 1 ; i <= N ; i++) {
                for (int j = 1 ; j <= N ; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        // 4. 1에서 출발했을 때 K이하인 경우 answer 증가한다.
        for (int i = 1 ; i <= N ; i++) {
            if (map[1][i] <= K) answer++;
        }
        System.out.println(answer);
    }
    public static void sol(int K, int curNode, int curValue, boolean[] visited) {

        // 연결될 점을 확인한다.
        for (int[] node : map[curNode]) {
            // 연결된 점 중에 방문 전이고 최대거리 안에 속하면 간다.
            if (!visited[node[0]] && (curValue + node[1]) <= K) {
                visited[node[0]] = true;
                isOk.add(node[0]);
                sol(K, node[0], curValue + node[1], visited);
                visited[node[0]] = false;
            }
        }
    }
}
