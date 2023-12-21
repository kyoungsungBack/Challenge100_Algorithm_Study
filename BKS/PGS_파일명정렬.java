package BKS;

import java.util.Arrays;
import java.util.Comparator;

public class PGS_파일명정렬 {
    // 20231221 10:06 ~ 15:39(런타임 이슈로 오래걸림)
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        // 1. 숫자 크기로 정렬(같으면 길이로 정렬)
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 1. head 만들기
                String head1 = o1.split("[0-9]")[0];

                // 2. number 만들기
                o1 = o1.replace(head1, "");
                head1 = head1.toUpperCase();
                String tempNum = "";
                for (char c : o1.toCharArray()) {
                    if (Character.isDigit(c) && tempNum.length() < 5) {
                        tempNum += c;
                    } else {
                        break;
                    }
                }

                int num1 = Integer.parseInt(tempNum);

                // 1. head 만들기
                String head2 = o2.split("[0-9]")[0];

                // 2. number 만들기
                o2 = o2.replace(head2, "");
                head2 = head2.toUpperCase();
                tempNum = "";
                for (char c : o2.toCharArray()) {
                    if (Character.isDigit(c) && tempNum.length() < 5) {
                        tempNum += c;
                    } else {
                        break;
                    }
                }

                int num2 = Integer.parseInt(tempNum);

                return head1.equals(head2) ? num1 - num2 : head1.compareTo(head2);
            }
        });
        System.out.println(Arrays.toString(files));
    }
}