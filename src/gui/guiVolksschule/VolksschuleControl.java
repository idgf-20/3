package gui.guiVolksschule;


import business.VolkshochschulekursModel;
import javafx.stage.Stage;
import ownUtil.Observer;



public class VolksschuleControl implements Observer {
	

	private VolkshochschulekursModel volkshochschulekursModel;
	private VolksschuleView  volksschuleView;
	
	
	public VolksschuleControl(Stage primaryStage) {
		super();
		this.volkshochschulekursModel = volkshochschulekursModel.getInstanz();
		this.volksschuleView = new VolksschuleView(this, primaryStage, volkshochschulekursModel);
		volkshochschulekursModel.addObserver(this);
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		volksschuleView.zeigeVolkshochschulekurserAn();
		
	}







	

		
		

}
