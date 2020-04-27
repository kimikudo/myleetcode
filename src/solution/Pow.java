package solution;

public class Pow {
    public double myPow(double x, int n) {
        double result = 1.0;
        if(n>=0){
            for(int i=0;i<n;i++){
                result*=x;
            }
        }else{
            for(int i=0;i>n;i--){
                result/=x;
            }
        }
        return result;
    }
    public static void main(String[] args){
        Pow pow = new Pow();
        double result = pow.myPow(2,-2);
        System.out.println(result);

    }
}
