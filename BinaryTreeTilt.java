class BinaryTreeTilt {

    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        this.totalTilt = 0;
        sum(root);
        return totalTilt;
    }
    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int tilt = Math.abs(leftSum - rightSum);
        this.totalTilt += tilt;
        return leftSum + rightSum + root.val;
    }
}
