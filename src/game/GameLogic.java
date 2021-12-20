package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.utility.BoardUtility;
import game.utility.CollisionUtility;
import game.utility.InputUtility;
import game.GameStatus;
import gui.BadEndPane;
import gui.GamePane;
import gui.GoodEndPane;
import gui.MainMenuPane;
import gui.SceneManager;
import gui.shop.ShopManager;
import interfaces.IDamageable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import render.RenderableHolder;
import sprite.base.Sprite;
import sprite.block.Block;
import sprite.block.Floor;
import sprite.character.Penguin;
import sprite.character.bear.Bear;
import sprite.equipment.bullet.Snow;
import sprite.equipment.healthcolor.HealthColor;
import sprite.equipment.weapon.Snowball;
import sprite.equipment.weapon.Stick;
import sprite.item.Item;

public class GameLogic {
	
//	single_instance
	private static GameLogic single_instance = null;
	
    public static GameLogic getInstance()
    {
        if (single_instance == null)
            single_instance = new GameLogic();
 
        return single_instance;
    }
//	---------------------------------------------------------
    private ArrayList<Block> collidableBlock;
	private ArrayList<Snow> bulletList;
	private ArrayList<Bear> enemyList;
	private ArrayList<Item> itemList;
	private ArrayList<Sprite> gameObjectContainer;
	private Penguin penguin;
	
	private int[] enemyType;
	private boolean freeze;
	private long freezeTime;
	
	
	int countAllEnemy = 0;

	
	private GameLogic(){
		
		initLogic();
		
	}
	
	public void initLogic() {
			
		penguin = new Penguin();
		freeze=false;
		freezeTime = 0;
		countAllEnemy = 0;
		collidableBlock = new ArrayList();
		bulletList = new ArrayList();
		enemyList = new ArrayList();
		itemList = new ArrayList();
		gameObjectContainer = new ArrayList<Sprite>();
		addObject(penguin);

		enemyType = new int[] {0, 0, 0, 0};
		
		CollisionUtility.loadCollisionUtility(collidableBlock, penguin, enemyList, itemList);
        BoardUtility.loadBoardUtility(enemyList, collidableBlock, itemList, penguin);
	
	}
	
	public void drawMap(int level) {
		Map map = new Map();	
		for (int x = 0; x < map.getSpriteFromMap(level).size() ; x++) {
		
				addObject(map.getSpriteFromMap(level).get(x));
		}		
		setType(level);
	}
	
	public void setType(int level) {
		switch (level) {
		 case 0:enemyType = new int[]{0, 0, 0, 0};break;
		 case 1:enemyType = new int[]{6, 0, 0, 0};break;
		 case 2:enemyType = new int[]{5, 2, 0, 0};break;
		 case 3:enemyType = new int[]{5, 1, 2, 0};break;
		 case 4:enemyType = new int[]{3, 3, 3, 0};break;
		 case 5: enemyType = new int[]{7, 2, 0, 1}; break;
		 case 6: enemyType = new int[]{0, 8, 0, 0}; break;
		 case 7: enemyType = new int[]{3, 5, 2, 2}; break;
		 case 8: enemyType = new int[]{8, 0, 0, 4}; break;
		 case 9: enemyType  = new int[]{2, 2, 6, 2}; break;
		 case 10: enemyType  = new int[]{4, 4, 4, 4}; break;
		}

	}		
	
	public int[] getEnemyType() {
		return enemyType;
	}

	public void logicUpdate(){
		removeDestroy();
		updateBear();
		updateBullets();
		updateWeapon();
		for(int i = 0; i < gameObjectContainer.size(); i++) {
			gameObjectContainer.get(i).update();
		}
		BoardUtility.checkCollisions();
		updateGameState();
		checkFreeze();
		System.out.println("-----------");
		System.out.println("Level: "+GameStatus.getInstance().getLevel());
		System.out.println("Fish: "+ShopManager.getInstance().getUpdatedFish());
		System.out.println("Weapon: "+penguin.getWeapon());
		System.out.println("Bullets: "+penguin.getBullets().size());
		int count = 0;
		for(int i =0; i<penguin.getBullets().size(); i++) {
			if(penguin.getBullets().get(i).isDestroyed()) {
				count++;
			}
		}
//		for check the value in console
		
//		System.out.println("Bullets Destroy: "+penguin.getBullets().size());
//		System.out.println("BaseAtk: "+Player.getInstance().getBaseAttack());
//		System.out.println("WepAtk: "+Player.getInstance().getWeaponAttack());
//		System.out.println("ItemAtk: "+Player.getInstance().getItemAttack());
//		System.out.println("RenderableHolder: "+RenderableHolder.getInstance().getEntities().size());
//		System.out.println("gameObjectContainer: "+gameObjectContainer.size());
//		System.out.println("TotalAtk: "+ Player.getInstance().getTotalAttack());
//		System.out.println("HP Player: "+Player.getInstance().getCurrentHealth() 
//				+"/"+Player.getInstance().getMaxHealth());
//		System.out.println("Goal: "+GameStatus.getInstance().getTargetKilled()
//				+"/"+GameStatus.getInstance().getGoal());
//		System.out.println("-----------");		
	}
	
	public void addObject(Sprite sprite) {
		gameObjectContainer.add(sprite);
		RenderableHolder.getInstance().add(sprite);
		if(sprite instanceof Block) {
			collidableBlock.add((Block) sprite);
		}
		if(sprite instanceof Bear) {
			enemyList.add((Bear) sprite);
		}			
		if(sprite instanceof Item) {
			itemList.add((Item) sprite);
		}						
	}
	
