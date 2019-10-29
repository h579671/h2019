package no.hvl.dat108;

import java.util.ArrayList;
import java.util.List;

public class Handleliste {
private List<ListeObjekt> items = new ArrayList<>();
    
    public void addItem(String item) {
        items.add(new ListeObjekt(item));
    }
    
    public void deleteItem(String item) {
    	for(int i = 0; i < items.size(); i++) {
    		if(items.get(i).getName().equals(item)) {
    			items.remove(i);
    		}
    	}
    	
    	//items.remove(new ListeObjekt(item));
    }
    
    public List<ListeObjekt> getItems() {
        return items;
    }

}
