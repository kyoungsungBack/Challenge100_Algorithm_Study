package BKS;

import java.util.HashMap;
import java.util.Map;

public class PGS_뉴스클러스터링 {
    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";
        int answer = 0;
        String match = "[^a-zA-Z]";
        // 자카드 유사도
        // String, 영어 대소문자, 특수문자 비교방법
        Map<String, Integer> A = new HashMap<>();
        Map<String, Integer> B = new HashMap<>();

        // 같은 문자열이면 유사도 1
        if (str1.toUpperCase().equals(str2.toUpperCase())) {
            // return 65536;
        }

        // 특수문자는 공백으로 대체
        str1 = str1.replaceAll(match, " ");
        str2 = str2.replaceAll(match, " ");

        // str1 에 대해서 키를 대문자로 치환 후 개수 세팅
        for (int i = 0; i < str1.length() - 1; i++) {
            String key = str1.substring(i, i + 2);
            if (!key.contains(" ") && key.length() == 2) {
                if (A.get(key.toUpperCase()) != null) {
                    A.put(key.toUpperCase(), A.get(key.toUpperCase()) + 1);
                } else {
                    A.put(key.toUpperCase(), 1);
                }
            }
        }

        // str2 에 대해서 키를 대문자로 치환 후 개수 세팅
        for (int i = 0; i < str2.length() - 1; i++) {
            String key = str2.substring(i, i + 2);
            if (!key.contains(" ") && key.length() == 2) {
                if (B.get(key.toUpperCase()) != null) {
                    B.put(key.toUpperCase(), B.get(key.toUpperCase()) + 1);
                } else {
                    B.put(key.toUpperCase(), 1);
                }
            }
        }

        // 교집합
        int num1 = 0;
        for (String key : A.keySet()) {
            if (B.containsKey(key)) {
                num1 += Math.min(A.get(key), B.get(key));
            }
        }

        // 합집합
        int num2 = 0;
        for (String key : A.keySet()) {
            if (B.containsKey(key)) {
                num2 += Math.max(A.get(key), B.get(key));
            } else {
                num2 += A.get(key);
            }
        }

        for (String key : B.keySet()) {
            if (!A.containsKey(key)) {
                num2 += B.get(key);
            }
        }

        answer = (int) Math.floor(((double) num1 / (double) num2) * 65536.0);

        System.out.println(answer);
    }
}
