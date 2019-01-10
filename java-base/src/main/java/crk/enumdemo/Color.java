package crk.enumdemo;

/**
 * 可以在枚举属性后面添加()来调用指定参数的构造方法，添加{}来实现其对应的匿名内部类
 * @author  kun
 *
 */
public enum Color {
	RED(1) {
		public Color nextColor() {
			return RED;
		}
	},

	GREEN(2) {
		public Color nextColor() {
			return GREEN;
		}
	};

	public abstract Color nextColor();

	private int index;

	Color(int index) {
		this.index = index;
		System.out.println(index);
	}

	public static void main(String[] args) {
		System.out.println(Color.RED);
	}

}
