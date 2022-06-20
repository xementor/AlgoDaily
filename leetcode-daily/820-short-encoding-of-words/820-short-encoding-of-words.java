class Solution {
//     public int minimuthEncoding2(String[] words) {
//         String res = "";
//         for( int i=0; i<words.length(); i++){
//             if (i == 0){
//                 res = res + words[i]  + '#';          
//             }else{
//                 // Check in reverse
//                 int k = res.length() -1;
//                 for (int j=words[i].length()-1; j<0; j--){
//                     if(res.charAt(k) != words[i].charAt(j)){
//                         res = res + words[i] + '#';
//                     }
//                 }
//             }
//         }
        
//     }
    

//     public int minimumLengthEncoding(String[] words) {
//         Set<String> good = new HashSet(Arrays.asList(words));

        
//         for (String word: words) {
//             for (int k = 1; k < word.length(); ++k){
             
//                 good.remove(word.substring(k));
               
//             }
                
          
            
//         }

//         int ans = 0;
//         for (String word: good)
//             ans += word.length() + 1;
//         return ans;
//     }
    
    

    public int minimumLengthEncoding(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j)
                cur = cur.get(word.charAt(j));
            nodes.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node: nodes.keySet()) {
            if (node.count == 0)
                ans += words[nodes.get(node)].length() + 1;
        }
        return ans;

    }
}

class TrieNode {
    TrieNode[] children;
    int count;
    TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }
    public TrieNode get(char c) {
        if (children[c-'a'] == null) {
            children[c-'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }
}

