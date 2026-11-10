class Solution {
    public int climbStairs(int n, int[] costs) {

        int[] stairs = new int[n + 1];

        Arrays.fill(stairs, Integer.MAX_VALUE);

        stairs[0] = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = Math.max(0, i - 3); j < i; j++) {

                int jump = i - j;
                int cost = costs[i - 1] + jump * jump;
                stairs[i] = Math.min(stairs[i], stairs[j] + cost);
            }
        }

        return stairs[n];
    }
}