import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int first = 0;

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            if (map.containsKey(character) && map.get(character) >= first) {
                maxLength = Math.max(maxLength, count);
                count = i - map.get(character);
                first = map.get(character) + 1;
                map.put(character, i);
            } else {
                map.put(character, i);
                count++;
            }
        }

        return Math.max(maxLength, count);
    }

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingChar mainClass = new LongestSubStringWithoutRepeatingChar();
        String s = "abcdaaacbbcdebfgb";
        System.out.println(mainClass.lengthOfLongestSubstring(s));
    }
}
