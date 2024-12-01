package gui.guiVolksschule;

import business.Volkshochschulekurs;
import business.VolkshochschulekursModel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class VolksschuleView {

	
		private Pane pane     					= new  Pane();
	    private TextArea txtAnzeige  			= new TextArea();
    	private Label lblAnzeigeVolkshochschulekurs = new Label("Anzeige volkshochschulekurs");;
	    private Button btnAnzeige 		 		= new Button("Anzeige");


   
	    //-------Ende Attribute der grafischen Oberflaeche-------
	    
	    // speichert temporaer ein Objekt vom Typ Buergeramt
	    private Volkshochschulekurs volkshochschulekurs;
	    
	    private VolksschuleControl volksschuleControl;
	    private VolkshochschulekursModel volkshochschulekursModel;
	    
	    public VolksschuleView(VolksschuleControl sportstaettenControl, Stage primaryStage, VolkshochschulekursModel volkshochschulekursModel) {
	        super();
	        this.volksschuleControl = sportstaettenControl;
	        this.volkshochschulekursModel = VolkshochschulekursModel.getInstanz();

	        // Ensure volkshochschulekursModel is not null when passed
	        Scene scene = new Scene(this.pane, 560, 340);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Anzeige von Kurse");
	        primaryStage.show();
	        this.initKomponenten();
	        this.initListener();
	    }

	    
	    


	    
	    private void initKomponenten(){
	       	// Labels

	    	Font font = new Font("Arial", 24); 
	

    		lblAnzeigeVolkshochschulekurs.setLayoutX(310);
    		lblAnzeigeVolkshochschulekurs.setLayoutY(40);
    		lblAnzeigeVolkshochschulekurs.setFont(font);
    		lblAnzeigeVolkshochschulekurs.setStyle("-fx-font-weight: bold;"); 
    		pane.getChildren().add(lblAnzeigeVolkshochschulekurs);
	     	
	
	        txtAnzeige.setEditable(false);
	     	txtAnzeige.setLayoutX(310);
	    	txtAnzeige.setLayoutY(90);
	     	txtAnzeige.setPrefWidth(220);
	    	txtAnzeige.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeige); 
	       	
	        // Buttons

	        btnAnzeige.setLayoutX(310);
	        btnAnzeige.setLayoutY(290);
	        pane.getChildren().addAll( btnAnzeige); 
	        
	   }
	    


		public void initListener() {
			btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {

		    	@Override
		        public void handle(ActionEvent e) {
		            zeigeVolkshochschulekurserAn();
		        } 
	   	    });
	
		
	    }
	    
	    public void zeigeVolkshochschulekurserAn(){
	       	if(this.volkshochschulekursModel.getVolkshochschulekurs() != null){
	       		txtAnzeige.setText(
	       			this.volkshochschulekursModel.getVolkshochschulekurs().gibVolkshochschulekursZurueck(' '));
	       	}
	       	else{
	       		zeigeInformationsfensterAn("Bisher wurde keine Kurse aufgenommen!");
	       	}
	       }
	    
	    public void zeigeInformationsfensterAn(String meldung){
	    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,"Information", meldung).zeigeMeldungsfensterAn();
	    }	
	    





	    
}
