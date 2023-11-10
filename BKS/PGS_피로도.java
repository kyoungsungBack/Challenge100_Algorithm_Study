package BKS;

import java.util.Arrays;

public class PGS_피로도 {static int result;
    static boolean[] visited;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        result = 0;
        visited = new boolean[dungeons.length];
        Arrays.fill(visited, false);

        cal(0, k, dungeons);
        System.out.println(result);;
    }
    public static void cal(int cnt, int k, int[][] dungeons) {
        for(int i = 0 ; i < dungeons.length ; i++) {
            // 해당 인덱스에 해당하는 던전을 아직 안돌았으면 돌기
            if (visited[i] == false && k >= dungeons[i][0]) {
                visited[i] = true;
                cal(cnt + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }

        result = Math.max(result, cnt);
    }
}
