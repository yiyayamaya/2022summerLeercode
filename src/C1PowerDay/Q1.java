package C1PowerDay;

import java.util.*;

class Stock implements Comparable<Stock>{
    String companyName;
    double value;


    public Stock(String companyName, double value) {
        this.companyName = companyName;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "companyName='" + companyName + '\'' +
                ", value=" + value +
                '}';
    }





    @Override
    public int compareTo(Stock stock) {
        return (int) (this.value-stock.value);
    }


}
public class Q1 {
    HashMap<String,Double> hashMap=new HashMap<>();
    ArrayList<Stock> list=new ArrayList<>();
    HashMap<String,Double> CASHBACK=new HashMap<>();
    PriorityQueue<Stock> heap=new PriorityQueue<>();

    public static void main(String[] args) {
        Q1 q1=new Q1();
        q1.print();

    }
    public void print(){
        CASHBACK.put("Starbucks",0.1);
        CASHBACK.put("Amazon",0.2);
        CASHBACK.put("Walmart",0.01);

        PURCHASE("Starbucks",100);
        PURCHASE("Starbucks",10);
        PURCHASE("Amazon",15);
        PURCHASE("Walmart",30);
        REFUND("Walmart",30);
        for (Map.Entry<String, Double> entry : hashMap.entrySet()) {
            Stock stock =new Stock(entry.getKey(),entry.getValue()*CASHBACK.get(entry.getKey()));
            list.add(stock);
            heap.add(stock);
        }
        Collections.sort(list);
        System.out.println("list = " + list);

        System.out.println();
    }
    public void PURCHASE(String companyName,double value){
        hashMap.put(companyName,hashMap.getOrDefault(companyName,0.0)+value);
    }
    public void REFUND(String companyName,double value){
        hashMap.put(companyName,hashMap.getOrDefault(companyName,0.0)-value);
    }

}
