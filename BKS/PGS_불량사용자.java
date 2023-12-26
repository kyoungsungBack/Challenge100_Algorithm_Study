package BKS;

import java.util.HashSet;

public class PGS_불량사용자 {
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
        // 집합이 생성되면 set에 넣기
        if (depth == bannedIds.length) {
            list.add(set);
            return;
        }

        // 만들 수 있는 집합 만들기
        for (int i = 0 ; i < userIds.length ; i++) {
            // 집합에 현재 원소가 있는 경우 무시(중복허용 x)
            if (set.contains(userIds[i])) {
                continue;
            }

            // 현재 아이디가 제재 아이디인지 확인
            if (cheek(userIds[i], bannedIds[depth])) {
                set.add(userIds[i]);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(userIds[i]);
            }
        }
    }

    public static boolean cheek(String str1, String str2) {
        // 두 str의 길이가 다르면 매핑 오류
        if (str1.length() != str2.length()) {
            return false;
        }

        // str2가 *이고 의 길이가 다르면 매핑 오류
        boolean isCheek = true;
        for (int i = 0 ; i < str2.length() ; i++) {
            if (str2.charAt(i) == '*') {
                continue;
            }

            if (str1.charAt(i) != str2.charAt(i)) {
                isCheek = false;
                break;
            }
        }

        return isCheek;
    }
}
