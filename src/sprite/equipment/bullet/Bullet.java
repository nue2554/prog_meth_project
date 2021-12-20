package sprite.equipment.bullet;

import sprite.base.Sprite;
import sprite.character.Character;

public abstract class Bullet extends Sprite{
	
    protected boolean isEnemy;
    protected Character character;
    
	public Bullet(boolean Enemy, Character character) {
		super();
		z = -20;
        this.character = character;
        this.isEnemy = Enemy;
	}

	public Character getCharacter() {
		return character;
	}

	public boolean isEnemy() {
		return isEnemy;
	}

	public void setEnemy(boolean isEnemy) {
		this.isEnemy = isEnemy;
	}
    
	
}
