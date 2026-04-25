class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // swap if needed
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // make naming easier
        int[] shorter = nums1;
        int[] longer = nums2;

        final int S = shorter.length;
        final int L = longer.length;
        final int TOTAL = S + L;
        final int HALF_LEFT_TOTAL = TOTAL / 2;

        int left = 0, right = S;

        while (left <= right) {
            int takeFromShort = left + (right - left) / 2;
            int takeFromLong = HALF_LEFT_TOTAL - takeFromShort;

            int Sleft = 0, Sright = 0, Lleft = 0, Lright = 0;
            if (takeFromShort == 0) {
                Sleft = Integer.MIN_VALUE;
            } else Sleft = shorter[takeFromShort - 1];

            if (takeFromLong == 0) {
                Lleft = Integer.MIN_VALUE;
            } else Lleft = longer[takeFromLong - 1];

            if (takeFromShort == S) {
                Sright = Integer.MAX_VALUE;
            } else Sright = shorter[takeFromShort];

            if (takeFromLong == L) {
                Lright = Integer.MAX_VALUE;
            } else Lright = longer[takeFromLong];

            // validate condition
            boolean validCut = Sleft <= Lright && Lleft <= Sright;

            if (validCut) {
                int leftMax = Math.max(Sleft, Lleft);
                int rightMin = Math.min(Sright, Lright);

                if (TOTAL % 2 == 1) return rightMin;
                else return 0.5 * (leftMax + rightMin);
            }

            if (Sleft > Lright) {
                right = takeFromShort - 1;
            } else left = takeFromShort + 1;
        }
        return -1;
    }
}
