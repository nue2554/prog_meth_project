package gui;

import game.GameStatus;
import game.utility.InputUtility;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import resource.FontHolder;
import resource.ImageHolder;

public class NextLevelPane extends StackPane {

	public NextLevelPane() {
 
		this.setPadding(new Insets(20));
		ImageView nextLevel = new ImageView(ImageHolder.nextLevel);
		nextLevel.setFitWidth(1080);
		nextLevel.setFitHeight(720);
	    this.setPrefSize(1080, 720);
 
	    //exit button to main menu
	    Button exitBtn = new Button();
	    exitBtn.setBackground(new Background(new BackgroundImage[] { new BackgroundImage(ImageHolder.exitButtonRed, 
	            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, 
	            new BackgroundSize(100, 60, false, false, false, false)) }));
	    exitBtn.setPrefWidth(100);
	    exitBtn.setPrefHeight(60);
	    exitBtn.setOnMouseClicked(e -> {
	    	//mainMenu - index 0
	    	InputUtility.clearKey();
	    	GameStatus.getInstance().setInGame(false);
	    	GameStatus.getInstance().defeat();
			SceneManager.getInstance().switchScene(0);
			
	    });
	    
	    //next level button
	    Button nextBtn = new Button();
	    //transparent button
		nextBtn.setBackground(new Background(new BackgroundImage[] { new BackgroundImage(ImageHolder.nextButton, 
		            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, 
		            new BackgroundSize(100, 60, false, false, false, false)) }));
		nextBtn.setPrefWidth(100);
		nextBtn.setPrefHeight(60);
		nextBtn.setOnMouseClicked(e -> {
 
			InputUtility.clearKey();
			
			System.out.println("in next level");
			SceneManager.getInstance().switchScene(1);

	    });
	    
	    getChildren().addAll(nextLevel,exitBtn,nextBtn);
	    StackPane.setAlignment(nextBtn, Pos.BOTTOM_CENTER);
	    StackPane.setAlignment(exitBtn, Pos.TOP_LEFT);
	    

	    setCursor(Cursor.DEFAULT);
	}
}
