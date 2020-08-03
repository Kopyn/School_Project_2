import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.nio.file.*;
import java.time.LocalDate;

public class Projekt {

	private ArrayList<Student> studenci;
	private static int size;
	ArrayList<IQueue<Student>> kolejki=new ArrayList<>();
	ArrayList<PriorityQueue<Student>> kolejkiPriorytetowe=new ArrayList<>();
	
	public Projekt() {
		size=0;
	}
	public void naKolejke() { 
		
	}
	public void stworzListe() {
		studenci = new ArrayList<>();
	}
	public void stworzKolejki() {
		System.out.println("Ile kolejek chcesz stworzyæ?");
		Scanner input = new Scanner(System.in);
		int z=input.nextInt();
		int s;
		for(int i=0; i<z; i++) {
			System.out.println("[1]-FIFO\n[2]-LIFO\n\n[3]-Fifo priorytetowa wedlug sredniej\n[4]-Lifo priorytetowa wedlug sredniej\n[0]-Wyjdz");
			s=input.nextInt();
			if(s==1) {
				kolejki.add(new Fifo<>());
			}
			if(s==2) {
				kolejki.add(new Lifo<>());
			}
			if(s==3) {
				kolejkiPriorytetowe.add(new PriorityFifo<>());
			}
			if(s==4) {
				kolejkiPriorytetowe.add(new PriorityLifo<>());
			}
		}
		//System.out.println(kolejki.size());
		this.menu();
	}
	public void wyswietlKolejki() {
		Scanner input = new Scanner(System.in);
		System.out.println("Wybierz kolejke:");
		for(int i=0; i<kolejki.size(); i++) {
			System.out.println("[" + (i+1) + "]-"+kolejki.get(i).getKlasa() + ". Rozmiar="+kolejki.get(i).size());
		}
		int z=input.nextInt()-1;
		this.oproznijKolejke(z);
	}
	public void wyswietlKolejkiPriorytetowe() {
		Scanner input = new Scanner(System.in);
		System.out.println("Wybierz kolejke:");
		for(int i=0; i<kolejkiPriorytetowe.size(); i++) {
			System.out.println("[" + (i+1) + "]-"+kolejkiPriorytetowe.get(i).getKlasa() + ". Rozmiar="+kolejkiPriorytetowe.get(i).size());
		}
		int z=input.nextInt()-1;
		this.oproznijKolejkePriorytetowa(z);
	}
	public void oproznijKolejkePriorytetowa(int i) {
		while(kolejkiPriorytetowe.get(i).size()!=0) {
				System.out.println(kolejkiPriorytetowe.get(i).dequeue());
	}
		this.menu();
	}
	
