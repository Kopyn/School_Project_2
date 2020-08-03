
public class PriorityFifo<T> extends PriorityQueue<T>{

	public PriorityFifo() {
		j=0;
	}
	@Override
	public void enqueue(T o) {
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
				if(s.getSrednia()>=s1.getSrednia()) {
					lista.add(i, o);
					break;
				}
				if(i==lista.size()-1 && s.getSrednia()<s1.getSrednia()) {
					lista.add(o);
				}
			}
		}
	}
		
	}
	

	@Override
	public T dequeue() {
		T object = (T)lista.getFirst();
		lista.remove(0);
		return object;
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		return lista.getFirst();
	}


	@Override
	public void naKolejke() {
		for(int i=0; i<lista.size(); i++) {
				enqueue(lista.get(i));
		}
		for(int i=lista.size(); i<lista.size()+j; i++) {
			
				enqueue(null);

		}
		
	}


	@Override
	public String getKlasa() {
		// TODO Auto-generated method stub
		return "PriorityFifo";
	}

}
