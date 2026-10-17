/*
問題5：最小コストでゴールへ

N 個の足場が一直線に並んでおり、
それぞれ 0 から N-1 までの番号が付いています。

あなたは足場 0 からスタートし、
足場 N-1 に到達することを目指します。

現在の足場 i からは、次の移動が可能です。

・i+1 へ移動する
・i+2 へ移動する
・i+3 へ移動する

ただし、N-1 を超える移動はできません。

足場 i から足場 j に移動するとき、
以下のコストが発生します。

コスト = |H[i] - H[j]| + (j - i) * 5

ここで H[i] は足場 i の高さです。

【入力データ】

N = 100000

各足場の高さ H[i] は次の式で生成されます。

H[i] = (int)((i * 73L + i * i * 17L) % 1000)

（0 <= i < N）

【条件】

1. 足場 0 からスタートする。
2. 1回の移動で 1〜3 個先の足場へ進める。
3. 足場 N-1 に到達するまでの
   移動コストの合計を最小にする。
4. スタート地点ではコストは発生しない。

【出力】

足場 N-1 に到達するための
最小コストを整数で出力してください。

【実行例】

入力：
なし（上記の式でデータを生成する）

出力：
最小コストの合計

【制約】

・N = 100000
・0 <= H[i] < 1000
・実行時間の目安：2秒
・使用言語：Java

【目標時間】

10〜15分
*/

class Solution16 {
    public static void main(String[] args) {
        //コスト = |H[i] - H[j]| + (j - i) * 5
        // H[i] = (int)((i * 73L + i * i * 17L) % 1000)

        int N = 100000;

        int[] H = new int[N];
        long[] minCost = new long[N];
        minCost[0] = 0;

        for (int i = 0; i < minCost.length; i++) {
            H[i] = (int)((i * 73L + (long)i * i * 17L) % 1000);
        }
        
        for (int i = 1; i < N; i++) {

            minCost[i] = Long.MAX_VALUE; 
            for (int j = 0; j < 3; j++) {
                if (i - j > 0) {
                    minCost[i] = Math.min(minCost[i], minCost[i-j-1] + Math.abs(H[i-j-1] - H[i]) + (i - (i - j - 1)) * 5);
                }
            }
        }

        System.out.println(minCost[N-1]);
    }
}
