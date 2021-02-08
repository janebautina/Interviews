class TreePostOrder {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
          Node current = stack.pop();
          list.addFirst(current.val);
          for (Node child: current.children) {
            if(child != null)
            stack.push(child);
          }
        }
        return list;
    }
}
