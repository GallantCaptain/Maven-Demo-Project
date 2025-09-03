package extra;

import java.util.List;
import java.util.ArrayList;

public class ExplanationList {
    public static void main(String[] args) {
    	//We need to perform upcasting till list from ArrayList
    	List<String> students = new ArrayList<>();
    	
    	students.add("Avinash");
    	students.add("Baburao");
    	students.add("Cicada");
    	students.add("Dubey");
    	students.add("Einstein");
    	students.add("Frankie");
    	students.add("George");
    	
    	students.remove(6);
    	
    	//size() method will return the size of the list
    	for(int i=0; i < students.size(); i++) {
    		//get(index) method -> Proof that list allows ordered elements 
    		System.out.println(students.get(i));
    	}
    }
}
