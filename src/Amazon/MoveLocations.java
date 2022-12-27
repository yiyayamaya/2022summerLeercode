package Amazon;

import java.util.HashSet;

public class MoveLocations {
    public static void main(String[] args) {
        HashSet<Integer>hashSet=new HashSet();
        int []locations=new int[]{1,7,6,8};
        for(int location:locations){
            hashSet.add(location);
        }

        int []movedFrom=new int[]{1,7,2};
        int []movedTo=new int[]{2,9,5};
        for(int i=0;i< movedFrom.length;i++){
            int start=movedFrom[i];
            int end=movedTo[i];
            hashSet.remove(start);
            hashSet.add(end);
        }
        for(int n:hashSet){
            System.out.println("n = " + n);
        }
    }
}
