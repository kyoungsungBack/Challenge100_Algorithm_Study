package BKS;

import java.util.Arrays;

public class PGS_최소직사각형 {
    // 20240424 12:27 ~ 12:35
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int answer = 0;
        int n = sizes.length;


        // 1. 하나의 명함의 가로, 세로는 쌍이고 각각 분리하여 배열에 담는다.
        int[] width = new int[n];
        int[] height = new int[n];

        int i = 0;
        // 2. 가로와 세로중 긴 변은 가로배열에 담고 짧은 변은 세로배열에 담는다.
        for (int[] size : sizes) {
            width[i] = Math.max(size[0], size[1]);
            height[i] = Math.min(size[0], size[1]);
            i++;
        }

        // 3. 정렬을 통해 가로, 세로 각각의 가장 긴 길이를 찾아 곱한 뒤 answer에 담는다.
        Arrays.sort(width);
        Arrays.sort(height);
        answer = width[n - 1] * height[n - 1];

        System.out.println(answer);
    }

}
