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

    /**
     * 将N进制转为十进制
     * @param number N进制数
     * @param N 进制
     * @return
     */
    public Long NToTen(String number, int N) {
        char[] charNum = number.toCharArray();
        System.out.println(Arrays.toString(charNum));
        //这里对每一位的数字做了个处理,如果是A-Z,就存储为实际的数字,
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
        //将实际数字数组进行转为十进制处理
        for (int i = realNum.length - 1; i >= 0; i--) {
            result += realNum[i] * base;
            base *= N;
        }
        return result;
    }

    /**
     * 将十进制转为N进制
     * @param number 十进制数
     * @param N 进制
     * @return
     */
    public String tenToN(Long number, int N) {
        char[] charNum=number.toString().toCharArray();
        //使用栈进行处理.
        Stack<Character> stack=new Stack<>();
        Long rest=number;
        //循环取余,将十进制数转为N进制
        while(rest!=0){
            Long item=rest%N;
            char pushItem;
            //大于等于10用字母代替.
            if(item>=10){
                pushItem=(char)(item+55);
            }else{
                pushItem=(item+"").toCharArray()[0];
            }
            //将取余结果入栈
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
