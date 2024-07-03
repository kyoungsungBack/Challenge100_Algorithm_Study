package BKS.복습;

import java.util.Arrays;

public class PGS_구명보트 {
    // 20231211 17:02 ~ 17:13
    // 20240703 21:46 ~ 21:56
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int answer = 0;

        // 1. people 배열을 정렬한다.
        Arrays.sort(people);

        // 2. 최대 두 명 탑승 가능하므로 두개씩 비교하여 최솟값을 구한다.
        int l = 0;
        int r = people.length - 1;
        while (r >= l) {
            if (people[r] + people[l] <= limit) {
                r--;
                l++;
            } else {
                r--;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
