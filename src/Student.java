import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable{
	
	private String nazwisko;
	private String imie;
	private LocalDate data = null;
	private int nr_albumu;
	private int rok_studiow;
	private double srednia;
	
	
	public Student() {
		nazwisko = "Kowalski";
		imie="Jan";
		data = LocalDate.of(2000, 1, 1);
		nr_albumu=1234;
		rok_studiow=1;
		srednia=4;
	}
	
	public Student(String nazwisko, String imie, LocalDate d, int nr_albumu, int rok_studiow, double srednia) {
		super();
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.data = d;
		this.nr_albumu = nr_albumu;
		this.rok_studiow = rok_studiow;
		this.srednia = srednia;
	}
	
	public Student(String nazwisko, String imie, int year, int month, int day, int nr_albumu, int rok_studiow, double srednia) {
		super();
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.data = LocalDate.of(year, month, day);
		this.nr_albumu = nr_albumu;
		this.rok_studiow = rok_studiow;
		this.srednia = srednia;
	}


	public String getNazwisko() {
		return nazwisko;
	}


	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}


	public String getImie() {
		return imie;
	}


	public void setImie(String imie) {
		this.imie = imie;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(int year, int month, int day) {
		this.data = LocalDate.of(year, month, day);
	}


	public int getNr_albumu() {
		return nr_albumu;
	}


	public void setNr_albumu(int nr_albumu) {
		this.nr_albumu = nr_albumu;
	}


	public int getRok_studiow() {
		return rok_studiow;
	}


	public void setRok_studiow(int rok_studiow) {
		this.rok_studiow = rok_studiow;
	}


	public double getSrednia() {
		return srednia;
	}


	public void setSrednia(double srednia) {
		this.srednia = srednia;
	}


	@Override
	public String toString() {
		Double i = new Double(srednia);
		return nazwisko + ";" + imie + ";" + data + ";" + nr_albumu
				+ ";" + rok_studiow + ";" + i.toString() ;
	}
	
	
	

}
