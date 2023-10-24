package BKS;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PGS_미로탈출 {
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};
    static String[][] map;
    static boolean[][] visit;
    static int Y;
    static int X;

    public static void main(String[] args) {
        int answer = 0;
        //String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        String[] maps = {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};
        // 통로: 지나갈 수 있음
        // 벽: 지나갈 수 없음
        // 통로 -> 레버 -> 출구
        Y = maps.length;
        X = maps[0].length(); // 배열 내의 원소 길이는 length()

        map = new String[Y][X];
        visit = new boolean[Y][X];

        // 1 지도 완성
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                map[i][j] = String.valueOf(maps[i].charAt(j));
            }
        }

        // 시작지점에서 출발(bfs)
        // 레버를 먼저 찾는다(최소)

        // 레버에서 출발(bfs)
        // 이후에 출구를 찾아간다(최소)

        // 위의 두 최소시간을 더하면 답


        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (map[i][j].equals("S")) { // 2 시작점 -> 레버 까지 최소시간
                    answer += leverSearch(i, j); // leverSearch를 통해 반환된 최소시간을 answer에 더 함
                } else if ((map[i][j].equals("L"))) { // 4 레버 -> 출구 까지 최소시간
                    answer += exitSearch(i, j); // exitSearch를 통해 반환된 최소시간을 answer에 더 함
                }
            }
        }

        // 6 레버 또는 출구를 못찾으면 int 범위를 벗어나면서 음수가 됨
        if (answer < 0) {
            answer = -1;
        }

        System.out.println(answer);
        //return answer;
    }

    static public int leverSearch(int y, int x) {
        // 방문배열 초기화
        for (int i = 0; i < Y; i++) {
            Arrays.fill(visit[i], false);
        }

        // 3 BFS를 통해 시작점 에서 레버를 찾는 최소시간을 찾는다
        int curTime = Integer.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(y, x, 0));
        visit[y][x] = true;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (map[cur.y][cur.x].equals("L")) {
                curTime = Math.min(curTime, cur.time);
            }

            for (int i = 0; i < 4; i++) {
                int py = cur.y + my[i];
                int px = cur.x + mx[i];
                if (0 <= py && py < Y && 0 <= px && px < X) {
                    if (!map[py][px].equals("X") && visit[py][px] == false) {
                        pq.offer(new Node(py, px, cur.time + 1));
                        visit[py][px] = true;
                    }
                }
            }
        }

        return curTime;
    }

    static public int exitSearch(int y, int x) {
        // 방문배열 초기화
        for (int i = 0; i < Y; i++) {
            Arrays.fill(visit[i], false);
        }

        // 5 BFS를 통해 시작점 에서 레버를 찾는 최소시간을 찾는다
        int curTime = Integer.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(y, x, 0));
        visit[y][x] = true;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (map[cur.y][cur.x].equals("E")) {
                curTime = Math.min(curTime, cur.time);
            }

            for (int i = 0; i < 4; i++) {
                int py = cur.y + my[i];
                int px = cur.x + mx[i];
                if (0 <= py && py < Y && 0 <= px && px < X) {
                    if (!map[py][px].equals("X") && visit[py][px] == false) {
                        pq.offer(new Node(py, px, cur.time + 1));
                        visit[py][px] = true;
                    }
                }
            }

        }

        return curTime;
    }
}

class Node implements Comparable<Node> {
    int y;
    int x;
    int time;

    public Node(int y, int x, int time) {
        this.y = y;
        this.x = x;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time;
    }
}
