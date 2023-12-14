package BKS;

public class COS_2차1급문제10 {
    public static void main(String[] args) {
        String s = "101100011100";
        s += '#'; // 맨 끝 length : 13 이고 맨끝 #은 어떤 조건에도 들어가지 않음
        String answer = "";
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0' && s.charAt(i + 1) != '0') {
                answer += "0";
            } else if (s.charAt(i) == '1') {
                answer += "1";
            }
        }
        System.out.println(answer);

    }
}
