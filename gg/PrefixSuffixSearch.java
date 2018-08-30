import java.util.*;

/**
 * Created by lingyanjiang on 18/8/18.
 */
public class PrefixSuffixSearch {
    //方法一:只用一个trie
    class TrieNode {
        char val;
        Map<Character, TrieNode> children;
        List<Integer> words;

        public TrieNode(char val) {
            this.val = val;
            this.children = new HashMap<>();
            this.words = new ArrayList<>();
        }
    }

    class TrieTree {
        TrieNode root;

        public TrieTree() {
            this.root = new TrieNode(' ');
        }

        public void add(String word, int weight) {
            TrieNode cur = root;
            root.words.add(weight);
            for(char c: word.toCharArray()) {
                if(cur.children.get(c) == null) {
                    cur.children.put(c, new TrieNode(c));
                }
                cur = cur.children.get(c);
                cur.words.add(weight);
            }
        }

        public List<Integer> find(String prefix) {
            TrieNode cur = root;

            for(char c: prefix.toCharArray()) {
                if (cur == null) return new ArrayList<>();
                cur = cur.children.get(c);
            }
            return cur == null ? new ArrayList<>() : cur.words;
        }
    }

    TrieTree prefixTree;
    String[] words;

    public PrefixSuffixSearch(String[] words) {
        this.words = words;
        this.prefixTree = new TrieTree();
        for(int i = 0; i < words.length; i++) {
            prefixTree.add(words[i], i);
        }
    }

    public int f(String prefix, String suffix) {
        suffix = reverseWord(suffix);
        List<Integer> candidates = prefixTree.find(prefix);
        Collections.sort(candidates, Collections.reverseOrder());
        for(int c: candidates) {
            if(reverseWord(words[c]).startsWith(suffix)) return c;
        }
        return -1;
    }

    private String reverseWord(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }


}
