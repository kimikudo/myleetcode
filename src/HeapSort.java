import java.util.Arrays;

public class HeapSort {
    public void heapSort(int[] array){
        //创建堆,从第一个非叶子节点开始,即(length-1)/2
        for(int i=(array.length-1)/2;i>=0;i--){
            adjustHeap(array,i,array.length);
        }
        for(int i=array.length-1;i>0;i--){
            //将堆顶 元素与末尾元素交换
            int temp=array[i];
            array[i]=array[0];
            array[0]=temp;
            //继续调整新的二叉树
            adjustHeap(array,0,i);
        }
    }
    //调整二叉树
    public void adjustHeap(int[] array, int parent, int length) {
        //父节点
        int parentNode = array[parent];
        //左孩子
        int lChild = 2 * parent + 1;
        //以下目的是,查找父节点的两个子节点是否大于父节点,
        //如果大于,则将较大的与父节点交换
        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            //如果右孩子存在,且大于左孩子,则交换右孩子,否则交换做孩子
            if (rChild < length && array[rChild] > array[lChild]) {
                lChild++;
            }
            //如果父节点大于孩子节点,则跳出此次循环
            if (parentNode > array[lChild]) {
                break;
            } else {
                //否则,交换父子节点
                array[parent] = array[lChild];
                array[lChild] = parentNode;
                //将父节点指向子节点,继续向下检索
                parent = lChild;
                lChild = 2 * lChild + 1;
            }
        }
    }
    public static void main(String[] args){
        int[] array={5,19,8,27,9,6,12,1,7};
        System.out.println("初始数组:" + Arrays.toString(array));
        HeapSort heapSort=new HeapSort();
        heapSort.heapSort(array);
        System.out.println("排序:" + Arrays.toString(array));
    }
}
