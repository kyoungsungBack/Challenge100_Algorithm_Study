package BKS;

public class PGS_큰수만들기 {
    public static void main(String[] args) {
        String number = "1924";
        int k = 2;
        String answer = "";
        StringBuilder sb = new StringBuilder();

        // 1 2 3 1 2 3 4
        char[] array = number.toCharArray();

        // 7 - 3 = 4
        int len = array.length - k;

        // 문자 비교를 시작하는 인덱스를 나타내는 start 변수
        int start = 0;

        // i = 0, 1, 2, 3
        for (int i = 0 ; i < len ; i++) {
            char max = '0';
            for (int j = start ; j <= i + k ; j++) {
                // 가장 큰수를 골라서 그 다음 인덱스를 시작 인덱스로 설정하기
                if (array[j] > max) {
                    max = array[j];
                    start = j + 1;
                }
            }
            // 가장 큰 문자를 String에 넣어주기
            sb.append(Character.toString(max));
        }

        // k개의 수를 제거할 때 얻을 수 있는 가장 큰 숫자를 구하려 한다
        answer = sb.toString();
        System.out.println(answer);
    }
}
