package crk.compare;

import java.util.Comparator;

public class AlphDesc implements Comparator<PersonBean> {

	@Override
	public int compare(PersonBean personA, PersonBean personB) {
		int cop = personA.age - personB.age;  
        if (cop != 0)  
            return cop;  
        else  
            return personB.getName().compareTo(personA.getName());  
	}  
	  
}  
