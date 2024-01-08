package BKS.복습;

public class PGS_입국심사 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        long answer = 0;
        int len = times.length;

        long left = 1;
        long right = (long) times[len - 1] * n;
        long mid = 0;
        long mok = 0;

        // 1. 몫을 기준으로 모두 분배가 되는 시점을 찾아간다,
        while (left <= right) {
            mok = 0;
            mid = (left + right) / 2;

            // 2. 현재 시간으로 몇 명이 입국심사를 완료할 수 있는지 확인
            for (int i = 0 ; i < times.length ; i++) {
                mok += (long) mid / times[i];
            }

            // 3. 입국심사 인원을 n과 비교
            if (mok < n) {  // 3.1 입국심사를 못받은 사람이 있는 경우
                left = mid + 1;
            } else {        // 3.2 입국심사를 받을 인원을 초과한 경우
                right = mid - 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}
