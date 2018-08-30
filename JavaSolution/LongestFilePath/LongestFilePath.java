import java.util.HashMap;
import java.util.Map;

/**
 * Created by lingyanjiang on 18/6/4.
 */
public class LongestFilePath {

    public int lengthLongestPath(String input) {
        int res = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 0);
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            int len = s.substring(level).length();
            if (s.contains(".")) {
                res = Math.max(res, m.get(level) + len);
            } else {
                m.put(level + 1, m.get(level) + len + 1);
            }
        }
        return res;
    }

//    /**
////     * @param input: an abstract file system
//     * @return: return the length of the longest absolute path to file
//     */
//    public static int lengthLongestPath(String input) {
//        if (input == null || input.length() == 0) return 0;
//        // write your code here
//        int res = 0;
//        int curLevel = 0;
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < input.length(); ) {
//            if (input.charAt(i) == '\t') {
//                i += 1;
//                curLevel += 1;
//                continue;
//            }
//            if (input.charAt(i) == '\n') {
//                i += 1;
//                continue;
//            }
//            int j = i + 1;
//
//            while (j < input.length()) {
//                if (input.charAt(j) == '\n' || input.charAt(j) == '\t') {
//                    break;
//                }
//                j++;
//            }
//            String curDir = input.substring(i, j);
//            if (list.size() > curLevel) {
//                String curLongest = getString(list);
//                res = curLongest.length() > res ? curLongest.length() : res;
//                while (list.size() > curLevel) {
//                    list.remove(list.size() - 1);
//                }
//            }
//            list.add(curDir);
//            String curLongest = getString(list);
//            res = curLongest.length() > res ? curLongest.length() : res;
//            i = j;
//            curLevel = 0;
//        }
//        return list.size() == 1 ? 0 :res;
//    }
//
//    private static String getString(List<String> list) {
//        String s = "";
//        for (int i = 0; i < list.size(); i++) {
//            if (i != 0) {
//                s += "\t";
//            }
//            s += list.get(i);
//        }
//        return s;
//    }

    public static void main(String[] args) {
//        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
//        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
//        System.out.println(lengthLongestPath("dir"));
    }
}
