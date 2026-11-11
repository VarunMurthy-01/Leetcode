class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {

        long indi = (long) need1 * cost1 + (long) need2 * cost2;

        long both = (long) Math.max(need1, need2) * costBoth;

        int min = Math.min(need1, need2);

        long shared = (long) min * costBoth
               + (long) (need1 - min) * cost1
               + (long) (need2 - min) * cost2;

        return Math.min(indi, Math.min(both, shared));
    }
}