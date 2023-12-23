package BKS;

import java.util.Arrays;

public class PGS_양과늑대 {
    static int maxSheepCnt = 0;
    public static void main(String[] args) {
        int[] info = {0,1,0,1,1,0,1,0,0,1,0};
        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};
        dfs(0, new boolean[info.length], 0, 0, info, edges);
        System.out.println(maxSheepCnt);
    }
    public static void dfs(int idx, boolean[] visited, int sheepCnt, int wolfCnt, int[] info, int[][] edges) {
        // 현재 노드가 뭔지 확인하여 cnt를 증가
        visited[idx] = true;
        if (info[idx] == 0) {
            sheepCnt++;
            if (sheepCnt > maxSheepCnt) {
                maxSheepCnt = sheepCnt;
            }
        } else {
            wolfCnt++;
        }

        // 현재 노드 지점에서 양과 늑대의 수를 비교 -> 더 갈 수 있으면 다른 노드를 방문한다
        if (sheepCnt <= wolfCnt) {
            return;
        }

        for (int[] edge : edges) {
            if (visited[edge[0]] && !visited[edge[1]]) {
                // visited은 간선의 연결상태를 저장하며 다음 노드로 갈 수 있는지 알려준다
                // clone을 안해주면 재귀 호출되면서 해당노드 true로 바뀌고 다시 돌아와서도 해당 노드는 true인 상태가 된다
                boolean[] nextVisited = visited.clone();
                dfs(edge[1], nextVisited, sheepCnt, wolfCnt, info, edges);

            }
        }
    }
}
