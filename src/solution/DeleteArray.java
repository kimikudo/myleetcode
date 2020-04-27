package solution;

public class DeleteArray {
    public int deleteArrayEvery2Step(int length) {
        //参数为数组长度
        if (length <= 0) {
            return -1;
        }
        //首先初始化数组中的值,初始化为1,删除之后将其置为-1
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = 1;
        }
        int currentSize = length;//当前数组长度
        int step = 2;//删除步长
        int count = 0;//步长计数
        int lastDelIndex = 0;//最后删除的下标
        int index = 0;
        while (currentSize != 0) {
            //循环遍历数组
            if (array[index] != -1) {
                //如果当前位未删除,且循环删除步长与指定步长相等,
                //则删除当前元素并记录下标
                if (count++ == step) {
                    array[index] = -1;
                    lastDelIndex = index;
                    currentSize--;
                    count = 0;
                    System.out.println("删除下标:" + index);
                }
            }
            index = (index + 1) % length;//下标取余实现循环遍历
        }
        return lastDelIndex;
    }

    public static void main(String[] args) {
        DeleteArray deleteArray = new DeleteArray();
        deleteArray.deleteArrayEvery2Step(8);
    }
}
