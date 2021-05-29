class FindNodeInClonedTree {
    TreeNode target, result;
    public final TreeNode getTargetCopy(final TreeNode original,
      final TreeNode cloned, final TreeNode target) {
        this.target = target;
        inorder(cloned, original);
        return result;
    }
    
    private void inorder(TreeNode c, TreeNode o) { // left, root, right
        if (o != null) {
            inorder(c.left, o.left); //left
            if (o == target) { //root
                result = c;
            }
            inorder(c.right, o.right);// right
        }

    }
}
