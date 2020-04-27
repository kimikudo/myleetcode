package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {
    //我的解法...有点麻烦,效率很低,内存消耗5.2%,时间14%...
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int i = 0;
        int j = 0;
        int result = 0;
        //存放截取的字符串
        Set<Character> strSet = new HashSet<>();
        //一层循环,从头开始遍历
        for (i = 0; i < length; i++) {
            //二层循环的索引,从当前位置向后遍历
            j = i;
            //每次开始前清空set
            if (strSet.size() > 0) {
                strSet.clear();
            }
            //二层循环,从当前位置开始
            while (j < length) {
                //如果无重复字符,就将字符加入set
                if (!strSet.contains(s.charAt(j))) {
                    strSet.add(s.charAt(j));
                } else {
                    //否则跳出循环
                    break;
                }
                j++;
            }
            //计算当前循环之后得到的子字符串长度是否是目前最大的
            result = Math.max(result, j - i);
        }
        return result;
    }

    //官方解法2之滑动窗口,仅进行一次循环
    //内存消耗依然很大5.2%,时间提升了很多.56%
    public int officialSolution2(String s) {
        int length = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //官方解法3,优化滑动窗口
    public int officialSolution3(String s) {
        int length = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < length; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        int result = longestSubstring.lengthOfLongestSubstring("au");
        System.out.println(result);
    }
}
