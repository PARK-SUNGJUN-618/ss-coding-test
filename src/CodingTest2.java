public class CodingTest2 {
    public static void main(String[] args) {
        // ex1)result:11
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        
        // ex2)result:-1
        //int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        int result = solution(maps);
        System.out.println(result);
    }


    public static int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int answer = 0;
        
        return answer;
    }
}
