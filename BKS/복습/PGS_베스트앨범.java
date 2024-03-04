package BKS.복습;

import java.util.*;

public class PGS_베스트앨범 {
    // 20240304 21:24 ~ 22:13
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] answer;

        // 1.1. 장르, 총 횟수를 담을 map을 선언한다.
        HashMap<String, Integer> map = new HashMap<>();
        // 1.2. 장르, 총 횟수, 각자 횟수, 인덱스 번호를 담을 list를 선언한다.
        ArrayList<String[]> list = new ArrayList<>();

        // 2.1. 장르, 총 횟수를 담는다.
        for (int i = 0 ; i < genres.length ; i++) {
            if (map.get(genres[i]) == null) {
                map.put(genres[i], plays[i]);
            } else {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            }
        }

        // 2.2. 장르, 총 횟수, 각자 횟수, 인덱스 번호를 담는다.
        for (int i = 0 ; i < genres.length ; i++) {
            String totalCnt = String.valueOf(map.get(genres[i]));
            String cnt = String.valueOf(plays[i]);
            String idx = String.valueOf(i);
            list.add(new String[]{genres[i], totalCnt, cnt, idx});
        }

        // 3. 주어진 조건에 맞게 list를 정렬한다.
        Collections.sort(list, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2) {
                // 3.1. 노래가 다르다면 총 횟수 기준으로 내림차순 정렬한다.
                if (!o1[0].equals(o2[0])) {
                    return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
                } else {
                    // 3.2. 재생 횟수가 같으면 인덱스 작은 번호로 오름차순 정렬한다.
                    if (o1[2].equals(o2[2])) {
                        return Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]);
                    } // 3.3. 재생 횟수가 다르면 재생 횟수로 오름차순 정렬한다.
                    else {
                        return Integer.parseInt(o2[2]) - Integer.parseInt(o1[2]);
                    }
                }
            }
        });

        String genre = list.get(0)[0];
        int cnt = 0;
        ArrayList<Integer> songs = new ArrayList<>();

        for (String[] song : list) {
            // 4.1. 장르가 같으면 두 개만 담는다.
            if (genre.equals(song[0]) && cnt < 2) {
                songs.add(Integer.parseInt(song[3]));
                cnt++;
            } // 4.2. 또는 장르가 달라지면 담는다. (한 개 일 경우)
            else if (!genre.equals(song[0])) {
                genre = song[0];
                songs.add(Integer.parseInt(song[3]));
                cnt = 1;
            }
        }

        // 5. 앨범 리스트를 answer에 담고 반환한다.
        answer = new int[songs.size()];
        for (int i = 0 ; i < songs.size() ; i++) {
            answer[i] = songs.get(i);
        }
        System.out.println(Arrays.toString(answer));
    }
}
