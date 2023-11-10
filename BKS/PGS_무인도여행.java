package BKS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PGS_무인도여행 {
    static String[][] map;
    static Boolean[][] flag;
    static int Y, X;
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};

    public static void main(String[] args) {
        //String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};
        String[] maps = {"XXX","XXX","XXX"};
        Y = maps.length;
        X = maps[0].length();
        map = new String[Y][X];
        flag = new Boolean[Y][X];

        int[] answer = {};

        // X : 바다
        // 1~9 : 무인도
        for (int i = 0; i < Y; i++) {
            Arrays.fill(flag[i], false); // boolean 배열은 null로 초기화 되므로
        }

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                // map 이차원 배열에 입력
                map[i][j] = String.valueOf(maps[i].charAt(j));
                // 수 일때만 방문
                if (maps[i].charAt(j) != 'X') {
                    flag[i][j] = true;
                }

            }
        }
        /*
        for (int i = 0; i < Y; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        for (int i = 0; i < Y; i++) {
            System.out.println(Arrays.toString(flag[i]));
        }*/

        ArrayList<Integer> ans = new ArrayList<>();
        // map을 돌면서 숫자로 시작되는 구간 찾기
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                // 방문을 안했고 바다가 아닐 때만
                if (flag[i][j] == true && !map[i][j].equals("X")) {
                    ans.add(bfs(i, j));
                }
            }
        }

        if (ans.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                answer[i] = ans.get(i);
            }
            Arrays.sort(answer);
        }
        System.out.println(Arrays.toString(answer));;
    }

    static public int bfs(int py, int px) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int sum = Integer.parseInt(map[py][px]);

        pq.add(new Point(px, py));
        flag[py][px] = false;

        while (!pq.isEmpty()) {
            // flag가 true이면 map의 수 sum
            Point cur = pq.poll();

            for (int i = 0; i < 4; i++) {
                int qx = cur.x + mx[i];
                int qy = cur.y + my[i];
                if (0 <= qx && qx < X && 0 <= qy && qy < Y) {
                    // 아직 방문을 안한 숫자면 들어간다
                    if (flag[qy][qx] == true) {
                        sum += Integer.parseInt(map[qy][qx]);   // 1. 그때의 수를 더함
                        pq.add(new Point(qx, qy));               // 2. 큐에 넣음
                        flag[qy][qx] = false;                   // 3. 방문표시를 함
                    }
                }
            }
        }
        return sum;
    }
}

class Point implements Comparable {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
