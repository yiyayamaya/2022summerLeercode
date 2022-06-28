import java.util.*;

public class GraphValidTree {
    public static void main(String[] args) {
        validTree(5,new int[][]{{0,1},{1,2},{2,3},{1,3},{1,4}});
    }
    public static boolean validTree(int n, int[][] edges) {

        HashSet<Integer> hashSet=new HashSet<>();
        //ai一定<bi吗

        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            if(edge[0]<edge[1])
                al.get(edge[0]).add(edge[1]);
            else
                al.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        hashSet.add(0);
        while (!queue.isEmpty()){
            int node=queue.remove();
            for (Integer integer : al.get(node)) {
                if(hashSet.contains(integer))
                    return false;
                hashSet.add(integer);
                queue.add(integer);
            }
        }

        return true;

    }
}
