/*
 * 問題5：特殊な数列
 *
 * 次の規則で定義される数列があります。
 *
 * a(1) = 1
 * a(2) = 2
 *
 * n >= 3 のとき、
 *
 * a(n) = a(n-1) + a(n-2)
 *
 * ただし、nが5の倍数の場合は、
 * 上記の計算結果にnを加算します。
 *
 * 【例】
 *
 * a(1) = 1
 * a(2) = 2
 * a(3) = 3
 * a(4) = 5
 * a(5) = 5 + 3 + 5 = 13
 * a(6) = 13 + 5 = 18
 *
 * 【問題】
 *
 * a(1)からa(40)までの数列について、
 * 各項を1000000007で割った余りを求め、
 * それらの余りの合計を計算してください。
 *
 * 【注意】
 * ・各項を計算する際にも、
 *   1000000007で割った余りを使用してください。
 * ・最終的な合計は、
 *   1000000007で割る必要はありません。
 *
 * 【出力】
 * 求めた合計を10進数の整数として
 * 出力してください。
 */

class Solution5 {
    public static void main(String[] args) {
        int n = 40;
        long mod = 1000000007L;

        long sum = 0;

        long[] resultList = new long[40];
        resultList[0] = 1;
        resultList[1] = 2;

        for (int i = 2; i < resultList.length; i++) {
            resultList[i] = resultList[i-1] + resultList[i-2];
            if ((i+1) % 5 == 0) {
                resultList[i] += (i + 1);
            }
        }

        for (int i = 0; i < resultList.length; i++) {
            sum += resultList[i] % mod;
        }

        System.out.println(sum);
    }
}
