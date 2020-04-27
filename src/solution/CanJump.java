package solution;

public class CanJump {
    public boolean canJump(int[] nums) {
        int rightmost=0;
        for(int i=0;i<nums.length;i++){
            if(i<=rightmost){
                rightmost=Math.max(rightmost,i+nums[i]);
                if(rightmost>=nums.length-1){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] array ={2,5,0,0};
        CanJump canJump=new CanJump();
        boolean result=canJump.canJump(array);
        System.out.println(result);
    }
}
