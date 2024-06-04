package BKS.복습;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_아이템줍기 {
    // 20240306 09:31 ~ 46 10:02 ~ 11:00 (다시 복습)
    // 20240307 18:40 ~ 19:13
    // 20240604 22:45 ~ 23:27
    static int[][] map;
    static int answer;

    public static void main(String[] args) {
        answer = 0;
        map = new int[101][101];
        int[][] rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        // 1. 주어진 도형을 map에 그린다.
        for (int[] rec : rectangle) {
            int X1 = rec[0];
            int Y1 = rec[1];
            int X2 = rec[2];
            int Y2 = rec[3];
            draw(X1 * 2, Y1 * 2, X2 * 2, Y2 * 2);
        }

        // 2. 현재 위치에서 아이템 위치까지 최소 거리를 탐색한다.
        sol(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        System.out.println(answer);
    }

    public static void draw(int X1, int Y1, int X2, int Y2) {
        for (int i = Y1; i <= Y2; i++) {
            for (int j = X1; j <= X2; j++) {
                if (map[i][j] == 1) {
                    continue;
                }
                // 1.1. 테두리이면 2를 넣는다.
                if (i == Y1 || i == Y2 || j == X1 || j == X2) {
                    map[i][j] = 2;
                    continue;
                }

                // 1.2. 내부이면 1을 넣는다.
                map[i][j] = 1;

            }
        }
    }

    public static void sol(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{characterY, characterX, 0});

        // 2.1. 시간초과를 막기위해 방문배열 꼭 선언한다.
        boolean[][] visited = new boolean[101][101];
        visited[characterY][characterX] = true;

        int[] my = {-1, 1, 0, 0};
        int[] mx = {0, 0, -1, 1};

        // 2.2. que에 담아서 캐릭터의 위치를 이동시킨다.
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == itemY && cur[1] == itemX) {
                answer = cur[2] / 2;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int py = cur[0] + my[i];
                int px = cur[1] + mx[i];

                if (py < 0 || py > 100 || px < 0 || px > 100) {
                    continue;
                }
                // 2.3. 테두리이고 방문하지 않았으면 간다.
                if (map[py][px] == 2 && visited[py][px] == false) {
                    que.offer(new int[]{py, px, cur[2] + 1});
                    visited[py][px] = true;
                }
            }
        }
    }
}
