package google;

/**
 * Created by lingyanjiang on 17/2/20.
 */
public class BullsAndCows {

    public String getHint2(String secret, String guess) {
        int [] map = new int[256];
        int countA = 0, countB = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countA++;
            } else {
                if (map[secret.charAt(i)]++ < 0) {
                    countB++;
                }
                if (map[guess.charAt(i)]-- > 0) {
                    countB++;
                }
            }
        }
        System.out.println(countA + "A" + countB + "B");
        return countA + "A" + countB + "B";
    }

//     public String getHint(String secret, String guess) {
//         if (secret.length() == 0) return "0A0B";
//         int countA = 0;
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (int i = 0; i < secret.length(); i++) {
//             if (secret.charAt(i) == guess.charAt(i)) {
//                 countA++;
//             }
//             map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
//         }
//         int countB = 0;
//         for (int i = 0; i < guess.length(); i++) {
//             if (map.getOrDefault(guess.charAt(i), 0) > 0) {
//                 countB++;
//                 map.put(guess.charAt(i), map.getOrDefault(guess.charAt(i), 0) - 1);
//             }
//         }
//         countB = countB - countA;
//         return countA + "A" + countB + "B";
//     }

    public static void main(String[] args) {
        new BullsAndCows().getHint2("1807", "7810");
    }
}
