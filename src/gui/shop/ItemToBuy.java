package gui.shop;

import java.util.ArrayList;

import javafx.scene.image.Image;
import resource.ImageHolder;

public class ItemToBuy {
	
    
	private String itemName;
	private int price;
	private int upTo;
	private Image picture;
	private Boolean isAlreadyBuy;
	private int index;

	public ItemToBuy(String itemName) {
		switch(itemName) {
			case "Attack normal" :	picture = ImageHolder.upATK0; 		price = 0;		
									upTo = 50;			isAlreadyBuy = true;				index = 0;		break;
									
			case "Attack silver" : 	picture = ImageHolder.upATK1; 		price = 500;		
									upTo = 150;			isAlreadyBuy = false; 				index = 1;		break;
									
			case "Attack gold" : 	picture = ImageHolder.upATK2; 		price = 1500;		
									upTo = 250;			isAlreadyBuy = false; 				index = 2;		break;
									
			case "Attack diamond" : picture = ImageHolder.upATK3; 		price = 3000;		
									upTo = 400;			isAlreadyBuy = false; 				index =	3;		break;
			
			case "Potion Blue" : 	picture = ImageHolder.upHealth0; 	price = 0;		
									upTo = 500;			isAlreadyBuy = true; 				index = 4;		break;
			case "Potion Green" : 	picture = ImageHolder.upHealth1; 	price = 500;		
									upTo = 1250;			isAlreadyBuy = false; 				index = 5;		break;
									
			case "Potion Orange" : 	picture = ImageHolder.upHealth2; 	price = 1500;		
									upTo = 2000;			isAlreadyBuy = false; 				index = 6;		break;
									
			case "Potion Red" : 	picture = ImageHolder.upHealth3; 	price = 3000;		
									upTo = 2750;			isAlreadyBuy = false; 				index = 7;		break;

		}
		this.itemName = itemName;
	}

	public String getItemName() {
		return itemName;
	}

	public int getPrice() {
		return price;
	}

	public Image getPicture() {
		return picture;
	}

	public int getUpTo() {
		return upTo;
	}

	public String getPriceText() {
		if (price == 0) {
			return "\nDefault";
		}
		return "\nPrice: " + price;

	}

	public String getUptoText() {
		return "\nUpgrade to: " + upTo;
	}

	public Boolean getIsAlreadyBuy() {
		return isAlreadyBuy;
	}

	public void setIsAlreadyBuy(Boolean isAlreadyBuy) {
		this.isAlreadyBuy = isAlreadyBuy;
	}

	public int getIndex() {
		return index;
	}

}