package BKS;

public class PGS_124나라의숫자 {
    // 20240113 15:25 ~ 16:13
    public static void main(String[] args) {
        int n = 4;
        String answer = "";
        String[] arr = {"4", "1", "2"};
        /*
           0. 특수한 숫자로 진법 변환 시에 진법변환에 주어진 수(4, 1, 2)로 배열을 만들고
              나머지를 배열의 인덱스로 이용하여 변환한다.
              이때, 변환하려는 수가 배열길이의 배수일 때 마다 이전 수와 몫이 같도록
              (변환하려는 수 - 1)을 배열길이로 나눠서 수를 줄여나간다.
        */

        // 1. n의 나머지로 해당하는 수를 더 해간다.
        while (n > 0) {
            answer = arr[n % 3] + answer;
            // 2. n이 3의 배수일 경우, 나누기 연산에 의해 몫이 증가하여 다음 연산의 나머지가 증가하므로 n을 1만큼 줄여준다.
            if (n % 3 == 0) {
                n--;
            }
            n = n / 3;
            // 또는 n = (n - 1) / 3;
        }
        System.out.println(answer);
    }
}
