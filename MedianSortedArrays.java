import java.util.ArrayList;
import java.util.List;

public class MedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> combinedList = new ArrayList<>();
        int id1 = 0;
        int id2 = 0;

        while(id1 < nums1.length || id2 < nums2.length) {
            if (id1 == nums1.length) {
                combinedList.add(nums2[id2++]);
            } else if (id2 == nums2.length) {
                combinedList.add(nums1[id1++]);
            } else if (nums1[id1] > nums2[id2]) {
                combinedList.add(nums2[id2++]);
            } else {
                combinedList.add(nums1[id1++]);
            }
        }

        int midIndex = combinedList.size() / 2;

        if (combinedList.isEmpty()) return 0;
        if (combinedList.size() % 2 == 1) return combinedList.get(midIndex);
        return (combinedList.get(midIndex - 1) + combinedList.get(midIndex)) / 2.0;
    }

    public static void main(String[] args) {
        MedianSortedArrays msa = new MedianSortedArrays();
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};

        System.out.println(msa.findMedianSortedArrays(nums1, nums2));
    }
}
