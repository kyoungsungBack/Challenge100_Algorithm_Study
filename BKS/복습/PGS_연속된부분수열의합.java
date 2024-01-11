package BKS.복습;

import java.util.Arrays;

public class PGS_연속된부분수열의합 {
    // 20240111 14:01 ~ 52 15:14 ~ 15:23
    public static void main(String[] args) {
        int[] answer = new int[2];
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        boolean isFirst = false;

        // 1. 투 포인터 방식으로 부분수열의 합을 확인한다.
        while (left <= right) {
            // 2. 현재 합이 k와 같으면 들어간다.
            if (sum == k) {
                // 3. 현재 합이 k와 같고 처음 입력값이면 answer에 대입한다.
                if (!isFirst) {
                    isFirst = true;
                    answer[0] = left;
                    answer[1] = right;
                } // 4. 현재 합이 k와 같고 answer보다 구간 길이가 짧으면 answer에 대입한다.
                else if ((answer[1] - answer[0] + 1) > (right - left + 1)) {
                    answer[0] = left;
                    answer[1] = right;
                }

            }

            // 4. 현재 합을 k와 비교하여 포인터를 이동한다.
            if (sum <= k && right != sequence.length - 1) {
                sum += sequence[++right];
            } else {
                sum -= sequence[left++];
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
