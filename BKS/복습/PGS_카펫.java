package BKS.복습;

import java.util.Arrays;

public class PGS_카펫 {
    // 20240111 09:36 ~ 10:26
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        int[] answer = new int[2];
        int sum = brown + yellow;

        for (int i = 3 ; i <= Math.sqrt(sum) ; i++) {
            if (sum % i == 0) {
                int row = (sum / i) - 2; // mok
                int col = i - 2;
                if (row * col == yellow) {
                    answer[0] = sum / i;
                    answer[1] = i;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
