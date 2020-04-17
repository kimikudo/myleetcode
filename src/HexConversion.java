import java.util.Arrays;
import java.util.Stack;

public class HexConversion {
    /**
     * 将任意N进制数字,转换为M进制数字.
     *
     * @param number
     * @param N
     * @param M
     * @return
     */
    public String hexConversion(String number, int N, int M) {
        return null;
    }

    //将N进制数转为十进制
    public Long NToTen(String number, int N) {
        char[] charNum = number.toCharArray();
        System.out.println(Arrays.toString(charNum));
        int[] realNum = new int[charNum.length];
        for (int i = 0; i < charNum.length; i++) {
            if (charNum[i] >= 'A' && charNum[i] <= 'Z') {
                realNum[i] = (int) (charNum[i] - 55);
            } else {
                realNum[i] = Integer.parseInt(charNum[i] + "");
            }
        }
        System.out.println(Arrays.toString(realNum));
        Long result = 0L;
        int base = 1;//倍率
        for (int i = realNum.length - 1; i >= 0; i--) {
            result += realNum[i] * base;
            base *= N;
        }
        return result;
    }

    //将十进制数,转为N进制
    public String tenToN(Long number, int N) {
        char[] charNum=number.toString().toCharArray();
        Stack<Character> stack=new Stack<>();
        Long rest=number;
        while(rest!=0){
            Long item=rest%N;
            char pushItem;
            if(item>=10){
                pushItem=(char)(item+55);
            }else{
                pushItem=(item+"").toCharArray()[0];
            }
            stack.push(pushItem);
            rest/=N;
        }
        StringBuilder result=new StringBuilder();
        while(!stack.empty()){
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        HexConversion hexConversion = new HexConversion();
        Long nToTenResult=hexConversion.NToTen("A5DE321", 16);
        System.out.println("任意进制转十进制:"+nToTenResult);
        String tenToNResult=hexConversion.tenToN(nToTenResult,16);
        System.out.println("十进制转任意进制:"+tenToNResult);
    }
}
