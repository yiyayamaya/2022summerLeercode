// 引入 ArrayList 和 Iterator 类
import java.util.*;

public class RunoobTest {
    public static void main(String[] args) {

        // 创建集合
        ArrayList<String> sites = new ArrayList<String>();
        LinkedList<String> sites2 = new LinkedList<String>();
        Vector<String> sites3 = new Vector<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");

        HashSet<String> hs = new HashSet<String>();
        Iterator<String> iterator = hs.iterator();

        // 获取迭代器
        Iterator<String> it = sites.iterator();
        Iterator<String> it2 = sites2.iterator();
        Iterator<String> it3 = sites3.iterator();

        // 输出集合中的第一个元素
        System.out.println(it.next());
    }
}