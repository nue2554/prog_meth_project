package sprite.character;

import javafx.geometry.Point2D;

import java.awt.Rectangle;

import game.GameLogic;
import game.Player;
import game.utility.CollisionUtility;
import game.utility.InputUtility;
import resource.ImageHolder;
import interfaces.IDamageable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import render.RenderableHolder;
import sprite.base.Sprite;
import sprite.block.Water;
import sprite.character.bear.Bear;
import sprite.equipment.bullet.Snow;
import sprite.equipment.bullet.Wood;
import sprite.equipment.healthcolor.HealthColor;
import sprite.equipment.weapon.Snowball;
import sprite.equipment.weapon.Stick;
import sprite.equipment.weapon.Weapon;

public class Penguin extends Character {
 
	private HealthColor healthColor;
	private long snowBallEquipedTime;
	private long snowBallExpireTime = 10000;
	
	public Penguin() {
		super();
		cooldown = 500;
		setPosition(new Point2D(200.0D, 200.0D));
		direction = 1;
		
		characterAttack = Player.getInstance().getBaseAttack();
		equipWeapon(Player.getInstance().getWeapon());
		itemAttack = Player.getInstance().getItemAttack();
		healthColor = Player.getInstance().getHealthColor();
		maxHealth = Player.getInstance().getMaxHealth();
		if(Player.getInstance().getCurrentHealth()<=0) {
			Player.getInstance().setCurrentHealth(Player.getInstance().getMaxHealth());
		}
		health = Player.getInstance().getCurrentHealth();
	
		
		speed = 35;
		updateTotalAttack();
	}

	public void move() {
		if (InputUtility.getKeyPressed(KeyCode.W)) {
			dy = -this.speed * normalSpeed;
			direction = 0;
			System.out.println("W");
		}else if (InputUtility.getKeyPressed(KeyCode.S)) {
			dy = this.speed * normalSpeed;
			direction = 2;
			System.out.println("S");
		} else if (InputUtility.getKeyPressed(KeyCode.D)) {
			dx = this.speed * normalSpeed;
			direction = 1;
			System.out.println("D");
		}else if (InputUtility.getKeyPressed(KeyCode.A)) {
			dx = -this.speed * normalSpeed;
			direction = 3;
			System.out.println("A");

		}	else {
			dx = 0;
			dy = 0;
		}
		
		
	}
	
	
	public void processInput() {

			if ((CollisionUtility.checkCollisionPenguinBlocks() == false && 
					CollisionUtility.checkCollisionPenguinBear()== false)) { 
				move();
			}else {			


				dx = -dx;
				dy = -dy;
			}
			

		if (InputUtility.getKeyPressed(KeyCode.SPACE) && (System.currentTimeMillis() - lastFired) > cooldown) {
			attack();
            lastFired = System.currentTimeMillis();
			
		}
		setPosition(new Point2D(getPosition().getX() + this.dx, getPosition().getY() + this.dy));
	}
	
	public void attack() {
	          
	    if(weapon instanceof Snowball)   {
	    	Snow snow; 
	        if (direction == 0) {
	        	snow = new Snow(getPosition().getX() +2, getPosition().getY() +2, direction, false, this);
	        } else if (direction == 1) {
	        	snow = new Snow(getPosition().getX() +2, getPosition().getY() +2, direction, false, this);
	        } else if (direction == 2) {
	        	snow = new Snow(getPosition().getX() +2, getPosition().getY() +2, direction, false, this);
	        } else {
	        	snow = new Snow(getPosition().getX() +2, getPosition().getY() +2, direction, false, this);
	        }
	        bullets.add(snow);
	        RenderableHolder.getInstance().add(snow);

	    }else if(weapon instanceof Stick) {
	    	Wood wood;
	    	dx = 0;
			dy = 0;
	        if (direction == 0) {
	        	wood = new Wood(getPosition().getX() +2, getPosition().getY() +2, direction, false, this);
	        } else if (direction == 1) {
	        	wood = new Wood(getPosition().getX() +2, getPosition().getY() +2, direction, false, this);
	        } else if (direction == 2) {
	        	wood = new Wood(getPosition().getX() +2, getPosition().getY() +2, direction, false, this);
	        } else {
	        	wood = new Wood(getPosition().getX() +2, getPosition().getY() +2, direction, false, this);
	        }
	        bullets.add(wood);
	        RenderableHolder.getInstance().add(wood);
	    }
	}
	
	@Override
	public void takeDamage(int damage) {
		if(health-damage<0) {
			health=0;
			Player.getInstance().setCurrentHealth(0);
		}else {
			Player.getInstance().setCurrentHealth(health-damage);
			health = health-damage;
			
		}
		
	}
	

	
	@Override
	public void draw(GraphicsContext gc) {
 
		Image image = (ImageHolder.getInstance()).penguin;
	    double x = getPosition().getX();
	    double y = getPosition().getY();		
		gc.drawImage(image, x, y, image.getWidth(), image.getHeight());
	}

	@Override
	public void update() {
		snowBallExpired();
		processInput();

	}
	private void snowBallExpired() {
		if(weapon instanceof Snowball) {
			
			if((long) (System.currentTimeMillis() - snowBallEquipedTime) >snowBallExpireTime) {
				weapon.destroy();
				equipWeapon(Player.getInstance().getWeapon());
				RenderableHolder.getInstance().add(weapon);
				
			}
		}
	}
	
	public void buffAttack(int item) {
		itemAttack = itemAttack + item;
		updateTotalAttack();
	}
	
	public void setSnowBallEquipedTime(long snowBallEquipedTime) {
		this.snowBallEquipedTime = snowBallEquipedTime;
	}

}
