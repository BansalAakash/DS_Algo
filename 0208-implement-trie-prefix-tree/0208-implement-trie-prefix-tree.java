class Trie {
    class TrieNode{
        boolean isLeaf;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        int i = 0, n = word.length();
        while(i < n){
            int index = word.charAt(i) - 'a';
            
            if(cur.children[index] == null)
                cur.children[index] = new TrieNode();
            
            cur = cur.children[index];
            i++;
        }
        cur.isLeaf = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        int i = 0, n = word.length();
        while(i < n){
            int index = word.charAt(i) - 'a';
            
            if(cur.children[index] == null)
                return false;
            
            cur = cur.children[index];
            i++;
        }
        return cur.isLeaf;
    }
    
    public boolean startsWith(String word) {
        TrieNode cur = root;
        int i = 0, n = word.length();
        while(i < n){
            int index = word.charAt(i) - 'a';
            
            if(cur.children[index] == null)
                return false;
            
            cur = cur.children[index];
            i++;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */