import java.time.LocalDate;
import java.util.ArrayList;

public class Wyszukiwanie {
	
	//private static Predicate<Student> p = new Predykaty<Student<>()>;
	 
	
	public static void wyszukaj(FilterIterator<Student> i) {
		
		while(i.hasNext()) {
			
			System.out.println(i.next());
		}
		}

	}
	
	/*public void setPredykat(Predicate<Student> p) {
		this.p=p;
	}*/
	

