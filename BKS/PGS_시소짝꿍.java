package BKS;

import java.util.Arrays;

public class PGS_시소짝꿍 {

    public static void main(String[] args) {
        long answer = 0;
        int[] weights = {100,180,360,100,270};
        int N = weights.length;

        boolean[] DP = new boolean[N];
        int[] weight2 = new int[N];
        int[] weight3 = new int[N];
        int[] weight4 = new int[N];

        for (int i = 0 ; i < N ; i++) {
            weight2[i] = weights[i] * 2;
            weight3[i] = weights[i] * 3;
            weight4[i] = weights[i] * 4;
        }

        int num = 0;
        for (int i = 0 ; i < N ; i++) {
            for (int j = i + 1 ; j < N ; j++) {
                if (DP[j]) continue;

                // 1. 아직 방문을 안했고 곱한 값이 같으면 answer++ 한다.
                for (int k = 2 ; k <= 4 ; k++ ) {
                    num = weights[i] * k;
                    if (num == weight2[j] || num == weight3[j] || num == weight4[j]) {
                        answer++;
                        DP[j] = true;
                        break;
                    }
                }
            }
            Arrays.fill(DP, false);
        }

        System.out.println(answer);
    }
}
