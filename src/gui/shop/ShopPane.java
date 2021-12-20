package gui.shop;

import resource.FontHolder;
import resource.ImageHolder;

import java.util.ArrayList;

import game.Player;
import gui.MainMenuPane;
import gui.SceneManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ShopPane extends StackPane {


	private static Label fishLabel;
	private static Label skillLabel;
	private ArrayList<ItemToBuy> allItemToBuy;

	public ShopPane() {
		ImageView bg = new ImageView(ImageHolder.bgShopMain);
		bg.setFitWidth(2000);
		bg.setFitHeight(800);
		getChildren().add(bg);
		this.setPadding(new Insets(20));
		this.setPrefSize(1080, 720);
		// Grid of Item slot
		TilePane itemToBuySlot = new TilePane();
		itemToBuySlot.setAlignment(Pos.CENTER);
		itemToBuySlot.setVgap(10);
		itemToBuySlot.setHgap(10);

		// add item button to each cell
		// change to item in singleton
		itemToBuySlot.getChildren().add(new ItemToBuyUI(ShopManager.getInstance().getAllItemToBuy().get(0)));
		itemToBuySlot.getChildren().add(new ItemToBuyUI(ShopManager.getInstance().getAllItemToBuy().get(1)));
		itemToBuySlot.getChildren().add(new ItemToBuyUI(ShopManager.getInstance().getAllItemToBuy().get(2)));
		itemToBuySlot.getChildren().add(new ItemToBuyUI(ShopManager.getInstance().getAllItemToBuy().get(3)));
		itemToBuySlot.getChildren().add(new ItemToBuyUI(ShopManager.getInstance().getAllItemToBuy().get(4)));
		itemToBuySlot.getChildren().add(new ItemToBuyUI(ShopManager.getInstance().getAllItemToBuy().get(5)));
		itemToBuySlot.getChildren().add(new ItemToBuyUI(ShopManager.getInstance().getAllItemToBuy().get(6)));
		itemToBuySlot.getChildren().add(new ItemToBuyUI(ShopManager.getInstance().getAllItemToBuy().get(7)));

		VBox orderShopBar = new VBox();

		Text shopName = new Text("SHOP");
		shopName.setFont(FontHolder.fontBlock40);
		shopName.setTextAlignment(TextAlignment.CENTER);

		Text shopInstuction = new Text("Choose one of Item Attack and one of Health Upgrade");
		 shopInstuction.setFont(FontHolder.font20);

		// Arrange Fish and Label text
		HBox orderFish = new HBox();
		ImageView fish = new ImageView(ImageHolder.fish1);
		fish.setFitWidth(40);
		fish.setFitHeight(40);
		
		fishLabel = new Label();
		// fishLabel.setFont(FontHolder.font18);
		setFishLabelText();
		fishLabel.setFont(FontHolder.font18);
		orderFish.getChildren().addAll(fish, fishLabel);
		orderFish.setAlignment(Pos.CENTER);

		skillLabel = new Label();
		setSkillLabelText();
		skillLabel.setFont(FontHolder.font18);

		// Go back to main Menu
		Button okBtn = new Button();
		okBtn.setBackground(new Background(new BackgroundImage[] {
				new BackgroundImage(ImageHolder.okButton, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.DEFAULT, new BackgroundSize(100, 60, false, false, false, false)) }));
		okBtn.setPrefWidth(100);
		okBtn.setPrefHeight(60);
		okBtn.setOnMouseClicked(e -> {

			// change to main menu - index 0
			SceneManager.getInstance().switchScene(0);


		});

		orderShopBar.getChildren().addAll(shopName, shopInstuction, orderFish, skillLabel, itemToBuySlot, okBtn);
		orderShopBar.setSpacing(15);
		orderShopBar.setAlignment(Pos.CENTER);
		getChildren().addAll(orderShopBar);
		setCursor(Cursor.DEFAULT);

	}

	// Label for fish and show penguin max Health and Attack
	public static void setFishLabelText() {
		fishLabel.textProperty().setValue(" Fish: " + ShopManager.getInstance().getUpdatedFish());
	}

	public static void setSkillLabelText() {
		skillLabel.textProperty().setValue(" Max Health: " + Player.getInstance().getMaxHealth() + " Attack: "
				+ Player.getInstance().getWeaponAttack());
	}
}
