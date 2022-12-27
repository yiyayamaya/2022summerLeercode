package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里用的geek 方法 下而上
 * 实际不嫌麻烦用回溯好模板也是可以的 只是回溯好模板就变成了所有路 不会一条路就返回
 */
public class 树里找到root到目标的一条路 {


    //更合理的下而上 是对的 感觉比geek好
    public List<Integer> dfs(TreeNode node, int target) {

        List<Integer> resAll = new ArrayList<>();

        if (node == null) {
            return resAll;
        }

        if (node.val == target) {
            resAll.add(node.val);
            return resAll;
        }

        List<Integer> resL = dfs(node.left, target);
        List<Integer> resR = dfs(node.right, target);

        if (resL.size() != 0) {
            resL.add(node.val);
            return resL;
        }

        if (resR.size() != 0) {
            resR.add(node.val);
            return resR;
        }



        return resAll;


    }

    //下而上 找到一条立刻返回了
    public static boolean hasPath(TreeNode root, ArrayList<Integer> arr, int x) {
        if (root == null)
            return false;

        arr.add(root.val);

        if (root.val == x)
            return true;

        if (hasPath(root.left, arr, x) || hasPath(root.right, arr, x))
            return true;
        arr.remove(arr.size() - 1);
        return false;
    }

    public static void printPath(TreeNode root, int x) {
        ArrayList<Integer> arr = new ArrayList<>();

        if (hasPath(root, arr, x)) {
            for (int i = 0; i < arr.size() - 1; i++)
                System.out.print(arr.get(i) + "->");
            System.out.print(arr.get(arr.size() - 1));
        }

        // 'x' is not present in the binary tree
        else
            System.out.print("No Path");
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int x = 5;
        printPath(root, x);
    }
}
