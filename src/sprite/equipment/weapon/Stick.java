package sprite.equipment.weapon;

import game.GameScreen;
import interfaces.IDamageable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import resource.ImageHolder;
import sprite.base.Sprite;
import sprite.character.Character;

public class Stick extends Weapon{
 
	private Image image;
	
	public Stick(int weaponAttack1, Image img) {
		super();
		this.weaponAttack = weaponAttack1;
		this.image = img;
	}


	@Override
	public void draw(GraphicsContext gc) {
		if(isDestroyed()) {
			image = (ImageHolder.getInstance()).floor;
		}
	    double x = getPosition().getX();
	    double y = getPosition().getY();		
		gc.drawImage(image, x, y, image.getWidth(), image.getHeight());
	}

	@Override
	public void update(double x, double y) {
		setPosition(new Point2D(x+20, y));
		
	}

	public Image getImage() {
		return image;
	};


}
