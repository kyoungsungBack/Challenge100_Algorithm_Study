package BKS.복습;

public class PGS_단어변환 {
    // 20231210 18:30 ~ 18:50
    static int answer;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        answer = Integer.MAX_VALUE;
        dfs(0, begin, target, new boolean[words.length], words);

        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
    }

    public static void dfs(int n, String word, String target, boolean[] visited, String[] words) {
        if (word.equals(target)) {
            answer = Math.min(answer, n);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            int cnt = 0;
            // 글자 수 비교
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == words[i].charAt(j)) {
                    cnt++;
                }
            }

            if (visited[i] == false && cnt == word.length() - 1) {
                visited[i] = true;
                dfs(n + 1, words[i], target, visited, words);
                visited[i] = false;
            }
        }
    }
}
