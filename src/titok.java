public class titok {
     int time=1;
    public static void main(String[] args) {
        int time=2;
        System.out.println(time);
        titok t1=new titok();
        System.out.println(t1.time);
        String s="1 2 3 4 5";
        String[] s1 = s.split(" ");
        for(String ss:s1){
            int a= Integer.parseInt(ss) ;
            System.out.println(a);
        }
    }

    public void test(){
        int a=1;
        System.out.println(a);
    }
}
