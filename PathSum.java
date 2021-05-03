class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
         if (root == null) {
             return false;
         }
         if (root.left == null && root.right == null && root.val == targetSum)
             return true;
         if (root.left == null && root.right == null && root.val != targetSum)
             return false;
         return hasPathSum(root.right, targetSum - root.val) || hasPathSum(root.left, targetSum - root.val);
    }
}
