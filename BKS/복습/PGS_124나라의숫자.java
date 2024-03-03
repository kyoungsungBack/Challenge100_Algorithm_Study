package BKS.복습;

public class PGS_124나라의숫자 {
    // 20240302 19:38 ~ 18:00 복습 다시 하기
    // 20240303 10:48 ~ 10:58
    public static void main(String[] args) {
        int n = 4;
        String answer = "";
        String[] arr = {"4", "1", "2"};

        // 1. 3종류 진수 변환이므로 3으로 나눈 나머지를 인덱스로 활용한다.
        while (n > 0) {
            answer = arr[n % 3] + answer;

            // 2. 이때, 3의 배수는 두번째 진수 변환에서 예상된 몫보다 1 커지므로
            //    n - 1을 3으로 나눈 몫을 n에 넣어서 진수 변환을 이어간다.
            n = (n - 1) / 3;
        }

        System.out.println(answer);
    }
}
