package BKS;

import java.util.Arrays;

public class PGS_양과늑대 {
    // 20231224 14:53 ~ 15:04
    static int maxSheepCnt;
    public static void main(String[] args) {
        /* Test Case1 */
        //int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        //int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};

        /* Test Case2 */
        int[] info = {0,1,0,1,1,0,1,0,0,1,0};
        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};
        maxSheepCnt = 0;

        dfs(0, 0, 0, new boolean[info.length], info, edges);

        System.out.println(maxSheepCnt);
    }
    public static void dfs(int idx, int sheepCnt, int wolfCnt, boolean[] visited, int[] info, int[][] edges) {
        // 0. 현재 info의 idx에 방문표시
        visited[idx] = true;

        // 1. 현재 idx에 들어있는 양 또는 늑대의 수 cnt 증가
        if (info[idx] == 0) {
            sheepCnt++;
            if (maxSheepCnt < sheepCnt) {
                maxSheepCnt = sheepCnt;
            }
        } else {
            wolfCnt++;
        }

        // 2. 늑대가 양과 같거나 크면 종료
        if (sheepCnt <= wolfCnt) {
            return;
        }

        // 3. 주어진 간선들을 통해 갈 수 있는 노드 탐색하기
        for (int[] edge : edges) {
            // 3.1. 주어진 간선을 통해 방문했던 노드와 연결된 노드에 방문 가능한지 확인
            if (visited[edge[0]] && !visited[edge[1]]) {
                // 3.2. clone을 하는 이유는 각 간선을 통해 연결되는 노드를 방문할 때 각 경로가 전혀 무관하므로
                //      visited를 그대로 사용하면 경로가 무관하지만 방문표기가 중첩되어 답을 구할 수 없다.
                boolean[] nextVisited = visited.clone();
                dfs(edge[1], sheepCnt, wolfCnt, nextVisited, info, edges);
            }
        }

    }
}
