import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的序列化与反序列化 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode deserialize(String data) {
        String[] split = data.split(",");

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);
        int count = 0;

        while (!queue.isEmpty() && count < split.length) {

            TreeNode node = queue.remove();
            if(node==null){
                count++;
                continue;
            }



            if (2 * count + 1 < split.length) {
                if (!split[2 * count + 1].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(split[2 * count + 1]));
                    queue.add(node.left);
                } else
                    queue.add(new TreeNode(-1));
            }


            if (2 * count + 2 < split.length) {
                if (!split[2 * count + 2].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(split[2 * count + 2]));
                    queue.add(node.right);
                } else
                    queue.add(new TreeNode(-1));
            }


            count++;
        }


        return root;
    }

    public static String serialize(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty() ) {

            TreeNode node = queue.remove();

            if(node!=null){
                queue.add(node.left);
                queue.add(node.right);
                res.add(String.valueOf(node.val));
            }else
                res.add("null");


        }
        return res.toString().replace("[", "")
                .replace("]", "")
                .replace(" ", "");
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        treeNode.right.left.left = new TreeNode(6);
        treeNode.right.left.right = new TreeNode(7);

        deserialize(serialize(treeNode));
//        deserialize("4,-7,-3,null,null,-9,-3,null,null,null,null,9,-7,-4,null,null,null,null,null,null,null,null,null,6,null,-6,-6,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,0,6,null,null,5,null,9,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,-4,null,null,null,null,null,null,null,null,null,-2,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null");

    }
}


