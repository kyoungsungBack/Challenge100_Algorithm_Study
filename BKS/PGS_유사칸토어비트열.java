package BKS;

public class PGS_유사칸토어비트열 {
    public static void main(String[] args) {
        int n = 2;
        int l = 4;
        int r = 17;
        int answer = 0;

        for (long i = l - 1 ; i < r; i++) {
            if (check(i)) answer++;
        }

        System.out.println(answer);
    }
    public static boolean check(long l) {
        System.out.println(l);
        if (l < 5 && l != 2) return true;
        if ((l - 2) % 5 == 0) return false;

        return check(l / 5);
    }
}
