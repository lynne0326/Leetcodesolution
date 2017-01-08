package Amazon;

/**
 * Created by lingyanjiang on 16/12/21.
 */
public class RemoveVowel {
    public static String removeVowel(String words) {
        StringBuilder sb = new StringBuilder();
        String vowel = "aeiouAEIOU";
        for(int i = 0; i < words.length(); i++) {
            if (vowel.indexOf(words.charAt(i)) != -1) {
                continue;
            }
            sb.append(words.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeVowel("abcdEfG"));
    }
}
