class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int best = Integer.MAX_VALUE;
                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;
                    int changes = 0;

                    for (int r = 0; r < d; r++) {
                        int left = r;
                        int right = len - d + r;

                        while (left < right) {
                            if (s.charAt(i + left) !=
                                s.charAt(i + right)) {
                                changes++;
                            }
                            left += d;
                            right -= d;
                        }
                    }
                    best = Math.min(best, changes);
                }
                cost[i][i + len - 1] = best;
            }
        }

        int INF = 1_000_000;
        int[][] res = new int[n + 1][k + 1];

        for (int[] row : res) {
            java.util.Arrays.fill(row, INF);
        }

        res[0][0] = 0;

        for (int parts = 1; parts <= k; parts++) {
            for (int i = 2 * parts; i <= n; i++) {
                for (int j = 2 * (parts - 1); j <= i - 2; j++) {
                    res[i][parts] = Math.min(
                        res[i][parts],
                        res[j][parts - 1] + cost[j][i - 1]
                    );
                }
            }
        }
        return res[n][k];
    }
}
