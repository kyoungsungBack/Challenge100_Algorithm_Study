package BKS;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_올바른괄호 {
    // 20240620 21:46 ~ 22:06
    public static void main(String[] args) {
        boolean answer = true;
        String s = "(())()";
        Queue<Character> que = new LinkedList<>();
        if (s.charAt(0) == ')') answer = false;

        for (int i = 0 ; i < s.length() ; i++) {
            // ( 일때만 담는다.
            if (s.charAt(i) == '(') {
                que.offer(s.charAt(i));
            } else if (s.charAt(i) == ')' && que.size() != 0) {
                que.poll();
            }
        }

        if (que.size() != 0) answer = false;

        System.out.println(answer);
    }
}
