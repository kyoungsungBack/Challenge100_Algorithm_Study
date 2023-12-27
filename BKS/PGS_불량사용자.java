package BKS;

import java.util.HashSet;

public class PGS_불량사용자 {
    // 20231227 09:11 ~ 09:23
    static String[] userIds;
    static String[] bannedIds;
    static HashSet<HashSet<String>> list;

    public static void main(String[] args) {
        int answer = 0;
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};
        userIds = user_id;
        bannedIds = banned_id;
        list = new HashSet<>();

        dfs(new HashSet<>(), 0);

        System.out.println(list.size());
    }

    public static void dfs(HashSet<String> set, int depth) {
        // list는 만들어진 집합의 중복을 포함하지 않아야 하므로 set 선언
        if (depth == bannedIds.length) {
            list.add(set);
            return;
        }

        for (int i = 0; i < userIds.length; i++) {
            if (set.contains(userIds[i])) continue;

            // 완전탐색을 한다.
            if (cheek(userIds[i], bannedIds[depth])) {
                set.add(userIds[i]);
                // 기존 set을 인자로 안넣는 이유는?
                // -> 새로운 집합을 계속 만드므로
                dfs(new HashSet<>(set), depth + 1);
                set.remove(userIds[i]);
            }
        }
    }

    public static boolean cheek(String str1, String str2) {
        // 길이가 다르면 다른 글자이므로 false
        if (str1.length() != str2.length()) return false;

        // 길이 같고 *를 제외한 글자가 같으면 true
        boolean isCheek = true;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) != '*' && str1.charAt(i) != str2.charAt(i)) {
                isCheek = false;
                break;
            }
        }
        return isCheek;
    }
}
