package business;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedList;

import factory.ConcreteCreator;
import factory.Creator;
import factory.Product;
import ownUtil.Observable;
import ownUtil.Observer;

public class VolkshochschulekursModel implements Observable  {
	
	LinkedList<Observer> liste = new LinkedList<Observer>();
	
	private static VolkshochschulekursModel instanz=null;
	
	public static VolkshochschulekursModel getInstanz() {
		if(instanz == null) {
			instanz = new VolkshochschulekursModel();
		}
		return instanz;
	}
	
	
	private VolkshochschulekursModel() {

	}




	private Volkshochschulekurs volkshochschulekurs;

	public Volkshochschulekurs getVolkshochschulekurs() {
		return volkshochschulekurs;
	}

	public void setVolkshochschulekurs(Volkshochschulekurs volkshochschulekurs) {
		this.volkshochschulekurs = volkshochschulekurs;
		notifyObservers();
	}
	
	public void schreibeVolkshochschulekurserInCsvDatei() throws Exception {
		
			BufferedWriter aus= new BufferedWriter(new FileWriter("VolkshochschulekursAusgabe.csv"));
			aus.write(volkshochschulekurs.gibVolkshochschulekursZurueck(';'));
			aus.close();
	

}
	
	 public void leseAusDatei(String typ)throws Exception {
		 
		 Creator creator;
		 creator = new ConcreteCreator();
		 Product product= creator.factoryMethod(typ);
		 String []zeile = product.leseAusDatei();
		 this.volkshochschulekurs = new Volkshochschulekurs(zeile[0], 
   				Float.parseFloat(zeile[1]), 
   				zeile[2], 
   				Float.parseFloat(zeile[3]), 
   				zeile[4].split("_"));
		 product.schliessDatei();
		 
		 
	    
	      		
		 /*if("csv".equals(typ)){
	      			BufferedReader ein = new BufferedReader(new FileReader("VolkshochschulekursAusgabe.csv"));
	      			String[] zeile = ein.readLine().split(";");
	      			this.volkshochschulekurs = new Volkshochschulekurs(zeile[0], 
	      				Float.parseFloat(zeile[1]), 
	      				zeile[2], 
	      				Float.parseFloat(zeile[3]), 
	      				zeile[4].split("_"));
	      				ein.close();

}*/
	 }
	 
	 
		@Override
		public void addObserver(Observer obs) {
			// TODO Auto-generated method stub
			liste.add(obs);
			
		}


		@Override
		public void removeObserver(Observer obs) {
			// TODO Auto-generated method stub
			liste.remove(obs);
			
		}


		@Override
		public void notifyObservers() {
			// TODO Auto-generated method stub
			for (Observer o : liste) {
				o.update();
			}
			
		}

}
	 