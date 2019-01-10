package crk.compare;

import java.util.Arrays;

public class TestComparable {  
	  
      
    public void compare() {  
        PersonBean[] p = { new PersonBean(20, "Tom"),  
                new PersonBean(20, "Jeff"),   
                new PersonBean(30, "Mary"),  
                new PersonBean(20, "Ada"),   
                new PersonBean(40, "Walton"),  
                new PersonBean(61, "Peter"),   
                new PersonBean(20, "Bush") };  
        System.out.println("before sort:\n" + Arrays.toString(p));  
        AlphDesc desc = new AlphDesc();  
        Arrays.sort(p,desc);  
        System.out.println("after sort:\n" + Arrays.toString(p));  
    }  
    
    /** 
     * @param args 
     */
    public static void main(String[] args) {  
        TestComparable tc = new TestComparable();  
        tc.compare();  
        int[] a = {1,2,3};
        if(a[0]==2 & a[3]==3){
        	System.out.println(true);
        }
        if(a[0]==2 && a[3]==3){
        	System.out.println(true);
        }
        
    }  
  
}
