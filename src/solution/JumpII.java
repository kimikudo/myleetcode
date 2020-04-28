package solution;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class JumpII {
    public int jump(int[] nums) {
        int count = 0;
        int start = 0;
        int end = 1;
        int length = nums.length;
        while (end < length) {
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end;
            end = maxPos + 1;
            count++;
        }
        return count;
    }

    public int jumpii(int[] nums) {
        int count = 0;
        int end = 0;
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == end) {
                end = maxPos;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        JumpII jumpII = new JumpII();
        int[] nums = {0};
        int result = jumpII.jump(nums);
        System.out.println(result);
    }
}
