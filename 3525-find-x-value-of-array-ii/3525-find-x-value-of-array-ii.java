class Solution {

    class Node {
        int product;
        int[] prefix;

        Node(int k) {
            prefix = new int[k];
        }
    }

    int k;

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;

        int n = nums.length;
        Node[] tree = new Node[4 * n];

        build(tree, nums, 1, 0, n - 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Update nums[index]
            update(tree, 1, 0, n - 1, index, value);

            // Query [start ... n-1]
            Node result = query(tree, 1, 0, n - 1, start, n - 1);

            ans[i] = result.prefix[x];
        }

        return ans;
    }

    // Build segment tree
    void build(Node[] tree, int[] nums, int node, int left, int right) {

        if (left == right) {

            tree[node] = new Node(k);

            int remainder = nums[left] % k;

            tree[node].product = remainder;

            // One element itself is one prefix
            tree[node].prefix[remainder] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(tree, nums, node * 2, left, mid);
        build(tree, nums, node * 2 + 1, mid + 1, right);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // Merge two segments
    Node merge(Node leftNode, Node rightNode) {

        Node result = new Node(k);

        // Product of complete segment
        result.product =
            (leftNode.product * rightNode.product) % k;

        // Prefixes completely inside left segment
        for (int r = 0; r < k; r++) {

            result.prefix[r] += leftNode.prefix[r];
        }

        /*
         * Prefixes that go through the entire left segment
         * and continue into the right segment.
         */
        for (int r = 0; r < k; r++) {

            int count = rightNode.prefix[r];

            if (count == 0)
                continue;

            int newRemainder =
                (leftNode.product * r) % k;

            result.prefix[newRemainder] += count;
        }

        return result;
    }

    // Point update
    void update(Node[] tree, int node, int left, int right,
                int index, int value) {

        if (left == right) {

            tree[node] = new Node(k);

            int remainder = value % k;

            tree[node].product = remainder;
            tree[node].prefix[remainder] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {

            update(tree, node * 2, left, mid, index, value);

        } else {

            update(tree, node * 2 + 1, mid + 1, right, index, value);
        }

        tree[node] =
            merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // Range query
    Node query(Node[] tree, int node, int left, int right,
               int ql, int qr) {

        if (ql <= left && right <= qr) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        if (qr <= mid) {

            return query(
                tree,
                node * 2,
                left,
                mid,
                ql,
                qr
            );

        } else if (ql > mid) {

            return query(
                tree,
                node * 2 + 1,
                mid + 1,
                right,
                ql,
                qr
            );
        }

        Node leftResult = query(
            tree,
            node * 2,
            left,
            mid,
            ql,
            qr
        );

        Node rightResult = query(
            tree,
            node * 2 + 1,
            mid + 1,
            right,
            ql,
            qr
        );

        return merge(leftResult, rightResult);
    }
}