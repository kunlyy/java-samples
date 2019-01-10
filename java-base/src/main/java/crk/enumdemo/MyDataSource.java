package crk.enumdemo;
/**
 * 实现单例的核心在于private私有化类中的构造方法，在枚举中的构造方法必须是私有的，
 * 这就为枚举来实现单例奠定了基础。下面以数据源中获得Connection连接来举例：
 *
 *  在开发中经常是通过数据源来获得数据库的Connection,数据源的实现方式有多种，
 *  最典型的有两种，一种是C3P0,另外一种是DBCP（以后有机会再针对两种数据源进行讨论）
 *  ，这里以C3P0数据源为例。由于数据源的创建与销毁都是十分消耗性能的，
 *  并且系统中有一个数据源一般就能满足开发的要求，因此要将数据源设计为单例。
 *
 * @author  kun
 *
 */
public enum MyDataSource {
	SINGLETON;

	private MyConnection conn = new MyConnection();

	MyDataSource(){

	}

	public MyConnection getInstance(){
		return conn;
	}

	public static void main(String[] args) {
		MyConnection conn1 = MyDataSource.SINGLETON.getInstance();
		MyConnection conn2 = MyDataSource.SINGLETON.getInstance();
		MyConnection conn3 = MyDataSource.SINGLETON.getInstance();
		System.out.println(conn1);
		System.out.println(conn2);
		System.out.println(conn3);
	}
}


class MyConnection{
	public MyConnection(){
		System.out.println("MyConnection");
	}
}

