package BKS.복습;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_프렌즈4블록 {
    // 20240311 22:56 ~ 23:41 (복습)
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int answer = 0;
        char[][] map = new char[m][n];
        int[][] isBoom = new int[m][n];

        for (int i = 0 ; i < board.length ; i++) {
            for (int j = 0 ; j < board[0].length() ; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        // 1. 매 턴 마다 2*2인 블록을 지운다.
        //   -> 지워지지 않는 순간 빈 칸의 개수가 총 없어진 수이다.
        while (true) {
            boolean flag = false;
            boolean[][] check = new boolean[m][n];

            for (int i = 0 ; i < m - 1; i++) {
                for (int j = 0 ; j < n - 1 ; j++) {
                    if (map[i][j] != '.' && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j] && map[i][j] == map[i + 1][j + 1]) {
                        check[i][j] = true;
                        check[i][j + 1] = true;
                        check[i + 1][j] = true;
                        check[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }

            // 2. map에 폭탄 터뜨리기
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        map[i][j] = '.';
                    }
                }
            }

            // 3. 블럭을 터뜨리지 못하면 탈출
            if (!flag) {
                break;
            }


            for (int i = 0 ; i < n ; i++) {
                Queue<Character> que = new LinkedList<>();

                for (int j = m - 1 ; j >= 0 ; j--) {
                    if (map[j][i] != '.') {
                        que.offer(map[j][i]);
                    }
                }

                if (que.size() < m) {
                    int needMore = m - que.size();

                    for (int j = 0; j < needMore; j++) {
                        que.add('.');
                    }
                }

                for (int j = m - 1; j >= 0; j--) {
                    map[j][i] = que.poll();
                }
            }
        }

        // 4. 맵에 있는 터진 공간을 카운트
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.') {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
