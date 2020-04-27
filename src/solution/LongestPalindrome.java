package solution;

public class LongestPalindrome {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     */
    public String longestPalindrome(String s){
        if(s==null||s.length()<1){
            return "";
        }
        int start=0;
        int end=0;
        //中心点法,中心点可能是一个字符,也可能是两个字符,所以共有2n-1个字符
        //从第一个字符开始遍历,分别计算以一个字符和两个字符为中心的回文字符串,
        // 取长度较长的为此次遍历的结果0
        for(int i=0;i<s.length();i++){
            //以当前遍历的字符为中心的回文字符串长度
            int len1=expandAroundCenter(s,i,i);
            //以当前遍历字符,及之后的字符为中心的回文字符串长度
            int len2=expandAroundCenter(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>end-start){
                //确定回文字符串的起止下标
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    private int expandAroundCenter(String s,int left,int right){
        int L=left;
        int R=right;
        while(L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
}
