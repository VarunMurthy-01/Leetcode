class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] a = new int[n];
        int[] b = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            a[i] = map.getOrDefault(x - 1, 0) + 1;
            b[i] = map.getOrDefault(x, 0) + 1;

            map.put(x, Math.max(map.getOrDefault(x, 0), a[i]));
            map.put(x + 1, Math.max(map.getOrDefault(x + 1, 0), b[i]));

            ans = Math.max(ans, Math.max(a[i], b[i]));
        }
        return ans;
    }
}