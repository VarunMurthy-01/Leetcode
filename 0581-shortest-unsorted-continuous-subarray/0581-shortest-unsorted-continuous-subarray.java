class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int n = nums.length;
        int max = nums[0];
        int right = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
        }

        int min = nums[n - 1];
        int left = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > min) {
                left = i;
            } else {
                min = nums[i];
            }
        }

        if (right == -1) {
            return 0;
        }
        return right - left + 1;
    }
}