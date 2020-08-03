import java.util.Iterator;

public class FilterIterator<T> implements Iterator<T> {

	private Iterator<T> iterator;
	private Predicate<T> pred;
	
	private T elemNext=null;
	private boolean bHasNext=true;
	
	public FilterIterator(Iterator<T> iterator, Predicate<T> pred) {
		
		super();
		this.iterator=iterator;
		this.pred=pred;
		findNextValid();
		
	}
	
	private void findNextValid() {
		
		while(iterator.hasNext()) {
			elemNext=iterator.next();
			if(pred.accept(elemNext)) {
				return;
			}
		}
		bHasNext = false;
		elemNext = null;
	}
	
	@Override
	public boolean hasNext() {
		return bHasNext;
	}

	@Override
	public T next() {
		T nextValue = elemNext;
		findNextValid();
		return nextValue;
	}

}
