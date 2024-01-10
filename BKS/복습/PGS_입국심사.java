package BKS.복습;

public class PGS_입국심사 {
    // 20240110 15:46 ~ 51 16:06 ~ 20
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        long answer = 0;
        long left = 1;
        long right = (long)times[times.length - 1] * n;
        long mid = 0; // 시간값
        long mok = 0;

        // 0. time배열은 int이므로 계산 시에 long으로 형변환 해준다.

        // 1. 가장 최소의 시간 구할 때 까지 반복한다.
        while (left <= right) {
            mid = (left + right) / 2;
            mok = 0;

            for (int i = 0 ; i < times.length ; i++) {
                mok +=  mid / (long)times[i];
            }

            // 2. 심사 받을 인원이 n일 때의 최소값 mid를 찾는다.
            if (mok < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}
