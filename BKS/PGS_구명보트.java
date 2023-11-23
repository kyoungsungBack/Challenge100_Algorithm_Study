package BKS;

import java.util.Arrays;

public class PGS_구명보트 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int answer = 0;

        // 최대 2명이 짝이되고 무게제한이 있다.
        Arrays.sort(people);
        int left = 0;
        int right = 0;

        while (left <= right) {
            // 최소 + 최대 가 limit보다 작으면 짝이 된다.
            if (people[left] + people[right] <= limit) {
                left++;
            }
            // 최소 + 최대 가 limit보다 크면 최소 + 최대보다 하나 작은 애들끼리 짝이 된다.
            right--;

            // 매번 짝이 생성되므로 answer 1 증가
            answer++;
        }
    }
}
