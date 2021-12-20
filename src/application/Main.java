package application;

import resource.ImageHolder;
import javafx.application.Application;
import javafx.stage.Stage;
import gui.SceneManager;
public class Main extends Application {

  public void start(Stage primaryStage) throws Exception {

	  	SceneManager.getInstance().setPrimaryStage(primaryStage);
	  	SceneManager.getInstance().getPrimaryStage();
	  	//index0 -> mainMenuPane
	  	SceneManager.getInstance().switchScene(0);
	  	SceneManager.getInstance().getPrimaryStage().sizeToScene();
	  	SceneManager.getInstance().getPrimaryStage().getIcons().add(ImageHolder.icon);
	  	SceneManager.getInstance().getPrimaryStage().setResizable(false);
	  	SceneManager.getInstance().getPrimaryStage().setTitle("ICE WAR");
	    SceneManager.getInstance().getPrimaryStage().show();
	    
  }
  
  public static void main(String[] args) {
    launch(args);
  }

}
