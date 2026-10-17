/*
 * 問題3：条件を満たす数値の組み合わせ
 *
 * 整数の配列が与えられます。
 *
 * 配列から異なる2つの要素を選び、
 * 以下の条件をすべて満たす組み合わせを
 * 調べてください。
 *
 * 【条件】
 * 1. 2つの要素の合計が100以上200以下である。
 * 2. 2つの要素の差の絶対値が30以上である。
 * 3. 2つの要素の積が偶数である。
 *
 * 条件を満たすすべての組み合わせについて、
 * 2つの要素の積を計算し、
 * その合計を求めてください。
 *
 * 【注意】
 * ・同じインデックスの要素を2回選ぶことは
 *   できません。
 * ・(i, j)と(j, i)は同じ組み合わせとして
 *   1回だけ数えてください。
 * ・同じ値でもインデックスが異なれば
 *   別の要素として扱います。
 *
 * 【例】
 * 配列: {40, 70, 90}
 *
 * (40, 70) → 合計110、差30、積2800
 * (40, 90) → 合計130、差50、積3600
 * (70, 90) → 差20のため対象外
 *
 * 出力: 6400
 *
 * 【出力】
 * 条件を満たすすべての組み合わせの積の合計を
 * 10進数の整数で出力してください。
 */
class Solution3 {
    public static void main(String[] args) {
        int[] numbers = {
            42, 85, 17, 96, 53, 71, 28, 64,
            39, 112, 75, 48, 91, 23, 67, 104,
            56, 82, 31, 119, 44, 73, 15, 98,
            61, 87, 36, 108, 52, 79, 25, 94
        };

        long sum = 0;
        boolean check = false;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                // int num1 = numbers[0];
                // int num2 = numbers[0];
                check = checkMethod(numbers[i], numbers[j]);
                if (check) {
                    sum += numbers[i] * numbers[j];
                }
            }
        }

        System.out.println(sum);
    }

    private static boolean checkMethod(int i, int j) {
        boolean result = false;

        //  * 1. 2つの要素の合計が100以上200以下である。
        //  * 2. 2つの要素の差の絶対値が30以上である。
        //  * 3. 2つの要素の積が偶数である。

        if (i + j >= 100 && i + j <= 200) {
            if (Math.abs(i - j) >= 30) {
                if ((i * j) % 2 == 0) {
                    result = true;
                }
            }
        }

        return result;
    }
}
