class GoodNodes {
    private int walkMax(TreeNode root, int maxValue) {
        int nGoodNodes = 0;
        int newMaxValue = maxValue;
        if (root == null) {
            return 0;
        }
        if (root.val >= maxValue) {
            newMaxValue = root.val;
        }
        return walkMax(root.left, newMaxValue) +                walkMax(root.right, newMaxValue) +
            (root.val >= maxValue ? 1 : 0);

    }

    public int goodNodes(TreeNode root) {
        return walkMax(root, Integer.MIN_VALUE);
    }
}
