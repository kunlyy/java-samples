package crk.sort;

/**
 * 快速排序实现。
 * 参考：https://blog.csdn.net/adusts/article/details/80882649
 *
 * Created by chenrongkun on 2019/5/17.
 */
public class MyQuickSort {

	public static int[] quickSort(int [] array, int left, int right) {
		if (left >= right){
			return array;
		}
		//以最左元素作为基准
		int i = left, j = right, temp = array[left];
		while (i < j) {
			//找到比基准小的元素
			while (i < j && array[j] >= temp) {
				j --;
			}
			//找到比基准大的元素
			while (i < j && array[i] <= temp) {
				i ++;
			}
			//交换大小元素
			if (i < j) {
				array[j] = array[i] + array[j];
				array[i] = array[j] - array[i];
				array[j] = array[j] - array[i];
			}
		}
		//交换基准的位置
		array[left] = array[i];
		array[i] = temp;
		//递归排序左边的子数组
		quickSort(array, left, i - 1);
		//递归排序右边的子数组
		quickSort(array, i + 1, right);
		return array;
	}

	public static void main(String[] args) {
		int[] arr = {10, 200, 15212, -11, 80, 25, 23, 17, 5};

		int[] newArr = MyQuickSort.quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + ",");
		}
	}
}
