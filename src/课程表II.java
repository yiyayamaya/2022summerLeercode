import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 课程表II {
    public static void main(String[] args) {
        //findOrder(3,new int[][]{new int[]{1,0},new int[]{1,2},new int[]{0,1}});
        findOrder(2,new int[][]{new int[]{0,1},new int[]{1,0}});
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] res=new int[numCourses];
        int k=0;

        //先算入度
        int[] inDegreeMaps=new int[numCourses];
        for(int [] prerequisite:prerequisites){
            inDegreeMaps[prerequisite[0]]++;
        }


        //算邻居
        ArrayList<ArrayList<Integer>> neighbors=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            neighbors.add(new ArrayList<Integer>());
        }
        for(int [] prerequisite:prerequisites){
            neighbors.get(prerequisite[1]).add(prerequisite[0]);
        }

        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(inDegreeMaps[i]==0)
                queue.add(i);
        }
        if(queue.isEmpty())
            return new int[]{};

        while(!queue.isEmpty()){
            int node=queue.remove();
            if(k>=numCourses)
                return new int[]{};
            res[k++]=node;


            for(int neighbor:neighbors.get(node)){
                inDegreeMaps[neighbor]--;
                if(inDegreeMaps[neighbor]==0)
                    queue.add(neighbor);
            }



        }

        return res;
    }
}
