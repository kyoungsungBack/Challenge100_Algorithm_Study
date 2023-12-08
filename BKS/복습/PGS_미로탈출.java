package BKS.복습;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_미로탈출 {
    // 20231208 21:35 ~ 22:12
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};
    static String[][] map;
    static int Y, X;
    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        Y = maps.length;
        X = maps[0].length();
        int answer = 0;

        boolean[][] visited = new boolean[Y][X];
        map = new String[Y][X];

        for (int i = 0 ; i < Y ; i++) {
            for (int j = 0 ; j < X ; j++) {
                String str = String.valueOf(maps[i].charAt(j));
                if (str.equals("X")) visited[i][j] = true;
                map[i][j] = str;
            }
        }

        for (int i = 0 ; i < Y ; i++) {
            for (int j = 0 ; j < X ; j++) {
                if (map[i][j].equals("S")) answer += solLever(i, j, visited);
            }
        }

        for (int i = 0 ; i < Y ; i++) {
            for (int j = 0 ; j < X ; j++) {
                if (map[i][j].equals("L")) answer += solExit(i, j, visited);
            }
        }

        if (answer < 0) {
            answer = -1;
        }
        System.out.println(answer);
    }
    public static int solLever(int i, int j, boolean[][] visited) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{i, j, 0});
        boolean[][] visitedCopy = new boolean[Y][X];
        int ans = Integer.MAX_VALUE;

        for (int k = 0 ; k < Y ; k++) {
            visitedCopy[k] = visited[k].clone();
        }

        visitedCopy[i][j] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (map[cur[0]][cur[1]].equals("L")) {
                ans = Math.min(ans, cur[2]);
            }

            for (int k = 0 ; k < 4 ; k++) {
                int py = cur[0] + my[k];
                int px = cur[1] + mx[k];
                if (0 <= py && py < Y && 0 <= px && px < X) {
                    if (visitedCopy[py][px] == false && !map[py][px].equals("X")) {
                        visitedCopy[py][px] = true;
                        que.offer(new int[]{py, px, cur[2] + 1});
                    }
                }
            }
        }

        return ans;
    }

    public static int solExit(int i, int j, boolean[][] visited) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{i, j, 0});
        boolean[][] visitedCopy = new boolean[Y][X];
        int ans = Integer.MAX_VALUE;

        for (int k = 0 ; k < Y ; k++) {
            visitedCopy[k] = visited[k].clone();
        }

        visitedCopy[i][j] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (map[cur[0]][cur[1]].equals("E")) {
                ans = Math.min(ans, cur[2]);
            }

            for (int k = 0 ; k < 4 ; k++) {
                int py = cur[0] + my[k];
                int px = cur[1] + mx[k];
                if (0 <= py && py < Y && 0 <= px && px < X) {
                    if (visitedCopy[py][px] == false && !map[py][px].equals("X")) {
                        visitedCopy[py][px] = true;
                        que.offer(new int[]{py, px, cur[2] + 1});
                    }
                }
            }
        }

        return ans;
    }
}
