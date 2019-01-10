package crk.staticBlock;

public class StaticBlockTest1 {

	//主调方法的非静态代码块
	{
		System.out.println("StaticBlockTest1 not static block");
	}
	//主调方法的静态代码块
	static {
		System.out.println("StaticBlockTest1 static block");
	}

	public StaticBlockTest1(){
		System.out.println("constructor StaticBlockTest1");
	}

	public static void main(String[] args) {
		//Children children = new Children();
		//children.getValue();
	/*	int i = 5;
		do{
			System.out.println(i);
		}while(--i>5);
		System.out.println("finished");

		int j = 5;
		while(j-->=5){
			System.out.println(i);
		}
		System.out.println("finished 2");
		*/
		/**
		 * try后面可以有多个catch块，但是捕获的Exception必须是从小到大的范围来写。否则编译不通过。
		 * 如果进入到某个catch块后，后面的catch块就不会进入了。直接回到finally里面。
		 */
		try{
			int x = 1/0;
		} catch(ArithmeticException e){
			System.out.println("ArithmeticException111");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("Exception111");
			e.printStackTrace();
		} finally{
			System.out.println("finally");
		}

	}

}


class Parent{

	private String name;
	private int age;

	//父类无参构造方法
	public Parent(){
		System.out.println("Parent constructor method");
		{
			System.out.println("Parent constructor method--> not static block");
		}
	}
	//父类的非静态代码块
	{
		System.out.println("Parent not static block");
		name = "zhangsan";
		age = 50;
	}
	//父类静态代码块
	static {
		System.out.println("Parent static block");
	}

	//父类有参构造方法
	public Parent(String name, int age) {
		System.out.println("Parent constructor method");
		this.name = "lishi";
		this.age = 51;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Children extends Parent{
	//子类静态代码块
	static {
		System.out.println("Children static block");
	}

	//子类非静态代码块
	{
		System.out.println("Children not static block");
	}

	//子类无参构造方法
	public Children(){
		System.out.println("Children constructor method");
	}


	public void getValue(){
		//this.setName("lisi");
		//this.setAge(51);
		System.out.println(this.getName() + this.getAge());
	}
}
