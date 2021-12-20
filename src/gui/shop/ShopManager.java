package gui.shop;

import java.util.ArrayList;

public class ShopManager {
	
    private static ShopManager instance = null; 
    
    //field
    public  int updatedFish;
    //ItemToBuy List
    public ArrayList<ItemToBuy> allItemToBuy;
    
	private ShopManager() {
		updatedFish = 0;
		//construct all itemToBuyList
		allItemToBuy = new ArrayList<ItemToBuy>();
		allItemToBuy.add(new ItemToBuy("Attack normal"));
		allItemToBuy.add(new ItemToBuy("Attack silver"));
		allItemToBuy.add(new ItemToBuy("Attack gold"));
		allItemToBuy.add(new ItemToBuy("Attack diamond"));
		allItemToBuy.add(new ItemToBuy("Potion Blue"));
		allItemToBuy.add(new ItemToBuy("Potion Green"));
		allItemToBuy.add(new ItemToBuy("Potion Orange"));
		allItemToBuy.add(new ItemToBuy("Potion Red"));
	}
	
	public static ShopManager getInstance() {
		if (instance == null)
		{
			instance = new  ShopManager();
		}  
			return instance;  
	}
	
	//when collect in game, use this one
	public  void addFish(int addFish) {
		setUpdatedFish(getUpdatedFish() + addFish);
	}
	
	//use when want to know fish right now
	public  int getUpdatedFish() {
		return updatedFish;
	}
	
	//using in shop after buying to set new value
	public  void setUpdatedFish(int updatedFish) {
		this.updatedFish = updatedFish;
	}
	
	//method
	public ArrayList<ItemToBuy> getAllItemToBuy() {
		return allItemToBuy;
	}

	public void setAllItemToBuy(ArrayList<ItemToBuy> allItemToBuy) {
		this.allItemToBuy = allItemToBuy;
	}
}
