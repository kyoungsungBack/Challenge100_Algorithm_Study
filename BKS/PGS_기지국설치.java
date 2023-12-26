package BKS;

public class PGS_기지국설치 {
    // 20231226 10:43 ~ 11:08
    public static void main(String[] args) {
        int n = 16;
        int[] stations = {9};
        int w = 2;

        int answer = 0;
        int begin = 1;

        for (int stat : stations) {
            if (begin < stat - w) {
                answer += (stat - w - begin) / (2 * w + 1);

                if ((stat - w - begin) % (2 * w + 1) != 0) {
                    answer++;
                }
            }

            begin = stat + w + 1;
        }

        if (begin <= n) {
            answer += (n - begin + 1) / (2 * w + 1);

            if ((n - begin + 1) % (2 * w + 1) != 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
