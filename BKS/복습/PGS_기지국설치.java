package BKS.복습;

public class PGS_기지국설치 {
    // 20240108 12:13 ~ 12:29
    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;

        int answer = 0;
        int range = w * 2 + 1;

        int begin = 1;
        for (int stat : stations) {
            int end = stat - w;

            if (begin >= end) {
                begin = stat + w + 1;
                continue;
            }

            answer += (end - begin) / range;
            if ((end - begin) % range != 0) {
                answer++;
            }

            begin = stat + w + 1;
        }

        if (begin <= n) {
            answer += (n - begin + 1) / range;
            if ((n - begin + 1) % range != 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
