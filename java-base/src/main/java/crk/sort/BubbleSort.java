package crk.sort;

/**
 * ??????????????,???????????????????,
 * ???????,?????????????????,
 * ???????????????,??????????,???????
 * <p>
 * ?????????????????????
 *
 * @author kun
 */
public class BubbleSort {

    /**
     * ????????i?j???????????????j??????????????
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort1(int[] arr) {
        int len = arr.length;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * ?????????????
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort2(int[] arr) {
        int len = arr.length;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * ???????????????????????
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort3(int[] arr) {
        int len = arr.length;
        int temp = 0;
        for (int i = len - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {10, 200, 15212, -11, 80, 25, 23, 17, 5};

        int[] newArr = BubbleSort.bubbleSort1(arr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + ",");
        }
    }

}
