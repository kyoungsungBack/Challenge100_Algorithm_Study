package BKS;

import java.util.ArrayList;
import java.util.Arrays;

public class PGS_영어끝말잇기 {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        /*int n = 5;
        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        */
        /*int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        */

        int[] answer = new int[2];
        ArrayList<String> list = new ArrayList<>();

        // N명의 사람이 끝말잇기를 하고
        // 주어진 단어의 순서대로 말하고 단어를 틀리거나 중복단어 말하면 탈락
        // n번씩 반복이 된다.

        int cnt = 1;
        list.add(words[0]);

        while(cnt < words.length){
            int idx = list.get(cnt - 1).length();
            // answer[0] : 1~n 번호를 나타내기 위해 나머지(0, 1, 2)에 +1 해준다.
            // answer[1] : 3의 배수 부터 새로운 차례 시작이고 차례는 1부터 시작된다.
            if(list.contains(words[cnt])) { // 1. 단어가 틀린 경우
                answer[0] = (cnt % n) + 1;
                answer[1] = (cnt / n) + 1;
                break;
            } else if (list.get(cnt - 1).charAt(idx - 1) != words[cnt].charAt(0)) { // 2. 단어가 중복인 경우
                answer[0] = (cnt % n) + 1;
                answer[1] = (cnt / n) + 1;
                break;
            } else {
                answer[0] = 0;
                answer[1] = 0;
            }
            list.add(words[cnt]);
            cnt++;
        }

        System.out.println(Arrays.toString(answer));
    }
}
