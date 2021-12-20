package sprite.character.bear;

import java.util.Random;

import game.GameStatus;
import game.utility.CollisionUtility;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import render.RenderableHolder;
import resource.ImageHolder;
import sprite.equipment.bullet.Snow;
import sprite.equipment.weapon.Snowball;
import sprite.equipment.weapon.Stick;

public class BrownBear  extends Bear{
	public BrownBear(double x, double y) {
		super();
		setPosition(new Point2D(x*36.0D, y*36.0D));
		speed = 30;
		health = (int) (200*GameStatus.getInstance().getMonsterMultiplier());
		maxHealth = (int) (200*GameStatus.getInstance().getMonsterMultiplier());
		characterAttack = 50;
		this.equipWeapon(new Snowball(new Stick(50, ImageHolder.upATK0)));
		itemAttack = 0;				
		direction = 3;
		updateTotalAttack();
		cooldown = 3000;
	}


	
	@Override
	public void update(){
		move();
		if ((System.currentTimeMillis() - lastFired) > cooldown) {
				attack();
	            lastFired = System.currentTimeMillis();
		}

	            
	    if ((System.currentTimeMillis() - lastCollidedPenguin) > cofusingTime) {
	               
	                collidedPenguin = false;
	    }		    


		setPosition(new Point2D(getPosition().getX() + this.dx, getPosition().getY() + this.dy));
	}
	
	@Override
	public void draw(GraphicsContext gc) {
 
		Image image ;
		if(imgSide == 0) {
			image = (ImageHolder.getInstance()).brownBearLeft;
		}else {
			image = (ImageHolder.getInstance()).brownBearRight;
		}
	    double x = getPosition().getX();
	    double y = getPosition().getY();		
		gc.drawImage(image, x, y, image.getWidth(), image.getHeight());
	}

	@Override
	public void attack() {

	          
	    if(weapon instanceof Snowball)   {
	    	Snow snow; 
	        if (direction == 0) {
	        	snow = new Snow(getPosition().getX() +2, getPosition().getY() +2, direction, true, this);
	        } else if (direction == 1) {
	        	snow = new Snow(getPosition().getX() +2, getPosition().getY() +2, direction, true, this);
	        } else if (direction == 2) {
	        	snow = new Snow(getPosition().getX() +2, getPosition().getY() +2, direction, true, this);
	        } else {
	        	snow = new Snow(getPosition().getX() +2, getPosition().getY() +2, direction, true, this);
	        }
	        bullets.add(snow);
	        RenderableHolder.getInstance().add(snow);

	    }
	}

}
