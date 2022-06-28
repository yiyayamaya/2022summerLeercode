import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 课程表 {
    public static void main(String[] args) {
        canFinish(2,new int[][]{new int[]{1,0}});
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Integer> res=new ArrayList<>();

        //先算入度
        HashMap<Integer,Integer> inDegreeMaps=new HashMap<>();
        for(int [] prerequisite:prerequisites){
            inDegreeMaps.put(prerequisite[0],inDegreeMaps.getOrDefault(prerequisite[0],0)+1);
        }

        //算邻居 用list会不会重复？ 不会 因为prerequisites[i] 中的所有课程对 互不相同
        HashMap<Integer,ArrayList<Integer>> neighbors=new HashMap<>();
        for(int [] prerequisite:prerequisites){
            if(neighbors.containsKey(prerequisite[1]))
                neighbors.get(prerequisite[1]).add(prerequisite[0]);
            else{
                ArrayList<Integer> list =new ArrayList<>();
                list.add(prerequisite[0]);
                neighbors.put(prerequisite[1],list);
            }
        }

        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegreeMaps.getOrDefault(i,0)==0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int node=queue.remove();
            res.add(node);
            if(neighbors.containsKey(node)){
                for(int neighbor:neighbors.get(node)){
                    inDegreeMaps.put(neighbor,inDegreeMaps.get(neighbor)-1);
                    if(inDegreeMaps.get(neighbor)==0)
                        queue.add(neighbor);
                }
            }


        }

        return res.size()==numCourses;

    }
}
