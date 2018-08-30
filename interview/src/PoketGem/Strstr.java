package PoketGem;

/**
 * Created by lingyanjiang on 17/2/18.
 */
public class Strstr {
    //version 1
    //复杂度 O(MN) worstcase 1111111112   1112
//    public int strStr(String hays, String needle) {
//        if (needle.length() == 0) return 0;
//        if (hays.length() < needle.length()) return -1;
//        for (int i = 0; i < hays.length(); i++) {
//            for (int j = 0; j <= needle.length(); j++) {
//                if (j == needle.length()) return i;
//                if (i + j >= hays.length()) return -1;
//                if (hays.charAt(i + j) != needle.charAt(j)) break;
//            }
//        }
//        return -1;
//    }
//
//    //version 2
//    public int strStr(String source, String target) {
//        if (source == null || target == null) {
//            return -1;
//        }
//
//        for (int i = 0; i < source.length() - target.length() + 1; i++) {
//            int j = 0;
//            for (j = 0; j < target.length(); j++) {
//                if (source.charAt(i + j) != target.charAt(j)) {
//                    break;
//                }
//            }
//            // finished loop, target found
//            if (j == target.length()) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && i + needle.length() - 1 < haystack.length()) {
                //If matching first character
                boolean isMatch = true;
                for (int j = i + needle.length() - 1; j > i; j--) {
                    if (haystack.charAt(j) != needle.charAt(j - i)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) return i;
            }
        }
        return -1;
    }


    public int strStr2(String haystack, String needle) {
        //First corner case, when needle length is 0, return 0
        if (needle.length() == 0) return 0;
        //Then if needle length is longer than the haystack length return -1
        if (haystack.length() < needle.length()) return -1;
        //Then we iterate through haystack, for each position
        // we need to find if it matches the needle
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j <= needle.length(); j++) {
                //so we iterate through the needle string character by character, if the j pointer exhausted,
                //which means we reach the end without break,
                //so we return the current position i
                //If i + j is larger than the last index of haystack, which means there is no more matching after it
                //we just return -1
                //Whenever we find a situation where haystack char where i point to
                // is not equal to needle current char j, means there is no matching for current i,
                // we just break the loop
                if (j == needle.length()) return i;
                if (i + j >= haystack.length()) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
        return -1;
    }
}
