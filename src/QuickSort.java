import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] array, int i, int j) {
        //基线条件,数组长度小于2
        if (array == null || array.length < 2) {
            return;
        }
        if (i > j) {
            return;
        }
        int pivot = array[i];//基准值
        int left = i;//左指针
        int right = j;//右指针
        while (left < right) {
            //遍历右边,找到小于基准值的
            while (array[right] >= pivot && left < right) {
                right--;
            }
            //遍历左边,找到大于基准值的
            while (array[left] <= pivot && left < right) {
                left++;
            }
            //交换两值
            if (left < right) {
                swap(array, left, right);
                System.out.println("交换后的数组" + Arrays.toString(array));
            }
        }
        //基准值复位,当前左指针位置变为一开始的基准值,即左右相遇位置
        array[i] = array[left];
        array[left] = pivot;
        System.out.println("基准值归位的数组:" + Arrays.toString(array));
        //将左数组排序
        if (i < left - 1) {
            quickSort(array, i, left - 1);
        }
        //将右数组排序
        if (j > right + 1) {
            quickSort(array, right + 1, j);
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {5, 1, 1, 2, 0, 0};
        QuickSort sort = new QuickSort();
        sort.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
