package no.hvl.data108;

import java.util.ArrayList;
import java.util.List;

public class Person {
	   private List<PersonInfo> personer = new ArrayList<>();
	    
	    public void addItem(PersonInfo personen) {
	        personer.add(personen);
	    }
	    
	    public List<PersonInfo> getItems() {
	        return personer;
	    }

}
