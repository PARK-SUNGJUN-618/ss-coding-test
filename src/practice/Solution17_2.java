/*
問題6：制約付きの最大スコア

N 個のステージが一直線に並んでおり、
それぞれ 0 から N-1 までの番号が付いています。

各ステージでは、次の3つの行動から
ちょうど1つを選択します。

・A：攻撃する
・B：防御する
・C：回復する

各行動によって得られるスコアは
ステージごとに異なります。

ステージ i で行動 A、B、C を選択したときの
スコアをそれぞれ A[i]、B[i]、C[i] とします。

ただし、行動の選択には次の制約があります。

【制約】

1. すべてのステージで必ず1つの行動を選択する。

2. 同じ行動を2回連続で選択してはいけない。

3. 行動 C（回復）を2回連続で選択することもできない。
   （制約2と同じ条件である）

4. 行動 A（攻撃）は、全ステージを通して
   ちょうど K 回選択しなければならない。

5. 最後のステージでは、
   行動 C（回復）を選択してはいけない。

【入力データ】

N = 1000
K = 300

各ステージのスコアは次の式で生成されます。

A[i] = (int)((i * 37L + 13) % 100)
B[i] = (int)((i * 53L + 29) % 100)
C[i] = (int)((i * 71L + 47) % 100)

（0 <= i < N）

【目的】

すべての制約を満たす行動の選び方のうち、
合計スコアが最大となるものを求めてください。

【出力】

最大スコアを整数で出力してください。

【実行例】

入力：
なし（上記の式でデータを生成する）

出力：
最大スコアの合計

【制約条件】

・N = 1000
・K = 300
・0 <= A[i], B[i], C[i] < 100
・実行時間の目安：2秒
・使用言語：Java

【目標時間】

15〜20分
*/

import java.util.Arrays;

class Solution17_2 {
    static int N = 1000;
    static int K = 300;

    static int[] A = new int[N];
    static int[] B = new int[N];
    static int[] C = new int[N];

    static long[][][] memo = new long[3][N + 1][K + 1]; // now, len, cntA
    static long maxScore = Long.MIN_VALUE;

    public static void main(String[] args) {

        for (int i = 0; i < N; i++) {
            A[i] = (int)((i * 37L + 13) % 100);
            B[i] = (int)((i * 53L + 29) % 100);
            C[i] = (int)((i * 71L + 47) % 100);
        }

        for (int now = 0; now < 3; now++) {
            for (int len = 0; len <= N; len++) {
                Arrays.fill(memo[now][len], -1);
            }
        }

        memo[0][1][1] = A[0]; // A 선택, A 사용 1회
        memo[1][1][0] = B[0]; // B 선택, A 사용 0회
        memo[2][1][0] = C[0]; // C 선택, A 사용 0회


        for (int len = 1; len < N; len++) {
            for (int cntA = 0; cntA <= K; cntA++) {
                for (int now = 0; now < 3; now++) {

                    // 도달할 수 없는 상태는 건너뛰기
                    if (memo[now][len][cntA] == -1) {
                        continue;
                    }

                    long nowScore = memo[now][len][cntA];

                    // 다음 행동 A
                    if (now != 0 && cntA < K) {
                        memo[0][len + 1][cntA + 1] = Math.max(
                            memo[0][len + 1][cntA + 1],
                            nowScore + A[len]
                        );
                    }

                    // 다음 행동 B
                    if (now != 1) {
                        memo[1][len + 1][cntA] = Math.max(
                            memo[1][len + 1][cntA],
                            nowScore + B[len]
                        );
                    }

                    // 다음 행동 C
                    if (now != 2) {
                        memo[2][len + 1][cntA] = Math.max(
                            memo[2][len + 1][cntA],
                            nowScore + C[len]
                        );
                    }
                    
                }
            }
        }

        // 5. 최종 결과
        long maxScore = Math.max(
            memo[0][N][K],
            memo[1][N][K]
        );
        
        System.out.println(maxScore);
    }

    
}
