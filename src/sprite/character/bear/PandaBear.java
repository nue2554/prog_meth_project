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
import sprite.equipment.bullet.Wood;
import sprite.equipment.weapon.Snowball;
import sprite.equipment.weapon.Stick;

public class PandaBear  extends Bear{
	
	public PandaBear(double x, double y) {
		super();
		setPosition(new Point2D(x*36.0D, y*36.0D));
		speed = 25;
		health = (int) (200*GameStatus.getInstance().getMonsterMultiplier());
		maxHealth = (int) (200*GameStatus.getInstance().getMonsterMultiplier());
		characterAttack = 50;
		this.equipWeapon((new Stick(50, ImageHolder.upATK0)));
		itemAttack = 0;				
		direction = 3;
		updateTotalAttack();
		cooldown = 5000;
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
			image = (ImageHolder.getInstance()).pandaBearLeft;
		}else {
			image = (ImageHolder.getInstance()).pandaBearRight;
		}
	    double x = getPosition().getX();
	    double y = getPosition().getY();		
		gc.drawImage(image, x, y, image.getWidth(), image.getHeight());
	}

	@Override
	public void attack() {

    	if(weapon instanceof Stick) {
	    	Wood wood;
	    	dx = 0;
			dy = 0;
	        if (direction == 0) {
	        	wood = new Wood(getPosition().getX(), getPosition().getY() - getHeight(), direction, true, this);
	        } else if (direction == 1) {
	        	wood = new Wood(getPosition().getX()  + getWidth(), getPosition().getY() , direction, true, this);
	        } else if (direction == 2) {
	        	wood = new Wood(getPosition().getX(), (getPosition().getY() + getHeight()), direction, true, this);
	        } else {
	        	wood = new Wood(getPosition().getX() - getWidth(), getPosition().getY(), direction, true, this);
	        }
	        bullets.add(wood);
	        RenderableHolder.getInstance().add(wood);
	    }
	}

}
