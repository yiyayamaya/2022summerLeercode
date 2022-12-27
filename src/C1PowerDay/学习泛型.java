package C1PowerDay;

import java.util.ArrayList;
import java.util.Arrays;

public class 学习泛型 {
    public  static < E >void print(ArrayList<E> list){
        for (E e : list) {
            System.out.println("e = " + e);
        }

    }


    public static void main( String args[] )
    {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        ArrayList<Integer>list1=new ArrayList<>(Arrays.asList(intArray));
        ArrayList<Double>list2=new ArrayList<>(Arrays.asList(doubleArray));
        ArrayList<Character>list3=new ArrayList<>(Arrays.asList(charArray));



        System.out.println( "整型数组元素为:");
        print(list1);
        System.out.println( "\n双精度型数组元素为:" );
        print(list2);
        System.out.println( "\n字符型数组元素为:" );
        print(list3);

    }

}


