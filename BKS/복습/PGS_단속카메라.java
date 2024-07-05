package BKS.복습;

import java.util.Arrays;
import java.util.Comparator;

public class PGS_단속카메라 {
    // 20240108 10:26 ~ 11:25
    // 20240703 22:10 ~ 22:50 X
    // 20240706 01:20 ~ 01:34
    public static void main(String[] args) {
        int answer = 0;
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        // 그리디 -> 현재 구간에 가장 많이 찍을 수 있는 차를 찾는다.

        // 1. 출발지점을 기준으로 오름차순 정렬한다.
        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);

        // 2. 매번 구간을 확인하며, 구간안에 속하는지 확인한다.
        // -> 출발지점 기준 오름차순 정렬이므로 start는 확인 안해도 된다.
        int start = -30001;
        int end = -30001;
        for (int[] range : routes) {
            // 현재 구간에 속한 경우
            // -> 범위를 좁혀가며 같이 찍힐 수 있는지 확인해야 한다.
            if (range[0] <= end && range[1] <= end) {
                start = range[0];
                end = range[1];
            } // 현재 구간에 겹친 경우
            // -> 현재 구간을 다음에도 확인하므로 무시한다. (어차피 같이 찍힘)
            else if (range[0] <= end && range[1] > end) {
                continue;
            } // 현재 구간을 벗어난 경우
            else {
                start = range[0];
                end = range[1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
