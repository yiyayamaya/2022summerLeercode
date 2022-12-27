import java.util.*;

public class IBM第二题 {
    public static void main(String[] args) {
        List<Integer> input=new ArrayList<>(            Arrays.asList(1,1,2,3,3,6));
        Collections.sort(input);
        Collections.reverse(input);

        Stack<Integer> stack=new Stack<>();
        for(int num:input)
            stack.push(num);
        int res=0;
        //boolean started=false;
        int lastNum=stack.pop();
        while (!stack.isEmpty()){
            int node=stack.pop();

                if(node==lastNum){
                    lastNum=node*2;
                }else{
                    res++;
                    lastNum=node;
                }

        }
        res+=1;
        System.out.println(res);
    }
}
