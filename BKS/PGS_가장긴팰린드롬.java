package BKS;

public class PGS_가장긴팰린드롬 {
    // 20240104 13:58 ~ 14:17 (정확성 O, 효율성 X)
    public static void main(String[] args) {
        String s = "abcdcba";
        int answer = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            for (int j = s.length() - 1 ; j >= i ; j--) {
                if (answer < j - i + 1) {
                    if (isPal(s, i, j)) {
                        answer = j - i + 1;
                    }
                }
            }
        }

        System.out.println(answer);
    }
    public static boolean isPal(String s, int start, int end) {
        boolean ans = true;

        // 문자열 직접비교
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return ans;
    }
}
