package BKS;

public class PGS_n진수게임 {
    // 20240112 15:58 ~ 16:18 (복습 해야 함)
    public static void main(String[] args) {
        String answer = "";
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        int len = 1; // 현재 나열된 숫자의 길이
        int tube = p; // 튜브의 위치

        // 1. 필요한 개수 * 전체 인원 = 확인해야 하는 최대 길이 만큼 반복해서 확인한다.
        for (int i = 0 ; i <= t * m ; i++) {
            String temp = Integer.toString(i, n).toUpperCase();

            // 2. n진수 변환된 숫자에서 tube 차례에 해당될 때 마다 answer에 더한다.
            for (int j = 0 ; j < temp.length() ; j++) {
                if (len == tube) {
                    answer += temp.substring(j, j + 1);
                    tube += m;
                }

                // 3. 원하는 갯수 만큼 채워졌으면 반복문 종료한다.
                if (answer.length() == t) break;

                len++;
            }
        }
        System.out.println(answer);
    }
}
