package crk.sort;
/**
 * 基本思想：在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排
 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
 也是排好顺序的。如此反复循环，直到全部排好顺序。
 * @author  kun
 *
 */
public class InsertSort {

	public static int[] insertSort(int[] arr){
		int len = arr.length;
		for(int i=1;i<len;i++){
			int temp = arr[i];
			int j = i-1;
			for(;j>=0&&temp<arr[j];j--){
				arr[j+1] = arr[j];	//把大的数据全部后移
			}
			arr[j+1] = temp;	//此时的arr[j+1]相当于arr[0].相当于把最小值temp的赋值给arr[0].
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = {10,200,15212,-11,80,25,23,17,5};

		int[] newArr = InsertSort.insertSort(arr);
		for(int i=0;i<newArr.length;i++){
			System.out.print(newArr[i]+",");
		}
	}
}
