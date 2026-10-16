import java.util.ArrayList;
import java.util.Collections;

public class CodingTest3 {

    static boolean graph[][];
    static boolean visited[][];
    static int n;
    static int countPerGroup;
    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};

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
        
        ArrayList<Integer> countList = solution(in_n, in_graph);
        
        System.out.println(countList.size());
        Collections.sort(countList);
        for(int i = 0; i < countList.size(); i++) {
            System.out.println(countList.get(i)); 
        }
    }
    private static ArrayList<Integer> solution(int in_n, boolean[][] in_graph) {
        n = in_n;
        graph = in_graph;
        visited = new boolean[n][n];

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

        return countList;
        // int nowX = 0;
        // int nowY = 0;
        // int count = 0;

        //dfs(resultList, nowX, nowY, count);
    }
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        countPerGroup++;

        for (int i = 0; i < 4; i++) {
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            if (newX >= 0 && newX < n && newY >= 0 && newY < n )
            if (!visited[newX][newY] && graph[newX][newY]) {
                dfs(newX, newY);
            }
        }


        // if (graph[nowX][nowY]) {
        //     visited[nowX][nowY] = true;
        //     count++;
        // }

        // if (nowX == n-1 && nowY == n-1) {

        // }

//         debug
//         solution
// i 0
// j 0 > 1

// countPerGroup 0 > 1 > ... > 7

// 	dfs!
// 	x 0
// 	y 1
// 	visited[0][1] true

// 	newX 1
// 	newY 1

// 		dfs!!
// 		x 1
// 		y 1
// 		visited[1][1] true
		
// 		newX 2
// 		newY 1
		
// 			dfs!!!
// 			x 2
// 			y 1
// 			visited[2][1] true
			
// 			newX 3 > 1 > 2
// 			newY 1 > 2
			
// 				dfs!!!
// 				x 2
// 				y 2
// 				visited[2][2] true
				
// 				newX 3 > 1
// 				newY 2
				
// 					dfs!!!!
// 					x 1
// 					y 2
// 					visited[1][2] true
					
// 					newX 2 > 0
// 					newY 2
					
// 						dfs!!!!!
// 						x 0
// 						y 2
// 						visited[0][2] true
						
// 						newX 1 > -1 > 0
// 						newY 2 > 3 > 1
					
// 					newX 1
// 					newY 3 > 1
				
// 				newX 2
// 				newY 3 > 1
			
// 			newX 2
// 			newY 0
			
// 				dfs!!!
// 				x 2
// 				y 0
// 				visited[2][0] true
				
// 				newX 3 > 1 > 0
// 				newY 0 > 1 > -1
		
// 		newX 2 > 0 > 1
// 		newY 1 > 2 > 0
	
// 	newX -1 > 0
// 	newY 1 > 2 > 0

// countList.add(7)


    }
}
