import java.util.LinkedList;

public class Fifo<T> implements IQueue<T>{
	
	private T[] tab;
	private int head=0, tail=0, queueSize=0;
	private LinkedList<T> lista;
	int j=0;
	
	public Fifo(){
		this(16);
	}
	
	@SuppressWarnings("unchecked")
	public Fifo(int size){
		tab=(T[])new Object[size+1];
		lista=new LinkedList<>();
		queueSize=size;
	}

	@Override
	public void enqueue(T o) throws FullQueueException {
		if(isFull()) throw new FullQueueException();
		else
		{
			tab[tail]=o;
			tail++;
		}
		
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		if(isEmpty()) throw new EmptyQueueException();
		else {
			T arg=tab[head];
			for(int i=0; i<tail; i++) {
				tab[i]=tab[i+1];		
			}
			tail--;
		return arg;
		}
	}

	@Override
	public boolean isEmpty() {
		if(head==tail) {
			return true;
		}else
			return false;
	}

	@Override
	public boolean isFull() {
		if(tab.length==(tail-1)) {
			return true;
		}else
			return false;
	}

	@Override
	public int size() {
		return tail;
	}

	@Override
	public T first() throws FullQueueException {
		return tab[head];
	}

	@Override
	public void addWithPriority(T o) {
		//System.out.println(lista.size());
		
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
	
	public void naKolejke() {
		for(int i=0; i<lista.size(); i++) {
			try {
				enqueue(lista.get(i));
			} catch (FullQueueException e) {
				e.printStackTrace();
			}
		}
		for(int i=lista.size(); i<lista.size()+j; i++) {
			try {
				enqueue(null);
			} catch (FullQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		lista=new LinkedList<>();
	}

	@Override
	public String getKlasa() {
		
		return "Fifo<Student>";
	}

	@Override
	public int getNulle() {
		// TODO Auto-generated method stub
		return j;
	}
	

}
