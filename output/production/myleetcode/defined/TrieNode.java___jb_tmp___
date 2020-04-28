package defined;

public class TrieNode {
    public TrieNode[] children;
    public int count;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.count = 0;
    }

    public TrieNode get(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }
}
