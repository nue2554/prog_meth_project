package sprite.character.bear;

import game.GameStatus;
import game.utility.BoardUtility;
import game.utility.CollisionUtility;
import interfaces.IDamageable;
import javafx.scene.canvas.GraphicsContext;
import sprite.base.Sprite;
import sprite.character.Character;
import sprite.equipment.weapon.Weapon;

public abstract class Bear extends Character{
	
	protected boolean collidedPenguin = false;
//	protected boolean first = false;
	protected long lastCollidedPenguin = 0;
	protected int cofusingTime = 1000;	
	protected boolean freezed =false;
	protected int imgSide = 1;
	
	public Bear() {
		super();
		
	}
	
public void move() {
		
		if(CollisionUtility.checkCollisionPenguinBearIndividual((Bear) this)== true	) {
			collidedPenguin = true;
			lastCollidedPenguin = System.currentTimeMillis();
//			System.out.println("Hit");
			backward();
		}else if ((CollisionUtility.checkCollisionBearBlocks(this) == false )) { 
//			System.out.println("Pass");
			
		

			if(collidedPenguin == false) {
//				System.out.println("forward");
				forward();
			}else {		
//				System.out.println("backward");
				backward();				
			}
		
		}else {
				dx = -dx;
				dy = -dy;
		}
		
		if(freezed == true) {
//			System.out.println("Fuck UP");
			dx = 0;
			dy = 0;
		}
	
	}
	
	private void forward() {
		if(BoardUtility.distanceX(this)<0 && BoardUtility.distanceY(this) <0) {
			if(BoardUtility.compareXY(this)) {
				
				direction = 3;
				dx = -this.speed * normalSpeed;
				//imgSide = 0;
			}
			
				direction = 0;
				dy = -this.speed * normalSpeed;
				//imgSide = 1;
			
		}else if(BoardUtility.distanceX(this)>=0 && BoardUtility.distanceY(this) <0) {
			if(BoardUtility.compareXY(this)) {
				direction = 0;
				dy = -this.speed * normalSpeed;
				//imgSide = 1;
			}
			direction = 1;
				dx = this.speed * normalSpeed;
				//imgSide = 1;
		}else if(BoardUtility.distanceX(this)>=0 && BoardUtility.distanceY(this) >=0) {
			if(BoardUtility.compareXY(this)) {
				
				direction = 1;
				dx = this.speed * normalSpeed;
				//imgSide = 1;
				
			}
				direction = 2;
				dy = this.speed * normalSpeed;
				//imgSide = 0;
				
		}else if(BoardUtility.distanceX(this)<0 && BoardUtility.distanceY(this) >=0) {	
			if(BoardUtility.compareXY(this)) {
				direction = 2;
				dy = this.speed * normalSpeed;
				//imgSide = 0;
				
			}
				direction = 3;
				dx = -this.speed * normalSpeed;
				//imgSide = 0;
		}
	}
	
	private void backward() {
		if(BoardUtility.distanceX(this)<0 && BoardUtility.distanceY(this) <0) {
			if(BoardUtility.compareXY(this)) {
				direction = 2;
				dy = this.speed * normalSpeed;
				//imgSide = 0;
			}
			direction = 1;
			dx = this.speed * normalSpeed;
			//imgSide = 1;
		}else if(BoardUtility.distanceX(this)>=0 && BoardUtility.distanceY(this) <0) {
			if(BoardUtility.compareXY(this)) {
				direction = 3;
				dx = -this.speed * normalSpeed;
				//imgSide = 0;
			}
			direction = 2;
			dy = this.speed * normalSpeed;
			//imgSide = 0;
		}else if(BoardUtility.distanceX(this)>=0 && BoardUtility.distanceY(this) >=0) {
			if(BoardUtility.compareXY(this)) {
				direction = 0;
				dy = -this.speed * normalSpeed;
				//imgSide = 1;
			}
			direction = 3;
			dx = -this.speed * normalSpeed;
			//imgSide = 0;
		}else if(BoardUtility.distanceX(this)<0 && BoardUtility.distanceY(this) >=0) {	
			if(BoardUtility.compareXY(this)) {
				direction = 1;
				dx = this.speed * normalSpeed;
				//imgSide = 1;
			}
			direction = 0;
			dy = -this.speed * normalSpeed;
			//imgSide = 0;
		}


	}
	
	public boolean isFreezed() {
		return freezed;
	}

	public void setFreezed(boolean freezed) {
		this.freezed = freezed;
	}

}
