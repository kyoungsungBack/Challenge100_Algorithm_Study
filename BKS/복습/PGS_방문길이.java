package BKS.복습;

import java.util.HashSet;
import java.util.Set;

public class PGS_방문길이 {
    // 20231210 18:54 ~ 19:28
    static Set<String> path;
    static int[] my = {1, -1, 0, 0};
    static int[] mx = {0, 0, 1, -1};
    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        int answer = 0;
        path = new HashSet<>();

        int y = 0; // 시작점
        int x = 0; // 시작점
        int py = 0; // 끝점
        int px = 0; // 끝점
        for (int i = 0 ; i < dirs.length() ; i++) {
            switch(dirs.charAt(i)) {
                case 'U':
                    py = y + my[0];
                    px = x + mx[0];
                    break;
                case 'D':
                    py = y + my[1];
                    px = x + mx[1];
                    break;
                case 'R':
                    py = y + my[2];
                    px = x + mx[2];
                    break;
                case 'L':
                    py = y + my[3];
                    px = x + mx[3];
                    break;
            }

            if (-5 <= py && py <= 5 && -5 <= px && px <= 5) {
                if (!path.contains(x +""+ y +""+ px +""+ py)) {
                    path.add(px +""+ py +""+ x +""+ y);
                    path.add(x +""+ y +""+ px +""+ py);
                    answer++;
                }

                y = py;
                x = px;
            }
        }
        System.out.println(answer);
    }
}
