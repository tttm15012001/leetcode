import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] result;
        result = ts.twoSum(new int[]{9, 13, 7, 2, 15}, 9);
        System.out.println(Arrays.toString(result));

        result = ts.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(result));

        result = ts.twoSum(new int[]{3, 3}, 6);
        System.out.println(Arrays.toString(result));
    }
}
