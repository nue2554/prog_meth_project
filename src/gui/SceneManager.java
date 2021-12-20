package gui;

import gui.shop.ShopPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
	private static SceneManager instance = null;

	private Stage primaryStage;
	private Scene scene;
	private ShopPane shopPane;
	private MainMenuPane mainMenuPane;
	private HowToPane howToPane;
	private GoodEndPane goodEndPane;
	private BadEndPane badEndPane;
	private NextLevelPane nextLevelPane;

	private SceneManager() {

		shopPane = new ShopPane();
		mainMenuPane = new MainMenuPane();
		howToPane = new HowToPane();
		goodEndPane = new GoodEndPane();
		badEndPane = new BadEndPane();
		nextLevelPane = new NextLevelPane();
		scene = new Scene(mainMenuPane);
	}

	public static SceneManager getInstance() {
		if (instance == null) {
			instance = new SceneManager();
		}
		return instance;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
	//index scene
	// 0 is main Menu;
	// 1 is Game Scene -> new Game Scene for playing
	// 2 is Shop
	// 3 is How to Pane
	// 4 is GoodEndPane
	// 5 is BadEndPane
	public void switchScene(int indexScene) {
		// to know index scene;
		switch (indexScene) {
		case 0:
			scene.setRoot(mainMenuPane);
			break;
		case 1:
			scene.setRoot(new GamePane());
			break;
		case 2:
			scene.setRoot(shopPane);
			break;
		case 3:
			scene.setRoot(howToPane);
			break;
		 case 4: scene.setRoot(goodEndPane); break;
		 case 5: scene.setRoot(badEndPane); break;
		 case 6: scene.setRoot(nextLevelPane); break;

		}
		primaryStage.setScene(scene);
	}

}
