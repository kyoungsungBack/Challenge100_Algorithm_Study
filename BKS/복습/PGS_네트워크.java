package BKS.복습;

public class PGS_네트워크 {
    static boolean[] visited;
    public static void main(String[] args) {
        // 20231207 09:13 ~ 09:29
        int n = 3;
        int[][] computers = {{1, 1, 0},{1, 1, 0},{0, 0, 1}};
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0 ; i < n ; i++) {
            // 네트워크 확인할 때 마다 answer++
            if (visited[i] == false) {
                sol(i, computers, n);
                answer++;
            }
        }
        System.out.println(answer);
    }
    // 모든 정점에 대해 연결된 점을 탐색
    public static void sol(int start, int[][] computers, int nodeCnt) {

        for (int i = 0 ; i < nodeCnt ; i++) {
            if (visited[i] == false && computers[start][i] == 1) {
                visited[i] = true;
                sol(i, computers, nodeCnt);
            }
        }
    }
}
