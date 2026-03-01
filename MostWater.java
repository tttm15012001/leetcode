public class MostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        int curIdx = -1;

        while (left < right) {
            if (height[left] <= height[right]) {
                max = Math.max(max, (right - left) * height[left]);
                curIdx = left;
                while(left < right && height[left] <= height[curIdx]) {
                    left++;
                }
            } else {
                max = Math.max(max, (right - left) * height[right]);
                curIdx = right;
                while(left < right && height[right] <= height[curIdx]) {
                    right--;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MostWater mw = new MostWater();
        int[] height = new int[]{1};
        System.out.println(mw.maxArea(height));
    }
}
