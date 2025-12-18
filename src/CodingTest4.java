public class CodingTest4 {
    public static void main(String[] args) {
        // Game Map Shortest Path - bfs
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
        
    }
}
