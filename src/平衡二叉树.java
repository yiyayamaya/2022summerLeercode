public class 平衡二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);
        isBalanced(root);

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (getHeight(root) == -1)
            return false;
        return true;
    }

    public static int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1)
            return -1;
        leftHeight++;
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1)
            return -1;
        rightHeight++;


        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight);

    }
}
