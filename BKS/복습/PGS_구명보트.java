package BKS.복습;

import java.util.Arrays;

public class PGS_구명보트 {
    // 20231211 17:02 ~ 17:13
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int answer = 0;
        // 1. 몸무게 정렬
        Arrays.sort(people);
        int left = 0;
        int rigth = people.length - 1;

        // 2. 최대 두명씩 태워야 하므로 본인까지 왔을 때 본인의 두 배 일 때도
        //    limit을 넘든 안넘든 answer이 증가됨
        while (left <= rigth) {
            if (people[left] + people[rigth] <= limit) {
                left++;
                rigth--;
                answer++;
            } else if (people[left] + people[rigth] > limit) {
                rigth--;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
