package gui;

import resource.FontHolder;
import resource.ImageHolder;
import gui.shop.ShopPane;
import gui.shop.ShopManager;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import render.RenderableHolder;

public class MainMenuPane extends StackPane {
 
	public MainMenuPane() {

		// Background
		ImageView bg = new ImageView(ImageHolder.welcomeScene);
		bg.setFitWidth(1080);
		bg.setFitHeight(720);
		this.setPrefSize(1080, 720);
		
		
		//sound
		
		// Game name
		Text title = new Text("ICE WAR");
		title.setFont(FontHolder.fontBlock60);

		// Play button
		Button playBtn = new Button();
		ImageView p = new ImageView(ImageHolder.playButton);
		playBtn.setGraphic(p);
		playBtn.setOnMouseClicked(e -> {
			// change to Game Scene - index 1
			SceneManager.getInstance().switchScene(1);
		});

		// Shop button
		Button shopBtn = new Button();
		ImageView sh = new ImageView(ImageHolder.shopButton);
		shopBtn.setGraphic(sh);
		shopBtn.setOnMouseClicked(e -> {
			// change to shop scene - index 2
			ShopManager.getInstance().getUpdatedFish();
            ShopPane.setFishLabelText();
			SceneManager.getInstance().switchScene(2);


		});

		// How to play button
		Button howBtn = new Button();
		ImageView h = new ImageView(ImageHolder.howButton);
		howBtn.setGraphic(h);
		howBtn.setOnMouseClicked(e -> {
			// change to How to play Scene -index 3
			SceneManager.getInstance().switchScene(3);
		});

		// Exit button
		Button exitBtn = new Button();
		ImageView ex = new ImageView(ImageHolder.exitButton);
		exitBtn.setGraphic(ex);
		exitBtn.setOnMouseClicked(e -> System.exit(0));

		// Menu bar for order the button
		VBox menuBar = new VBox();
		menuBar.setSpacing(50);
		menuBar.getChildren().addAll(title, playBtn, shopBtn, howBtn, exitBtn);
		menuBar.setAlignment(Pos.TOP_CENTER);
		menuBar.setTranslateY(90);

		getChildren().addAll(bg, menuBar);
		setCursor(Cursor.DEFAULT);
	}

}
