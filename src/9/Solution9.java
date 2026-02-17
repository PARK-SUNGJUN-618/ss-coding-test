import java.util.LinkedList;
import java.util.Queue;

class Solution9 {
    /*
    * Find the minimum number of transformations.
    *
    * Problem:
    * Transform the begin word into the target word
    * by changing only one letter at a time.
    * Each intermediate word must exist in the given word list.
    * Return the minimum number of transformations needed.
    * Return 0 if the target cannot be reached.
    *
    * Example:
    * Input :
    * begin = "hit"
    * target = "cog"
    * words = ["hot", "dot", "dog", "lot", "log", "cog"]
    *
    * Output: 4
    *
    * @param begin Starting word
    * @param target Target word
    * @param words List of available words for transformation
    * @return Minimum number of transformations, or 0 if impossible
    */
    public int solution(String begin, String target, String[] words) {
        int result = 0;
        boolean[] visited = new boolean[words.length];

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(begin, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            String current = node.current;
            int cnt = node.cnt;

            if (current.equals(target)) {
                return cnt;
            }

            for (int i = 0; i < words.length; i++) {
                String next = words[i];
                if (!visited[i] && canTransform(current, next)) {
                    queue.offer(new Node(next, cnt + 1));
                    visited[i] = true;
                }
            }

        }

        return result;
    }

    private boolean canTransform(String current, String next) {
        int diffCount = 0;

        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != next.charAt(i)) {
                diffCount++;

                // More than one character is different
                if (diffCount > 1) {
                    return false;
                }
            }
        }

        // Exactly one character is different
        return diffCount == 1;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";

        String[] words = {
            "hot",
            "dot",
            "dog",
            "lot",
            "log",
            "cog"
        };

        // String[] words = {
        //     "hot",
        //     "dot",
        //     "dog",
        //     "lot",
        //     "log"
        // };

        Solution9 sol = new Solution9();
        int result = sol.solution(begin, target, words);

        System.out.println(result);
    }
}

class Node {
    String current;
    int cnt;

    Node(String current, int cnt) {
        this.current = current;
        this.cnt = cnt;
    }
}