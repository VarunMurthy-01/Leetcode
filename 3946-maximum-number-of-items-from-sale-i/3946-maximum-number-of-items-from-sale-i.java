class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] dp = new int[budget + 1];
        int min = items[0][1];
        for (int i = 1; i < n; i++) {
            if (items[i][1] < min) {
                min = items[i][1];
            }
        }
        for (int i = 0; i < n; i++) {
            int free = 0;
            for (int j = 0; j < n; j++) {
                if (items[j][0] % items[i][0] == 0) {
                    free++;
                }
            }
            int price = items[i][1];
            for (int j = budget; j >= price; j--) {
                if (dp[j - price] + free > dp[j]) {
                    dp[j] = dp[j - price] + free;
                }
            }
        }
        int ans = 0;

        for (int i = 0; i <= budget; i++) {
            int total = dp[i] + (budget - i) / min;
            if (total > ans) {
                ans = total;
            }
        }
        return ans;
    }
}