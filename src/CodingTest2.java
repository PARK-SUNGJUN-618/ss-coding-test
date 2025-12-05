public class CodingTest2 {
    public static void main(String[] args) {
        // ex1)result:11
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        
        // ex2)result:-1
        // int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

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
        answer = Integer.MAX_VALUE;
        
        
        dfs(maps, 0, 0, 1);

        answer = answer == Integer.MAX_VALUE ? -1 : answer; 
        return answer;
    }


    private static void dfs(int[][] maps, int n, int m, int count) {
        visited[n][m] = true;

        if (n == maxN-1 && m == maxM-1) {
            answer = Math.min(answer, count);
            return;
        }

        if (n < maxN-1 && !visited[n+1][m] && maps[n+1][m] == 1) {
            dfs(maps, n+1, m, count+1);
        }
        if (m < maxM-1 && !visited[n][m+1] && maps[n][m+1] == 1) {
            dfs(maps, n, m+1, count+1);
        }
        if (n > 0 && !visited[n-1][m] && maps[n-1][m] == 1) {
            dfs(maps, n-1, m, count+1);
        }
        if (m > 0 && !visited[n][m-1] && maps[n][m-1] == 1) {
            dfs(maps, n, m-1, count+1);
        }

        visited[n][m] = false;
    }
}
