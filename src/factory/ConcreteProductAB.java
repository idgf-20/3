package factory;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductAB extends Product {

	private BufferedReader ein;
	
	
	public ConcreteProductAB() throws IOException {
		super();
		this.ein= new BufferedReader(new FileReader("VolkshochschulekursAusgabe.txt"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String[]ergebniszeile= new String[5];
		String zeile= ein.readLine();
		int i=0;
		
		while(i<ergebniszeile.length) {
			ergebniszeile[i]=zeile;
			zeile=ein.readLine();
			i++;
			
		
	}
		return ergebniszeile;
	}

	@Override
	public void schliessDatei() throws IOException {
		ein.close();
		
	}
	

}
