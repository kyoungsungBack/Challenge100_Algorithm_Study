package BKS;

public class PGS_마법의엘리베이터 {
    // 20240402 21:13 ~ 22:08 (못품)
    // 20240403 09:20 ~ 09:29 (복습)
    public static void main(String[] args) {
        int storey = 555;
        int answer = 0;

        // 0. 일, 십의 자리가 5초과면 올림 이하면 버림하며 횟수를 센다.

        // 1. storey를 줄여가며 일의 자리 부터 나머지를 계산하고 올림, 버림을 정한다.
        while (storey != 0) {
            int digit = storey % 10; // 일의 자리 나머지 계산
            storey /= 10; // 한자리 위의 수를 구하기 위해 10을 나눈다.

            // 2.1. 일의자리가 5이면 십의자리도 확인한다.
            //      (다음 연산의 수를 4이하 6이상 수로 만들어 준다.)
            if (digit == 5) {
                // 2.1.1. 십의자리가 5보다 크면 십의자리 1 키운다.
                //        (다음 연산에서 올림이 최소 횟수로 더 해진다.)
                if (storey % 10 >= 5) {
                    answer += (10 - digit);
                    storey++;
                } // 2.1.2. 십의자리가 5 미만이면 나머지만큼만 더 한다.
                else {
                    answer += digit;
                }
            } // 2.2. 일의자리가 5보다 크면 올리고 십의자리 수를 1키운다.
            else if (digit > 5) {
                answer += (10 - digit);
                storey++;
            } // 2.3. 일의자리가 5미만이면 버린다.
            else {
                answer += digit;
            }
        }
        System.out.println(answer);
    }
}
