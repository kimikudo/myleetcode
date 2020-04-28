package solution;

import defined.TrieNode;

import java.util.*;

/**
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 */
public class WordsEncoding {
    //这种方法不得行,对于后面的词包含前面的词的情况处理不了,
    /*public int minimumLengthEncoding(String[] words) {
        int length = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (!stringBuilder.toString().contains(words[i])){
                stringBuilder.append(words[i]+"#");
            }
        }
        length = stringBuilder.length();
        return length;
    }*/

    //官方解法一,存储单词后缀,使用一个HashSet
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        int length = 0;
        for (String string : set) {
            length += string.length() + 1;
        }
        return length;
    }

    //官方解法二 字典树 
    public int minLengthEncodingTrie(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; j--) {
                cur = cur.get(word.charAt(j));
            }
            nodes.put(cur, i);
        }

        int result = 0;
        for (TrieNode node : nodes.keySet()) {
            if (node.count == 0) {
                result += words[nodes.get(node)].length() + 1;
            }
        }
        return result;

    }


    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        WordsEncoding wordsEncoding = new WordsEncoding();
        //int result = wordsEncoding.minimumLengthEncoding(words);
        int result = wordsEncoding.minLengthEncodingTrie(words);
        System.out.println(result);
    }
}
