package gui;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import resource.FontHolder;
import resource.ImageHolder;

public class HowToPane extends StackPane{

	public HowToPane() {

		this.setPadding(new Insets(20));
		ImageView manual = new ImageView(ImageHolder.how);
	    manual.setFitWidth(1080);
	    manual.setFitHeight(720);
	    this.setPrefSize(1080, 720);
	    
	    Button bBtn = new Button();
	    
	    //transparent button
	    bBtn.setBackground(new Background(new BackgroundImage[] { new BackgroundImage(ImageHolder.backButton, 
	            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, 
	            new BackgroundSize(100, 60, false, false, false, false)) }));

	    bBtn.setPrefWidth(100);
	    bBtn.setPrefHeight(60);
	    
	    bBtn.setOnMouseClicked(e -> {
	    	//mainMenu - index 0
			SceneManager.getInstance().switchScene(0);
//	    	
        });
	    
	    getChildren().addAll(manual,bBtn);
	    StackPane.setAlignment(bBtn, Pos.TOP_RIGHT);
	    setCursor(Cursor.DEFAULT);
	}

	

	
}
