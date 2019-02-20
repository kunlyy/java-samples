package crk.sort;

/**
 * 通过设置flag优化冒泡排序
 * Created by kunlyy on 2017/2/6.
 */
public class BubbleSort {

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
			System.out.print(i + "-->");
			for (int m = 0; m < arr.length; m++) {
				System.out.print(arr[m] + ",");
			}
			System.out.println("\n");
		}
		return arr;
	}

	public static int[] bubbleSort2(int[] arr) {
		int n = arr.length;
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 1; i < n; i++) {
				if (arr[i - 1] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
					flag = true;
				}
			}
			System.out.print(n + "-->");
			for (int m = 0; m < arr.length; m++) {
				System.out.print(arr[m] + ",");
			}
			System.out.println("\n");
			n--;
		}
		return arr;
	}

	public static int[] bubbleSort3(int[] arr) {
		boolean flag = true;
		int n = arr.length;

		for (int i = 0; i < arr.length; i++) {
			flag = false;
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					flag = true;
				}
			}
			System.out.print(i + "-->");
			for (int m = 0; m < arr.length; m++) {
				System.out.print(arr[m] + ",");
			}
			System.out.println();
			if (!flag) {
				break;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
//		int[] arr = {10, 200, 15212, -11, 80, 25, 23, 17, 5};
		int[] arr = {8,1,2,4};

//        int[] newArr = BubbleSort.bubbleSort1(arr);
//		int[] newArr = BubbleSort.bubbleSort2(arr);
		int[] newArr = BubbleSort.bubbleSort3(arr);
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + ",");
		}
	}
}
