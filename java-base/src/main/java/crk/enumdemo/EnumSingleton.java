package crk.enumdemo;

public enum EnumSingleton {
	INSTANCE {
		@Override
		protected String work() {
			return new String("123");
		}
	};
	
	protected abstract String work();
	
	
	public static void main(String[] args) {
		String work1 = EnumSingleton.INSTANCE.work();
		String work2 = EnumSingleton.INSTANCE.work();
		
		System.out.println(work1 == work2);
		System.out.println(work1.equals(work2));
		
		
		String a = new String("ab");
		String b = new String("ab");
		System.out.println(a == b);
		System.out.println(a.equals(b));
	}
}
