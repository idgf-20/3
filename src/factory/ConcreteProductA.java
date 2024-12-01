package factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class ConcreteProductA extends Product {
	
	private BufferedReader ein;
	

	public ConcreteProductA()throws IOException {
		super();
		this.ein= new BufferedReader(new FileReader("VolkshochschulekursAusgabe.csv"));
	
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		
		String[]ergebniszeile= new String[5];
		String zeile= ein.readLine();
		int i=0;
		
		while(i<ergebniszeile.length) {
			ergebniszeile[i]=zeile;
			i++;
			
		}
		String[]array= ergebniszeile[0].split(";");
		
		
		return ergebniszeile[0].split(";");
	}

	@Override
	public void schliessDatei() throws IOException {
		ein.close();
		
		
	}

}
