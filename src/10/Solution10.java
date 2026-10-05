import java.util.HashMap;

class Solution10 {
    public static void main(String[] args) {
        String input = "48,18";

        String[] inputList = input.split(",");
        long a = Long.parseLong(inputList[0]);
        long b = Long.parseLong(inputList[1]);
        
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        System.out.println("result:" + a + ",b:" + b);
    }
}
