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

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        if(A.length > B.length){
            A = nums2;
            B = nums1;
        }
        int total = A.length + B.length;
        int half = total/2;
        int l = 0;
        int r = A.length;
        while (l <= r) {
            int midA = (l + r)/2;
            int midB = half - midA;
            int Aleft = midA > 0 ? A[midA - 1] : Integer.MIN_VALUE;
            int Aright = midA < A.length ? A[midA] : Integer.MAX_VALUE;
            int Bleft = midB > 0 ? B[midB - 1] : Integer.MIN_VALUE;
            int Bright = midB < B.length ? B[midB] : Integer.MAX_VALUE;

            if(Aleft <= Bright && Bleft <= Aright){
                // tới đây thì sự sắp xếp sẽ như sau Aleft -> Bleft -> Aright -> Bright (Aleft, Bleft có thể đảo, Aright và Bright cũng v)
                if(total % 2 != 0){
                    // median nằm ngay sau đó và nằm trong đống right -> min(Aright và Bright)
                    return Math.min(Aright, Bright);
                }
                else{
                    // median là chứa giá trị lớn nhất của left + giá trị nhỏ nhất của right
                    return (Math.max(Aleft, Bleft) +  Math.min(Aright, Bright)) / 2.0;
                }
            }
            else if(Aleft > Bright){
                r = midA - 1;
            }
            else{
                l = midA + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MedianSortedArrays msa = new MedianSortedArrays();
        int[] nums1 = new int[]{1,2,3,4,12};
        int[] nums2 = new int[]{6,7,8,9,10,11,12,13,14,15,16,17};

        System.out.println(msa.findMedianSortedArrays2(nums1, nums2));
    }
}
