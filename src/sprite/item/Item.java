package sprite.item;

import interfaces.IDamageable;
import sprite.base.Sprite;
import sprite.character.Penguin;

public abstract class Item extends Sprite{

	public Item() {
		super();
		z = -40;
	}


	public abstract void pick(Penguin penguin);
}
