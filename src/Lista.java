
public class Lista<T>{
	private Node head = new Node(null);
	private int size;

	public Lista(){
		clear();
	}
	public void clear(){
		head.setNext(null);
		size=0;
	}
	
	public void add(T value){
		if (head.getNext()==null) head.setNext(new Node(value)); 
		Node last = head.getNext();
		while(last.getNext() != null) 
			last=last.getNext();
		++size;
		last.setNext(new Node(value)); 
	}
	
	public boolean delete(Student o){
		if(head.getNext() == null) return false;
		if(head.getNext().getValue().equals(o)){
			head.setNext(head.getNext().getNext());
			size--;
			return true;
		}

		Node delete = head.getNext();
		while(delete != null && delete.getNext() != null){
			if(delete.getNext().getValue().equals(o)){
				delete.setNext(delete.getNext().getNext());
                                size--;
				return true;
			}
			delete = delete.getNext();
		}
		return false;
	}

	public Object get(int index) throws IndexOutOfBoundsException{
		if(index<0 || index>size) throw new IndexOutOfBoundsException();
		Node find = head.getNext();
		for(int i=0; i <= index; i++)
			find = find.getNext();
		return find.getValue();
	}
	public Student set(int index, Student value) throws IndexOutOfBoundsException{
		if(index<0 || index>size) throw new IndexOutOfBoundsException();
		Node find = head.getNext();
		for(int i=0; i <= index; i++)
			find = find.getNext();
		find.setValue(value);
		return value;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}


	private static final class Node<T>{
		private T value;
		private Node next; 

		public Node(T val){
			this(val, null);
		}

		 
		public Node(T val, Node n){
			value = val;
			next = n;
		}

		public T getValue(){
			return value;
		}

		public Node getNext(){
			return next;
		}

		public void setNext(Node n){
			next = n;
		}

		public void setValue(T o){
			value = o;
		}
	}
}