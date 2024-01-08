package BKS.복습;

import java.util.Arrays;
import java.util.Comparator;

public class PGS_단속카메라 {
    // 20240108 10:26 ~ 11:25
    public static void main(String[] args) {
        int answer = 0;
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] prev = {-30001, -30001};

        for (int[] route : routes) {
            if (prev[1] >= route[0] && prev[1] < route[1]) {
                continue;
            } else if (prev[1] >= route[0] && prev[1] >= route[1]) {
                prev = route;
            } else {
                answer++;
                prev = route;
            }
        }
        System.out.println(answer);
    }
}
