package BKS.복습;

public class PGS_JadenCase문자열만들기 {
    // 20240306 풀이
    public static void main(String[] args) {
        String s = "3people unFollowed me";
        String answer = "";
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        String start = "";
        String end = "";

        // 1. 처음 문자 앞 공백을 구한다.
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) != ' ') {
                break;
            }

            start += s.charAt(i);
        }

        // 2. 끝 문자 뒤 공백을 구한다.
        for (int i = s.length() - 1 ; i > 0 ; i--) {
            if (s.charAt(i) != ' ') {
                break;
            }

            end += s.charAt(i);
        }

        // 3. 중간 문자들의 변환을 구한다.
        for (String str : strArr) {
            if (str.equals("")) {
                sb.append(" ");
                continue;
            }

            sb.append(str.substring(0,1).toUpperCase());
            sb.append(str.substring(1).toLowerCase());
            sb.append(" ");
        }

        // 4. 처음, 중간, 끝 문자열을 더하여 반환한다.
        System.out.println(start + sb.substring(0, sb.length() - 1) + end);
    }
}
