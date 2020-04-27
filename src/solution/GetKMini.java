package solution;

import java.util.Arrays;

public class GetKMini {
    public int[] smallestK(int[] arr, int k) {
        heapSort(arr,k);
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=arr[arr.length-1-i];
        }
        return result;

    }
    public void heapSort(int[] array,int k){
        for(int i=array.length/2-1;i>=0;i--){
            adjustHeap(array,i,array.length);
        }
        for(int i=0;i<k;i++){
            int temp=array[array.length-i-1];
            array[array.length-i-1]=array[0];
            array[0]=temp;

            adjustHeap(array,0,array.length-1-i);
        }

    }
    public void adjustHeap(int[] array,int parent,int length){
        int parentNode=array[parent];
        int lChild=parent*2+1;
        while(lChild<length){
            int rChild=lChild+1;
            if(rChild<length&&array[rChild]<array[lChild]){
                lChild++;
            }
            if(parentNode<array[lChild]){
                break;
            }else{
                array[parent]=array[lChild];
                array[lChild]=parentNode;

                parent=lChild;
                lChild=2*lChild+1;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 2, 4, 6, 8,};
        System.out.println("初始数组:" + Arrays.toString(array));
        GetKMini getKMini = new GetKMini();
        int[] result = getKMini.smallestK(array, 4);
        System.out.println("结果数组:" + Arrays.toString(result));
    }
}
