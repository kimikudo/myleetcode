package solution;

public class Reverse {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     */
    public int reverse(int x) {
        int result = 0;
        while(x != 0){
            int pop = x % 10;
            x /= 10;
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        int number = -354;
        int result = reverse.reverse(number);
        System.out.println(result);
    }
}
