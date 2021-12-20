package sprite.equipment.healthcolor;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import resource.ImageHolder;
import sprite.base.Sprite;

public class HealthColor extends Sprite {
	private int health;
	private Image image;
	
	public HealthColor(int health1, Image img) {
		health = health1;
		image = img;
	}

	@Override
	public void update() {}
	
	@Override
	public void draw(GraphicsContext gc) {

		if(isDestroyed()) {
			image = (ImageHolder.getInstance()).floor;
		}
	    double x = getPosition().getX();
	    double y = getPosition().getY();		
		gc.drawImage(image, x, y, image.getWidth(), image.getHeight());
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Image getImage() {
		return image;
	}
}
