package BKS.복습;

public class PGS_단어변환 {
    // 20231210 18:30 ~ 18:50
    // 20240108 09:35 ~ 10:07
    static int answer;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        answer = Integer.MAX_VALUE;
        /* 함수1 */
        /*
        dfs(0, begin, target, new boolean[words.length], words);

        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        */

        boolean isTar = false;

        // 0. target이 words에 없는 경우 종료된다.
        for (int i = 0 ; i < words.length ; i++) {
            if (words[i].equals(target)) {
                isTar = true;
            }
        }

        if (!isTar) {
            System.out.println(0);
        }

        // 1. begin이 target으로 변환될 최소 횟수를 찾는다.
        sol(begin, target, 0, new boolean[words.length], words);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(answer);
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

    public static void sol(String begin, String target, int n, boolean[] visited, String[] words) {
        if (begin.equals(target)) {
            answer = Math.min(answer, n);
            return;
        }

        // 2. 사전 내의 단어 중에 변환될 수 있는 경우를 찾는다.
        for (int i = 0 ; i < words.length ; i++) {
            int cnt = 0;

            // 3. 현재 단어와 사전 내의 공통 단어 갯수를 찾는다.
            for (int j = 0 ; j < begin.length() ; j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    cnt++;
                }
            }

            // 4. 방문 전이고 변환이 가능하면 호출한다.
            if (visited[i] == false && (begin.length() - 1) == cnt) {
                visited[i] = true;
                sol(words[i], target, n + 1, visited, words);
                visited[i] = false;
            }
        }
    }
}
