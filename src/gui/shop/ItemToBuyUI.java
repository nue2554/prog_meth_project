package gui.shop;

import exception.BuyItemFailedException;
import game.Player;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import resource.FontHolder;
import resource.ImageHolder;
import resource.SoundHolder;
import sprite.equipment.healthcolor.HealthColor;
import sprite.equipment.weapon.Stick;

public class ItemToBuyUI extends StackPane {
	
	private ItemToBuy item;
	private Button chooseBtn;

	public ItemToBuyUI(ItemToBuy item) {

		ImageView bg = new ImageView(ImageHolder.bgShop);
		bg.setFitWidth(200);
		bg.setFitHeight(180);

		
		this.item = item;
		VBox orderBar = new VBox();
		orderBar.setSpacing(10);
		
		ImageView itPic = new ImageView(this.item.getPicture());
		itPic.setFitWidth(48);
		itPic.setFitHeight(48);

		
//----------------------------------------------------------------
		//try to change text button when already buy button (buy->use)
//------------------------------------------------------------------
		chooseBtn = new Button();
		if (item.getIsAlreadyBuy()) {
			chooseBtn.setText("USE");
		}else {
			chooseBtn.setText("BUY");
		}
		chooseBtn.setFont(FontHolder.font12);
		chooseBtn.setAlignment(Pos.CENTER);
		chooseBtn.setOnMouseClicked(e -> {
			
			if(item.getIsAlreadyBuy()) {
				//set the value of skill
				setSkillPlayer(item);
			}else {
				try {
					buyItem(item);
				} catch (BuyItemFailedException e1) {

					e1.printStackTrace();
				}
			}
			
	      });
		
		//create name, price, and upgrade to
		Text name = new Text(this.item.getItemName() +item.getPriceText()+ item.getUptoText());
		name.setTextAlignment(TextAlignment.CENTER);
		name.setFont(FontHolder.font12);
		orderBar.getChildren().addAll(itPic,name, chooseBtn);
		orderBar.setAlignment(Pos.CENTER);
		getChildren().addAll(bg, orderBar);
		}

		//function to set maxHealth or Item Attack 
		public void setSkillPlayer(ItemToBuy item) {

			System.out.println("It press on use button");
			//index 0-3 is Upgrade Item attack and 4-7 is Upgrade Health
			if((0 <= item.getIndex()) && (item.getIndex() <=3 )) {

				Player.getInstance().equipWeapon(new Stick(item.getUpTo(), item.getPicture()));
			}else {
				//Upgrade maxHealth

				Player.getInstance().equipHealthColor(new HealthColor(item.getUpTo(), item.getPicture()));
			}
			ShopPane.setSkillLabelText();
		}		
		
		//function when click Buy button
		public void buyItem(ItemToBuy item) throws  BuyItemFailedException {
			
			//get the fish right now from UpdateFishSingleton
			int fish = ShopManager.getInstance().getUpdatedFish();
			
			//Not Enough Fish
			if (fish < item.getPrice() ) throw new BuyItemFailedException("Not Enough Fish");
			
			//can buy fish ->  set the new value of fish
			ShopManager.getInstance().setUpdatedFish(fish-item.getPrice());
			System.out.println(ShopManager.getInstance().updatedFish);
			
			//change the value to already buy for create new button
			item.setIsAlreadyBuy(true);
			
			//change the button to use button and when click on change to set skill
			chooseBtn.setText("USE");
			chooseBtn.setOnMouseClicked(e -> {setSkillPlayer(item);});
			
			//update fish balance
			ShopPane.setFishLabelText();
						
			}
}
		

		
	

