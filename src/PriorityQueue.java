import java.util.LinkedList;

public abstract class PriorityQueue<T> {
	protected LinkedList<T> lista = new LinkedList<>();
	protected int j;
	
	public abstract void enqueue(T o);
	
	public abstract T dequeue();
	
	public int size() {
		return lista.size();
	}
	
	public abstract T first();
	public int getNulle() {
		return j;
	}
	public abstract void naKolejke();
	public abstract String getKlasa();
}