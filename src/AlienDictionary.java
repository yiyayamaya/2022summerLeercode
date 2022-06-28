import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {

        alienOrder(new String[]{"abc", "ab"});
    }

    public static String alienOrder(String[] words) {

        ArrayList<Integer> res=new ArrayList<>();
        ArrayList<int[]> prerequisites = new ArrayList<>();
        for (int j = 1; j < words.length; j++) {
            int i = j - 1;
            if(!find(prerequisites, words[i], words[j]))
                return "";
        }
        //算numCourses
        HashSet<Integer> hashSet=new HashSet<>();
        for(String s:words){
            for(char c:s.toCharArray())
                hashSet.add(c-'a');
        }
        int numCourses=hashSet.size();

        //先算入度
        int[] inDegreeMaps=new int[26];
        for (int i = 0; i < inDegreeMaps.length; i++) {
            if(!hashSet.contains(i))
                inDegreeMaps[i]=-1;
        }
        for(int [] prerequisite:prerequisites){
            inDegreeMaps[prerequisite[0]]++;
        }

        //算邻居
        ArrayList<ArrayList<Integer>> neighbors=new ArrayList<>();
        for(int i=0;i<26;i++){
            neighbors.add(new ArrayList<Integer>());
        }
        for(int [] prerequisite:prerequisites){
            neighbors.get(prerequisite[1]).add(prerequisite[0]);
        }


        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<26;i++){
            if(inDegreeMaps[i]==0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int node=queue.remove();
            res.add(node);

            for(int neighbor:neighbors.get(node)){
                inDegreeMaps[neighbor]--;
                if(inDegreeMaps[neighbor]==0)
                    queue.add(neighbor);
            }



        }
        String resStr="";
        for (int re : res) {
            resStr+=(char)('a'+(char)re);
        }

        if(res.size()!=numCourses)
            return "";
        return resStr;

    }

    public static boolean find(ArrayList<int[]> prerequisites, String a, String b) {
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                prerequisites.add(new int[]{b.charAt(i)-'a', a.charAt(i)-'a'});
                return true;
            }
        }
        if(a.length()>b.length())
            return false;
        return true;
    }
}
