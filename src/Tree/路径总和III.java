package Tree;

public class 路径总和III {
    public  static int res;
    public static void main(String[] args) {
/*        TreeNode A = new TreeNode(10);
        A.left = new TreeNode(5);
        A.right = new TreeNode(-3);
        A.left.left = new TreeNode(3);
        A.left.right = new TreeNode(2);
        A.right.right = new TreeNode(11);
        A.left.left.left = new TreeNode(3);
        A.left.left.right = new TreeNode(-2);
        A.left.right.right = new TreeNode(1);*/
        TreeNode A = new TreeNode(5);
        A.left = new TreeNode(4);
        A.right = new TreeNode(8);
        A.left.left = new TreeNode(11);
        A.left.left.left = new TreeNode(7);
        A.left.left.right = new TreeNode(2);
        A.right.left = new TreeNode(13);
        A.right.right = new TreeNode(4);
        A.right.right.right = new TreeNode(1);
        A.right.right.left = new TreeNode(5);
        pathSum(A, 22);
        System.out.println(res);


    }
    public static int pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,true);
        return res;

    }
    public static void dfs(TreeNode root,int targetSum,boolean amIStarted){
        if(root==null)
            return;
        if(root.val==targetSum){
            res++;
            //System.out.println(root.val+" "+targetSum);
        }
        //要区分我是不是一个新起点 如果我不是新起点而是第二步棋子 那我没资格不走自己
        if(!amIStarted){
            dfs(root.left,targetSum-root.val,false);
            dfs(root.right,targetSum-root.val,false);
        }else {
            //我是新起点 我可以不走自己
            dfs(root.left, targetSum, true);
            dfs(root.right, targetSum, true);
            //也可以走自己
            dfs(root.left, targetSum - root.val, false);
            dfs(root.right, targetSum - root.val, false);
        }
    }


}
