package BKS;

public class COS_1차1급문제1 {
    public static void main(String[] args) {
        long num = 9949999;
        /* 풀이1 */
        /*
        String str = String.valueOf(num + 1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) == '0') {
                sb.append("1");
            } else {
                sb.append(String.valueOf(str.charAt(i)));
            }
        }

        num = Long.parseLong(sb.toString());
        */

        /* 풀이 2 */
        num++; // 1을 더해준 수를 리턴하므로
        int digit = 1; // 주어진 수의 자릿수 나타내는 변수

        while ((num / digit) % 10 == 0) {
            num += digit;
            digit *= 10;
        }

        System.out.println(num);
    }
}
