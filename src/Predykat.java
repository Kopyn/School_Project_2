
public class Predykat<T> implements Predicate<T>{

	
	@Override
	public boolean accept(T arg) {
		
		Student s = (Student)arg;
		if(s.getImie().equals("Jan")) {
			return true;
		}else
			return false;
		
	}

}
