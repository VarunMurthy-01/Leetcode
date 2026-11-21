class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        int[] newParent = new int[n];
        int[] prevLast = new int[n];
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] order = new int[n];
        int orderIndex = 0;
        int[] stack = new int[2 * n];
        int top = 0;
        stack[top++] = 0;

        while (top > 0) {
            int event = stack[--top];
            if (event < 0) {
                int node = ~event;
                int c = s.charAt(node) - 'a';
                last[c] = prevLast[node];
                continue;
            }
            int node = event;
            int c = s.charAt(node) - 'a';

            prevLast[node] = last[c];
            if (last[c] != -1) {
                newParent[node] = last[c];
            } else {
                newParent[node] = parent[node];
            }

            last[c] = node;
            order[orderIndex++] = node;
            stack[top++] = ~node;
            for (int i = children[node].size() - 1;
                 i >= 0; i--) {
                stack[top++] = children[node].get(i);
            }
        }
        int[] size = new int[n];
        Arrays.fill(size, 1);

        for (int i = n - 1; i >= 0; i--) {
            int node = order[i];
            int p = newParent[node];
            if (p != -1) {
                size[p] += size[node];
            }
        }
        return size;
    }
}