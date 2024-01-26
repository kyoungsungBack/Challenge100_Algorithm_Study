package BKS;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_아이템줍기 {
    // 20240125 10:03 ~ 11:17 (복습할 것)
    // 20240126 09:23 ~ 09:49 (복습)
    static int[][] map = new int[101][101];
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};
    static int answer;
    public static void main(String[] args) {
        int[][] rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        // 0. 테두리를 이용할 땐 모든 길이를 두 배 하고 내부 및 테두리 값을 1과 2로 구분한다.

        // 1. 먼저, map을 채운다.
        for (int i = 0 ; i < rectangle.length ; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];
            draw(y1 * 2, y2 * 2, x1 * 2, x2 * 2);
        }
        answer = Integer.MAX_VALUE;

        // 2. BFS를 통해 탐색하고 가장 처름으로 아이템 위치에 닿는 길이가 최소 너비이므로 답이 된다.
        bfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2, new boolean[101][101]);

        System.out.println(answer);

    }

    static public void bfs(int y, int x, int itemY, int itemX, boolean[][] visited) {
        // 3. Queue를 생성하고 출발점을 세팅한다.
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{y, x, 0});
        visited[y][x] = true;

        // 4. 테두리만 찾아서 이동한다.
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            // 5.1. 너비우선탐색 이므로 해당 조건을 처음으로 만족하는 너비가 최소가 된다.
            if (cur[0] == itemY && cur[1] == itemX) {
                answer = cur[2] / 2;
                break;
            }

            // 5.2. 연결된 테두리만 방문하고 미방문, 테두리일 조건을 Queue에 넣는다
            for (int i = 0 ; i < 4 ; i++) {
                int py = cur[0] + my[i];
                int px = cur[1] + mx[i];

                if (0 <= py && py < map.length && 0 <= px && px < map[0].length){
                    if (visited[py][px] == false && map[py][px] == 2) {
                        visited[py][px] = true;
                        que.offer(new int[]{py, px, cur[2] + 1});
                    }
                }

            }
        }
    }
    // 1.1. 주어진 길이의 2배로 map을 세팅한다.
    static public void draw(int y1, int y2, int x1, int x2) {

        for (int i = y1 ; i <= y2 ; i++) {
            for(int j = x1 ; j <= x2 ; j++) {
                if (map[i][j] == 1) continue;

                // 1.2. 기본으로 1을 세팅
                map[i][j] = 1;

                // 1.3. 경계이면 2를 세팅
                if (i == y1 || i == y2 || j == x1 || j == x2) {
                    map[i][j] = 2;
                }
            }
        }
    }
}
