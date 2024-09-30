package BKS.복습;

public class PGS_피로도 {
    // 20241001 00:23 ~ 00:36
    static int answer;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        answer = -1;
        sol(0, k, dungeons, new boolean[dungeons.length]);
        System.out.println(answer);
    }

    public static void sol(int cnt, int k, int[][] dungeons, boolean[] isVisited) {
        answer = Math.max(answer, cnt);

        for (int i = 0 ; i < dungeons.length ; i++) {
            if (!isVisited[i] && k >= dungeons[i][0]) {
                isVisited[i] = true;
                sol(cnt + 1, k - dungeons[i][1], dungeons, isVisited);
                isVisited[i] = false;
            }
        }
    }
}
