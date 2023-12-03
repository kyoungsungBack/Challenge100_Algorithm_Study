package BKS.복습;

public class PGS_피로도 {
    static int answer;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        answer = 0;
        dfs(0, k, new boolean[dungeons.length], dungeons);
        System.out.println(answer);
    }

    public static void dfs(int n, int cur, boolean[] visited, int[][] dungeons) {
        if (n > answer) {
            answer = Math.max(answer, n);
            System.out.println(cur + " " + answer);
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] == false && cur >= dungeons[i][0]) {
                visited[i] = true;
                dfs(n + 1, cur - dungeons[i][1], visited, dungeons);
                visited[i] = false;
            }
        }
    }
}
