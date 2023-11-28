package BKS;

public class COS_3차1급문제4 {
    public static void main(String[] args) {
        String s1 = new String("ababc");
        String s2 = new String("abcdab");
        int answer = 0;
        int shortLen = Math.min(s1.length(), s2.length());
        int overLen = 0; // 중복길이
        int tempLen = 0; // 첫 중복길이 임시변수

        // s1 + s2
        for (int i = 0 ; i < shortLen ; i++) {
            if (s1.substring(s1.length() - 1 - i).equals(s2.substring(0, i + 1))) {
                overLen = Math.max(overLen, i + 1);
            }
        }

        tempLen = overLen;
        overLen = 0;

        // s2 + s1
        for (int i = 0 ; i < shortLen ; i++) {
            if (s2.substring(s2.length() - 1 - i).equals(s1.substring(0, i + 1))) {
                overLen = Math.max(overLen, i + 1);
            }
        }

        answer = s1.length() - Math.max(tempLen, overLen) + s2.length();
        System.out.println(answer);
    }
}
