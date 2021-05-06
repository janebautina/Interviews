class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        return isUniversal(root, root.val);
    }

    private boolean isUniversal(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        if (node.val != val)
            return false;
        return isUniversal(node.left, val) && isUniversal(node.right, val);
    }
}
