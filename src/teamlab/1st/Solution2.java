/*
 * 問題2：文字列の連続パターン
 *
 * 英大文字のみで構成された文字列が与えられます。
 *
 * この文字列に含まれる、同じ文字が
 * 連続している部分のうち、
 * 長さが3以上のものをすべて調べてください。
 *
 * 各連続部分について、長さの2乗を計算し、
 * その合計を求めてください。
 *
 * 【例】
 * 文字列: "AAABBCCCCD"
 *
 * 連続部分:
 * AAA  → 長さ3 → 9
 * BB   → 長さ2 → 対象外
 * CCCC → 長さ4 → 16
 * D    → 長さ1 → 対象外
 *
 * 出力: 25
 *
 * 【注意】
 * ・連続部分は、同じ文字が最大限連続する
 *   ひとまとまりとして扱ってください。
 * ・文字列の最後の連続部分も判定対象です。
 *
 * 【出力】
 * 条件を満たす連続部分の長さの2乗の合計を
 * 整数で出力してください。
 */

class Solution2 {
    public static void main(String[] args) {
        String input =
            "AAABBBCCCCDAAEEEEFFGGGGGHH" +
            "IIIIJJJKKLLLLLLMMNNNOOOO" +
            "PPQQQQRRRSSSTTTTTUUUVVV" +
            "WWWWXXXXYYYYYZZ";

        long sum = 0;

        char check = input.charAt(0);
        char now = input.charAt(0);

        long cnt = 0;

        for (int i = 0; i < input.length(); i++) {
            now = input.charAt(i);
            cnt++;
            // System.out.println("check:"+check);
            // System.out.println("now:"+now);
            // System.out.println("cnt:"+cnt);
            if (check != now) {
                if (cnt-1 >= 3) {
                    sum += (cnt-1) * (cnt-1);
                } 
                cnt = 1;
                check = now;
            } 
        }

        System.out.println(sum);
    }
}
