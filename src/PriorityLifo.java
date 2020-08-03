
public class PriorityLifo<T> extends PriorityQueue{

	@Override
	public void enqueue(Object o) {
		Student s = (Student)o;
		if(o==null) {
			j++;
		}else {
		if(lista.size()==0) {
			lista.add(o);
		}else{
			for(int i=0; i<lista.size(); i++) {
				//System.out.println("Srednia studenta wchodzacego:" + s.getSrednia());
				Student s1=(Student)lista.get(i);
				//System.out.println("Srednia studenta porownywanego:" + s1.getSrednia());
				if(s.getSrednia()<=s1.getSrednia()) {
					lista.add(i, o);
					break;
				}
				if(i==lista.size()-1 && s.getSrednia()>s1.getSrednia()) {
					lista.add(o);
				}
			}
		}
	}
		
	}

	@Override
	public Object dequeue() {
		T object = (T)lista.getLast();
		lista.remove(lista.size()-1);
		return object;
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		return lista.getLast();
	}

	@Override
	public void naKolejke() {
		for(int i=0; i<lista.size(); i++) {
			enqueue(lista.get(i));
	}
	for(int i=lista.size(); i<lista.size()+j; i++) {
		
			enqueue(null);

	}
	lista.remove(lista.size()-1);
	}

	@Override
	public String getKlasa() {
		// TODO Auto-generated method stub
		return "PriorityLifo";
	}

}
