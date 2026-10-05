class Solution10 {
    public static void main(String[] args) {
        //String input = "123456,789012";
        String input = "48,18";

        String[] inputList = input.split(",");
        long input1 = Long.parseLong(inputList[0]);
        long input2 = Long.parseLong(inputList[1]);
        long a = input1;
        long b = input2;
        
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        System.out.println("GCD:" + a);
        System.out.println("LCM:" + (input1/a*input2));
        System.out.println("RESULT:" + (a+(input1/a*input2)));
    }
}
