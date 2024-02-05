package BKS;

public class PGS_땅따먹기 {
    // 20240205 17:33 ~ 17:50(시간초과)
    static int answer, N;

    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        answer = 0;
        N = land.length;

        sol(0, 0, -1, land);
        System.out.println(answer);
    }

    public static void sol(int depth, int move, int prev, int[][] land) {

        if (depth == N) {
            answer = Math.max(answer, move);
            return;
        }

        for (int i = 0 ; i < 4 ; i++) {
            if (i != prev) {
                sol(depth + 1, move + land[depth][i], i, land);
            }
        }
    }
}
