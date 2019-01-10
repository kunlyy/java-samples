package crk.enumdemo;

/**
 * 使用抽象类和静态方法模拟枚举
 * @author  kun
 *
 */
public abstract class WeekDay {

	public static final WeekDay Monday = new WeekDay() {
		@Override
		public WeekDay nextDay() {
			return SunDay;
		}
	};

	public static final WeekDay SunDay = new WeekDay() {
		@Override
		public WeekDay nextDay() {
			return Monday;
		}
	};

	@Override
	public String toString() {
		return this == SunDay ? "SUN星期天" : "MON星期一";
	}

	public abstract WeekDay nextDay();


	public static void main(String[] args) {
		System.out.println(WeekDay.Monday.nextDay());
		System.out.println(WeekDay.SunDay.nextDay());
	}
}
