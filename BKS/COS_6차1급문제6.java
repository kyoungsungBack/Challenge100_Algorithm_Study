package BKS;

public class COS_6차1급문제6 {
    public static void main(String[] args) {
        int[][] grid = {{1, 4, 16, 1}, {20, 5, 15, 8}, {6, 13, 36, 14}, {20, 7, 19, 15}};
        int answer = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = j + 1; k < 4; k += 2) {
                    answer = Math.max(answer, Math.max(grid[i][j] + grid[i][k], grid[j][i] + grid[k][i]));
                }
            }
        }
        System.out.println(answer);
    }
}
