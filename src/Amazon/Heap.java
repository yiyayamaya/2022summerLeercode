package Amazon;

public class Heap {
    int []data=new int[10001];
    int size;
    private void push(int key){
        data[size++]=key;
        heapUP(size-1);
    }
    private int pop(){
        int res=data[0];
        swap(0,size-1);
        //fixme 这里实现有问题吧？
        size--;
        //data[size--]=0;
        heapDown(0);
        return res;


    }

    /**
     * 在两个children 中找一个比较小的值 如果它比我小->和它交换->递归 直到我已经到了最后一层 没有children了
     * @param index
     */
    private void heapDown(int index){
        int smallest=index;

        int childL=2*index+1;
        int childR=2*index+2;
        //左右儿子里找一个存在且更小的
        if(childL<size&&data[index]<data[childL])
            smallest=childL;
        if(childR<size&&data[index]<data[childR])
            smallest=childR;

        //如果没有这样的儿子说明已经完成了heap化 返回
        if(smallest==index)
            return;
        //和这样的儿子交换后 从新位置处递归
        swap(index,smallest);
        heapDown(smallest);




    }
    private void heapUP(int index){
        if(index==0)
            return;
        int parent=(index-1)/2;
        if(data[index]<data[parent]){
            swap(index,parent);
            heapUP(parent);
        }
    }

    private void swap(int index,int parent){
        int tmp=data[index];
        data[index]=data[parent];
        data[parent]=tmp;
    }
}
