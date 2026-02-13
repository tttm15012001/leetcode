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

    public int lengthOfLongestSubstring2(String s) {
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxRepeatIndex = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            if (map.containsKey(character)) {
                maxLength = Math.max(maxLength, count);
                // khi bị trùng, tính toán vị trí trùng lớn nhất (các kí tự trước đó coi như bỏ qua)
                maxRepeatIndex = Math.max(maxRepeatIndex, map.get(character));
                // chỉ đếm từ kí tự đầu tiên ngay sau kí tự trùng
                count = i - maxRepeatIndex;
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
        System.out.println(mainClass.lengthOfLongestSubstring2(s));
    }
}
