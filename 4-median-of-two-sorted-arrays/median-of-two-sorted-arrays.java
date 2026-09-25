class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;
        int half = (m + n + 1) / 2;
        while (low <= high) {
            int i = (low + high) / 2;
            int j = half - i;
            int nums1Left =
                    (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right =
                    (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left =
                    (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right =
                    (j == n) ? Integer.MAX_VALUE : nums2[j];
            if (nums1Left <= nums2Right &&
                nums2Left <= nums1Right) {
                if ((m + n) % 2 == 1) {
                    return Math.max(nums1Left, nums2Left);
                }
                double leftMax =
                        Math.max(nums1Left, nums2Left);
                double rightMin =
                        Math.min(nums1Right, nums2Right);
                return (leftMax + rightMin) / 2.0;
            }
            else if (nums1Left > nums2Right) {
                high = i - 1;
            }
            else {
                low = i + 1;
            }
        }
        return 0.0;
    }
}