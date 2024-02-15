package BKS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGS_프렌즈4블록 {
    public static void main(String[] args) {
        int answer = 0;
        int M = 6;
        int N = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        char[][] map = new char[M][N];

        // 1. map에 문자열 하나씩 담아서 관리한다.
        for (int i = 0 ; i < M ; i++) {
            map[i] = board[i].toCharArray();
        }


        // 2. 매 턴에 대해서 4블록을 찾고 답을 반환한다.
        // 이때, 더이상 4블록이 없으면 종료한다.
        while (true) {
            boolean flag = false;
            boolean[][] visited = new boolean[M][N];// 같은 턴에서 이미 없어진 블록임을 판단한다.

            // 3. 매 턴을 돌면서 확인한다.
            for (int i = 0 ; i < M - 1 ; i++) {
                for (int j = 0 ; j < N - 1 ; j++) {
                    // 아래 4블록이 같으면 visited 배열에 1을 넣는다.
                    char ch = map[i][j];
                    if (ch != 'X' && ch == map[i + 1][j] && ch == map[i][j + 1] && ch == map[i + 1][j + 1]) {
                        visited[i][j] = true;
                        visited[i + 1][j] = true;
                        visited[i][j + 1] = true;
                        visited[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) {
                        map[i][j] = 'X';
                    }
                }
            }

            // 5. 만약 더이상 삭제할게 없으면 반복문 탈출한다.
            if (!flag) {
                break;
            }

            for (int j = 0 ; j < N ; j++) {
                Queue<Character> que = new LinkedList<>();

                for (int i = M - 1; i >= 0; i--) {
                    // 현재 칸이 없어질 칸이면 채운다.
                    if (map[i][j] != 'X') {
                        que.add(map[i][j]);
                    }
                }

                if (que.size() < M) {
                    int needMore = M - que.size();

                    for (int i = 0 ; i < needMore ; i++) {
                        que.add('X');
                    }
                }

                for (int i = M - 1; i >= 0; i--) {
                    map[i][j] = que.poll();
                }
            }
        }

        // 4. 맵에 있는 터진 공간을 카운트
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X') {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
