/*
【第3問】文字列の連続区間スコア

長さ100000の文字列 S を生成します。

各位置 i（0 <= i < 100000）の文字は、
以下の規則で決定されます。

int x = (int)((i * 37L + i / 7 + 13) % 10);

・x が 0, 1, 2 の場合：'A'
・x が 3, 4, 5 の場合：'B'
・x が 6, 7 の場合：'C'
・x が 8, 9 の場合：'D'

文字列 S を、同じ文字が連続する
最大の区間に分割します。

各区間の長さを L としたとき、
以下の規則でスコアを計算します。

【スコア計算】
・L が 3 未満の場合：0点
・L が 3 以上の場合：L × L 点

ただし、文字が 'D' の区間については、
長さに関係なく0点とします。

すべての区間のスコアの合計を
求めてください。

【制約】
・文字列の長さ：100000
・実行時間制限：2秒
・使用言語：Java

【解答形式】
スコアの合計を整数で回答してください。
*/

class Solution3_3 {
    public static void main(String[] args) {
        int N = 100_000;

        int nowStr = 4;
        int nowlen = 0;

        long sum = 0;

        for (int i = 0; i < N; i++) {
            int x = (int)((i * 37L + i / 7 + 13) % 10);

            if (x <= 2) {
                if (nowStr == 0) {
                    nowlen++;
                } else {
                    if (nowlen >=3 && nowStr < 3) {
                        sum += nowlen * nowlen;
                    }
                    nowStr = 0;
                    nowlen = 1;
                }
            } else if (x <= 5) {
                if (nowStr == 1) {
                    nowlen++;
                } else {
                    if (nowlen >=3 && nowStr < 3) {
                        sum += nowlen * nowlen;
                    }
                    nowStr = 1;
                    nowlen = 1;
                }
            } else if (x <= 7) {
                if (nowStr == 2) {
                    nowlen++;
                } else {
                    if (nowlen >=3 && nowStr < 3) {
                        sum += nowlen * nowlen;
                    }
                    nowStr = 2;
                    nowlen = 1;
                }
            } else {
                if (nowStr == 3) {
                    nowlen++;
                } else {
                    if (nowlen >=3 && nowStr < 3) {
                        sum += nowlen * nowlen;
                    }
                    nowStr = 3;
                    nowlen = 1;
                }
            }
        }

        if (nowlen >= 3 && nowStr < 3) {
            sum += (long) nowlen * nowlen;
        }

        System.out.println(sum);
    }
}
