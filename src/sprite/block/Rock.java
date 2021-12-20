package sprite.block;

import resource.ImageHolder;
import interfaces.IDamageable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sprite.base.Sprite;
import sprite.character.bear.Bear;
import sprite.equipment.bullet.Snow;
import sprite.equipment.weapon.Weapon;
import sprite.character.Penguin;

public class Rock extends Block{

	public Rock(double x, double y) {
		super();
		this.setPosition(new Point2D(x*getWidth(),y*getHeight()));
		health = 300;
	}

	@Override
	public void draw(GraphicsContext gc) {
 
		Image image = (ImageHolder.getInstance()).rock;
		if(isDestroyed()) {
			image = (ImageHolder.getInstance()).floor;
		}
	    double x = getPosition().getX();
	    double y = getPosition().getY();		
		gc.drawImage(image, x, y, image.getWidth(), image.getHeight());
	}

	@Override
	public void update() {
		if(health<=0) {
			destroy();
		}
	}




}
