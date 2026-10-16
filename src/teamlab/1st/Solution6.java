
/*
 * 問題6：約数の個数
 *
 * 1以上50000以下の整数について、
 * 正の約数の個数を調べてください。
 *
 * 正の約数の個数がちょうど12個である整数のうち、
 * 以下の条件をすべて満たす整数の合計を
 * 求めてください。
 *
 * 【条件】
 * 1. 正の約数の個数がちょうど12個である。
 * 2. その整数は3の倍数である。
 * 3. その整数は5の倍数ではない。
 *
 * 【例】
 * 60の正の約数は、
 *
 * 1, 2, 3, 4, 5, 6,
 * 10, 12, 15, 20, 30, 60
 *
 * の12個です。
 *
 * ただし、60は5の倍数であるため、
 * 今回の条件を満たしません。
 *
 * 【出力】
 * 条件を満たすすべての整数の合計を
 * 10進数の整数として出力してください。
 *
 * 【注意】
 * ・1とその整数自身も約数に含めます。
 * ・Java 11の標準機能のみ使用できます。
 */

class Solution6 {
    public static void main(String[] args) {
        int start = 1;
        int end = 50000;

        long sum = 0;

        for (int i = start; i <= end; i++) {
            if (is12ko(i)) {
                if (i % 3 == 0 && i % 5 != 0) {
                    sum += i;
                }
            }
        }

        System.out.println(sum);
    }

    private static boolean is12ko(int i) {
        boolean result = false;

        int cnt = 0;

        for (int j = 1; j <= i; j++) {
            if (i % j == 0) cnt++;

            if (cnt > 12) break;
        }

        if (cnt == 12) result = true;

        return result;
    }
}
