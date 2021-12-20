package gui;

import game.GameLogic;
import game.GameScreen;
import game.GameStatus;
import game.utility.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import render.RenderableHolder;

public class GamePane extends StackPane {
 
		private GameScreen gameScreen;
		private AnimationTimer animation;
		public static MediaPlayer  mediaBackGroundGame;
		
		public GamePane() {

		GameStatus.getInstance().nextLevel();
		this.gameScreen = new GameScreen(1080.0D, 720.0D);
		
	    Media media = new Media(ClassLoader.getSystemResource("SoundBackGround.mp3").toString());
	    this.mediaBackGroundGame = new MediaPlayer(media);
	    mediaBackGroundGame.setAutoPlay(true);
	    mediaBackGroundGame.setVolume(0.3D);
	    mediaBackGroundGame.setCycleCount(-1);
	    mediaBackGroundGame.play();
		getChildren().addAll(gameScreen);
		gameScreen.setFocusTraversable(true);


		animation = new AnimationTimer() {
		public void handle(long now) {
			if(GameStatus.getInstance().isInGame()) {

				GameLogic.getInstance().logicUpdate();
				RenderableHolder.getInstance().update();		
				gameScreen.paintComponent();
				
			}else {
				animation.stop();
			}
			
		}
		};
		animation.start();
	}
	
	
	public void addListerner() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});

		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});
	}
	

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public void setGameScreen(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}
	
}
