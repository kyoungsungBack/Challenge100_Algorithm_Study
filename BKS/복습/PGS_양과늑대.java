package BKS.복습;

public class PGS_양과늑대 {
    // 20240110 17:21 ~ 17:49
    static int[] Info;
    static int[][] Edges;
    static int answer;
    public static void main(String[] args) {
        /* Test Case1 */
        //int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        //int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};

        /* Test Case2 */
        int[] info = {0,1,0,1,1,0,1,0,0,1,0};
        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};
        answer = 0;
        Info = info;
        Edges = edges;
        sol(0, 0, 0, new boolean[info.length]);

        System.out.println(answer);
    }
    public static void sol (int start, int sheapCnt, int wolfCnt, boolean[] visited) {
        if (Info[start] == 0) {
            sheapCnt++;
        } else {
            wolfCnt++;
        }

        if (sheapCnt <= wolfCnt) {
            return;
        }

        visited[start] = true;
        answer = Math.max(answer, sheapCnt);

        // 1. Edges로 갈 수 있는 곳을 모두 방문하고 갔던 점에 대해 방문표시 한다.
        for (int i = 0 ; i < Edges.length ; i++) {
            if (visited[Edges[i][0]] == true && visited[Edges[i][1]] == false) {
                boolean[] visitedCp = visited.clone();
                sol(Edges[i][1], sheapCnt, wolfCnt, visitedCp);
            }
        }

    }
}
