package BKS;

import java.util.HashSet;
import java.util.Set;

public class PGS_연속부분수열합의개수 {
    // 20240404 18:24 ~ 19:06
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int n = (elements.length * 2) - 1;
        int[] arr = new int[n];

        // 1. 연속된 수열 형태를 만들고 그 수열의 합 배열을 만든다.
        arr[0] = elements[0];
        for (int i = 1 ; i < elements.length ; i++) {
            arr[i] = arr[i - 1] + elements[i];
        }

        for (int i = 0 ; i < elements.length - 1 ; i++) {
            arr[i + elements.length] = arr[i + elements.length - 1] + elements[i];
        }

        // 2. 부분합으로 가질 수 있는 값을 계산하여 set에 담는다.
        //    1 ~ elements.length 개로 만들 수 있는 연속된 부분합을 찾늗다.
        //    이때, set을 사용하여 중복을 제거한다.
        for (int i = arr.length - 1 ; i >= 1  ; i--) {
            for (int j = i - elements.length ; j < i ; j++) {
                // 2.1. i가 elements 길이와 값이 같을 땐 elements.length을 빼주면 음수가 되므로 제한한다.
                if (j < 0) {
                    continue;
                }
                set.add(arr[i] - arr[j]);
            }
        }

        System.out.println(set.size());
    }
}
