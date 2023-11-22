package BKS;

import java.util.Arrays;

public class PGS_단어변환 {
    static boolean[] visited;
    static int m;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int answer = 0;
        visited = new boolean[words.length];
        Arrays.fill(visited, false);

        m = Integer.MAX_VALUE;
        for (String word : words) {
            if (word.equals(target)) {
                dfs(0, begin, target, words);
            }
        }

        if (m == Integer.MAX_VALUE) {
            System.out.println(0);
            ;
        } else {
            System.out.println(m);
        }
    }

    static public void dfs(int ans, String trans, String target, String[] words) {
        if (trans.equals(target)) {
            m = Math.min(m, ans);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            int cnt = 0;

            // 현재 글자와 단어사전의 글자가 한글자 빼고 같다면 변환 가능
            for (int j = 0; j < trans.length(); j++) {
                if (words[i].charAt(j) == trans.charAt(j) && visited[i] == false) {
                    cnt++;
                }
            }

            if (cnt == trans.length() - 1) { // 변환이 가능할 때
                visited[i] = true;
                dfs(ans + 1, words[i], target, words);
                visited[i] = false;
            }
        }
    }
}
