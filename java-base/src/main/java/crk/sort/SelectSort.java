package crk.sort;

/**
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 *
 * @author kun
 */
public class SelectSort {

    /**
     * 此方式有点像冒泡排序
     *
     * @param arr
     * @return
     */
    public static int[] selectSort1(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectSort2(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return null;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

    public static int[] selectSort3(int[] arr) {
        int position = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            position = i;
            int temp = arr[i];
            for (; j < len; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    position = j;
                }
            }
            arr[position] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {10, 200, 15212, -11, 80, 25, 23, 17, 5};

        int[] newArr = SelectSort.selectSort2(arr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + ",");
        }
    }
}
