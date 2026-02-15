import java.util.LinkedList;
import java.util.Queue;

class Solution8 {
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

        queue = new LinkedList<>();

        queue.offer(new Node(begin, 0));

        return result;
    }

    private Queue<Node> queue;

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

        Solution8 sol = new Solution8();
        int result = sol.solution(begin, target, words);

        System.out.println(result);
    }
}

class Node {
    String word;
    int cnt;

    Node(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }
}