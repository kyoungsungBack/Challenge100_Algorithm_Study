package BKS.복습;

import java.util.*;

public class PGS_무인도여행 {
    static ArrayList<Integer> list;
    static boolean[][] visited;
    static String[][] map;
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};
    static int Y, X;

    public static void main(String[] args) {
        String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};
        int[] answer;
        Y = maps.length;
        X = maps[0].length();
        list = new ArrayList<>();
        visited = new boolean[Y][X];
        map = new String[Y][X];

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                map[i][j] = String.valueOf(maps[i].charAt(j));
            }
        }

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (visited[i][j] == false && !map[i][j].equals("X")) {
                    bfs(i, j);
                }
            }
        }
        Collections.sort(list);

        if (list.size() == 0) {
            answer = new int[]{-1};
        } else {
            answer = new int[list.size()];

            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }
        System.out.println(Arrays.toString(answer));
    }

    public static void bfs(int i, int j) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{i, j});
        visited[i][j] = true;
        int res = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            res += Integer.parseInt(map[cur[0]][cur[1]]);

            for (int k = 0; k < 4; k++) {
                int py = cur[0] + my[k];
                int px = cur[1] + mx[k];

                if (0 <= py && py < Y && 0 <= px && px < X) {
                    if (visited[py][px] == false && !map[py][px].equals("X")) {
                        visited[py][px] = true;
                        que.offer(new int[]{py, px});
                    }
                }
            }
        }

        list.add(res);
    }
}
