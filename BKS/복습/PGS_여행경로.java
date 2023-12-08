package BKS.복습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PGS_여행경로 {
    static ArrayList<String> list;
    public static void main(String[] args) {
        // 20231207 09:40 ~ 10:09
        String[][] tickets = {{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}};
        String[] answer;
        list = new ArrayList<>();
        // 항상 ICN에서 출발
        sol(1, "ICN", "ICN", tickets, new boolean[tickets.length]);

        Collections.sort(list);
        answer = list.get(0).split(" ");

        System.out.println(Arrays.toString(answer));
    }
    public static void sol(int n, String start, String path, String[][] tickets, boolean[] visited) {
        if (n == tickets.length + 1) {
            list.add(path);
            return;
        }

        for (int i = 0 ; i < tickets.length ; i++) {
            if (visited[i] == false && tickets[i][0].equals(start)) {
                visited[i] = true;
                sol(n + 1, tickets[i][1], path + " " + tickets[i][1], tickets, visited);
                visited[i] = false;
            }
        }

    }
}
