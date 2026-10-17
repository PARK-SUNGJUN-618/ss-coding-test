/*
 * 問題7：条件を満たすペアの数
 *
 * 昇順にソートされた整数配列が与えられます。
 *
 * 配列から異なる2つのインデックス i, j を選び、
 * 以下の条件を満たすペアの数を求めてください。
 *
 * 【条件】
 * 1. 0 <= i < j < 配列の長さ
 * 2. numbers[i] + numbers[j] >= 100
 * 3. numbers[i] + numbers[j] <= 150
 *
 * 【例】
 * 配列: {10, 40, 60, 80, 100}
 *
 * 条件を満たすペア：
 * (10, 100) → 110
 * (40, 60)  → 100
 * (40, 80)  → 120
 * (40, 100) → 140
 * (60, 80)  → 140
 *
 * 出力: 5
 *
 * 【問題】
 * 以下の配列について、
 * 条件を満たすペアの総数を求めてください。
 *
 * 【注意】
 * ・(i, j)と(j, i)は同じペアです。
 * ・同じインデックスを2回選べません。
 * ・配列はすでに昇順にソートされています。
 * ・最終的なペアの数を出力してください。
 */

class Solution7 {
    public static void main(String[] args) {
        int[] numbers = new int[10000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i / 50 + 1;
        }

        long count = 0;

//  * 1. 0 <= i < j < 配列の長さ
//  * 2. numbers[i] + numbers[j] >= 100
//  * 3. numbers[i] + numbers[j] <= 150        

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 150) break;

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] > 150) break;

                if (numbers[i] + numbers[j] >= 100 && numbers[i] + numbers[j] <= 150) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
