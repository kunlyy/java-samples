package crk.sort;

/**
 * Created by kunlyy on 2017/2/6.
 */
public class BubbleSort2 {

    public static int[] bubbleSort1(int[] arr) {
        int n = arr.length;
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 1; j < n - i; j++) {
                if (arr[j - 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            System.out.print(i+"-->");
            for (int m = 0; m < arr.length; m++) {
                System.out.print(arr[m] + ",");
            }
            System.out.println("\n");
        }
        return arr;
    }

    public static int[] bubbleSort2(int[] arr) {
        int n = arr.length;
        int i, j;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (i=1;i<n;i++) {
                if(arr[i-1] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    flag = true;
                }
                System.out.print(n + "-->");
                for (int m = 0; m < arr.length; m++) {
                    System.out.print(arr[m] + ",");
                }
                System.out.println("\n");
            }
            n--;

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {10, 200, 15212, -11, 80, 25, 23, 17, 5};

//        int[] newArr = BubbleSort2.bubbleSort1(arr);
        int[] newArr = BubbleSort2.bubbleSort2(arr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + ",");
        }
    }
}
