package gui.guiVolkshochschule;

import java.io.IOException;

import business.Volkshochschulekurs;
import business.VolkshochschulekursModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class VolkshochschulekursControle implements Observer{
	
	
		private VolkshochschulekursModel volkshochschulekursModel;
		private VolkshochschulekursView  volkshochschulekursView;
		
		
		public VolkshochschulekursControle(Stage primStage) {
			super();
			this.volkshochschulekursModel=  VolkshochschulekursModel.getInstanz();
			this.volkshochschulekursView =  new VolkshochschulekursView (this,volkshochschulekursModel,primStage);
			volkshochschulekursModel.addObserver(this);
		}
		 
		 public void nehmeVolkshochschulekursAuf(){
		    	try{
		    		volkshochschulekursModel.setVolkshochschulekurs( new Volkshochschulekurs(
		        			this.volkshochschulekursView.getTxtKursname().getText(), 
		       	            Float.parseFloat(this.volkshochschulekursView.getTxtKursbeitrag().getText()),
		       	            this.volkshochschulekursView.getTxtWochentag().getText(),
		       	            Float.parseFloat(this.volkshochschulekursView.getTxtStartuhrzeit().getText()),
		       	            this.volkshochschulekursView.getTxtStandVorkenntnisse().getText().split(";")));
		    		        this.volkshochschulekursView.zeigeInformationsfensterAn("Der volkshochschulekurs wurde aufgenommen!");
		       	}
		       	catch(Exception exc){
		       		this.volkshochschulekursView.zeigeFehlermeldungsfensterAn(exc.getMessage());
		     	}
		    }
		 
		 public void leseAusDatei(String typ){
		    	try {
		      		this.volkshochschulekursModel.leseAusDatei(typ);
		      	}
				catch(IOException exc){
					this.volkshochschulekursView.zeigeFehlermeldungsfensterAn(
						"IOException beim Lesen!");
				}
				catch(Exception exc){
					this.volkshochschulekursView.zeigeFehlermeldungsfensterAn(
						"Unbekannter Fehler beim Lesen!");
				}
			}
		 
		 public void schreibeVolkshochschulekurserInCsvDatei() {
				try {
					this.volkshochschulekursModel.schreibeVolkshochschulekurserInCsvDatei();
		   			this.volkshochschulekursView.zeigeInformationsfensterAn("Die Kurse wurden gespeichert!");
				}	
				catch(IOException exc){
					this.volkshochschulekursView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
				}
				catch(Exception exc){
					this.volkshochschulekursView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
				}
			}

		@Override
		public void update() {
			// TODO Auto-generated method stub
			volkshochschulekursView.zeigeVolkshochschulekurserAn();
			
		}
			
			
		 
		
		

}
