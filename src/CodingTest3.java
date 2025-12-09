import java.util.ArrayList;

public class CodingTest3 {

    static boolean graph[][];
    static boolean visited[][];
    static int n;
    static int result;
    static int resultCnts[];
    public static void main(String[] args) {
        // idea
        // 1. graph 0,0 check 
        //      -> false -> go 2.
        //      -> true  -> visited 0,0 true -> count 1 ->
        // 2. graph 0,1 check ->
        int in_n = 7;
        boolean[][] in_graph = new boolean[][]{
            {false,true ,true ,false,true ,false,false},
            {false,true ,true ,false,true ,false,true },
            {true ,true ,true ,false,true ,false,true },
            {false,false,false,false,true ,true ,true },
            {false,true ,false,false,false,false,false},
            {false,true ,true ,true ,true ,true ,false},
            {false,true ,true ,true ,false,false,false}
        };
        
        solution(in_n, in_graph);
        
        System.out.println(result);
        for(int resultCnt : resultCnts) {
            System.out.println(resultCnt); 
        }
    }
    private static void solution(int in_n, boolean[][] in_graph) {
        n = in_n;
        graph = in_graph;
        visited = new boolean[n][n];
        result = 0;

        ArrayList<Integer> countList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] && !visited[i][j]) {
                    countPerGroup = 0;
                    dfs(i, j);
                    countList.add(countPerGroup);
                }
            }
        }

        int nowX = 0;
        int nowY = 0;
        int count = 0;

        //dfs(resultList, nowX, nowY, count);
    }
    private static void dfs(ArrayList<Integer> resultList, int nowX, int nowY, int count) {
        if (graph[nowX][nowY]) {
            visited[nowX][nowY] = true;
            count++;
        }

        if (nowX == n-1 && nowY == n-1) {

        }
    }
}
