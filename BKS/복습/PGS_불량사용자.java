package BKS.복습;

import java.util.HashSet;

public class PGS_불량사용자 {
    // 20240110 09:23 ~ 48 10:00 ~ 10:30
    static HashSet<HashSet<String>> set;
    static String[] G_user_id;
    static String[] G_banned_id;
    public static void main(String[] args) {
        int answer = 0;
        set = new HashSet<>();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        G_user_id = user_id;
        G_banned_id = banned_id;

        sol(0, new HashSet<>(), new boolean[user_id.length]);
        System.out.println(set.size());
    }
    public static void sol(int idx, HashSet<String> list, boolean[] visited) {
        if (list.size() == G_banned_id.length) {
            set.add(list);
            return;
        }

        for (int i = 0 ; i < G_user_id.length ; i++) {
            if (visited[i] == false && isTrue(G_user_id[i], G_banned_id[idx])) {
                visited[i] = true;
                list.add(G_user_id[i]);
                /*
                매개변수에 list를 쓰면 주소값 그 자체가 들어가버리기 때문에,
                나중에 list 객체를 수정하면 set안에 있는 list 객체가 수정되는 이슈 발생한다.
                그래서 깊은복사 개념을 적용하여 새로운 객체 공간을 생성하여 매개변수에 넣는다.
                 */
                sol(idx + 1, new HashSet<>(list), visited);
                list.remove(G_user_id[i]);
                visited[i] = false;
            }
        }
    }

    public static boolean isTrue(String user_id, String banned_id) {

        // 1. 두 문자열의 길이가 다르면 false이다.
        if (user_id.length() != banned_id.length()) {
            return false;
        }

        // 2. 동일한 길이의 두 문자열을 비교한다.
        for (int i = 0 ; i < banned_id.length() ; i++) {
            // 2.1 banned_id가 *이면 무시한다.
            if (banned_id.charAt(i) == '*') {
                continue;
            }
            // 2.2 두 문자열이 다른 경우 false이다.
            if (user_id.charAt(i) != banned_id.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
