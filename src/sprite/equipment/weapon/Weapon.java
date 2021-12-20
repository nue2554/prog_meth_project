package sprite.equipment.weapon;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import sprite.base.Sprite;
import sprite.character.Character;

public abstract class Weapon extends Sprite{
	
	protected int weaponAttack;
	
	public Weapon() {
		super();
		width = 28;
		height = 28;		
		z = -20;
	}
			
	public int getWeaponAttack() {
		return weaponAttack;
	}
	
	public void setWeaponAttack(int weaponAttack) {
		this.weaponAttack = weaponAttack;
	}
	
	@Override
	public void update() {}
	
	public abstract void update(double x, double y);

	
	
}
