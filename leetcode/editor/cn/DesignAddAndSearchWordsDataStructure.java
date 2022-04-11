package editor.cn;


public class DesignAddAndSearchWordsDataStructure{
    public static void main(String[] args) {
        //Solution solution = new DesignAddAndSearchWordsDataStructure().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if(cur.next[word.charAt(i) - 'a'] == null){
                cur.next[word.charAt(i) - 'a'] = new Node();
            }
            cur = cur.next[word.charAt(i) - 'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    public boolean dfs(Node root, String word, int index){
        if(index == word.length()){
            return root.isEnd;
        }

        char cur = word.charAt(index);
        if(Character.isLetter(cur)){
            if(root.next[cur-'a'] != null && dfs(root.next[cur-'a'], word, index + 1)){
                return true;
            }
            return false;
        }

        for (int i = 0; i < 26; i++) {
            if(root.next[i] != null && dfs(root.next[i], word, index + 1)){
                return true;
            }
        }
        return false;
    }
}

class Node {
    Node[] next;
    boolean isEnd;

    Node(){
        next = new Node[26];
        isEnd = false;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

