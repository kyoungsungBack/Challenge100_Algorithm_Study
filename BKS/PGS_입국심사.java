package BKS;

public class PGS_입국심사 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        long answer = 0;

        long mok = 0;
        long left = 1;
        long right = (long) n * times[times.length - 1];
        long mid = 0;

        while (left <= right) {
            mok = 0;
            mid = (right + left) / 2;

            for (int i = 0 ; i < times.length ; i++) {
                mok += mid / times[i];
            }

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
