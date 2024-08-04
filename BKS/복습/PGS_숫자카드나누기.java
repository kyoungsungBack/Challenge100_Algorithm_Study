package BKS.복습;

public class PGS_숫자카드나누기 {
    // 20240804 17:39 ~ 18:07
    public static void main(String[] args) {
        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};
        int answer = 0;

        // 0. arrayA, arrayB 각 배열의 최대공약수를 찾는다.
        int aNum = arrayA[0];
        int bNum = arrayB[0];

        // 1. arrayA의 최대공약수를 구한다.
        for (int i = 1 ; i < arrayA.length ; i++) {
            aNum = gcd(aNum, arrayA[i]);
        }

        // 2. arrayB의 최대공약수를 구한다.
        for (int i = 1 ; i < arrayB.length ; i++) {
            bNum = gcd(bNum, arrayB[i]);
        }

        // 3. arrayB의 모든 수를 aNum으로 나눈다.
        for (int num : arrayB) {
            if (num % aNum == 0) {
                aNum = 0;
                break;
            }
        }
        answer = aNum;

        // 4. arrayA의 모든 수를 bNum으로 나눈다.
        for (int num : arrayA) {
            if (num % bNum == 0) {
                bNum = 0;
                break;
            }
        }

        // 5. 조건1, 2 중 하나는 만족하는 최대 수를 answer에 대입한다.
        answer = Math.max(answer, bNum);
        System.out.println(answer);
    }
    public static int gcd(int a, int b) {
        if (a % b == 0) return b;
        else return gcd(b, a % b);
    }
}
