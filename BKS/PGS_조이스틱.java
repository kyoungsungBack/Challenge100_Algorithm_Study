package BKS;

public class PGS_조이스틱 {
    // 20240428 15:22 ~ x (다시풀기)
    // 20240429 12:42 ~ 13:24 (복습)
    public static void main(String[] args) {
        int answer = 0;
        String name = "JEROEN";

        // 1. 상하로 바꿀 수 있는 최소 조작횟수를 구한다.
        for (int i = 0 ; i < name.length() ; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }

        int len = name.length();
        int move = name.length() - 1; // 좌우 최소 횟수이며 우측이동 조작횟수 초기화

        // 2. 좌우로 이동하는 최소 조작횟수를 구한다.
        for (int i = 0 ; i < name.length() ; i++) {
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            // 2.1.
            // (i * 2) : 처음 -> 우 -> 좌 -> 처음
            // len - next : 연속된 A 이후의 남은 이동횟수
            move = Math.min(move, (i * 2) + len - next);

            // 2.2.
            // (len - next) * 2 : 처음 -> 좌 -> 우 -> 처음
            // i : 연속된 A 이전의 이동횟수
            move = Math.min(move, (len - next) * 2 + i);
        }

        answer += move;
        System.out.println(answer);
    }
}
