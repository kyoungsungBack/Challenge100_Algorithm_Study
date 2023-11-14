package BKS;

public class PGS_정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int answer = 0;
        int Y = triangle.length;
        int X = triangle[triangle.length - 1].length;
        int[][] sum = new int[Y][X];

        sum[0][0] = triangle[0][0]; // 1. 가장 상위값은 비교대상이 없으므로 넣고 시작

        // 2. triangle 배열을 돌며 sum에 들어갈 수 있는 최대값을 넣는다.
        for (int i = 1 ; i < triangle.length ; i++) {
            for (int j = 0 ; j < triangle[i].length ; j++) {
                if (j == 0) { // 상위 부모 한 명
                    sum[i][j] = triangle[i][j] + sum[i - 1][j];
                } else if (j == triangle[i].length - 1) { // 상위 부모 한 명
                    sum[i][j] = triangle[i][j] + sum[i - 1][j - 1];
                } else { // 상위 부모 두 명
                    sum[i][j] = triangle[i][j] + Math.max(sum[i - 1][j - 1], sum[i - 1][j]);
                }
            }
        }

        // 3. 도착점 중에 가장 큰 수가 답이다.
        for (int i = 0 ; i < X ; i++) {
            answer = Math.max(answer, sum[Y - 1][i]);
        }

        System.out.println(answer);
    }
}
