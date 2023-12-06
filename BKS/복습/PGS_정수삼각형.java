package BKS.복습;

public class PGS_정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int answer = 0;

        for (int i = 1 ; i < triangle.length ; i++) {
            for (int j = 0 ; j < triangle[i].length; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == triangle[i].length - 1) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }

        for (int i = 0 ; i < triangle[triangle.length - 1].length ; i++) {
            answer = Math.max(answer, triangle[triangle.length - 1][i]);
        }
        System.out.println(answer);
    }
}
