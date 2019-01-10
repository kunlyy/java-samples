package crk.bitoperation;

/**
 * Created by kunlyy on 2017/2/26.
 */
public class BasicOper {

    public void judgeParity() {
        for (int i = 1; i < 100; i++) {
            if ((i & 1) == 0) {
                System.out.println(i + "偶数");
            }
        }
    }

    /**
     * 位运算交换两数
     *
     * @param a
     * @param b
     */
    public static void swap(int a, int b) {
        System.out.println(a + "**" + b);
        if (a != b) {
            a ^= b;
            b ^= a;
            a ^= b;
        }
        System.out.println(a + "**" + b);
    }

    /**
     * 加减法或者乘除法交换两数
     *
     * @param a
     * @param b
     */
    public static void swap2(int a, int b) {
        System.out.println(a + "**" + b);
        if (a != b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        System.out.println(a + "**" + b);
        /*if(a != b){
            a = a * b;
            b = a / b;
            a = a / b;
        }*/
    }

    public static void main(String[] args) {
        BasicOper basicOper = new BasicOper();
        basicOper.judgeParity();

        BasicOper.swap(10, 20);
        BasicOper.swap2(20, 40);

    }
}
