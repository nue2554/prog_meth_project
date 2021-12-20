package sprite.block;

import interfaces.IDamageable;
import sprite.base.Sprite;

public abstract class Block extends Sprite implements IDamageable{
	protected int health;
	
	public Block() {
		super();
	}
	
	public int getHealth() {
		return health;
	}
	
	public void takeDamage(int damage) {
		if(health-damage<0) {
			health=0;
		}else {
			health = health-damage;
		}
		
	}
}
