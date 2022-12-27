package C1PowerDay;

//最大堆
public class MaxHeap {
    private int[] data;//存放堆数据的数组
    private int size; //当前堆的大小
    private int capacity; //堆的最大容量

    public MaxHeap(int size) {
        data = new int[size];
        this.size = 0;
        this.capacity = size;
    }

    /**
     * 获取某个结点的父结点索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new RuntimeException("根结点没有父结点");
        }

        return (index - 1) / 2;
    }

    /**
     * 获取某个结点的左孩子索引
     *
     * @param index
     * @return
     */
    private int lchild(int index) {
        return (2 * index) + 1;
    }

    /**
     * 获取某个结点的右孩子索引
     *
     * @param index
     * @return
     */
    private int rchild(int index) {
        return (2 * index) + 2;
    }

    //插入元素
    public void insert(int d) {
        if (size == capacity) {
            System.out.println("堆已满");
            return;
        }
        data[size] = d;
        shiftUp(size);
        size++;
    }

    //移除元素
    public int removeMax() {

        if (size == 0) {
            System.out.println("堆已经是空的了！");
            return -1;
        }
        int t = data[0];
        //将最后一个元素放到第一个元素位置
        data[1] = data[size];
        //然后将第一个元素下移到适当位置
        shiftDown(1);
        size--;


        return t;
    }

    //堆删除元素时的元素下移
    private void shiftDown(int i) {
        while ((2 * i + 1) <= size) {
            int j = i * 2 + 1;
            // 让j指向他的孩子结点中的大的那一个
            if (j + 1 <= size && data[j] < data[j + 1]) {
                j = j + 1;
            }
            if (data[i] > data[j]) {
                break;
            }

            //元素下移
            int t=data[i];
            data[i]=data[j];
            data[j]=t;
            i=j;
        }
    }

    private void shiftUp(int index) {

        while (index > 0 && data[index] > data[(index - 1) / 2]) {
            int temp = data[index];
            data[index] = data[(index - 1) / 2];
            data[(index - 1) / 2] = temp;
            index = (index - 1) / 2;
        }

    }

    public static void main(String[] args) {
        MaxHeap maxHeap=new MaxHeap(100);
        maxHeap.insert(8);
        maxHeap.insert(15);
        maxHeap.insert(7);
        maxHeap.insert(6);
        maxHeap.insert(9);
        maxHeap.insert(2);
        maxHeap.insert(6);

    }


}