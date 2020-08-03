import java.util.Scanner;

public class Predykaty<T> implements Predicate<T>{

	private int r;
	
	public Predykaty(){		
		Scanner s = new Scanner(System.in);
		r=s.nextInt();
	}

		@Override
		public boolean accept(T arg) {
			Student s = (Student)arg;
			if(s.getRok_studiow()==r) {
				return true;
			}else
				return false;
		
		}
}
