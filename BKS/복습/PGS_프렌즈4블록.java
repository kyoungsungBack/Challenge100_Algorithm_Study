package BKS.복습;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_프렌즈4블록 {
    // 20240311 22:56 ~ 23:41 (복습)
    // 20240312 22:12 ~ 22:39
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int answer = 0;
        char[][] map = new char[m][n];

        for (int i = 0 ; i < board.length ; i++) {
            for (int j = 0 ; j < board[0].length() ; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        // 1. 매 턴 마다 map에서 같은 블럭 2*2가 있으면 터뜨린다.
        while (true) {
            boolean[][] isBoom = new boolean[m][n];
            boolean flag = false;
            for (int i = 0 ; i < m - 1 ; i++) {
                for (int j = 0 ; j < n - 1 ; j++) {
                    // 2. 2*2가 모두 같은 블럭이고 터진 블럭이 아니면 터짐(true) 표시한다.
                    if (map[i][j] != '.' && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j] && map[i][j] == map[i + 1][j + 1]) {
                        isBoom[i][j] = true;
                        isBoom[i + 1][j] = true;
                        isBoom[i][j + 1] = true;
                        isBoom[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }

            // 3. 터지지 않았으면 반복문 탈출한다.
            if (!flag) {
                break;
            }

            // 4. 터짐으로 표시된 좌표를 가진 map에 터짐 표시를 한다.
            for (int i = 0 ; i < m ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    if (isBoom[i][j] == true) map[i][j] = '.';
                }
            }

            // 5. 열마다 해당 행의 마지막부터 큐에 담고 map에 다시 정렬한다.
            for (int i = 0 ; i < n ; i++) {
                Queue<Character> que = new LinkedList<>();

                // 5.1. 터지지 않은 블록을 que에 담는다.
                for (int j = m - 1 ; j >= 0 ; j--) {
                    if (map[j][i] != '.') {
                        que.offer(map[j][i]);
                    }
                }

                // 5.2. 터진 블록은 행의 길이만큼 마저 채운다.
                int cnt = m - que.size();
                for (int j = 0 ; j < cnt ; j++) {
                    que.offer('.');
                }

                // 5.3. que에 있는 블록 순서를 다시 넣는다.
                for (int j = m - 1 ; j >= 0 ; j--) {
                    map[j][i] = que.poll();
                }
            }
        }

        // 6. 터진 블럭의 개수를 세고 반환한다.
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (map[i][j] == '.') answer++;
            }
        }
        System.out.println(answer);
    }
}
