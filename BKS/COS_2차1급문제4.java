package BKS;

public class COS_2차1급문제4 {
    static int answer = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        int[] arr = {1, 2, 3, 4, 5};
        boolean[] visited = new boolean[arr.length];
        int K = 3;
        answer = 0;


        dfs(0, 0, 0, K, arr, visited);

        System.out.println(answer);
    }
    static public void dfs(int idx, int cnt, int sum, int K, int[] arr, boolean[] visited) {
        if (cnt == 3) {
            if (sum % K == 0) {
                answer++;
            }
            return;
        }

        for (int i = idx ; i < arr.length ; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(idx + 1, cnt + 1, sum + arr[i], K, arr, visited);
                visited[i] = false;
            }
        }
    }
}
