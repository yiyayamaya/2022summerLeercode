package Tree;

public class 树的子结构 {
    static boolean started = false;
    static boolean end = false;

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.left.left = new TreeNode(4);
        A.right = new TreeNode(3);

        TreeNode B = new TreeNode(3);

        System.out.println(isSubStructure(A, B));
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {

        if(started&&B==null)
            return true;
        if(B==null)
            return false;
        if(A==null)
            return false;
        if(A.val!=B.val)
            return false;
        if(A.val==B.val){
            started=true;
            boolean res= isSubStructure(A.left,B.left)&&isSubStructure(A.right,B.right);
            if(!res)
                started=false;
            else
                return true;

        }
        return isSubStructure(A.left,B)||isSubStructure(A.right,B);

    }

}

