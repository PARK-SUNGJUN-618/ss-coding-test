/*
 * 問題 1：条件を満たす連続部分配列の数
 *
 * 整数配列 A が与えられます。
 *
 * 連続する要素からなる部分配列のうち、
 * 要素の合計が K 以下となる部分配列の個数を求めてください。
 *
 * 【条件】
 * ・配列の長さ N = 100,000
 * ・A[i] = (i * 37L % 100) + 1
 * ・K = 500
 * ・配列のすべての要素は正の整数
 * ・部分配列は1つ以上の要素を含む
 * ・答えは long 型で扱うこと
 *
 * 【例】
 * A = [2, 1, 3]
 * K = 3
 *
 * 条件を満たす部分配列：
 * [2]
 * [1]
 * [3]
 * [2, 1]
 *
 * 出力：4
 *
 * 【実装条件】
 * ・Javaを使用すること
 * ・効率的なアルゴリズムで実装すること
 * ・最終的な個数を標準出力に表示すること
 *
 * 【配列生成コード】
 *
 * int N = 100_000;
 * long K = 500;
 *
 * int[] A = new int[N];
 *
 * for (int i = 0; i < N; i++) {
 *     A[i] = (int) ((i * 37L % 100) + 1);
 * }
 *
 * 目標時間：7～10分
 */

class Solution11 {
    public static void main(String[] args) {
        int N = 100_000;
        long K = 500;

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = (int) ((i * 37L % 100) + 1);
        }

        int left = 0;
        long sum = 0;
        long count = 0;

        // A = [2, 1, 3]

        for (int right = 0; right < N; right++) {
            sum += A[right];

            while (sum > K) {
                sum -= A[left];
                left++;
            }

            count += right - left + 1;
        }

        System.out.println(count);
    }
}
