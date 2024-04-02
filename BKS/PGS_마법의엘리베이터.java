package BKS;

public class PGS_마법의엘리베이터 {
    // 20240402 21:13 ~ 22:08 (못품)
    public static void main(String[] args) {
        int storey = 16;
        int answer = 0;

        while (storey != 0) {
            int digit = storey % 10;
            storey /= 10;

            if (digit == 5) {
                if (storey % 10 >= 5) {
                    answer += 10 - digit;
                    storey++;
                } else {
                    answer += digit;
                }
            } else if (digit > 5) {
                answer += 10 - digit;
                storey++;
            } else {
                answer += digit;
            }
        }
        System.out.println(answer);
    }
}
