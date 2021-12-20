package gui;

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
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import resource.ImageHolder;

public class GoodEndPane extends StackPane {
	
	public static MediaPlayer mediaGoodEnd;
	
	public GoodEndPane() {
		this.setPadding(new Insets(20));
		
		Media media1 = new Media(ClassLoader.getSystemResource("Congratulation (1080 x 720 px).mp4").toString());
		MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
		MediaView mediaView1 = new MediaView(mediaPlayer1);
		
		mediaPlayer1.setAutoPlay(true);
	    mediaPlayer1.setCycleCount(-1);
	    
	    Media media = new Media(ClassLoader.getSystemResource("SoundGoodEnd.wav").toString());
	    this.mediaGoodEnd = new MediaPlayer(media);

	    mediaView1.setFitWidth(1080);
	    mediaView1.setFitHeight(720);
	    this.setPrefSize(1080, 720);
	    
	    Button okBtn = new Button();
	
	    
	    //transparent button
	    okBtn.setBackground(new Background(new BackgroundImage[] { new BackgroundImage(ImageHolder.okButton, 
	            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, 
	            new BackgroundSize(100, 60, false, false, false, false)) }));
	
	    okBtn.setPrefWidth(100);
	    okBtn.setPrefHeight(60);
	    
	    okBtn.setOnMouseClicked(e -> {
	    	//mainMenu - index 0
	    	mediaGoodEnd.stop();
			SceneManager.getInstance().switchScene(0);

	    });
	    
	    getChildren().addAll(mediaView1,okBtn);
	    StackPane.setAlignment(okBtn, Pos.BOTTOM_CENTER);
	    setCursor(Cursor.DEFAULT);
	}
	
	
}

