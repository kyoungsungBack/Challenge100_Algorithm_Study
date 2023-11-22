package BKS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PGS_여행경로 {
    static boolean[] visited;
    static ArrayList<String> ans;

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String[] answer = {};
        ans = new ArrayList<>();
        visited = new boolean[tickets.length];
        Arrays.fill(visited, false);

        dfs(0, "ICN", tickets, "ICN");
        Collections.sort(ans);
        answer = ans.get(0).split(" ");

        System.out.println(answer);
    }

    static public void dfs(int cnt, String ticket, String[][] tickets, String path) {
        if (cnt == tickets.length) {
            ans.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (visited[i] == false && ticket.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(cnt + 1, tickets[i][1], tickets, path + " " + tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}

