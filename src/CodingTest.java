import java.util.Arrays;

public class CodingTest {
    static int count = 0;

    public static void main(String[] args) {
        //HashMap<String, String> root = 
        // String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "ABC"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[] answer= solution(tickets);

        for(String str : answer) {
            System.out.println(str);
        }
    }



    public static String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        boolean[] visited = new boolean[tickets.length];

        // sort
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        dfs(tickets, visited, answer, "ICN", 0);

        return answer;
    }

    private static boolean dfs(String[][] tickets, boolean[] visited, String[] answer, String current, int count) {
        answer[count] = current;
        for(String str : answer) {
            System.out.print(str + " ");
        }
        System.out.println();

        if (tickets.length == count) {
            return true; 
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;

                if (dfs(tickets, visited, answer, tickets[i][1], count + 1)) {
                    return true;
                }

                // back tracking
                visited[i] = false;
            }
        }

        return false;
    }
}
