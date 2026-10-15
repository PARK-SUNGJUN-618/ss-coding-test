/*
【第4問】特殊な素数の総和

1以上100000以下の整数 n のうち、
以下の条件をすべて満たす整数の総和を求めてください。

【条件】
1. n は素数である。
2. n の各桁の数字の和も素数である。
3. n の各桁を逆順に並べた整数も素数である。

【例】
n = 113 の場合

・113 は素数
・各桁の和：1 + 1 + 3 = 5（素数）
・逆順の整数：311（素数）

したがって、113 は条件を満たします。

【注意】
・逆順にした際の先頭の0は無視します。
  例：1030 → 301

【制約】
・1 <= n <= 100000
・実行時間制限：2秒
・使用言語：Java

【解答形式】
条件を満たす整数 n の総和を回答してください。
*/

class Solution4 {
    public static void main(String[] args) {
        int N = 100000;

        long sum = 0;

        for (int i = 1; i < N; i++) {
            if (isPrimeNum(i)) {
                if (isPrimeNumSumDigits(i)) {
                    if (isPrimeNumReverse(i)) {
                        sum += i;
                    }
                }
            }
        }

        System.out.println(sum);
    }

    private static boolean isPrimeNumReverse(int num) {
        int reverseNum = 0;

        while (num > 0) {
            reverseNum = reverseNum * 10 + (num % 10);
            num /= 10;
        }

        return isPrimeNum(reverseNum);
    }

    private static boolean isPrimeNumSumDigits(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10; 
        }

        return isPrimeNum(sum);
    }

    private static boolean isPrimeNum(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
