class Trie{
    class TrieNode{
        TrieNode[] children;
        boolean isLeaf;
        public TrieNode(){
            children = new TrieNode[2];
        }
    }
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(int num){
        TrieNode cur = root;
        int i = 31;
        while(i >= 0){
            int ch = (num >> i) & 1;
            if(cur.children[ch] == null)
                cur.children[ch] = new TrieNode();
            cur = cur.children[ch];
            i--;
        }
        cur.isLeaf = true;
    }
    public int getMax(int num){
        TrieNode cur = root;
        int i = 31, result = 0;
        while(i >= 0){
            int digit = (num >> i) & 1; 
            int ch = 1 - digit;
            if(cur.children[ch] != null){
                result = result | (1 << i);
                cur = cur.children[ch];
            } else {
                result = result | (0 << i);
                cur = cur.children[digit];
            }
            i--;
        }
        return result;
    }
    public void insertAll(int[] nums){
        for(int i : nums)
            insert(i);
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();
        t.insertAll(nums);
        int max = 0;
        for(int i : nums)
            max = Math.max(max, t.getMax(i));
        return max;
    }
}