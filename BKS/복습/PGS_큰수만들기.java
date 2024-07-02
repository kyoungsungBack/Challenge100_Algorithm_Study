package BKS.복습;

public class PGS_큰수만들기 {
    // 20240111 09:24 ~ 09:31
    // 20240702 21:30 ~ 21:56
    public static void main(String[] args) {
        String number = "1924";
        int k = 2;
        String answer = "";
        StringBuilder sb = new StringBuilder();

        // 1. 얻고자 하는 숫자의 길이를 지정한다.
        int len = number.length() - k;

        int start = 0;
        // 2. number에서 확인해볼 구간을 정하여 각 구간의 최대를 sb에 담는다.
        for (int i = 0 ; i < len ; i++) {
            char max = '0';
            for (int j = start ; j <= i + k ; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    start = j + 1;
                }
            }
            sb.append(max);
        }

        answer = sb.toString();
        System.out.println(answer);
    }
}
