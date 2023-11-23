package BKS;

import java.util.ArrayList;

public class PGS_방문길이 {
    static int[] mx = {0, 0, 1, -1};
    static int[] my = {1, -1, 0, 0};

    public static void main(String[] args) {
        // 1. 범위를 벗어날 때
        // 2. 같은 통로를 지날 때(같은 통로를 반대로 갔을 때도 제외)
        // 1, 2 제외하고 경로 길이 반환
        String dirs = "ULURRDLLU";
        ArrayList<String> path = new ArrayList<>();

        // 출발 좌표
        int x = 0;
        int y = 0;

        for (int i = 0; i < dirs.length(); i++) {
            int px = 0;
            int py = 0;

            if ("U".equals(String.valueOf(dirs.charAt(i)))) {
                px = x + mx[0];
                py = y + my[0];
            } else if ("D".equals(String.valueOf(dirs.charAt(i)))) {
                px = x + mx[1];
                py = y + my[1];
            } else if ("R".equals(String.valueOf(dirs.charAt(i)))) {
                px = x + mx[2];
                py = y + my[2];
            } else if ("L".equals(String.valueOf(dirs.charAt(i)))) {
                px = x + mx[3];
                py = y + my[3];
            }

            // 1. 범위를 벗어나지 않을 경우
            if (-5 <= px && px <= 5 && -5 <= py && py <= 5) {
                // 2. 같은 통로를 지날 경우(같은 통로를 반대로 갔을 때도 제외)
                //  -> 지나가지 않은 통로일 때만 path에 등록된다.
                if (!path.contains(x + "" + y + "" + px + "" + py) && !path.contains(px + "" + py + "" + x + "" + y)) {
                    path.add(x + "" + y + "" + px + "" + py);
                }

                // 도착 좌표 (주어진 UDRL로 이동된 좌표가 다음 출발 좌표가 된다.)
                x = px;
                y = py;
            }
        }
    }
}
