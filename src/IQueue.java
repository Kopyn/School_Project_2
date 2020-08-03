
public interface IQueue<T> {

	
	public void enqueue(T o) throws FullQueueException;
	public T dequeue() throws EmptyQueueException;
	public boolean isEmpty();
	public boolean isFull();
	public int size();
	public T first() throws FullQueueException;
	public void addWithPriority(T o);
	public void naKolejke();
	public String getKlasa();
	public int getNulle();
}
//fifo
	/*if(aktywnyProces().getCzasZgloszenia()+aktywnyProces().getCzasWykonania()<i) {
		lista.peek().setCzasOczekiwania(i-lista.peek().getCzasZgloszenia());
	}
	if(lista.peek()!=null) {
	if(lista.peek().czyWykonany()==false) {
		lista.peek().setPozostalyCzas(lista.peek().getPozostalyCzas()-1);
		if(lista.peek().getPozostalyCzas()==0) {
			lista.peek().czasZakonczenia=i;
			lista.peek().setWykonany(true);
		}
	}else {
		s.ilPrzelaczen++;
		s.dodajDoStatystyki(lista.peek());
		lista.poll();
		if(lista.peek()!=null)
		lista.peek().czasRozpoczecia=i;
	}
	
	//System.out.println(i);
	System.out.println(lista.peek());
	//System.out.println(nastProces);
	}

	else return;
}*/

//rot
/*
if(a>=procesy.size()) {
	a=0;
}


b=a+1;//potrzebne do oceny, czy prze³¹czaæ procesy

if(b>=procesy.size()) {
	b=0;
}

if(a!=b)
czasNastZgloszenia=procesy.get(b).getCzasZgloszenia();
System.out.println("czasNastZgloszenia: "+czasNastZgloszenia);

System.out.println(this.aktywnyProces());
	if(procesy.get(a).doKoncaKwantu>0) {//rozpoczynanie pracy na okres przydzielonego czasu
		procesy.get(a).setPozostalyCzas(procesy.get(a).getPozostalyCzas()-1);
		if(procesy.get(a).getPozostalyCzas()==0) {//zmiana pozosta³ego czasu wykonywana jest liniê wy¿ej, wiêc warunek ten istnieje w celu zgodnoœci czasu zakoñczenia
			procesy.get(a).setWykonany(true);
			procesy.get(a).czasZakonczenia=i;
			s.dodajDoStatystyki(procesy.get(a));
			procesy.remove(a);
			return;
		}
		procesy.get(a).doKoncaKwantu--;
		return;
	}
	procesy.get(a).doKoncaKwantu=Rot.kwant;
	if(czasNastZgloszenia>i) {
		a=0;//jesli nie pojawi sie zadne zadanie-idz na poczatek kolejki
		procesy.get(a).setPozostalyCzas(procesy.get(a).getPozostalyCzas()-1);
		if(procesy.get(a).getPozostalyCzas()==0) {
			procesy.get(a).setWykonany(true);
			procesy.get(a).czasZakonczenia=i;
			s.dodajDoStatystyki(procesy.get(a));
			procesy.remove(a);
			return;
		}
		procesy.get(a).doKoncaKwantu=Rot.kwant;
		//return;
	}else {
		s.ilPrzelaczen++;//przelaczenie trwa 1 jednostke czasu i jest doliczane do czasu oczekiwania nastepnego procesu
		
		a++;
		//return;
	}
	*/

