package Tree;


import java.util.Stack;

public class 二叉树与双向链表 {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(4);
        A.left = new TreeNode(2);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(3);
        A.right = new TreeNode(5);
        TreeNode res = treeToDoublyList(A);
        System.out.println();

    }
    public static TreeNode treeToDoublyList(TreeNode root) {


        Stack<TreeNode> stack=new Stack<>();
        TreeNode head=null;
        TreeNode pre=null;
        TreeNode cur=null;
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            //visit
            root=stack.pop();
            if(pre==null){
                head=root;
                pre=root;
            }else{
                cur=root;
                cur.left=pre;
                pre=root;
            }
            root=root.right;


        }
        head.left=pre;

        return head;


    }
}




