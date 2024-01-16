package BKS;

import java.util.*;

public class PGS_베스트앨범 {
    // 20240116 10:06 ~ 15:15
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        //String[] genres = {"classic", "pop", "classic", "classic"};
        //int[] plays = {800, 600, 150, 800};
        // 1. 장르별 횟수를 적재한다.
        HashMap<String, Integer> genre = new HashMap<>();
        ArrayList<String[]> order = new ArrayList<>();

        for (int i = 0 ; i < genres.length ; i++) {
            // 2. 현재 map에 해당 장르의 총 재생횟수 적재한다.
            if (genre.get(genres[i]) != null) {
                genre.put(genres[i], genre.get(genres[i]) + plays[i]);
            } else {
                genre.put(genres[i], plays[i]);
            }
        }

        // 3. ArrayList에 장르, 장르 총 재생횟수, 각 재생횟수, 고유번호 로 적재한다.
        for (int i = 0 ; i < genres.length ; i++) {
            order.add(new String[]{genres[i], String.valueOf(genre.get(genres[i])), String.valueOf(plays[i]), String.valueOf(i)});
        }

        Collections.sort(order, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                // 모든 장르는 재생된 횟수가 다릅니다.
                // 4.1. 장르가 같고 각 재생횟수가 많은 것을 앞으로
                if (o1[0].equals(o2[0])) {
                    if (Integer.parseInt(o1[2]) < Integer.parseInt(o2[2])) {
                        return 1;
                    } else if (Integer.parseInt(o1[2]) > Integer.parseInt(o2[2])) {
                        return -1;
                    } else {
                        return Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]);
                    }
                } else if (!o1[0].equals(o2[0])) {
                    if (Integer.parseInt(o1[1]) < Integer.parseInt(o2[1])) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return 0;
                }

            }
        });

        ArrayList<Integer> ans = new ArrayList<>();
        String prev = ""; // 첫번째 장르
        int cnt = 0;

        // 5. order에 들어있는 고유번호들을 출력한다.
        for (int i = 0 ; i < order.size() ; i++) {

            // 길이가 1이면 하나 넣고 다음 턴으로 돌린다.
            if (genre.get(order.get(i)[0]) == 1) {
                ans.add(Integer.parseInt(order.get(i)[3]));
                continue;
            }

            // 5 장르가 바뀌면 넣는다.
            if (!prev.equals(order.get(i)[0])) {
                cnt = 0;
                ans.add(Integer.parseInt(order.get(i)[3]));
                prev = order.get(i)[0];
            } // 5.1 현재 장르가 다르면 두 번 넣는다.
            else if (cnt < 2 && prev.equals(order.get(i)[0])) {
                ans.add(Integer.parseInt(order.get(i)[3]));
            }
            cnt++;
        }

        int[] answer = new int[ans.size()];
        for (int i = 0 ; i < ans.size() ; i++) {
            answer[i] = ans.get(i);
        }
        System.out.println(Arrays.toString(answer));
    }
}
