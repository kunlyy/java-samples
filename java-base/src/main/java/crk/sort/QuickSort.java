package crk.sort;

/**
 * 挖坑法快速排序。
 * 参考：http://ju.outofmemory.cn/entry/372908
 *
 * @author kunlyy
 */
public class QuickSort {

	public static int[] quickSort(int[] arr, int l, int r) {
		if (arr != null && arr.length <= 0) {
			return null;
		}
		if (l < r) {
			// arrwap(arr[l], arr[(l + r) / 2]); //如果要使用中间数作为基准数，将中间的这个数和第一个数交换
			int i = l, j = r, temp = arr[l];
			while (i < j) {
				while (i < j && arr[j] >= temp) {
					// 从右向左找第一个小于x的数
					j--;
				}
				if (i < j) {
					arr[i++] = arr[j];
				}
				while (i < j && arr[i] < temp) {
					// 从左向右找第一个大于等于x的数
					i++;
				}
				if (i < j) {
					arr[j--] = arr[i];
				}
			}
			arr[i] = temp;
			// 递归调用
			quickSort(arr, l, i - 1);
			quickSort(arr, i + 1, r);
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = {10, 200, 15212, -11, 80, 25, 23, 17, 5};

		int[] newArr = QuickSort.quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + ",");
		}
	}

}
