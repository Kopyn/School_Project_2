import java.time.LocalDate;
import java.util.Scanner;

public class poDacie<T> implements Predicate<T> {

	private LocalDate data;
	
	public poDacie() {
		Scanner s = new Scanner(System.in);
		int rok=s.nextInt();
		int miesiac=s.nextInt();
		int dzien=s.nextInt();
		this.data=LocalDate.of(rok, miesiac, dzien);
	}

			@Override
	public boolean accept(T arg) {
		if(arg!=null) {
		Student s = (Student)arg;
		if(s.getData().equals(data)) {
			
			return true;
		}
		else 
			return false;		
		}else
			return false;
}
}	
