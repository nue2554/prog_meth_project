package game.utility;

import java.awt.Rectangle;
import java.util.ArrayList;

import game.GameLogic;
import sprite.character.Character;
import sprite.character.Penguin;
import sprite.character.bear.Bear;
import sprite.equipment.bullet.Bullet;
import sprite.equipment.bullet.Snow;
import sprite.equipment.weapon.Stick;
import sprite.item.Item;
import sprite.base.Sprite;
import sprite.block.Block;
import sprite.block.Edge1;
import sprite.block.Edge2;
import sprite.block.Water;


public class CollisionUtility {

	private static ArrayList<Block> blocks;
	private static ArrayList<Bear> enemies;
	private static Penguin thePenguin;
	private static ArrayList<Item> items;
	
	public static boolean isCollided(Sprite moving, Sprite target, double delta) { 
		double movingTopX = moving.getPosition().getX();
		double movingTopY = moving.getPosition().getY();
		double movingBottomX = moving.getPosition().getX()+moving.getWidth();
		double movingBottomY = moving.getPosition().getY()+moving.getHeight();
		double targetTopX = target.getPosition().getX();
		double targetTopY = target.getPosition().getY();
		double targetBottomX = target.getPosition().getX()+target.getWidth();
		double targetBottomY = target.getPosition().getY()+target.getHeight();
		
		if(movingTopX<=targetTopX && movingTopY <= targetTopY && 
				movingBottomX + delta>=  targetTopX && movingBottomY + delta>= targetTopY) {

			return true;
		}else if (movingBottomX>=targetBottomX && movingTopY <= targetTopY && 
				movingTopX - delta<=  targetBottomX && movingBottomY + delta>= targetTopY) {

			return true;
		}else if (movingTopX<=targetTopX && movingBottomY >= targetBottomY && 
				movingBottomX + delta>=  targetTopX && movingTopY - delta<= targetBottomY) {

			return true;
		}else if (movingBottomX>=targetBottomX && movingBottomY >= targetBottomY && 
				movingTopX - delta<=  targetBottomX && movingTopY - delta<= targetBottomY) {
			return true;
		}
		return false;
	}
	
    static public void loadCollisionUtility(ArrayList<Block> collidableBlock, Penguin penguin
    		,ArrayList<Bear> enemyList, ArrayList<Item> itemList) {
    		blocks = collidableBlock;
    		thePenguin = penguin;
    		enemies = enemyList;
    		items = itemList;
    }
    

    public static void CollisionBulletsBlocksHelper(Bullet bullet, Block block) {

        if ((!(block instanceof Water))||(!(block instanceof Edge1))||(!(block instanceof Edge2))) {
        	
        	if(!bullet.isDestroyed()) {
        		block.takeDamage(bullet.getCharacter().getTotalAttack());
        	}

            bullet.destroy();
        }
        if (block.getHealth() == 0) {

            block.destroy();

        }
        System.out.println("------------------------------------");
    }
    

    public static boolean checkCollisionPenguinBlocks() {

        for (Sprite block : blocks) {

            if(isCollided(thePenguin, block, 6D)) {

        		
                return true;
            }
        }

        return false;
    }
    

    public static boolean checkCollisionBearBlocks(Bear bear) {


        for (Sprite block : blocks) {



            if(isCollided(bear, block, 6D)) {

        		
                return true;
            }
        }

        return false;
    }    
    
    
    
  
    public static boolean checkCollisionPenguinBear() {

        for (Sprite enemy : enemies) {

            if(isCollided(thePenguin, enemy, 2D)) {
                return true;
            }
        }
        return false;
    }    
    
    
    public static boolean checkCollisionPenguinBearIndividual(Bear bear) {

            if(isCollided(thePenguin, bear, 2D)) {
                return true;
            }

        return false;
    }    

    
    public static void checkCollisionBulletsBlocks(ArrayList<Bullet> bullets, ArrayList<Block> blocks) {

    		for (int x = 0; x < bullets.size(); x++) {
    			Bullet b = bullets.get(x);


    			for (int i = 0; i < blocks.size(); i++) {
    				Block aBlock = blocks.get(i);

    				if(isCollided(b, aBlock, 13D)) {

    					CollisionBulletsBlocksHelper(b, aBlock);
    				}
    			}
    		}
    }
    

    public static void checkCollisionBulletsPenguin(ArrayList<Bullet> bullets) {

    	for (int x = 0; x < bullets.size(); x++) {
    		Bullet bullet = bullets.get(x);

    		if(isCollided(bullet, thePenguin, 2D) && bullet.isEnemy() == true && bullet.isDestroyed() == false) {

    			thePenguin.takeDamage(bullet.getCharacter().getTotalAttack());
    			bullet.destroy();    			
    		}
            if (thePenguin.getHealth() == 0) {

	              System.out.println("YOU LOSE");

	            	thePenguin.getWeapon().destroy();
	            	thePenguin.destroy();

	            }
    	}
    }
    		

    
    
    
    
    public static void checkCollisionBulletsBear(ArrayList<Bullet> bullets, ArrayList<Bear> bears) {
	    for (int x = 0; x < bullets.size(); x++) {
	        Bullet bullet = bullets.get(x);
	
	        for (int i = 0; i < bears.size(); i++) {
	            Bear bear = bears.get(i);

	            if(isCollided(bullet, bear, 2D)  && bullet.isEnemy() == false && bullet.isDestroyed() == false) {


	            	bear.takeDamage(bullet.getCharacter().getTotalAttack());

	                bullet.destroy();

	            }
	            if (bear.getHealth() == 0 ) {

	            	for(int j = 0; j<bear.getBullets().size(); j++) {

	            		GameLogic.getInstance().addObject(bear.getBullets().get(j));
	            	}
	            	bear.getWeapon().destroy();
	            	bear.destroy();


	            }
	  	    
	        }
	    }    
    }
    
    public static void checkCollisionItemsPenguin(ArrayList<Item> items) {

    	for (int x = 0; x < items.size(); x++) {
    		Item item = items.get(x);

    		if(isCollided(thePenguin, item, 13D)== true) {

    			item.pick(thePenguin);
    			item.destroy();

    		}	
    	}
    }

}
