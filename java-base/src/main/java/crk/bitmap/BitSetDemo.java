package crk.bitmap;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 可以利用BitSet去重、查找是否存在等操作
 * Created by chenrongkun on 2019/1/23.
 */
public class BitSetDemo {

	public static void main(String[] args) {
//		List<Integer> list = new ArrayList<>(100);
//		BitSet bitSet = new BitSet();
//		Stream.generate(Math::random).limit(100).forEach(e -> list.add((int) (e * 1000)));
//		// BitSet set()的过程本来就是一个去重的过程
//		list.forEach(e -> bitSet.set(e));
//		System.out.println("list:" + list.toString());
//		// get()操作可以对某个数值进行是否存在的操作
//		IntStream.range(0, 100).forEach(i -> System.out.print(bitSet.get(i) + "*"));
//
//		System.out.println();
//		System.out.println((619 >> 6) + "*" + bitSet.size() + "*" + (1L << 619));

		BitSet bitSet1 = new BitSet();

		bitSet1.set(500);
		bitSet1.set(510);
		bitSet1.set(530);
		bitSet1.set(500);
		System.out.println(bitSet1.size());
		System.out.println(bitSet1.length());

	}

}
