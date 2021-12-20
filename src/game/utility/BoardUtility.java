package game.utility;


import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import game.GameStatus;
import sprite.block.Block;
import sprite.character.Penguin;
import sprite.character.bear.Bear;
import sprite.character.bear.BrownBear;
import sprite.character.bear.PandaBear;
import sprite.character.bear.RunnerBear;
import sprite.character.bear.WhiteBear;
import sprite.equipment.bullet.Bullet;
import sprite.equipment.bullet.Snow;
import sprite.item.AttackItem;
import sprite.item.Fish;
import sprite.item.FreezeItem;
import sprite.item.HealingItem;
import sprite.item.Item;
import sprite.item.SnowBallItem;


public class BoardUtility {

    private static ArrayList<Bear> enemy = new ArrayList<>();
    private static ArrayList<Block> blocks = new ArrayList<>();
    private static ArrayList<Item> items = new ArrayList<>();
    private static Penguin penguin;

    public static void loadBoardUtility(ArrayList<Bear> enemy1, ArrayList<Block> blocks1
    		,ArrayList<Item> items1    , Penguin penguin1) {
    	enemy = enemy1;
    	blocks = blocks1;
    	penguin = penguin1;
    	items = items1;
    }   
    public static Item spawnItem(double x, double y) {
	    	Random random = new Random();
	    	int randomItem = random.nextInt(100);
	    	System.out.println("Item:"+ randomItem);
	    	if (randomItem<35) {
		          return new Fish(x, y,(new Random()).nextInt(8)*10+20);
//		          return new AttackItem(x, y);
	    	}else if (randomItem>=35 && randomItem<45) {
		    	  return new AttackItem(x, y);
	    	}else if (randomItem>=45 && randomItem<65) {
		    	  return new SnowBallItem(x, y);
	    	}else if (randomItem>=65 && randomItem<90) {
		    	  return new HealingItem(x, y);
	    	}else{
		          return new FreezeItem(x, y);
	    	}

    }

    
    public static Bear spawnBear(int randomBear) {
    	Random random = new Random();
    	int randomPosX = random.nextInt(28);
    	int randomPosY = random.nextInt(18);
    	Bear bear;
    	if(randomBear==0) {
    		bear = new WhiteBear(randomPosX+2, randomPosY+2);
    	}else if(randomBear==1) {
    		bear = new BrownBear(randomPosX+2, randomPosY+2);   		
    	}else if(randomBear==2) {
    		bear = new RunnerBear(randomPosX+2, randomPosY+2);
    	}else{
    		bear = new PandaBear(randomPosX+2, randomPosY+2);
    	}
    	
    	while(CollisionUtility.checkCollisionPenguinBearIndividual(bear)||
    			CollisionUtility.checkCollisionBearBlocks(bear)){
    		randomPosX = random.nextInt(28);
        	randomPosY = random.nextInt(18); 

        	bear.destroy();
        	bear.getWeapon().destroy();
        	if(randomBear==0) {
        		bear= new WhiteBear(randomPosX+2, randomPosY+2);
        		
        	}else if(randomBear==1) {
        		bear = new BrownBear(randomPosX+2, randomPosY+2);   		
        	}else if(randomBear==2) {
        		bear = new RunnerBear(randomPosX+2, randomPosY+2);
        	}else{
        		bear = new PandaBear(randomPosX+2, randomPosY+2);
        	}
    	}
    	System.out.println("Bear: "+ bear.getPosition().getX()+" "+bear.getPosition().getY());
    	return bear ;
    }


    public static void updateBulletsBear() {
        for (Bear bear : enemy) {
            ArrayList<Bullet> bullet = bear.getBullets();
            for (int i = 0; i < bullet.size(); i++) {
            	Bullet b = bullet.get(i);
                if (b.isDestroyed()==false) {
                    b.update();
                } else if (b.isDestroyed() == true) {
                	bullet.remove(i);
                }
            }
        }
    }

    
    public static void updateBulletsPenguin() {
        ArrayList<Bullet> bullet = penguin.getBullets();

        for (int i = 0; i < bullet.size(); i++) {
        	Bullet b = bullet.get(i);
            if (b.isDestroyed()==false) {
                b.update();
                System.out.println(b+": ");
            } else if (b.isDestroyed() == true) {
            	bullet.remove(i);
            }
        }
    }
    
    public static void checkCollisions() {
        ArrayList<Bullet> bullets = new ArrayList<>();
        bullets.addAll(penguin.getBullets());
        for (Bear bear : enemy) {
            bullets.addAll(bear.getBullets());
        }
        CollisionUtility.checkCollisionBulletsBlocks(bullets, blocks);
        CollisionUtility.checkCollisionBulletsPenguin(bullets);
        CollisionUtility.checkCollisionBulletsBear(bullets, enemy);
        CollisionUtility.checkCollisionPenguinBear();
        CollisionUtility.checkCollisionItemsPenguin(items);
        

    }
    
    public static boolean compareXY(Bear bear) {
    		return Math.abs(distanceX(bear))>Math.abs(distanceY( bear));
    }

    
    public static double distanceX(Bear bear) {
    	
    	return penguin.getPosition().getX() - bear.getPosition().getX(); 
    }
    public static double distanceY(Bear bear) {
    	
    	return penguin.getPosition().getY() - bear.getPosition().getY(); 
    }

    
    
}
