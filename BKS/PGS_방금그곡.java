package BKS;

import java.util.ArrayList;

public class PGS_방금그곡 {
    // 20240831 22:52 ~ 못품
    // 20240901 14:44 ~ 16:54
    // 20240901 17:20 ~ 17:39
    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String answer = "";
        ArrayList<Music> list = new ArrayList<>();

        // 1. 악보를 변환한다.
        m = m
                .replace("A#", "H")
                .replace("B#", "I")
                .replace("C#", "J")
                .replace("D#", "K")
                .replace("E#", "L")
                .replace("F#", "M")
                .replace("G#", "O");

        // 2. 노래 리스트의 시간을 저장한다.
        for (String musicinfo : musicinfos) {
            String[] temp = musicinfo.split(",");
            int start = Integer.parseInt(temp[0].substring(0, 2)) * 60 + Integer.parseInt(temp[0].substring(3));
            int end = Integer.parseInt(temp[1].substring(0, 2)) * 60 + Integer.parseInt(temp[1].substring(3));
            int time = end - start;
            String name = temp[2];
            String melody = "";

            temp[3] = temp[3]
                    .replace("A#", "H")
                    .replace("B#", "I")
                    .replace("C#", "J")
                    .replace("D#", "K")
                    .replace("E#", "L")
                    .replace("F#", "M")
                    .replace("G#", "O");

            // 2.1. 재생시간이 악보보다 짧을 때
            if (time < temp[3].length()) {
                melody = temp[3].substring(0, time);
            } // 2.2. 재생시간이 악보보다 길 때
            else {
                for (int i = 0 ; i < time / temp[3].length() ; i++) {
                    melody += temp[3];
                }
                melody += temp[3].substring(0, time % temp[3].length());
            }

            // 3. 재생시간과 악보의 길이를 비교하여 필요한만큼 객체에 담는다.
            list.add(new Music(start, end, time, name, melody));
        }


        // 4. 조건에 맞는 노래 제목을 찾는다.
        Music prev = new Music(0, 0, 0, "(None)", "");
        for (Music cur : list) {
            if (cur.melody.contains(m)) {
                if (prev.time < cur.time) {
                    prev = cur;
                }
            }
        }
        answer = prev.name;

        System.out.println(answer);
    }
}
class Music {
    int start;
    int end;
    int time;
    String name;
    String melody;

    public Music(int start, int end, int time, String name, String melody) {
        this.start = start;
        this.end = end;
        this.time = time;
        this.name = name;
        this.melody = melody;
    }
}
