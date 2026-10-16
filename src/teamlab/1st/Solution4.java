/*
 * 問題4：特別な素数の合計
 *
 * 2以上100000以下の整数について、
 * 以下の条件をすべて満たす数を調べてください。
 *
 * 【条件】
 * 1. その数が素数である。
 * 2. 各桁の数字の合計も素数である。
 * 3. その数を逆順に並べた整数も素数である。
 *
 * 条件を満たすすべての整数の合計を
 * 求めてください。
 *
 * 【例】
 * 113の場合：
 *
 * ・113は素数である。
 * ・各桁の合計は1+1+3=5で、素数である。
 * ・逆順に並べた311も素数である。
 *
 * したがって、113は条件を満たします。
 *
 * 一方、23の場合：
 *
 * ・23は素数である。
 * ・各桁の合計は2+3=5で、素数である。
 * ・逆順に並べた32は素数ではない。
 *
 * したがって、23は条件を満たしません。
 *
 * 【注意】
 * ・1は素数ではありません。
 * ・逆順に並べた際、先頭の0は無視します。
 *   例：1030 → 301
 *
 * 【出力】
 * 条件を満たすすべての整数の合計を
 * 10進数の整数として出力してください。
 */

class Solution4 {
    public static void main(String[] args) {
        int start = 2;
        int end = 100000;

        long sum = 0;

        for (int i = start; i <= end; i++) {

            if (isPrimeNum(i)) {
                if (isPrimeNum(sumOfDigits(i))) {
                    if (isPrimeNum(reverseNum(i))) {
                        sum += i;
                    }
                }
            }

        }

        System.out.println(sum);
    }

    private static int reverseNum(int i) {
        int sum = 0;

        while (i > 0) {
            sum = (sum * 10) + (i % 10);
            i /= 10;
        }

        return sum;
    }

    private static int sumOfDigits(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }

    private static boolean isPrimeNum(int i) {
        boolean result = true;

        if (i == 1) return false;
        if (i == 2) return true;

        for(int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                result = false;
                break;
            }
        }

        return result;
    }
}
