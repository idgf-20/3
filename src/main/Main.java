package main;


import gui.guiVolkshochschule.VolkshochschulekursControle;
import gui.guiVolksschule.VolksschuleControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new VolkshochschulekursControle(primaryStage);
		Stage fensterKurs = new Stage(); 
		new VolksschuleControl(fensterKurs);
	}
	

	
	public static void main(String[] args){
		launch(args);
	} 
	
}