	public void updateWeapon() {
		for(int i = 0; i<enemyList.size(); i++) {
			enemyList.get(i).getWeapon().update(enemyList.get(i).getPosition().getX(),
					enemyList.get(i).getPosition().getY());
		}
		penguin.getWeapon().update(penguin.getPosition().getX(), penguin.getPosition().getY());
	}
	
	public void updateBear() {
		
		if(enemyList.size()<3
				&& countAllEnemy < GameStatus.getInstance().getGoal()) {
				boolean check = false;
				while(!check) {
					Random random = new Random();
					int randomBear = random.nextInt(4);
					if(enemyType[randomBear]>0) {
						enemyType[randomBear]=enemyType[randomBear]-1;
						addObject(BoardUtility.spawnBear(randomBear));
						countAllEnemy++;
						check = true;
					}
					
				}
		}

	}
	
	
	
    public void updateBullets() {   	
    	
    	BoardUtility.updateBulletsBear();
    	BoardUtility.updateBulletsPenguin();
    }	
	
	
    public void checkCollisions() {
    	BoardUtility.checkCollisions();
    }

    public void removeDestroy() {
        	for(int i =0; i<collidableBlock.size(); i++) {
        		if(collidableBlock.get(i).isDestroyed()) {
        			double x = collidableBlock.get(i).getPosition().getX()/collidableBlock.get(i).getWidth();
        			double y = collidableBlock.get(i).getPosition().getY()/collidableBlock.get(i).getHeight();
        			
        			collidableBlock.remove(i);
        			
        			Floor floor = new Floor(x ,y);
        			addObject(floor);
      			
        		}
        	}
        	for(int i =0; i<enemyList.size(); i++) {
        		if(enemyList.get(i).isDestroyed()) {
        			double x = enemyList.get(i).getPosition().getX();
        			double y = enemyList.get(i).getPosition().getY();
        			enemyList.remove(i);
	            	GameStatus.getInstance().setTargetKilled(
	            			GameStatus.getInstance().getTargetKilled()+1);
        			
        			int level = GameStatus.getInstance().getLevel();
        			Random random = new Random();
        			int randomItem = random.nextInt(120);
        			double rate =  random.nextInt(100)+10*(level);
        			if(randomItem>30) {
        				addObject(BoardUtility.spawnItem(x, y));
        			}
        			
        		}
        	}
        	
        	for(int i =0; i<itemList.size(); i++) {
        		if(itemList.get(i).isDestroyed()) {
        			itemList.remove(i);
        		}
        	}
        	for(int i =0; i<gameObjectContainer.size(); i++) {
        		if(gameObjectContainer.get(i).isDestroyed()) {
        			gameObjectContainer.remove(i);
        		}
        	}
    }


   
    //----------
    public void updateGameState() {
    	if(isGameWin()) {
    		GameStatus.getInstance().win();
    		clear(); 
//    		Good end scene - index 4
    		InputUtility.clearKey();
    		GameStatus.getInstance().setInGame(false);
    		
    		GamePane.mediaBackGroundGame.stop();
    	    GoodEndPane.mediaGoodEnd.play();

    		SceneManager.getInstance().switchScene(4);
    		
    		
    		
			
    	}else if(isGameNextLevel()) {
    		clear();
    		
    		GameStatus.getInstance().setInGame(false);
    		GamePane.mediaBackGroundGame.stop();
    		//Next level scene - index 6
    		SceneManager.getInstance().switchScene(6);
//			
    	}else if(isGameDefeat()) {
    		InputUtility.clearKey();
    		GameStatus.getInstance().defeat();
    		clear();
    		GameStatus.getInstance().setInGame(false);
    		GamePane.mediaBackGroundGame.stop();
			//bad end -  index 5
    		SceneManager.getInstance().switchScene(5);
    	    BadEndPane.mediaBadEnd.play();

			
			System.out.println("Defeated");
    	}
    }
    //---------
    
    public boolean isGameNextLevel() {
    	if(GameStatus.getInstance().getTargetKilled()>=GameStatus.getInstance().getGoal()) {
    		return true;
    	}
    	return false;
    }
    
    public boolean isGameWin() {
    	if(GameStatus.getInstance().getLevel()==2
    		&& GameStatus.getInstance().getTargetKilled()>=GameStatus.getInstance().getGoal()){
    		
    		return true;
    	}
    	return false;
    }
    
    public boolean isGameDefeat() {
    	if(Player.getInstance().getCurrentHealth()<=0) {
    		return true;
    	}
    	return false;
    }   
    
    public void checkFreeze() {
		for(int i =0; i<enemyList.size();i++) {

			if(freeze==true) {
				enemyList.get(i).setFreezed(true);
    		}else {
    			enemyList.get(i).setFreezed(false);   		
    		}
    		if(System.currentTimeMillis()- freezeTime > 2000) {
    			freeze = false;
    		}
    	}
    }
    
    public void clear() {
 		RenderableHolder.getInstance().clear();
		initLogic();
    }
   
    
	public List<Sprite> getGameObjectContainer() {
		return gameObjectContainer;
	}

	public Penguin getPenguin() {
		return penguin;
	}

	public boolean isFreeze() {
		return freeze;
	}

	public void setFreeze(boolean freeze) {
		this.freeze = freeze;
	}

	public long getFreezeTime() {
		return freezeTime;
	}

	public void setFreezeTime(long l) {
		this.freezeTime = l;
	}

	
}
