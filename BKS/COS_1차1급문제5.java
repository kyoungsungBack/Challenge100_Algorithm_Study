package BKS;

public class COS_1차1급문제5 {
    public static void main(String[] args) {
        int answer = 0;
        int n = 3;
        int[] mx = {1, 0, -1, 0};
        int[] my = {0, 1, 0, -1};
        int[][] visited = new int[n][n];
        int x = 0;
        int y = 0;
        int num = 1;

        while (isBound(y, x, n) && visited[y][x] == 0) {
            for (int i = 0 ; i < 4 ; i++) {
                if (!isBound(y, x, n) || visited[y][x] != 0) break;

                while (true) {
                    visited[y][x] = num++;

                    int py = y + my[i];
                    int px = x + mx[i];

                    if (!isBound(py, px, n) || visited[py][px] != 0) {
                        y += my[(i + 1) % 4];
                        x += mx[(i + 1) % 4];
                        break;
                    }

                    y = py;
                    x = px;
                }
            }
        }

        for (int i = 0 ; i < n ; i++) {
            answer += visited[i][i];
        }
        System.out.println(answer);
    }

    static boolean isBound(int y, int x, int n) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
