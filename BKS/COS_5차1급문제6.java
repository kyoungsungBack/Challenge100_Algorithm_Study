package BKS;

public class COS_5차1급문제6 {
    public static void main(String[] args) {
        String s1 = new String("112001");
        String s2 = new String("12010");
        int p = 3;
        int q = 8;

        String answer = "";
        // p진법 -> 10진법
        int num1 = 0;
        int num2 = 0;
        int idx = 0;

        for (int i = s1.length() - 1; i >= 0; i--) {
            num1 += Integer.parseInt(s1.substring(i, i + 1)) * (int) Math.pow(p, idx);
            idx++;
        }

        idx = 0;
        for (int i = s2.length() - 1; i >= 0; i--) {
            num2 += Integer.parseInt(s2.substring(i, i + 1)) * (int) Math.pow(p, idx);
            idx++;
        }

        int sum = num1 + num2;
        while (sum > 0) {
            answer = String.valueOf(sum % q) + answer;
            sum /= q;
        }
        System.out.println(answer);
    }
}
