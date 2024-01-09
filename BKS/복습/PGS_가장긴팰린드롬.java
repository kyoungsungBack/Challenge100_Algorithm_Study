package BKS.복습;

public class PGS_가장긴팰린드롬 {
    // 20240109 09:23 ~ 10:06
    public static void main(String[] args) {
        int answer = 0;
        String s = "abcdcba";
        for (int i = 0 ; i < s.length() ; i++) {
            for (int j = i ; j < s.length() ; j++) {
                if (j - i + 1 > answer && sol(s, i, j)) {
                    answer = j - i + 1;
                }
            }
        }

        System.out.println(answer);
    }
    public static boolean sol(String s, int start, int end) {
        boolean isPal = true;

        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return isPal;
    }
}