	public void oproznijKolejke(int i) {
		while(kolejki.get(i).size()!=0) {
			try {
				System.out.println(kolejki.get(i).dequeue());
			}catch(EmptyQueueException e) {
				e.printStackTrace();
			}
	}
		this.menu();
	}
	public void dodajWgPriorytetuMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("[1]-Dodaj wszystkich studentów.\n[2]-Dodaj jednego studenta.");
		int q=input.nextInt();
		switch(q) {
		case 1:
			System.out.println("Wybierz kolejke:");
			for(int i=0; i<kolejkiPriorytetowe.size(); i++) {
				System.out.println("[" + (i+1) + "]-"+kolejkiPriorytetowe.get(i).getKlasa());
				
			}
			int kolejka=(input.nextInt()-1);
			for(int i=0; i<studenci.size(); i++) {
					
						kolejkiPriorytetowe.get(kolejka).enqueue(studenci.get(i));

				
			}
			this.menu();
			break;
		case 2:{
		System.out.println("Wybierz studenta z listy.");
		this.wyswietlWszystkich();	
		int nrStudenta=(input.nextInt()-1);
		System.out.println("Wybierz kolejke:");
		for(int i=0; i<kolejkiPriorytetowe.size(); i++) {
			System.out.println("[" + (i+1) + "]-"+kolejkiPriorytetowe.get(i).getKlasa());
		}
		int kolejka1=(input.nextInt()-1);
		
			kolejkiPriorytetowe.get(kolejka1).enqueue(studenci.get(nrStudenta));
			System.out.println("Dodano studenta!");
			this.menu();
		}
			//this.menu();
		}
	}
			
	
	
	public void dodajStudentaKolejkaMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("[1]-Dodaj wszystkich studentów.\n[2]-Dodaj jednego studenta.");
		int q=input.nextInt();
		switch(q) {
		case 1:
			System.out.println("Wybierz kolejke:");
			for(int i=0; i<kolejki.size(); i++) {
				System.out.println("[" + (i+1) + "]-"+kolejki.get(i).getKlasa());
				;
			}
			int kolejka=(input.nextInt()-1);
			for(int i=0; i<studenci.size(); i++) {
					try {
						kolejki.get(kolejka).enqueue(studenci.get(i));
					}catch(FullQueueException e) {
						e.printStackTrace();
					}
				
			}
			this.menu();
			break;
		case 2:{
		System.out.println("Wybierz studenta z listy.");
		this.wyswietlWszystkich();	
		int nrStudenta=(input.nextInt()-1);
		System.out.println("Wybierz kolejke:");
		for(int i=0; i<kolejki.size(); i++) {
			System.out.println("[" + (i+1) + "]-"+kolejki.get(i).getKlasa());
		}
		int kolejka1=(input.nextInt()-1);
		try {
			kolejki.get(kolejka1).enqueue(studenci.get(nrStudenta));
			System.out.println("Dodano studenta!");
		} catch (FullQueueException e) {
			e.printStackTrace();
		}
		}
			this.menu();
		}
	}
	public void menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("MENU\n[0]-Zakoncz program.\n[1]-Wyswietl liste studentow.\n[2]-Stworz liste kolejek.\n[3]-Dodaj studenta do kolejki zwyklej.\n[4]-Dodaj studentów do kolejki priorytetowej.\n[5]-Wyswietl i oproznij kolejke zwykla.\n[6]-Wyswietl i oproznij kolejke priorytetowa.");
		int z=input.nextInt();
		switch(z) {
		case 0:
			return;
		case 1:
			this.wyswietl();
			break;
		case 2:
			this.stworzKolejki();
			break;
		case 3:
			if(kolejki.size()==0) {
				System.out.println("Brak kolejek!");
				this.menu();
			}else
			this.dodajStudentaKolejkaMenu();
			break;
		case 4:
			if(kolejkiPriorytetowe.size()==0) {
				System.out.println("Brak kolejek!");
				this.menu();
			}else
			this.dodajWgPriorytetuMenu();
			break;
		case 5:
			this.wyswietlKolejki();
			break;
		case 6:
			this.wyswietlKolejkiPriorytetowe();
			default:
				return;
		}
	}
	
	public void dodaj(int index, Student s) {
		if(index<studenci.size() && index>=0) {
			studenci.add(index, s);
		}else if(index==studenci.size()){
			studenci.add(s);
		}else if(index>studenci.size()){
			for(int i=studenci.size(); i<(index-1); i++) {
				studenci.add(null);
			}
			studenci.add(s);
		}
		size=studenci.size();
	}
	
	public int getSize() {
		return size;
	}
	
	public void wczytajCsv() {
		
		if(studenci.size()!=0) {
			for(int i=(studenci.size()-1); i>=0; i--) {
				studenci.remove(i);
			}
		}
		String[] obiekty = null;
		Path sciezka = Paths.get("Studenci.csv");
		ArrayList<String> odczyt = new ArrayList<>();
		
        try {
        	
            odczyt = (ArrayList) Files.readAllLines(sciezka);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        String linia = odczyt.toString();        
        linia=linia.replace("[", "");
        linia=linia.replace("]", "");
        linia=linia.replace(" ", "");
        obiekty=linia.split(",");
		for(int i=0; i<obiekty.length; i++) {
			if(obiekty[i].length()==9){
				studenci.add(null);
				
			}else {
			 String nazwisko = (String)obiekty[i].split(";")[0];
			 String imie= (String)obiekty[i].split(";")[1];
			 int [] dat = new int[3];
			 String date = obiekty[i].split(";")[2];
			 for(int j = 0; j<3; j++) {
				 dat[j]=Integer.parseInt(date.split("-")[j]);
			 }
			 LocalDate data = LocalDate.of(dat[0], dat[1], dat[2]);
			 int nr_albumu=Integer.parseInt(obiekty[i].split(";")[3]);
			 int rok_studiow=Integer.parseInt(obiekty[i].split(";")[4]);
			 double srednia=Double.parseDouble(obiekty[i].split(";")[5]);
			 studenci.add(new Student(nazwisko, imie, data, nr_albumu, rok_studiow, srednia));
			 
		}
		}
	}
	
	public void zapiszCsv() {
		Path sciezka = Paths.get("Studenci.csv");
		ArrayList<String> out = new ArrayList<>();
		for(int i = 0; i<studenci.size(); i++) {
			if(studenci.get(i)!=null) {
			out.add(studenci.get(i).toString());
			}
			else
				out.add("puste pole");
		}
		try {
		for(int i=0; i<out.size(); i++) {
			Files.write(sciezka, out);
		}
		}catch(IOException e) {
			e.printStackTrace();
		}
		for(int i=(studenci.size()-1); i>=0; i--) {
			studenci.remove(i);
		}
	}
	
	public void usun(int i) {
		studenci.remove(i-1);
	}
	
	public void edytuj(int i, Student s) {
		studenci.set(i, s);
	}
	
	public void wyswietlWszystkich() {		for(int i=0; i<size; i++) {
		if(studenci.get(i)==null) {
			System.out.println((i+1) + ". puste pole");
		}else
			System.out.println((i+1) + ". " + studenci.get(i));
	}
	}
	
	public void wyswietl() {
		System.out.println("Lista studentow:");
		for(int i=0; i<size; i++) {
			if(studenci.get(i)==null) {
				System.out.println((i+1) + ". puste pole");
			}else
				System.out.println((i+1) + ". " + studenci.get(i));
		}
		this.menu();
	}
	public ArrayList<Student> getStudenci(){
		return studenci;
	}
	

}
