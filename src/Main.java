import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		
		Projekt p = new Projekt();
		p.stworzListe();
		p.dodaj(0,new Student());
		p.dodaj(1,new Student());
		p.dodaj(1, new Student("Nowak", "Adam", LocalDate.of(1999, 3, 12), 3241, 2, 4.5));
		p.dodaj(2, new Student("Kopiñski", "Maciej", LocalDate.of(2000, 11, 2), 3241, 1, 4.5));
		p.dodaj(7, new Student());
		p.zapiszCsv();
		p.wczytajCsv();
		p.menu();
		//p.wyswietl();
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine());
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
