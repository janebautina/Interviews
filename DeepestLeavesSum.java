class DeepestLeavesSum {

    class Pair {
        TreeNode node;
        int level;
        Pair(TreeNode n, int l) {
            level = l;
            node = n;
        }
        int getLevel() { return level; }
        TreeNode getNode() { return node; }
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        int maxDepth = depthTree(root); //4
        int currentLevel = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, currentLevel));
        while(!q.isEmpty()) {
            Pair curPair = q.poll();
            TreeNode cur = curPair.getNode();//root
            currentLevel = curPair.getLevel();//0
            if (cur.left == null && cur.right == null) {
                if (currentLevel == maxDepth) {
                   result += cur.val;
                }
            }
            if (cur.left != null) {
                q.offer(new Pair(cur.left, currentLevel + 1));
            }
            if (cur.right != null) {
                q.offer(new Pair(cur.right, currentLevel + 1));
            }
        }
        return result;
    }

    int depthTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depthTree(root.right), depthTree(root.left)) + 1;

    }

}
