public class CodingTest2 {
    public static void main(String[] args) {
        // ex1)result:11
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        
        // ex2)result:-1
        //int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        int result = solution(maps);
        System.out.println(result);
    }

    static int answer;
    static boolean[][] visited;
    static int maxN;
    static int maxM;
    static int[][] maps;

    public static int solution(int[][] maps) {
        maxN = maps.length;
        maxM = maps[0].length;
        visited = new boolean[maxN][maxM];
        answer = 0;
        
        
        dfs(maps, 0, 0);

        return answer;
    }


    private static void dfs(int[][] maps, int n, int m) {
        visited[n][m] = true;
        System.out.println("n:" + n + ",m:" + m);

        if (n == 4 && m == 4) return;

        if (n < maxN-1 && !visited[n+1][m] && maps[n+1][m] == 1) {
            n++;
            answer++;
            dfs(maps, n, m);
        }
        if (m < maxM-1 && !visited[n][m+1] && maps[n][m+1] == 1) {
            m++;
            answer++;
            dfs(maps, n, m);
        }
        if (n > 0 && !visited[n-1][m] && maps[n-1][m] == 1) {
            n--;
            answer++;
            dfs(maps, n, m);
        }
        if (m > 0 && !visited[n][m-1] && maps[n][m-1] == 1) {
            m--;
            answer++;
            dfs(maps, n, m);
        }

    }
}
